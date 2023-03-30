package com.example.lab2.domain;

import com.example.lab2.domain.entity.ProfileSettingListItem;

import java.util.List;

public interface SettingsRepository {

    List<ProfileSettingListItem> getUserSettingsList();

    List<ProfileSettingListItem> getAdminSettingsList();
}
