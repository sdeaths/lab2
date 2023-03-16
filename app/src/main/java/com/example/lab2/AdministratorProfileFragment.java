package com.example.lab2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.lab2.databinding.FragmentAdministratorProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class AdministratorProfileFragment extends Fragment {
    private FragmentAdministratorProfileBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAdministratorProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<ProfileSettingListItem> items = initSettings();
        SettingsRecyclerViewAdapter adapter = new SettingsRecyclerViewAdapter(items);
        binding.settingsList.setAdapter(adapter);
    }

    private List<ProfileSettingListItem> initSettings() {
        List<ProfileSettingListItem> items = new ArrayList<>();
        items.add(new ProfileSettingListItem(
                0,
                "Администратор",
                true
        ));
        items.add(new ProfileSettingListItem(
                R.drawable.location,
                "Категории",
                false
        ));
        items.add(new ProfileSettingListItem(
                R.drawable.card,
                "Продукты",
                false
        ));
        items.add(new ProfileSettingListItem(
                R.drawable.box,
                "Заказы",
                false
        ));
        items.add(new ProfileSettingListItem(
                R.drawable.logout,
                "Выход",
                false
        ));
        items.add(new ProfileSettingListItem(
                0,
                "Уведомления",
                true
        ));
        items.add(new ProfileSettingListItem(
                R.drawable.notification,
                "Настройки уведомлений",
                false
        ));
        return items;
    }
}
