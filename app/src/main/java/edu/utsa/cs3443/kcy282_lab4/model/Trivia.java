package edu.utsa.cs3443.kcy282_lab4.model;

import java.util.Random;

public class Trivia {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private int correctAnswerIndex; // The index of the correct answer (1, 2, or 3)

    public Trivia() {
        // Default constructor
    }

    // Getter and setter methods for the variables
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    // This method loads a random trivia question and its answers
    public void loadTrivia(String filename) {
        // For this example, we'll use hardcoded data, but you'll load from a file
        Random random = new Random();
        int questionIndex = random.nextInt(3); // Simulate loading a random question

        switch (questionIndex) {
            case 0:
                setQuestion("What is the capital of Halloween?");
                setAnswer1("Spookyville");
                setAnswer2("Tricktopolis");
                setAnswer3("Haunt City");
                correctAnswerIndex = 1;
                break;
            case 1:
                setQuestion("What is a common Halloween color?");
                setAnswer1("Red");
                setAnswer2("Black");
                setAnswer3("Green");
                correctAnswerIndex = 2;
                break;
            case 2:
                setQuestion("Which creature says 'Boo!'?");
                setAnswer1("Ghost");
                setAnswer2("Bat");
                setAnswer3("Zombie");
                correctAnswerIndex = 1;
                break;
        }
    }
}
