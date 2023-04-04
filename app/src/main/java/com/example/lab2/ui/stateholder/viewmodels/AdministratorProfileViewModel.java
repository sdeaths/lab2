package com.example.lab2.ui.stateholder.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.ProfileSettingListItem;
import com.example.lab2.data.repositories.SettingsRepository;

import java.util.List;

public class AdministratorProfileViewModel extends ViewModel {

    private final SettingsRepository repository = new SettingsRepository();

    public LiveData<List<ProfileSettingListItem>> listLiveData = repository.getAdminSettingsList();

}
