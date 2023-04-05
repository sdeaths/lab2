package com.example.lab2.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.data.database.entity.ProfileSettingListItem;
import com.example.lab2.databinding.ItemSettingsProfileListBinding;
import com.example.lab2.ui.stateholder.viewmodels.SettingsProfileListItemViewModel;

public class SettingsProfileListItem extends Fragment {

    private ItemSettingsProfileListBinding binding;
    private SettingsProfileListItemViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = ItemSettingsProfileListBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(SettingsProfileListItemViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        parseArgs();
        viewModel.profileSettingListItemLiveData.observe(getViewLifecycleOwner(), new Observer<ProfileSettingListItem>() {
            @Override
            public void onChanged(ProfileSettingListItem profileSettingListItem) {
                binding.titleSetting.setText(profileSettingListItem.getSettingsTitle());
            }
        });
    }

    private void parseArgs() {
        Bundle bundle = this.getArguments();
        if (bundle != null) {
            int position = bundle.getInt(UserProfileFragment.KEY_POS);
            viewModel.getSettingListItem(position);
        }
    }
}
