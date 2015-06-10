package com.project.william.flashcards.StorageHelperClasses;

import java.util.ArrayList;

/**
 * Created by William on 2015-05-25.
 */
public class DeckFactory {

    public static ArrayList<Deck> deckList = new ArrayList<Deck>();

    //Persistent storage for a deck
    public static void addToStorage(Deck deck){

    }

    public static void deleteFromStorage(){

    }

    public static Deck search(String title){
        return new Deck("test");
    }

    public static Deck getDeck(int position){
        return deckList.get(position);
    }


}
