package com.example.quiz1;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.quiz1.model.Question;

public class MainActivity extends AppCompatActivity {

    private Button trueButton;
    private Button falseButton;
    private Button nextButton;
    private TextView questionView;

    private int position = 0;
    private int points = 0;

    private boolean botonAPresionado = false;
    private boolean botonBPresionado = false;

    private final QuizManager quizManager = new QuizManager();


    private void disableButtons(boolean action){
        trueButton.setEnabled(action);
        falseButton.setEnabled(action);
        nextButton.setEnabled(!action);

    }
    private void checkQuestion(Question question, boolean answer){

        if (question.trueOrFalse() == answer){
            System.out.println(question.trueOrFalse());
            points = points+10;
            Toast.makeText(MainActivity.this, R.string.correct_toast, Toast.LENGTH_SHORT).show();
        } else {
            points = points-2;
            Toast.makeText(MainActivity.this, R.string.incorrect_toast, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] nombreJugadores = getIntent().getStringArrayExtra("nombres_jugadores");

        quizManager.createPlayers(nombreJugadores);

        Question[] questions = quizManager.generateQuestions();

        trueButton = (Button) findViewById(R.id.button_true);
        falseButton = (Button) findViewById(R.id.button_false);
        nextButton = (Button) findViewById(R.id.button_next);
        nextButton.setEnabled(false);

        questionView = (TextView) findViewById(R.id.questionView);
        questionView.setText(questions[position].getQuestion());

        trueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botonAPresionado = true;
                //nextButton.setEnabled(true);
                disableButtons(false);
                checkQuestion(questions[position], true);
            }
        });

        falseButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                botonBPresionado = true;
                //nextButton.setEnabled(true);
                disableButtons(false);
                checkQuestion(questions[position], false);
            }
        });

         nextButton.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {

                if (position < questions.length-1) {
                    position++;
                    disableButtons(true);
                    //nextButton.setEnabled(false);
                    questionView.setText(questions[position].getQuestion());
                }else {
                    Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                    intent.putExtra("points", points);
                    startActivity(intent);
                }
             }
         });


    }



}