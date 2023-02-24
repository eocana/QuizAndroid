package com.example.quiz1;

import static com.example.quiz1.QuizManager.makeClasification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.quiz1.model.Player;


public class ResultActivity extends AppCompatActivity {

    private TextView textView;
    private Button buttonExit;

    private Button newGame;

    private Player[] players;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        players = (Player[]) getIntent().getSerializableExtra("players");
        players = makeClasification(players);
        LinearLayout linearLayout = findViewById(R.id.linear_layout);



        buttonExit = (Button) findViewById(R.id.button_finish);
        newGame = (Button) findViewById(R.id.button_newgame);

        for (int i = 0; i < players.length; i++) {
            TextView textView1 = new TextView(this);
            textView1.setText("Player: "+players[i].getName());
            textView1.setTextSize(24);
            textView1.setTextColor(Color.BLACK);

            TextView textView2 = new TextView(this);
            textView2.setText("Total points: "+players[i].getPoints());
            textView2.setTextSize(24);
            textView2.setTextColor(Color.BLACK);

            linearLayout.addView(textView1);
            linearLayout.addView(textView2);

            if (i % 2 == 0) {
                View space = new View(this);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        30 // Ajusta la altura de la separación aquí
                );
                space.setLayoutParams(params);
                linearLayout.addView(space);
            }
        }

        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultActivity.this, Menu1Activity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(intent);
                finish(); // Opcional: finaliza la Activity actual para liberar recursos
            }
        });

        buttonExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //finish(); //me devuelve a la MainActivity
                finishAffinity(); //cierra TODAS las pantallas

            }
        });

       // pointsView.setText(Integer.toString(points));

    }

}