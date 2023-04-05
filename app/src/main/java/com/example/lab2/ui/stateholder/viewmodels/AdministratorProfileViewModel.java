package com.example.lab2.ui.stateholder.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.database.entity.ProfileSettingListItem;
import com.example.lab2.data.repositories.SettingsRepository;

import java.util.List;

public class AdministratorProfileViewModel extends AndroidViewModel {

    private final SettingsRepository repository = new SettingsRepository(getApplication());

    public LiveData<List<ProfileSettingListItem>> listLiveData = repository.getAdminSettingsList();

    public AdministratorProfileViewModel(@NonNull Application application) {
        super(application);
    }
}
