package com.example.quiz1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class Menu1Activity extends AppCompatActivity {

    private Button buttonNext;
    private EditText editTextPlayers;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

        buttonNext = (Button) findViewById(R.id.buttonNext);
        buttonNext.setEnabled(false);

        editTextPlayers = (EditText) findViewById(R.id.editTextPlayers);


    }
}