package com.example.lab2.ui.stateholder.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.datasource.SettingsLocalDataSource;
import com.example.lab2.data.models.ProfileSettingListItem;
import com.example.lab2.data.repositories.SettingsRepository;

public class SettingsProfileListItemViewModel extends ViewModel {

    private SettingsRepository repository = new SettingsRepository();

    public LiveData<ProfileSettingListItem> profileSettingListItemLiveData;

    public void getSettingListItem(int position) {
        profileSettingListItemLiveData = repository.getProfileItem(position);
    }


}
