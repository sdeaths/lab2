package com.example.lab2;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.example.lab2.databinding.FragmentAdministratorProfileBinding;

import java.util.ArrayList;
import java.util.List;

public class AdministratorProfileFragment extends Fragment {
    private FragmentAdministratorProfileBinding binding;
    private final static String CHANNEL_ID = "Sales";

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
