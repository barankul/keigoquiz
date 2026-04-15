package com.barankul.keigoquiz;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String scene;
    private String changedWords;
    private String normalSentence;
    private String explanation;
    private String answer;
    private List<String> options = new ArrayList<>();

    public Question(String scene, String changedWords, String normalSentence, String explanation, String answer,List<String> options ) {
        this.scene = scene;
        this.changedWords = changedWords;
        this.normalSentence = normalSentence;
        this.explanation = explanation;
        this.answer = answer;
        this.options = options;
    }

    public String getScene() {
        return scene;
    }

    public String getChangedWords() {
        return changedWords;
    }

    public String getNormalSentence() {
        return normalSentence;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getAnswer() {
        return answer;
    }

    public List<String> getOptions() {
        return options;
    }


}
