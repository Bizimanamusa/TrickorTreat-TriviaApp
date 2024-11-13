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

    private List<TriviaQuestion> triviaQuestions = new ArrayList<>();

    public Trivia() {
        // Default constructor
    }

    // Getter and setter methods
    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getExplanation() {
        return explanation;
    }

    public boolean isCorrect(int answerIndex) {
        return answerIndex == correctAnswerIndex;
    }

    // This method loads trivia data from the CSV file located in assets
    public void loadTrivia(Context context, String filename) {
        try {
            // Open the CSV file from assets
            BufferedReader reader = new BufferedReader(new InputStreamReader(context.getAssets().open(filename)));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",", 4);  // Splitting into 4 parts (question, 3 answers, explanation)

                // Make sure we have exactly 4 elements in the array
                if (data.length == 4) {
                    String question = data[0];
                    String answer1 = data[1];
                    String answer2 = data[2];
                    String answer3 = data[3];

                    // Add the trivia question to the list (for later random selection)
                    triviaQuestions.add(new TriviaQuestion(question, answer1, answer2, answer3, 1)); // Correct answer logic needs to be updated later
                }
            }
            reader.close();

            // Randomly select a trivia question from the list
            if (!triviaQuestions.isEmpty()) {
                Random random = new Random();
                TriviaQuestion selectedQuestion = triviaQuestions.get(random.nextInt(triviaQuestions.size()));

                setQuestion(selectedQuestion.getQuestion());
                setAnswer1(selectedQuestion.getAnswer1());
                setAnswer2(selectedQuestion.getAnswer2());
                setAnswer3(selectedQuestion.getAnswer3());
                // Note: Correct answer index will need additional logic based on the question
                // This is a placeholder; you should set the correct answer index based on data
                this.correctAnswerIndex = 1;  // This is just a placeholder
                this.explanation = "This is where the explanation will go.";
            }
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Trivia", "Error loading trivia questions from CSV", e);
        }
    }

    // Setter methods
    private void setQuestion(String question) {
        this.question = question;
    }

    private void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    private void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    private void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    // Inner class to represent a trivia question
    private static class TriviaQuestion {
        private String question;
        private String answer1;
        private String answer2;
        private String answer3;
        private int correctAnswerIndex;

        public TriviaQuestion(String question, String answer1, String answer2, String answer3, int correctAnswerIndex) {
            this.question = question;
            this.answer1 = answer1;
            this.answer2 = answer2;
            this.answer3 = answer3;
            this.correctAnswerIndex = correctAnswerIndex;
        }

        public String getQuestion() {
            return question;
        }

        public String getAnswer1() {
            return answer1;
        }

        public String getAnswer2() {
            return answer2;
        }

        public String getAnswer3() {
            return answer3;
        }

        public int getCorrectAnswerIndex() {
            return correctAnswerIndex;
        }
    }
}
