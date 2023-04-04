package com.example.lab2.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2.databinding.FragmentUserBinding;

public class UserFragment extends Fragment {
    private FragmentUserBinding binding;
    public static final String KEYT = "telephone";

    private String Phone = "";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        pars();
        binding.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle result = new Bundle();
                result.putString(LoginFragment.KEYT, Phone);
                getParentFragmentManager().setFragmentResult(LoginFragment.KEY_RESULT, result);
                requireActivity().onBackPressed();
            }
        });
    }

    private void pars(){
        Bundle bundle = this.getArguments();
        if (bundle != null){
            Phone = bundle.getString(KEYT);
            binding.phoneNumber.setText("+7" + Phone);
        }
    }

    public static UserFragment newInstance(String Phone){
        UserFragment userFragment = new UserFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEYT, Phone);
        userFragment.setArguments(bundle);
        return  userFragment;
    }
}
