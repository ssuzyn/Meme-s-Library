package com.example.memes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        TextView scoreText = findViewById(R.id.score_text);
        Button resetBtn = findViewById(R.id.reset_btn);

        int score = getIntent().getIntExtra("score", 0);
        int totalSize = getIntent().getIntExtra("totalSize", 0);

        // 점수 보여주기
        scoreText.setText(getString(R.string.count_label, score, totalSize));

        // 다시하기 버튼
        resetBtn.setOnClickListener(v -> {
            Intent intent = new Intent(ResultActivity.this, QuizActivity.class);
            startActivity(intent);
        });
    }
}
