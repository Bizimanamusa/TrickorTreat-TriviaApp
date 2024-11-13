package edu.utsa.cs3443.kcy282_lab4;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.kcy282_lab4.model.Trivia;

public class TrickActivity extends AppCompatActivity {

    private Trivia trivia;  // The trivia model object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick);

        // Initialize the Trivia object and load a trivia question
        trivia = new Trivia();
        trivia.loadTrivia(this, "trivia.csv");

        // Find UI components
        TextView triviaQuestion = findViewById(R.id.triviaQuestion);
        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);

        // Set the question and answers from the trivia data
        triviaQuestion.setText(trivia.getQuestion());
        answer1.setText(trivia.getAnswer1());
        answer2.setText(trivia.getAnswer2());
        answer3.setText(trivia.getAnswer3());

        // Set OnClickListeners to check if answers are correct
        answer1.setOnClickListener(v -> showAnswerResult(1));
        answer2.setOnClickListener(v -> showAnswerResult(2));
        answer3.setOnClickListener(v -> showAnswerResult(3));
    }

    private void showAnswerResult(int answerIndex) {
        String message = trivia.isCorrect(answerIndex) ? "Correct!" : "Incorrect!";
        Toast.makeText(TrickActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
