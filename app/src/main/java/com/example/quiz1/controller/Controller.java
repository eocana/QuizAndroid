package com.example.quiz1.controller;

import android.widget.Toast;

import com.example.quiz1.model.Player;
import com.example.quiz1.model.Question;

public class Controller {
    private Player[] players;

    private int round;

    public Controller(Player[] players) {
        this.players = players;
        this.round = 0;
    }

    public boolean checkQuestion(Question question, boolean answer){
        return question.trueOrFalse() == answer;
    }

    public Player actionPlayer(Player player, boolean correct){

        if (correct){
            player.sumarPuntos();
        }else {
            player.restaPuntos();
        }
        return player;
    }
}
