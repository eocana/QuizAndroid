package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu1Activity extends AppCompatActivity {

    private Button buttonNext;
    private EditText editTextPlayers;

    private int numberPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setEnabled(false);

        editTextPlayers = (EditText) findViewById(R.id.editTextPlayers);

        editTextPlayers.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() == 0) {
                    buttonNext.setEnabled(false);
                } else {
                    buttonNext.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

        });


        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              numberPlayers = Integer.parseInt(editTextPlayers.getText().toString());
              if (numberPlayers > 0){
                  Intent intent = new Intent(Menu1Activity.this, NamesPlayersActivity.class);
                  intent.putExtra("num_jugadores", numberPlayers);
                  startActivity(intent);


              }
            }
        });

    }
}