package com.example.memes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGotoQuiz = findViewById(R.id.btnGotoQuiz);
        btnGotoQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, QuizActivity.class);
            startActivity(intent);
        });

        Button btnAddQuiz = findViewById(R.id.btnAddQuiz);
        btnAddQuiz.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddQuizActivity.class);
            startActivity(intent);
        });
    }
}