package com.example.helloworldappgaurav.quiz.model;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.helloworldappgaurav.quiz.R;
import com.example.helloworldappgaurav.quiz.VolleySingleton;
import com.example.helloworldappgaurav.quiz.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class QuizManager {
    private RequestQueue mRequestQueue; // added volley singleton
    private  String mUrl;
    Context mContext;

    public QuizManager(Context context) {
        mContext = context;
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue(); //first volley statement for inside
        mUrl = "https://opentdb.com/api.php?amount=10&type=boolean";

    }

    public void getQuizQuestion(Activity activity){

        List<QuizQuestion> quizQuestions = new ArrayList<>();

        //Created a Object and not array request because at the root level you have an object not an array
        JsonObjectRequest filmsJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, mUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("FILMS","This is successful"+response);

                try {
                    JSONArray results = response.getJSONArray("results"); //results is the key name on the url
                    for(int index = 0;index<results.length();index++){
                        JSONObject questionJsonObject = results.getJSONObject(index);
                        String questionText = questionJsonObject.getString("question");

                        JSONObject categoryJsonObject = results.getJSONObject(index);
                        String questionCategory = questionJsonObject.getString("category");

                        boolean questionAnswer = questionJsonObject.getBoolean("correct_answer");

                        QuizQuestion myQuestion = new QuizQuestion(questionText,questionCategory,questionAnswer);

                        quizQuestions.add(myQuestion);

                    }

                    CardStackView mCardStackView = activity.findViewById(R.id.myCardStackView); // first line to add after importing CardStackView
                    mCardStackView.setLayoutManager(new CardStackLayoutManager(mContext)); //from github setup

                    mCardStackView.setAdapter(new CardStackAdapter(mContext,quizQuestions)); //initially red becuase you don't have an adapter yet
                    //mCardStackView.setAdapter(new CardStackAdapter(this,CategoryFilms));

                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(filmsJsonObjectRequest);
    }
}
