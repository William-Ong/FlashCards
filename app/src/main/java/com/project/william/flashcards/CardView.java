package com.project.william.flashcards;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.project.william.flashcards.R;
import com.project.william.flashcards.StorageHelperClasses.Deck;
import com.project.william.flashcards.StorageHelperClasses.DeckFactory;
import com.project.william.flashcards.StorageHelperClasses.FlashCard;

/**
 * Created by William on 2015-06-10.
 */
public class CardView extends Activity {

    private Deck currentDeck;
    private int positionOfCard;
    private int currentAnswerTracker;
    private TextView question;
    private TextView answer;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.card_view_screen);


        Intent intent = getIntent();
        int pos = intent.getIntExtra("DeckPosition", 0);//Bad, change later for DeckPosition ID
        int positionOfCard = 0;

        //TEST CARDS
        currentDeck = new Deck("Something");//DeckFactory.getDeck(pos);
        currentDeck.addCard(new FlashCard("1","ans1"));
        currentDeck.addCard(new FlashCard("2","ans2"));
        currentDeck.addCard(new FlashCard("3","ans3"));
        currentDeck.addCard(new FlashCard("4","ans4"));
        currentDeck.addCard(new FlashCard("5", "ans5"));


        Button nextButton = (Button)findViewById(R.id.nextBtn);
        Button revealButton = (Button)findViewById(R.id.answerBtn);
        Button prevButton = (Button)findViewById(R.id.prevBtn);
        question = (TextView)findViewById(R.id.question_box);
        answer = (TextView)findViewById(R.id.answer_box);
        setCardQuestion();
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setNextQuestion();
            }
        });

        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setPreviousQuestion();
            }
        });

        revealButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                revealAnswer();
            }
        });


    }

    private void setCardQuestion(){
//        currentAnswerTracker = positionOfCard;
        question.setText(currentDeck.getCard(positionOfCard).getQuestion());
        answer.setText("");
    }

    private void setNextQuestion(){
        if(positionOfCard < currentDeck.getSize() - 1){
            positionOfCard++;
            setCardQuestion();
        }else{
            Toast.makeText(this, "No more Cards", Toast.LENGTH_SHORT).show();
        }
    }

    private void setPreviousQuestion(){
        if(positionOfCard > 0){
            positionOfCard--;
            setCardQuestion();
        }else{
            Toast.makeText(this, "No more Cards", Toast.LENGTH_SHORT).show();
        }
    }

    private void revealAnswer(){
        answer.setText(currentDeck.getCard(positionOfCard).getAnswer());
    }
}
