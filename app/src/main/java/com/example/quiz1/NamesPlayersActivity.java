package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NamesPlayersActivity extends AppCompatActivity {
    private EditText nombreJugadorEditText;
    private Button siguienteButton;
    private TextView numJugadoresTextView;
    private int numJugadores;
    private String[] nombresJugadores;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names_players);
        nombreJugadorEditText = findViewById(R.id.nombre_jugador_edit_text);
        siguienteButton = findViewById(R.id.siguiente_button);

        numJugadores = getIntent().getIntExtra("num_jugadores", 0);
        nombresJugadores = new String[numJugadores];

        siguienteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombresJugadores[index] = nombreJugadorEditText.getText().toString();
                if (index == numJugadores-1) {
                    // Ya se ingresaron todos los nombres
                    Intent intent = new Intent(NamesPlayersActivity.this, MainActivity.class);
                    intent.putExtra("nombres_jugadores", nombresJugadores);
                    startActivity(intent);
                } else {

                    index++;
                    nombreJugadorEditText.setText("");

                }
            }
        });
    }


}