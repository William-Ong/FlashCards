package com.project.william.flashcards.StorageHelperClasses;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by William on 2015-05-25.
 */
public class Deck {

    private ArrayList<FlashCard> deck;

    public Deck(){
        deck = new ArrayList<FlashCard>();
    }

    public Deck(String questionFiles, String answerFiles){
        //TODO create deck from txt files
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
