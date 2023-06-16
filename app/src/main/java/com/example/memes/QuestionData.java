package com.example.memes;

import java.util.ArrayList;

public class QuestionData {

    public static ArrayList<Question> getQuestion() {

        ArrayList<Question> queList = new ArrayList<>();

        Question q1 = new Question(
                1,
                "1 + 1은 무엇일까요?",
                "1",
                "2",
                "3",
                "4",
                2
        );

        Question q2 = new Question(
                2,
                "홍대 가려면 어디로 가야해요?",
                "지하철 타고 가세요",
                "버스요",
                "뉴진스 하입보이요",
                "뉴진면이요",
                3
        );

        Question q3 = new Question(
                3,
                "3 + 3?",
                "2",
                "4",
                "6",
                "8",
                3
        );

        queList.add(q1);
        queList.add(q2);
        queList.add(q3);

        return queList;
    }
}
