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
import com.example.lab2.databinding.FragmentUserProfileBinding;
import com.example.lab2.data.models.ProfileSettingListItem;
import com.example.lab2.ui.stateholder.SettingsRecyclerViewAdapter;
import com.example.lab2.ui.stateholder.UserProfileViewModel;

import java.util.ArrayList;
import java.util.List;

public class UserProfileFragment extends Fragment {
    private FragmentUserProfileBinding binding;
    private UserProfileViewModel viewModel;
    public static String KEY_POS = "pos";
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentUserProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(UserProfileViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        List<ProfileSettingListItem> items = initSettings();
        SettingsRecyclerViewAdapter adapter = new SettingsRecyclerViewAdapter(items);
        adapter.onSettingItemListClickListener = new SettingsRecyclerViewAdapter.OnSettingItemListClickListener() {
            @Override
            public void onSettingItemListClickListener(int position) {
                Bundle bundle = new Bundle();
                bundle.putInt(KEY_POS, position);
                Navigation.findNavController(requireView())
                        .navigate(R.id.action_userProfileFragment_to_settingsProfileListItem, bundle);
            }
        };
        binding.settingsList.setAdapter(adapter);

    }

    @NonNull
    private List<ProfileSettingListItem> initSettings() {
        List<ProfileSettingListItem> items = new ArrayList<>();
        items.add(new ProfileSettingListItem(
                0,
                "Мой Аккаунт",
                true
        ));
        items.add(new ProfileSettingListItem(
                R.drawable.location,
                "Пункт выдачи",
                false
        ));
        items.add(new ProfileSettingListItem(
                R.drawable.card,
                "Пополнить баланс",
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
                "Пуш-уведомления",
                false
        ));
        items.add(new ProfileSettingListItem(
                R.drawable.notification,
                "Акции и уведомления",
                false
        ));
        return items;
    }
}
