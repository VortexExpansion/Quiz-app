package com.example.helloworldappgaurav.quiz.view;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworldappgaurav.quiz.R;

public class FilmViewHolder extends RecyclerView.ViewHolder{

    private TextView txtFilmCategory;
    private TextView txtFilmQuestion;
    private ImageButton imgButtonTrue;
    private ImageButton imgButtonFalse;

    public FilmViewHolder(@NonNull View itemView) {
        super(itemView);

        //txtFilmCategory = itemView.findViewById(R.id.category_question_text);
        txtFilmQuestion = itemView.findViewById(R.id.film_question_text);
        imgButtonTrue = itemView.findViewById(R.id.trueButton);
        imgButtonFalse = itemView.findViewById(R.id.falseButton);
        txtFilmCategory = itemView.findViewById(R.id.film_category);
    }

    public TextView getTxtFilmQuestion() {
        return txtFilmQuestion;
    }

    public ImageButton getImgButtonTrue() {
        return imgButtonTrue;
    }

    public ImageButton getImgButtonFalse() {
        return imgButtonFalse;
    }

    public TextView getTxtFilmCategory() {
        return txtFilmCategory;
    }


}
