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
import com.example.helloworldappgaurav.quiz.model.QuizManager;
import com.example.helloworldappgaurav.quiz.model.QuizQuestion;
import com.yuyakaido.android.cardstackview.CardStackLayoutManager;
import com.yuyakaido.android.cardstackview.CardStackView;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private QuizManager mQuizManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mQuizManager = new QuizManager(this);
        mQuizManager.getQuizQuestion(this);


//        ArrayList<String> testFilms = new ArrayList<>();
//        testFilms.add("Matrix the question for the day is basically checking the indentation");
//        testFilms.add("On Golden Pond just like the Golden circle of Kingsman");
//        testFilms.add("At CLose Range is a measure of the amount of substance");
//        testFilms.add("The pledge that ought to be taken");
//        testFilms.add("Basketball Diaries that are affected by this measure");
//
//        ArrayList<String> CategoryFilms = new ArrayList<>();
//        CategoryFilms.add("Sports");
//        CategoryFilms.add("Science");
//        CategoryFilms.add("General");
//        CategoryFilms.add("Biztech");
//        CategoryFilms.add("MELA");





    }
}