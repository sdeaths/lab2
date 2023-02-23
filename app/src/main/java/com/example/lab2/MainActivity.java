package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView textAuthorization = findViewById(R.id.textAuthorization);
        textAuthorization.setText(R.string.authorization);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.logo);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onClick", "button clicked");
            }
        });
    }

//    public void logInClick(View view) {
//        Log.d("onClick", "button clicked");
//    }

}