package com.example.lab2.ui.stateholder.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.database.entity.ProfileSettingListItem;
import com.example.lab2.data.repositories.SettingsRepository;

public class SettingsProfileListItemViewModel extends AndroidViewModel {

    private SettingsRepository repository = new SettingsRepository(getApplication());

    public LiveData<ProfileSettingListItem> profileSettingListItemLiveData;

    public SettingsProfileListItemViewModel(@NonNull Application application) {
        super(application);
    }

    public void getSettingListItem(int position) {
        profileSettingListItemLiveData = repository.getProfileItem(position);
    }


}
