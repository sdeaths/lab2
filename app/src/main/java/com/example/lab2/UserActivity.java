package com.example.lab2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2.databinding.ActivityUserBinding;

public class UserActivity extends AppCompatActivity {
    public static final String KEY = "user_phone";
    private String Phone = " ";
    private ActivityUserBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityUserBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        parsIntent();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultActivity();
            }
        });
    }
    public static Intent newUsrActivity (Context context, String phone){
        Intent intent = new Intent(context, UserActivity.class);
        intent.putExtra(KEY, "+7" + phone);
        return intent;
    }
    private void parsIntent (){
        if (!getIntent().hasExtra(KEY)){
            throw new RuntimeException("Напишите телефон");
        }
        Phone = getIntent().getStringExtra(KEY);
        binding.phoneNumber.setText(Phone);
    }
    private void resultActivity (){
        Intent intent = new Intent();
        intent.putExtra(KEY, Phone.substring(2));
        setResult(RESULT_OK,intent);
        finish();
    }

    @Override
    public void onBackPressed() {
        resultActivity();
        super.onBackPressed();
    }
}
