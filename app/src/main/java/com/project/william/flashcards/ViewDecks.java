package com.project.william.flashcards;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.william.flashcards.StorageHelperClasses.Deck;

import java.util.ArrayList;

/**
 * Created by William on 2015-05-22.
 */
public class ViewDecks extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deck_view_screen);
        ArrayList<Deck> newDeck = new ArrayList<Deck>();
        newDeck.add(new Deck("test1"));

        newDeck.add(new Deck("test2"));
        DeckAdapter testAdapter = new DeckAdapter(newDeck, this);

        RecyclerView deckList = (RecyclerView)findViewById(R.id.deck_list);
        deckList.setHasFixedSize(true);
        deckList.setAdapter(testAdapter);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        deckList.setLayoutManager(manager);
    }
}
