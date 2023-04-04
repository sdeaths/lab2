package com.example.lab2.data.repositories;

import androidx.lifecycle.LiveData;

import com.example.lab2.data.protocols.SettingsProtocol;
import com.example.lab2.data.datasource.SettingsLocalDataSource;
import com.example.lab2.data.models.ProfileSettingListItem;

import java.util.List;

public class SettingsRepository implements SettingsProtocol {

    private final SettingsLocalDataSource dataSource = new SettingsLocalDataSource();

    @Override
    public LiveData<List<ProfileSettingListItem>> getUserSettingsList() {
        return dataSource.getUserListSettings();
    }

    @Override
    public LiveData<ProfileSettingListItem> getProfileItem(int position) {
        return dataSource.getProfileItem(position);
    }

    @Override
    public LiveData<List<ProfileSettingListItem>> getAdminSettingsList() {
        return dataSource.getAdminListSettings();
    }
}
