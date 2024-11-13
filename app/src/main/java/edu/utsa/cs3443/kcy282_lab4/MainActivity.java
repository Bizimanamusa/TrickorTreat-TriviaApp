package edu.utsa.cs3443.kcy282_lab4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button trickButton = findViewById(R.id.trickButton);
        trickButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent trickIntent = new Intent(MainActivity.this, TrickActivity.class);
                startActivity(trickIntent);
            }
        });

        Button treatButton = findViewById(R.id.treatButton);
        treatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Launch TreatActivity
                Intent intent = new Intent(MainActivity.this, TreatActivity.class);
                startActivity(intent);
            }
        });
    }
}
