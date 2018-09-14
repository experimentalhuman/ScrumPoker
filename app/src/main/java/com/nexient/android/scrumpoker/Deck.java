package com.nexient.android.scrumpoker;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Deck {
    //Deck should be able to access the
    //three main views of our activity
    private View cards;
    private View backOfCard;
    private TextView frontOfCard;

    //animations for transitions
    private final Animation animOut;
    private final Animation animIn;

    public Deck(View multi_card, View card_hide, TextView card_show, Context context){
        cards = multi_card;
        backOfCard = card_hide;
        frontOfCard = card_show;
        animIn = AnimationUtils.loadAnimation(context, R.anim.flip_in);
        animOut = AnimationUtils.loadAnimation(context, R.anim.flip_out);
    }



    //to be called with the value of the button that's pressed
    //switches from the whole table view to the back of the card.
    public void chooseCard(String value){
        //set the final card text to
        frontOfCard.setText(value);

        //the back of the card pops up and others are made invisible
        cards.startAnimation(animOut);
        cards.postDelayed(new Runnable(){
            public void run(){
                cards.setVisibility(View.INVISIBLE);
                backOfCard.setVisibility(View.VISIBLE);
                backOfCard.startAnimation(animIn);
            }
        }, 500);
        frontOfCard.setVisibility(View.INVISIBLE);

    }

    //to be called when the back of the card is touched to reveal
    public void reveal(){
        //switch so front of the card is the only thing visible
        cards.setVisibility(View.INVISIBLE);

        backOfCard.startAnimation(animOut);
        backOfCard.postDelayed(new Runnable(){
            public void run(){
                backOfCard.setVisibility(View.INVISIBLE);
                frontOfCard.setVisibility(View.VISIBLE);
                frontOfCard.startAnimation(animIn);
            }
        }, 500);
    }

    //to be called when going back to the full table view
    public void discard(){
        //switch so only the table view is visible
        backOfCard.setVisibility(View.INVISIBLE);

        frontOfCard.startAnimation(animOut);
        frontOfCard.postDelayed(new Runnable(){
            public void run(){
                frontOfCard.setVisibility(View.INVISIBLE);
                cards.setVisibility(View.VISIBLE);
                cards.startAnimation(animIn);
            }
        }, 500);
    }

}
