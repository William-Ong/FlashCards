package com.project.william.flashcards;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MenuScreen extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_screen);

        Button goToViewDecks = (Button)findViewById(R.id.view_deck);
        Button goToDeckCreate = (Button)findViewById(R.id.deck_create);
        Button createFromFiles = (Button)findViewById(R.id.file_browser);
        Button helpButton = (Button)findViewById(R.id.help_button);



        goToViewDecks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuScreen.this, ViewDecks.class));
            }
        });

        goToDeckCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuScreen.this, DeckCreations.class));
            }
        });

        createFromFiles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuScreen.this, FileBrowserCreation.class));
            }
        });

        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MenuScreen.this, HelpScreen.class));
            }
        });
    }


}
