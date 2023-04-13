package com.example.lab2.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;

import com.example.lab2.R;
import com.example.lab2.ui.fragments.LoginFragment;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NavHostFragment navHost =
                (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.main_container);
        NavGraph graph = navHost.getNavController()
                .getNavInflater().inflate(R.navigation.main_navigation);

        Intent intent = getIntent();
        if (intent != null) {
            String action = intent.getAction();
            String type = intent.getType();
            if (Intent.ACTION_SEND.equals(action) && type != null) {
                if (type.equalsIgnoreCase("text/plain")) {
                    String textData = intent.getStringExtra(Intent.EXTRA_TEXT);
                    Bundle bundle = new Bundle();
                    bundle.putString(LoginFragment.KEYT, textData);
                    graph.setStartDestination(R.id.loginFragment);
                    navHost.getNavController().setGraph(graph, bundle);
                }
            } else {
                graph.setStartDestination(R.id.welcomeScreenFragment);
                navHost.getNavController().setGraph(graph);
            }
        }
    }
}