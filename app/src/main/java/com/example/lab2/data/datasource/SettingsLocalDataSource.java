package com.example.lab2.data.datasource;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.lab2.R;
import com.example.lab2.data.models.ProfileSettingListItem;

import java.util.ArrayList;
import java.util.List;


public class SettingsLocalDataSource {

    List<ProfileSettingListItem> items = new ArrayList<>();

    public LiveData<List<ProfileSettingListItem>> getUserListSettings() {
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
        MutableLiveData<List<ProfileSettingListItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(items);
        return mutableLiveData;
    }

    public LiveData<List<ProfileSettingListItem>> getAdminListSettings() {
        List<ProfileSettingListItem> adminItems = new ArrayList<>();
        adminItems.add(new ProfileSettingListItem(
                0,
                "Администратор",
                true
        ));
        adminItems.add(new ProfileSettingListItem(
                R.drawable.location,
                "Категории",
                false
        ));
        adminItems.add(new ProfileSettingListItem(
                R.drawable.card,
                "Продукты",
                false
        ));
        adminItems.add(new ProfileSettingListItem(
                R.drawable.box,
                "Заказы",
                false
        ));
        adminItems.add(new ProfileSettingListItem(
                R.drawable.logout,
                "Выход",
                false
        ));
        adminItems.add(new ProfileSettingListItem(
                0,
                "Уведомления",
                true
        ));
        adminItems.add(new ProfileSettingListItem(
                R.drawable.notification,
                "Настройки уведомлений",
                false
        ));
        MutableLiveData<List<ProfileSettingListItem>> mutableLiveData = new MutableLiveData<>();
        mutableLiveData.setValue(adminItems);
        return mutableLiveData;
    }

    public LiveData<ProfileSettingListItem> getProfileItem(int position) {
        getUserListSettings();
        MutableLiveData<ProfileSettingListItem> data = new MutableLiveData<>();
        data.setValue(items.get(position));
        return data;
    }
}
