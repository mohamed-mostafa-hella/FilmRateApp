package com.example.filmrate_v1.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.filmrate_v1.Animation.Animation;
import com.example.filmrate_v1.R;
import com.example.filmrate_v1.pojo.Film;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FilmVerticalRecyclerAdabter extends
        RecyclerView.Adapter<FilmVerticalRecyclerAdabter.ViewHolder> {

    private static final String TAG = FilmVerticalRecyclerAdabter.class.getSimpleName();

    private Context context;
    private List<Film> list;
    private OnItemClickListener onItemClickListener;
    private int previousPosition = 0;


    public FilmVerticalRecyclerAdabter(Context context, List<Film> list,
                                       OnItemClickListener onItemClickListener) {
        this.context = context;
        this.list = list;
        this.onItemClickListener = onItemClickListener;
    }


    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnItemClickListener listener;
        ImageView movieImage;

        TextView txtName,txtLang,txtYear,txtSammery;
        RatingBar rateBare;

        public ViewHolder(View itemView , OnItemClickListener listener) {
            super(itemView);
            //onclick
            this.listener = listener;
            itemView.setOnClickListener(this);
            //handel id
            txtName = itemView.findViewById(R.id.film_name);
            rateBare = itemView.findViewById(R.id.rate_bare);
            txtLang = itemView.findViewById(R.id.lang);
            txtYear = itemView.findViewById(R.id.year);
            txtSammery = itemView.findViewById(R.id.sammery);
            movieImage = itemView.findViewById(R.id.movieImage);
        }

        @Override
        public void onClick(View v) {
            listener.onItemClick(getLayoutPosition());
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        View view = inflater.inflate(R.layout.item_view, parent, false);

        ViewHolder viewHolder = new ViewHolder(view,onItemClickListener);

        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Film item = list.get(position);

        //Setup viewholder for item
        holder.txtName.setText(item.getTitle_english());
        holder.rateBare.setRating((float)(item.getRating()*0.5));
        holder.txtSammery.setText(item.getSummary());
        holder.txtYear.setText(String.valueOf(item.getYear()));
        holder.txtLang.setText(item.getLanguage());

        Picasso.with(context)
                .load(item.getLarge_cover_image())
                .into(holder.movieImage);

        //To set a animation to holder
        //animation(position, holder);
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