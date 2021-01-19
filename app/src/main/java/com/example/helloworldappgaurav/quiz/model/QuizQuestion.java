package com.example.helloworldappgaurav.quiz.model;

public class QuizQuestion {
    private String questionText;
    private String questionCategory;
    private boolean trueAnswer;

    public QuizQuestion(String questionText, String questionCategory, boolean trueAnswer) {
        this.questionText = questionText;
        this.questionCategory = questionCategory;
        this.trueAnswer = trueAnswer;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }

    public String getQuestionCategory() {
        return questionCategory;
    }

    public void setQuestionCategory(String questionCategory) {
        this.questionCategory = questionCategory;
    }

    public boolean isTrueAnswer() {
        return trueAnswer;
    }

    public void setTrueAnswer(boolean trueAnswer) {
        this.trueAnswer = trueAnswer;
    }
}
