package com.nexient.android.scrumpoker;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

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
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onClick(View clickedView) {
        int viewID = clickedView.getId();

        if(viewID == R.id.single_card_view_show){
            deck.discard();
        } else if(viewID == R.id.single_card_view_hide){
            deck.reveal();
        }

        String cardLabel = "0";
        switch (viewID) {
            case R.id.card_button_top_left: cardLabel = getString(R.string.card_label_top_left);
                break;
            case R.id.card_button_top_center: cardLabel = getString(R.string.card_label_top_center);
                break;
            case R.id.card_button_top_right: cardLabel = getString(R.string.card_label_top_right);
                break;
            case R.id.card_button_center_left: cardLabel = getString(R.string.card_label_center_left);
                break;
            case R.id.card_button_center_center: cardLabel = getString(R.string.card_label_center_center);
                break;
            case R.id.card_button_center_right: cardLabel = getString(R.string.card_label_center_right);
                break;
            case R.id.card_button_bottom_left: cardLabel = getString(R.string.card_label_bottom_left);
                break;
            case R.id.card_button_bottom_center: cardLabel = getString(R.string.card_label_bottom_center);
                break;
            case R.id.card_button_bottom_right: cardLabel = getString(R.string.card_label_bottom_right);
                break;
            default: cardLabel = "0";
                break;
        }

        deck.chooseCard(cardLabel);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.action_settings){

            // TODO launch settings activity

        }

        return true;
    }
}
