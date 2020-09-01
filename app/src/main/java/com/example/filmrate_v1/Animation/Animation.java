package com.example.filmrate_v1.Animation;

import android.animation.ObjectAnimator;

import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by ameen on 06-Feb-18.
 */

public class Animation {



    public static void animationUpDown (RecyclerView.ViewHolder holder, boolean goDown) {

        ObjectAnimator mObjectAnimator = ObjectAnimator.ofFloat(holder.itemView,
                                            "translationY", goDown ? 300 : -300, 0);

        mObjectAnimator.setDuration(1500);
        mObjectAnimator.start();
    }

    public static void animationRightLeft (RecyclerView.ViewHolder holder, boolean goDown) {

        ObjectAnimator mObjectAnimator = ObjectAnimator.ofFloat(holder.itemView,
                "translationX", goDown ? 250 : -250, 0);

        mObjectAnimator.setDuration(1500);
        mObjectAnimator.start();
    }

}
