package com.example.lab2;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2.databinding.FragmentLoginBinding;
import com.example.lab2.databinding.FragmentWelcomeScreenBinding;

public class WelcomeScreenFragment extends Fragment {
    private FragmentWelcomeScreenBinding binding;

    private static final String TAG = "WelcomeScreenFragment";

    @Override
    public void onAttach(@NonNull Context context) {
        Toast.makeText(getContext(), "onAttach", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "onCreate", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "onCreateView", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreateView");
        binding = FragmentWelcomeScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "onViewCreated", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onViewCreated");
        super.onViewCreated(view, savedInstanceState);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.main_container, LoginFragment.class, null)
                        .addToBackStack(null)
                        .commit();
            }
        });
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        Toast.makeText(getContext(), "onViewStateRestored", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onViewStateRestored");
        super.onViewStateRestored(savedInstanceState);
    }

    @Override
    public void onStart() {
        Toast.makeText(getContext(), "onStart", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Toast.makeText(getContext(), "onResume", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Toast.makeText(getContext(), "onPause", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Toast.makeText(getContext(), "onStop", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        Toast.makeText(getContext(), "onSaveInstanceState", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onSaveInstanceState");
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        Toast.makeText(getContext(), "onDestroyView", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Toast.makeText(getContext(), "onDestroy", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Toast.makeText(getContext(), "onDetach", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onDetach");
        super.onDetach();
    }
}
