package com.example.filmrate_v1.ui.fragments;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.filmrate_v1.R;
import com.example.filmrate_v1.pojo.Film;
import com.example.filmrate_v1.ui.main.FilmListViewModel;
import com.example.filmrate_v1.ui.main.FilmRecyclerAdabter;
import com.example.filmrate_v1.ui.main.FilmVerticalRecyclerAdabter;

import java.util.ArrayList;
import java.util.List;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class AllMoviesFragment extends Fragment
        implements FilmRecyclerAdabter.OnItemClickListener,
        FilmVerticalRecyclerAdabter.OnItemClickListener , Observer<List<Film>>{


    RecyclerView mRecyclerView,hRecyclerView;
    FilmRecyclerAdabter mAdapter;
    FilmVerticalRecyclerAdabter verticalAdapter;

    SwipeRefreshLayout mSwipeRefreshLayout;

    NavController navController;

    FilmListViewModel model;

    private List<Film> list = new ArrayList<>();

    boolean ok = true;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");

        model = ViewModelProviders.of(requireActivity())
                .get(FilmListViewModel.class);
        model.lood();

        mAdapter = new FilmRecyclerAdabter(getContext(),list,AllMoviesFragment.this);
        verticalAdapter = new FilmVerticalRecyclerAdabter(getContext(),list,AllMoviesFragment.this);

        if( isNetworkAvailable()){
            //Get data into the layout
            model.getFilms().observe(requireActivity(), AllMoviesFragment.this);
        }else{
            nonet();
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: ");
        return inflater.inflate(R.layout.fragment_all_movies, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.d(TAG, "onViewCreated: ");

        navController = Navigation.findNavController(view);

        mRecyclerView = view.findViewById(R.id.recyclehead);//HEAD IS THE GRID
        hRecyclerView = view.findViewById(R.id.recycleGrid);//THEY ARE REVESED

        mSwipeRefreshLayout = view.findViewById(R.id.ref);


        setRecycler();

        if(ok){
            ok=false;


        }

        //called if screen swaped
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                if (isNetworkAvailable())
                    model.refresh();
                else {
                    nonet();
                }
            }
        });


    }

    void setRecycler ()
    {
        mRecyclerView.setHasFixedSize(true);

        hRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.HORIZONTAL,false));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(),RecyclerView.VERTICAL,false));

        ViewCompat.setNestedScrollingEnabled(hRecyclerView, false);
        ViewCompat.setNestedScrollingEnabled(mRecyclerView, false);


        mRecyclerView.setAdapter(verticalAdapter);
        hRecyclerView.setAdapter(mAdapter);

        mSwipeRefreshLayout.setRefreshing(false);
    }



    void nonet(){
        //TODO:navigate to no internet fragment
        Log.d(TAG, "mmh nonet: ");
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager =
                (ConnectivityManager) getActivity().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }



    @Override
    public void onChanged(List<Film> films) {
        Log.d(TAG, "in -> onChanged: "+Thread.currentThread());
        list = films;
        mAdapter.setList(list);
        verticalAdapter.setList(list);

        //setRecyclerData();
    }

    @Override
    public void onItemClick(int position) {
        Log.d(TAG, "mmh onItemClick: "+list.get(position).getTitle());
        AllMoviesFragmentDirections.ActionAllMoviesFragmentToDetailsFragment action =
                AllMoviesFragmentDirections.actionAllMoviesFragmentToDetailsFragment(list.get(position));

        navController.navigate(action);
    }

}
