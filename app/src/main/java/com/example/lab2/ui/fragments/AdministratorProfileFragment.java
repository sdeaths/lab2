package com.example.lab2.ui.fragments;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.lab2.R;
import com.example.lab2.SaleService;
import com.example.lab2.databinding.FragmentAdministratorProfileBinding;
import com.example.lab2.data.database.entity.ProfileSettingListItem;
import com.example.lab2.ui.stateholder.viewmodels.AdministratorProfileViewModel;
import com.example.lab2.ui.stateholder.SettingsRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class AdministratorProfileFragment extends Fragment {
    private FragmentAdministratorProfileBinding binding;
    private final static String CHANNEL_ID = "Sales";

    private AdministratorProfileViewModel viewModel;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentAdministratorProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        viewModel = new ViewModelProvider(this).get(AdministratorProfileViewModel.class);
        super.onViewCreated(view, savedInstanceState);
        viewModel.listLiveData.observe(getViewLifecycleOwner(), new Observer<List<ProfileSettingListItem>>() {
            @Override
            public void onChanged(List<ProfileSettingListItem> profileSettingListItems) {
                SettingsRecyclerViewAdapter adapter = new SettingsRecyclerViewAdapter(profileSettingListItems);
                adapter.onSettingItemListClickListener = new SettingsRecyclerViewAdapter.OnSettingItemListClickListener() {
                    @Override
                    public void onSettingItemListClickListener(int position) {
                    }
                };
                binding.settingsList.setAdapter(adapter);
            }
        });


        // Создание канала уведомлений
        NotificationChannel channel = new NotificationChannel(
                CHANNEL_ID,
                "sales",
                NotificationManager.IMPORTANCE_DEFAULT
        );

        NotificationManager notificationManager =
                (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.createNotificationChannel(channel);

        binding.notifyButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создание уведомления
                Notification notification = new NotificationCompat.Builder(requireContext(), CHANNEL_ID)
                        .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                        .setContentText("Скидка на товар 20%")
                        .setContentTitle("Акция")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                        .build();

                NotificationManager notificationManager =
                        (NotificationManager) requireContext().getSystemService(Context.NOTIFICATION_SERVICE);

                notificationManager.notify(1, notification);

                // Запуск сервиса
                Intent intent = new Intent(requireContext(), SaleService.class);
                requireActivity().startService(intent);
            }
        });
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
