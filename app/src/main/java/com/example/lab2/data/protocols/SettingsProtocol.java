package com.example.lab2.data.protocols;

import androidx.lifecycle.LiveData;

import com.example.lab2.data.models.ProfileSettingListItem;

import java.util.List;

public interface SettingsProtocol {

    LiveData<List<ProfileSettingListItem>> getUserSettingsList();

    LiveData<ProfileSettingListItem> getProfileItem(int position);

    LiveData<List<ProfileSettingListItem>> getAdminSettingsList();
}
