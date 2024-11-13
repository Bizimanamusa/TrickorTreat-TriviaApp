package edu.utsa.cs3443.kcy282_lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import edu.utsa.cs3443.kcy282_lab4.model.Trivia;

public class TrickActivity extends AppCompatActivity {

    private Trivia trivia; // The trivia model object

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trick);

        // Create the Trivia object and load a random trivia question
        trivia = new Trivia();
        trivia.loadTrivia(this, "trivia.csv");

        // Set the trivia question on the TextView
        TextView triviaQuestion = findViewById(R.id.triviaQuestion);
        triviaQuestion.setText(trivia.getQuestion());

        // Set the answers on the buttons
        Button answer1 = findViewById(R.id.answer1);
        Button answer2 = findViewById(R.id.answer2);
        Button answer3 = findViewById(R.id.answer3);

        answer1.setText(trivia.getAnswer1());
        answer2.setText(trivia.getAnswer2());
        answer3.setText(trivia.getAnswer3());

        // Set OnClickListeners for each answer button
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerResult(1); // Check if the first answer is correct
            }
        });

        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerResult(2); // Check if the second answer is correct
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAnswerResult(3); // Check if the third answer is correct
            }
        });
    }

    private void showAnswerResult(int answerIndex) {
        // Check if the selected answer is correct
        String message;
        if (trivia.isCorrect(answerIndex)) {
            message = "Correct!";
        } else {
            message = "Incorrect!";
        }

        // Display a Toast with the result
        Toast.makeText(TrickActivity.this, message, Toast.LENGTH_SHORT).show();
    }
}
