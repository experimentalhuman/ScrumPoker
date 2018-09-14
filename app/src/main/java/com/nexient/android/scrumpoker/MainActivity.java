package com.nexient.android.scrumpoker;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.PopupMenu;

import java.util.Set;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ConstraintLayout multiCardLayout;
    private Button[][] cardButtonArray;
    private Button singleCardShownButton;
    private Button singleCardHiddenButton;
    private Deck deck;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // COMPLETED retrieve UI objects by resource ID
        multiCardLayout = (ConstraintLayout) findViewById(R.id.multi_card_layout);
        cardButtonArray = new Button[3][3];
        cardButtonArray[0][0] = (Button) findViewById(R.id.card_button_top_left);
        cardButtonArray[0][1] = (Button) findViewById(R.id.card_button_top_center);
        cardButtonArray[0][2] = (Button) findViewById(R.id.card_button_top_right);
        cardButtonArray[1][0] = (Button) findViewById(R.id.card_button_center_left);
        cardButtonArray[1][1] = (Button) findViewById(R.id.card_button_center_center);
        cardButtonArray[1][2] = (Button) findViewById(R.id.card_button_center_right);
        cardButtonArray[2][0] = (Button) findViewById(R.id.card_button_bottom_left);
        cardButtonArray[2][1] = (Button) findViewById(R.id.card_button_bottom_center);
        cardButtonArray[2][2] = (Button) findViewById(R.id.card_button_bottom_right);
        singleCardHiddenButton = (Button) findViewById(R.id.single_card_view_hide);
        singleCardShownButton = (Button) findViewById(R.id.single_card_view_show);

        // COMPLETED init Deck class/object
        deck = new Deck(multiCardLayout, singleCardHiddenButton, singleCardShownButton, this);

        cardButtonArray[0][0].setOnClickListener(this);
        cardButtonArray[0][1].setOnClickListener(this);
        cardButtonArray[0][2].setOnClickListener(this);
        cardButtonArray[1][0].setOnClickListener(this);
        cardButtonArray[1][1].setOnClickListener(this);
        cardButtonArray[1][2].setOnClickListener(this);
        cardButtonArray[2][0].setOnClickListener(this);
        cardButtonArray[2][1].setOnClickListener(this);
        cardButtonArray[2][2].setOnClickListener(this);
        singleCardShownButton.setOnClickListener(this);
        singleCardHiddenButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View clickedView) {
        Log.d("Scrum Poker", "clicked");
        int viewID = clickedView.getId();

        //added returns so it doesn't go on to the switch

        if(viewID == R.id.single_card_view_show){
            deck.discard();
        } else if(viewID == R.id.single_card_view_hide) {
            deck.reveal();
        } else {

            String cardLabel = "0";
            switch (viewID) {
                case R.id.card_button_top_left:
                    cardLabel = getString(R.string.card_label_top_left);
                    break;
                case R.id.card_button_top_center:
                    cardLabel = getString(R.string.card_label_top_center);
                    break;
                case R.id.card_button_top_right:
                    cardLabel = getString(R.string.card_label_top_right);
                    break;
                case R.id.card_button_center_left:
                    cardLabel = getString(R.string.card_label_center_left);
                    break;
                case R.id.card_button_center_center:
                    cardLabel = getString(R.string.card_label_center_center);
                    break;
                case R.id.card_button_center_right:
                    cardLabel = getString(R.string.card_label_center_right);
                    break;
                case R.id.card_button_bottom_left:
                    cardLabel = getString(R.string.card_label_bottom_left);
                    break;
                case R.id.card_button_bottom_center:
                    cardLabel = getString(R.string.card_label_bottom_center);
                    break;
                case R.id.card_button_bottom_right:
                    cardLabel = getString(R.string.card_label_bottom_right);
                    break;
                default:
                    cardLabel = "0";
                    break;
            }

            deck.chooseCard(cardLabel);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menuDefaultStyle){
            FrameLayout fl = findViewById(R.id.main_frame_layout);
            fl.setBackgroundResource(R.color.colorDefaultBG);

            Button b1 = (Button) findViewById(R.id.card_button_top_left);
            b1.setBackgroundResource(R.color.colorDefaultButton);
            b1.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b2 = (Button) findViewById(R.id.card_button_top_center);
            b2.setBackgroundResource(R.color.colorDefaultButton);
            b2.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b3 = (Button) findViewById(R.id.card_button_top_right);
            b3.setBackgroundResource(R.color.colorDefaultButton);
            b3.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b4 = (Button) findViewById(R.id.card_button_center_left);
            b4.setBackgroundResource(R.color.colorDefaultButton);
            b4.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b5 = (Button) findViewById(R.id.card_button_center_center);
            b5.setBackgroundResource(R.color.colorDefaultButton);
            b5.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b6 = (Button) findViewById(R.id.card_button_center_right);
            b6.setBackgroundResource(R.color.colorDefaultButton);
            b6.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b7 = (Button) findViewById(R.id.card_button_bottom_left);
            b7.setBackgroundResource(R.color.colorDefaultButton);
            b7.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b8 = (Button) findViewById(R.id.card_button_bottom_center);
            b8.setBackgroundResource(R.color.colorDefaultButton);
            b8.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b9 = (Button) findViewById(R.id.card_button_bottom_right);
            b9.setBackgroundResource(R.color.colorDefaultButton);
            b9.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b10 = (Button) findViewById(R.id.single_card_view_hide);
            b10.setBackgroundResource(R.color.colorDefaultButton);
            b10.setTextColor(getResources().getColor(R.color.colorDefaultText));
            Button b11 = (Button) findViewById(R.id.single_card_view_show);
            b11.setBackgroundResource(R.color.colorDefaultButton);
            b11.setTextColor(getResources().getColor(R.color.colorDefaultText));

        }else if (item.getItemId() == R.id.menuAlternateStyle){
            FrameLayout fl = findViewById(R.id.main_frame_layout);
            fl.setBackgroundResource(R.color.colorAlternateBG);

            Button b1 = (Button) findViewById(R.id.card_button_top_left);
            b1.setBackgroundResource(R.color.colorAlternateButton);
            b1.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b2 = (Button) findViewById(R.id.card_button_top_center);
            b2.setBackgroundResource(R.color.colorAlternateButton);
            b2.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b3 = (Button) findViewById(R.id.card_button_top_right);
            b3.setBackgroundResource(R.color.colorAlternateButton);
            b3.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b4 = (Button) findViewById(R.id.card_button_center_left);
            b4.setBackgroundResource(R.color.colorAlternateButton);
            b4.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b5 = (Button) findViewById(R.id.card_button_center_center);
            b5.setBackgroundResource(R.color.colorAlternateButton);
            b5.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b6 = (Button) findViewById(R.id.card_button_center_right);
            b6.setBackgroundResource(R.color.colorAlternateButton);
            b6.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b7 = (Button) findViewById(R.id.card_button_bottom_left);
            b7.setBackgroundResource(R.color.colorAlternateButton);
            b7.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b8 = (Button) findViewById(R.id.card_button_bottom_center);
            b8.setBackgroundResource(R.color.colorAlternateButton);
            b8.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b9 = (Button) findViewById(R.id.card_button_bottom_right);
            b9.setBackgroundResource(R.color.colorAlternateButton);
            b9.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b10 = (Button) findViewById(R.id.single_card_view_hide);
            b10.setBackgroundResource(R.color.colorAlternateButton);
            b10.setTextColor(getResources().getColor(R.color.colorAlternateText));
            Button b11 = (Button) findViewById(R.id.single_card_view_show);
            b11.setBackgroundResource(R.color.colorAlternateButton);
            b11.setTextColor(getResources().getColor(R.color.colorAlternateText));
        }

        return true;
    }


}
