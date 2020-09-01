package com.example.filmrate_v1.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.filmrate_v1.Animation.Animation;
import com.example.filmrate_v1.R;
import com.example.filmrate_v1.pojo.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmRecyclerAdabter extends
        RecyclerView.Adapter<FilmRecyclerAdabter.ViewHolder> {

    private static final String TAG = FilmRecyclerAdabter.class.getSimpleName();

    private Context context;
    private List<Film> list;
    private OnItemClickListener onItemClickListener;
    private int previousPosition = 0;


    public FilmRecyclerAdabter(Context context, List<Film> list,
                               OnItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnItemClickListener listener;
        ImageView movieImage;

        public ViewHolder(View itemView , OnItemClickListener listener) {
            super(itemView);
            //onclick
            this.listener = listener;
            itemView.setOnClickListener(this);
            //handel id
            movieImage = itemView.findViewById(R.id.movieImage);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getLayoutPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.new_film_layout, parent, false);

        ViewHolder viewHolder = new ViewHolder(view,onItemClickListener);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film item = list.get(position);

        //Setup viewholder for item
        Picasso.with(context)
                .load(item.getLarge_cover_image())
                .into(holder.movieImage);

        //To set a animation to holder
        Animation.animationUpDown(holder, false);
    }


    private void animation(int position , ViewHolder holder){
        if(position > previousPosition)
            Animation.animationUpDown(holder, false);
        else
            Animation.animationUpDown(holder, true);

        previousPosition = position;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setList(List<Film> list) {
        this.list = list;
        notifyDataSetChanged();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

}