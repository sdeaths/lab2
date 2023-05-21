package com.example.lab2.ui.fragments;

import android.graphics.drawable.AnimatedVectorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import com.example.lab2.R;
import com.example.lab2.data.API.PlaceHolderPost;
import com.example.lab2.databinding.FragmentLoginBinding;
import com.example.lab2.ui.stateholder.viewmodels.LoginViewModel;

import java.util.List;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    public static final String KEYT = "telephone";
    public static final String KEYP = "password";
    public static final String KEY_RESULT = "result";

    private LoginViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);
        viewModel.getListPostLiveData().observe(getViewLifecycleOwner(), new Observer<List<PlaceHolderPost>>() {
            @Override
            public void onChanged(List<PlaceHolderPost> placeHolderPosts) {
                Log.d("MyLogs", placeHolderPosts.get(2).getTitle());
            }
        });
        viewModel.getPostLiveData().observe(getViewLifecycleOwner(), new Observer<PlaceHolderPost>() {
            @Override
            public void onChanged(PlaceHolderPost placeHolderPost) {
                Log.d("MyLogs", placeHolderPost.getTitle());
            }
        });
        viewModel.getPushPostLiveData().observe(getViewLifecycleOwner(), new Observer<PlaceHolderPost>() {
            @Override
            public void onChanged(PlaceHolderPost placeHolderPost) {
                Log.d("MyLogs", placeHolderPost.getTitle());
            }
        });
        super.onViewCreated(view, savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                AnimatedVectorDrawable drawable = (AnimatedVectorDrawable) binding.imageView.getDrawable();
                drawable.start();
            }
        }, 2000);
        pars();
        binding.acc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_registrationScreenFragment);
            }
        });
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (viewModel.loginAccount(
                        binding.textPhone.getText().toString(),
                        binding.password.getText().toString()
                ))
                    Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_userProfileFragment);
            }
        });
        getParentFragmentManager().setFragmentResultListener(KEY_RESULT, this, new FragmentResultListener() {
            @Override
            public void onFragmentResult(@NonNull String requestKey, @NonNull Bundle result) {
                binding.password.setText("");
                String userLogin = result.getString(KEYT);
                binding.textPhone.setText(userLogin);
            }
        });
        binding.adm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_administratorLoginFragment);
            }
        });
    }


    private void pars() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            if (bundle.getString(KEYT) == null) {
                String Phone = bundle.getString(KEYT);
                String Password = bundle.getString(KEYP);
                binding.textPhone.setText(Phone);
                binding.password.setText(Password);
            }
            else{
                String Phone = bundle.getString(KEYT);
                binding.textPhone.setText(Phone);
            }
        }
    }

    public static LoginFragment newInstance(String Phone, String Password) {
        LoginFragment loginFragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEYT, Phone);
        bundle.putString(KEYP, Password);
        loginFragment.setArguments(bundle);
        return loginFragment;
    }
}
