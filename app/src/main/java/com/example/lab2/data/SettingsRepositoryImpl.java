package com.example.lab2.data;

import com.example.lab2.data.datasource.SettingsLocalDataSource;
import com.example.lab2.domain.SettingsRepository;
import com.example.lab2.domain.entity.ProfileSettingListItem;

import java.util.List;

public class SettingsRepositoryImpl implements SettingsRepository {

    private final SettingsLocalDataSource dataSource = new SettingsLocalDataSource();

    @Override
    public List<ProfileSettingListItem> getUserSettingsList() {
        return dataSource.getUserListSettings();
    }

    @Override
    public List<ProfileSettingListItem> getAdminSettingsList() {
        return dataSource.getAdminListSettings();
    }
}
