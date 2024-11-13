package edu.utsa.cs3443.kcy282_lab4.model;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Trivia {

    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private int correctAnswerIndex;
    private String explanation;

    private final List<TriviaQuestion> triviaQuestions = new ArrayList<>();

    public Trivia() {
        // Default constructor
    }

    // Getter methods
    public String getQuestion() { return question; }
    public String getAnswer1() { return answer1; }
    public String getAnswer2() { return answer2; }
    public String getAnswer3() { return answer3; }
    public String getExplanation() { return explanation; }
    public boolean isCorrect(int answerIndex) { return answerIndex == correctAnswerIndex; }

    // Method to load trivia data from the CSV file located in assets
    public void loadTrivia(Context context, String filename) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 5);  // Expecting 5 parts: question, 3 answers, correct answer index

                // Check if each line has exactly 5 elements
                if (data.length == 5) {
                    try {
                        String question = data[0];
                        String answer1 = data[1];
                        String answer2 = data[2];
                        String answer3 = data[3];
                        int correctAnswerIndex = Integer.parseInt(data[4].trim());  // Parse correct answer index

                        // Add the trivia question to the list for later random selection
                        triviaQuestions.add(new TriviaQuestion(question, answer1, answer2, answer3, correctAnswerIndex));
                    } catch (NumberFormatException e) {
                        Log.e("Trivia", "Error parsing correct answer index for line: " + line, e);
                    }
                } else {
                    Log.e("Trivia", "Incorrect format in CSV line: " + line);
                }
            }
            reader.close();

            // Select a random trivia question
            selectRandomTrivia();

        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Trivia", "Error loading trivia questions from CSV", e);
        }
    }

    // Selects a random trivia question from the list and sets it as the current trivia
    private void selectRandomTrivia() {
        if (!triviaQuestions.isEmpty()) {
            Random random = new Random();
            TriviaQuestion selectedQuestion = triviaQuestions.get(random.nextInt(triviaQuestions.size()));

            // Set the current question and answers
            setQuestion(selectedQuestion.getQuestion());
            setAnswer1(selectedQuestion.getAnswer1());
            setAnswer2(selectedQuestion.getAnswer2());
            setAnswer3(selectedQuestion.getAnswer3());
            Log.d("Trivia", "Question: " + question);
            Log.d("Trivia", "Answer 1: " + answer1);
            Log.d("Trivia", "Answer 2: " + answer2);
            Log.d("Trivia", "Answer 3: " + answer3);
            this.correctAnswerIndex = selectedQuestion.getCorrectAnswerIndex();
            this.explanation = "Explanation not provided"; // Placeholder if explanation is not included
        } else {
            Log.e("Trivia", "No trivia questions loaded.");
        }
    }

    // Setter methods
    private void setQuestion(String question) { this.question = question; }
    private void setAnswer1(String answer1) { this.answer1 = answer1; }
    private void setAnswer2(String answer2) { this.answer2 = answer2; }
    private void setAnswer3(String answer3) { this.answer3 = answer3; }

    // Inner class to represent a trivia question
    private static class TriviaQuestion {
        private final String question;
        private final String answer1;
        private final String answer2;
        private final String answer3;
        private final int correctAnswerIndex;

        public TriviaQuestion(String question, String answer1, String answer2, String answer3, int correctAnswerIndex) {
            this.question = question;
            this.answer1 = answer1;
            this.answer2 = answer2;
            this.answer3 = answer3;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestion() { return question; }
        public String getAnswer1() { return answer1; }
        public String getAnswer2() { return answer2; }
        public String getAnswer3() { return answer3; }
        public int getCorrectAnswerIndex() { return correctAnswerIndex; }
    }
}
