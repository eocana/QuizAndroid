package com.example.quiz1;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1.model.Player;
import com.example.quiz1.model.Question;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionView;

    private TextView playerView;

    private int position = 0;

    private int round = 0;

    private int totalPlayers = 0;
    private boolean botonAPresionado = false;
    private boolean botonBPresionado = false;

    private Player[] players;
    private Player player_actual;

    private final QuizManager quizManager = new QuizManager();


    private void disableButtons(boolean action){
        trueButton.setEnabled(action);
        falseButton.setEnabled(action);
        nextButton.setEnabled(!action);

    }
    private void checkToast(boolean check){

        if (check){
            Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        String[] nombreJugadores = getIntent().getStringArrayExtra("nombres_jugadores");


        trueButton = (Button) findViewById(R.id.button_true);
        falseButton = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(R.id.button_next);
        questionView = (TextView) findViewById(R.id.questionView);
        playerView = (TextView) findViewById(R.id.nameplayer);
        totalPlayers = nombreJugadores.length;

        players = new Player[totalPlayers];

        players = quizManager.createPlayers(nombreJugadores);

        player_actual = quizManager.getAPlayer(0);

        nextButton.setEnabled(false);

        Question[] questions = quizManager.generateQuestions();

        questionView.setText(questions[position].getQuestion());
        playerView.setText("player: "+player_actual.getName());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botonAPresionado = true;
                //nextButton.setEnabled(true);
                disableButtons(false);
                boolean check = quizManager.checkQuestion(questions[position], true);
                checkToast(check);
                quizManager.actionPlayer(player_actual, check);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                botonBPresionado = true;
                //nextButton.setEnabled(true);
                disableButtons(false);
                boolean check = quizManager.checkQuestion(questions[position], false);
                checkToast(check);
                quizManager.actionPlayer(player_actual, check);

            }
        });

         nextButton.setOnClickListener(new View.OnClickListener() {
             @SuppressLint("SetTextI18n")
             @Override
             public void onClick(View view) {

                if (position < questions.length-1) {
                    position++;
                    disableButtons(true);
                    questionView.setText(questions[position].getQuestion());
                }else {
                    round++;
                    position = 0;

                    if (round == totalPlayers){
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("players", players);
                        startActivity(intent);
                    } else {

                        player_actual = quizManager.getAPlayer(round);
                        players[round] = player_actual;

                        playerView.setText("player: "+player_actual.getName());

                        questionView.setText(questions[position].getQuestion());
                        disableButtons(true);

                    }

                }
             }
         });


    }



}