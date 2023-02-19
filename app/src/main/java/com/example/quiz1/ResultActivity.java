package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    private TextView pointsView;
    private Button buttonExit;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        int points = getIntent().getIntExtra("points",0);

        pointsView = (TextView) findViewById(R.id.resultView);
        buttonExit = (Button) findViewById(R.id.button_finish);

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish(); //me devuelve a la MainActivity
                finishAffinity(); //cierra TODAS las pantallas

            }
        });

        pointsView.setText(Integer.toString(points));

    }

}