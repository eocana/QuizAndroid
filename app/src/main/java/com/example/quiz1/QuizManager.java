package com.example.quiz1;

import com.example.quiz1.model.Player;
import com.example.quiz1.model.Question;

import java.util.Arrays;
import java.util.Comparator;

class PointsComparator implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return p1.getPoints() - p2.getPoints();
    }
}

public class QuizManager {

    private Player[] players;
    private Question[] questions;

    public Question[] generateQuestions(){

        this.questions = new Question[5];

        this.questions[0] =  new Question( "Eres humano?", true);
        this.questions[1] =  new Question( "Estas estudiando?", true);
        this.questions[2] =  new Question( "El XML es divertido", false);
        this.questions[3] =  new Question( "Java esta divertido", true);
        this.questions[4] =  new Question( "Has entendido todo lo que has hecho", true);

        return this.questions;
    }

    public Player[] createPlayers(String[] names){
        this.players = new Player[names.length];
        for (int i = 0; i < names.length; i++) {
            this.players[i] = new Player(names[i]);
        }
        return players;
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

    public Player[] getPlayers() {
        return players;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public Player getAPlayer(int index){
        return players[index];
    }

    public static Player[] makeClasification(Player[] players){
        Arrays.sort(players, new PointsComparator());
        return players;
    }


}
