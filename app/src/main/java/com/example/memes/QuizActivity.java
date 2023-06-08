package com.example.memes;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {

    private ProgressBar progressBar;
    private TextView progressText;
    private TextView questionText;
    private Button option1;
    private Button option2;
    private Button option3;
    private Button option4;
    private Button submitBtn;

    private ArrayList<Question> questionList;

    private int currentPosition = 1; //질문 위치
    private int selectedOption = 0; // 선택 옵션
    private int score = 0; //점수

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        progressBar = findViewById(R.id.progressBar);
        progressText = findViewById(R.id.progressText);
        questionText = findViewById(R.id.questionText);
        option1 = findViewById(R.id.option1_text);
        option2 = findViewById(R.id.option2_text);
        option3 = findViewById(R.id.option3_text);
        option4 = findViewById(R.id.option4_text);
        submitBtn = findViewById(R.id.submitBtn);

        //질문 리스트 가져 오기
        questionList = QuestionData.getQuestion();

        for(int i = 0; i < 3; i++){
            System.out.println(questionList.get(i).getQuestion());
        }

        //화면 셋팅
        getQuestionData();

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        submitBtn.setOnClickListener(view -> {
            if (selectedOption != 0) {
                Question question = questionList.get(currentPosition - 1);

                //정답 체크(선택 답변과 정답을 비교)
                if (selectedOption != question.getCorrect_answer()) { //오답
                    setColor(selectedOption, R.drawable.wrong_option_background);
                    callDialog("오답", "정답 " + question.getCorrect_answer());
                } else {
                    score++;
                }
                setColor(question.getCorrect_answer(), R.drawable.correct_option_background);

                if (currentPosition == questionList.size()) {
                    ((Button) view).setText(getString(R.string.submit, "끝"));
                } else {
                    ((Button) view).setText(getString(R.string.submit, "다음"));
                }
            } else {
                //위치값 상승
                currentPosition++;
                if (currentPosition <= questionList.size()) {
                    //다음 문제 셋팅
                    getQuestionData();
                } else {
                    Intent intent = new Intent(QuizActivity.this, ResultActivity.class);
                    intent.putExtra("score", score);
                    intent.putExtra("totalSize", questionList.size());
                    startActivity(intent);
                    finish();
                }

            }
            //선택값 초기화
            selectedOption = 0;
        });

    }

    // 답변 배경색 변경
    private void setColor(int opt, int color) {
        switch (opt) {
            case 1:
                option1.setBackgroundColor(ContextCompat.getColor(this, color));
                break;
            case 2:
                option2.setBackgroundColor(ContextCompat.getColor(this, color));
                break;
            case 3:
                option3.setBackgroundColor(ContextCompat.getColor(this, color));
                break;
            case 4:
                option4.setBackgroundColor(ContextCompat.getColor(this, color));
                break;
        }
    }

    // 정답 확인 다이얼로그
    private void callDialog(String alertTitle, String correctAnswer) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle)
                .setMessage("정답: " + correctAnswer)
                .setPositiveButton("OK", (dialog, which) -> {
                    dialog.dismiss(); // 창 닫기
                })
                .setCancelable(false)
                .show();
    }


    private void getQuestionData() {
        setOptionStyle();

        //질문 변수에 담기
        Question question = questionList.get(currentPosition - 1);

        //상태바 위치
        progressBar.setProgress(currentPosition);

        //상태바 최대값
        progressBar.setMax(questionList.size());

        //현재 위치 표시
        progressText.setText(getString(R.string.count_label, currentPosition, questionList.size()));

        //질문 표시
        questionText.setText(question.getQuestion());

        //답변 표시
        option1.setText(question.getOptionOne());
        option2.setText(question.getOptionTwo());
        option3.setText(question.getOptionThree());
        option4.setText(question.getOptionFour());

        setSubmitBtn("제출");
    }

    //제출 버튼 텍스트 설정
    private void setSubmitBtn(String name) {
        submitBtn.setText(getString(R.string.submit, name));
    }
    /**
    *답변 스타일 설정
     * */
    private void setOptionStyle() {
        ArrayList<TextView> optionList = new ArrayList<>();
        optionList.add(option1);
        optionList.add(option2);
        optionList.add(option3);
        optionList.add(option4);

        //답변 텍스트 뷰 설정
        for (TextView op : optionList) {
            op.setTextColor(Color.parseColor("#555151"));
            op.setBackground(ContextCompat.getDrawable(this, R.drawable.option_background));
            op.setTypeface(Typeface.DEFAULT);
        }
    }

    /**
     * 답변 선택 이벤트
     */
    private void selectedOptionStyle(TextView view, int opt) {
        //옵션 초기화
        setOptionStyle();

        //위치 담기
        selectedOption = opt;

        view.setTextColor((Color.parseColor("#5F00FF")));
        view.setBackground(ContextCompat.getDrawable(this, R.drawable.selected_option_background));
        view.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void onClick(View view) {
        int id = view.getId();

        if (id == R.id.option1_text) {
            selectedOptionStyle(option1, 1);
        } else if (id == R.id.option2_text) {
            selectedOptionStyle(option2, 2);
        } else if (id == R.id.option3_text) {
            selectedOptionStyle(option3, 3);
        } else if (id == R.id.option4_text) {
            selectedOptionStyle(option4, 4);
        } else {
            throw new IllegalStateException("Unexpected value: " + id);
        }
    }

}
