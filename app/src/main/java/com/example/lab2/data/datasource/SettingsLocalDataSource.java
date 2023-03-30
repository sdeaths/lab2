package com.example.lab2.data.datasource;

import com.example.lab2.R;
import com.example.lab2.domain.entity.ProfileSettingListItem;

import java.util.ArrayList;
import java.util.List;

public class SettingsLocalDataSource {

    public List<ProfileSettingListItem> getUserListSettings() {
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

    public List<ProfileSettingListItem> getAdminListSettings() {
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
