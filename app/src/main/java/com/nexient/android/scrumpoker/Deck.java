package com.nexient.android.scrumpoker;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class Deck {
    //Deck should be able to access the
    //three main views of our activity
    private FrameLayout cards;
    private Button backOfCard;
    private Button frontOfCard;

    public void onCreate(Bundle savedInstanceState){
        //TODO: assign cards, backOfCard, frontOfCard with id's
    }

    //to be called with the value of the button that's pressed
    //switches from the whole table view to the back of the card.
    public void chooseCard(String value){
        //set the final card text to
        frontOfCard.setText(value);

        //the back of the card pops up and others are made invisible
        //TODO: animate
        cards.setVisibility(View.GONE);
        frontOfCard.setVisibility(View.GONE);
        backOfCard.setVisibility(View.VISIBLE);
    }

    //to be called when the back of the card is touched to reveal
    public void reveal(){
        //switch so front of the card is the only thing visible
        //TODO: animate
        cards.setVisibility(View.GONE);
        backOfCard.setVisibility(View.GONE);
        frontOfCard.setVisibility(View.VISIBLE);
    }

    //to be called when going back to the full table view
    public void discard(){
        //switch so only the table view is visible
        //TODO: animate
        backOfCard.setVisibility(View.GONE);
        frontOfCard.setVisibility(View.GONE);
        cards.setVisibility(View.VISIBLE);
    }

}