package com.example.lab2.ui.fragments;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentRegistrationScreenBinding;
import com.example.lab2.ui.stateholder.viewmodels.RegistrationViewModel;

public class RegistrationScreenFragment extends Fragment {
    private FragmentRegistrationScreenBinding binding;
    private static final String SHARED_PREF_NAME = "name";
    private RegistrationViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentRegistrationScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(RegistrationViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        // read
        SharedPreferences sharedPrefRead =
                requireActivity().getPreferences(Context.MODE_PRIVATE);
        String loginSP = sharedPrefRead.getString(SHARED_PREF_NAME, "");
        binding.inputName.setText(loginSP);
        binding.acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_registrationScreenFragment_to_loginFragment);
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // write
                SharedPreferences sharedPrefWrite =
                        requireActivity().getPreferences(Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPrefWrite.edit();
                editor.putString(SHARED_PREF_NAME,
                        binding.inputName.getText().toString());
                editor.apply();
                if (binding.password.getText().toString().equals(binding.confirmPassword.getText().toString())) {
                    if (viewModel.registrationAccount(
                            binding.textPhone.getText().toString(),
                            binding.password.getText().toString(),
                            binding.inputName.getText().toString()
                    ))
                        Navigation.findNavController(v).navigate(R.id.action_registrationScreenFragment_to_loginFragment);
                }
            }
        });
    }
}
