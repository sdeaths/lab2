package com.example.lab2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if (result != null && result.getResultCode() == RESULT_OK) {
                        if (result.getData() != null && result.getData().getStringExtra(UserActivity.KEY) != null) {
                            binding.textPhone.setText(result.getData().getStringExtra(UserActivity.KEY));
                            binding.password.setText("");
                        }
                    }
                }
            });
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
//        TextView textAuthorization = findViewById(R.id.textAuthorization);
        binding.textAuthorization.setText(R.string.authorization);
//        ImageView imageView = findViewById(R.id.imageView);
        binding.imageView.setImageResource(R.drawable.logo);
//        Button button = findViewById(R.id.button);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onClick", "button clicked");
                startForResult.launch(UserActivity.newUsrActivity(MainActivity.this, binding.textPhone.getText().toString()));
            }
        });

    }

//    public void logInClick(View view) {
//        Log.d("onClick", "button clicked");
//    }

}