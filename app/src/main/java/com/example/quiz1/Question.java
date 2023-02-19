package com.example.quiz1;

public class Question {
    private String question;
    private boolean respuesta;

    public Question(String question, boolean respuesta) {
        this.question = question;
        this.respuesta = respuesta;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public boolean trueOrFalse() { return respuesta; }

    public void setRespuesta(boolean respuesta) {
        this.respuesta = respuesta;
    }
}
