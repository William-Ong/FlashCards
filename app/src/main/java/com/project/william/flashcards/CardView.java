package com.project.william.flashcards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.project.william.flashcards.R;

/**
 * Created by William on 2015-06-10.
 */
public class CardView extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_screen);

        Intent intent = getIntent();
        int pos = intent.getIntExtra("DeckPosition", 0);//Bad, change later for DeckPosition ID
    }
}
