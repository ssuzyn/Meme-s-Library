package com.example.memes;

import java.util.ArrayList;

public class QuestionData {

    public static ArrayList<Question> getQuestion() {

        ArrayList<Question> queList = new ArrayList<>();

        Question q1 = new Question(
                1,
                "1 + 1?",
                "1",
                "2",
                "3",
                "4",
                2
        );

        Question q2 = new Question(
                1,
                "2 + 2?",
                "2",
                "3",
                "4",
                "5",
                3
        );

        Question q3 = new Question(
                1,
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
