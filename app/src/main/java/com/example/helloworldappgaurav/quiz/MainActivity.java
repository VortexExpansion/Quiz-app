package com.example.helloworldappgaurav.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.helloworldappgaurav.quiz.controller.CardStackAdapter;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RequestQueue mRequestQueue; // added volley singleton
    private  String url;
    private CardStackView mCardStackView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCardStackView = findViewById(R.id.myCardStackView); // first line to add after importing CardStackView
        mCardStackView.setLayoutManager(new CardStackLayoutManager(this)); //from github setup

        ArrayList<String> testFilms = new ArrayList<>();
        testFilms.add("Matrix the question for the day is basically checking the indentation");
        testFilms.add("On Golden Pond just like the Golden circle of Kingsman");
        testFilms.add("At CLose Range is a measure of the amount of substance");
        testFilms.add("The pledge that ought to be taken");
        testFilms.add("Basketball Diaries that are affected by this measure");

        mCardStackView.setAdapter(new CardStackAdapter(this,testFilms)); //initially red becuase you don't have an adapter yet

        url = "https://opentdb.com/api.php?amount=10&type=boolean";
        mRequestQueue = VolleySingleton.getInstance().getRequestQueue(); //first volley statement for inside

        //Created a Object and not array request because at the root level you have an object not an array
        JsonObjectRequest filmsJsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                Log.i("FILMS","This is successful"+response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        mRequestQueue.add(filmsJsonObjectRequest);
    }
}