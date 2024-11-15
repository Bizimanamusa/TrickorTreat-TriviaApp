package edu.utsa.cs3443.kcy282_lab4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class TreatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat);

        // Find the ImageView and Button
        ImageView imageView = findViewById(R.id.defaultImageView);
        Button treatButton = findViewById(R.id.btnTreat);

        // List of images to choose from
        int[] images = new int[]{
                R.drawable.treat1,   // Replace with your actual image names
                R.drawable.treat2,
                R.drawable.treat3,
                R.drawable.treat4
        };

        // Initialize random generator
        Random random = new Random();

        // Set the random image to the ImageView on activity start
        int randomIndex = random.nextInt(images.length);
        imageView.setImageResource(images[randomIndex]);

        // Set up the button click listener to load a new random image
        treatButton.setOnClickListener(v -> {
            int newRandomIndex = random.nextInt(images.length); // Get a new random image
            imageView.setImageResource(images[randomIndex]); // Update the ImageView
        });

        // Set up edge-to-edge display and apply insets padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    // Method to handle the "Back" button
    public void goBack(View view) {
        finish(); // Closes the activity and returns to the previous screen
    }
}
