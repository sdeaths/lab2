package com.example.lab2.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.navigation.Navigation;

import com.example.lab2.R;
import com.example.lab2.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {
    private FragmentLoginBinding binding;
    public static final String KEYT = "telephone";
    public static final String KEYP = "password";
    public static final String KEY_RESULT = "result";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
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


    private void pars (){
        Bundle bundle = this.getArguments();
        if (bundle != null){
            String Phone = bundle.getString(KEYT);
            String Password = bundle.getString(KEYP);
            binding.textPhone.setText(Phone);
            binding.password.setText(Password);
        }
    }
    public static LoginFragment newInstance (String Phone, String Password){
        LoginFragment loginFragment = new LoginFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEYT, Phone);
        bundle.putString(KEYP, Password);
        loginFragment.setArguments(bundle);
        return  loginFragment;
    }
}
