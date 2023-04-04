package com.example.lab2.ui.fragments;

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
import com.example.lab2.databinding.FragmentAdministratorLoginBinding;
import com.example.lab2.ui.stateholder.viewmodels.AdministratorLoginViewModel;

public class AdministratorLoginFragment extends Fragment {
    private FragmentAdministratorLoginBinding binding;

    private AdministratorLoginViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAdministratorLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AdministratorLoginViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModel.loginAccount(
                        binding.inputName.getText().toString(),
                        binding.inputKey.getText().toString()
                ))
                    Navigation.findNavController(v).navigate(R.id.action_administratorLoginFragment_to_administratorProfileFragment);
            }
        });
    }
}
