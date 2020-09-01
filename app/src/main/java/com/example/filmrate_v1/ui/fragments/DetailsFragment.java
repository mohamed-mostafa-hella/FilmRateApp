package com.example.filmrate_v1.ui.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.filmrate_v1.R;
import com.example.filmrate_v1.pojo.Film;
import com.squareup.picasso.Picasso;

public class DetailsFragment extends Fragment {

    private TextView mTitle, mDate, mRate, mOverView;
    private ImageView mImage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //Referances to the layout
        mTitle = view.findViewById(R.id.txtTitleDetail);
        mDate = view.findViewById(R.id.txtDateDetail);
        mRate = view.findViewById(R.id.txtRateDetail);
        mOverView = view.findViewById(R.id.txtOverViewDetail);
        mImage = view.findViewById(R.id.imageDetail);




        if (getArguments() != null) {
            //TODO:: get data
            DetailsFragmentArgs args = DetailsFragmentArgs.fromBundle(getArguments());
            setData(args.getFilmeItim());
        }
    }

    private void setData(Film movie) {
        // show data in detales

        //Load the image
        Picasso.with(getContext())
                .load(movie.getMedium_cover_image())
                .into(mImage);

        mTitle.setText(movie.getTitle());
        mDate.setText("Release date: " + String.valueOf(movie.getYear()));
        mRate.setText("Average rate: " + String.valueOf(movie.getRating()));
        mOverView.setText(movie.getSummary());
    }
}
