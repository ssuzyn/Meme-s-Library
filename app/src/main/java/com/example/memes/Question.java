package com.example.memes;

public class Question {
    int id;
    String question;
    String option_one;
    String option_two;
    String option_three;
    String option_four;
    int correct_answer;

    public Question(int id, String question, String option_one, String option_two, String option_three, String option_four, int correct_answer) {
        this.id = id;
        this.question = question;
        this.option_one = option_one;
        this.option_two = option_two;
        this.option_three = option_three;
        this.option_four = option_four;
        this.correct_answer = correct_answer;
    }


    public int getCorrect_answer(){
        return correct_answer;
    }
    public String getOptionOne() {
        return option_one;
    }
    public String getOptionTwo() {
        return option_two;
    }
    public String getOptionThree() {
        return option_three;
    }
    public String getOptionFour() {
        return option_four;
    }

    public String getQuestion() {
        return question;
    }
}
