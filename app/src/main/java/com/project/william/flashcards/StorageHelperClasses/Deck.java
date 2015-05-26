package com.project.william.flashcards.StorageHelperClasses;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by William on 2015-05-25.
 */
public class Deck {
    String title;
    private ArrayList<FlashCard> deck;

    public Deck(String title){
        this.title = title;
        deck = new ArrayList<FlashCard>();
    }

    public Deck(String title, String questionFiles, String answerFiles){
        //TODO create deck from txt files
        this.title = title;
    }

    public String getTitle(){
        return title;
    }

    public void addCard(FlashCard card){
        deck.add(card);
    }

    public void deleteCard(int position){
        deck.remove(position);
    }

    public void shuffleCards(){
        Collections.shuffle(deck);
    }
}
