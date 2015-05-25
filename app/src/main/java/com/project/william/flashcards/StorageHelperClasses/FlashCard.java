package com.project.william.flashcards.StorageHelperClasses;

/**
 * Created by William on 2015-05-25.
 */
public class FlashCard {
    private String question = null;
    private String answer = null;

    public FlashCard(){

    }

    public FlashCard(String question, String answer){
        this.question = question;
        this.answer = answer;
    }

    public FlashCard(String question){
        this.question = question;
    }

    public void setQuestion(String question){
        this.question = question;
    }

    public void setAnswer(String answer){
        this.answer = answer;
    }

    public String getQuestion(){
        return question;
    }

    public String getAnswer(){
        return answer;
    }
}
