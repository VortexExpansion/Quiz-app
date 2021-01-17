package com.example.helloworldappgaurav.quiz.controller;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.helloworldappgaurav.quiz.R;
import com.example.helloworldappgaurav.quiz.view.FilmViewHolder;

import java.util.List;

public class CardStackAdapter extends RecyclerView.Adapter<FilmViewHolder> {

    private Context mContext;
    private List<String> mfilmNames;
    private LayoutInflater mLayoutInflater;
    
    public CardStackAdapter(Context context, List<String> filmNames){
        mContext = context;
        mfilmNames = filmNames;
        mLayoutInflater = LayoutInflater.from(context);
    }


    @NonNull
    @Override
    public FilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        
        View view = mLayoutInflater.inflate(R.layout.film_view, parent, false);
        return new FilmViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmViewHolder holder, int position) {

        holder.getTxtFilmQuestion().setText(mfilmNames.get(position));
        holder.getImgButtonTrue().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "True is tapped", Toast.LENGTH_SHORT).show();
            }
        });
        holder.getImgButtonFalse().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext, "False is tapped", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mfilmNames.size();
    }
}
