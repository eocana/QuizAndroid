package com.example.quiz1;

import com.example.quiz1.controller.Controller;
import com.example.quiz1.model.Player;
import com.example.quiz1.model.Question;

import java.io.Serializable;

public class QuizManager  {

    private Controller controller;
    private Player[] players;
    private Question[] questions;


    public void generateQuestions(){

        this.questions = new Question[5];

        this.questions[0] =  new Question( "Eres humano?", true);
        this.questions[1] =  new Question( "Estas estudiando?", true);
        this.questions[2] =  new Question( "El XML es divertido", false);
        this.questions[3] =  new Question( "Java esta divertido", true);
        this.questions[4] =  new Question( "Has entendido todo lo que has hecho", true);
    }

    public void createPlayers(int nPlayers, String[] names){
        for (int i = 0; i < nPlayers; i++) {
            this.players[i] = new Player(names[i]);
        }
    }
}
