package com.example.lab2.domain.usecase;

import com.example.lab2.domain.SettingsRepository;
import com.example.lab2.domain.entity.ProfileSettingListItem;

import java.util.List;

public class GetUserSettingsUseCase {

    private final SettingsRepository repository;

    public List<ProfileSettingListItem> getUserSettingsList(){
        return repository.getUserSettingsList();
    }

    public GetUserSettingsUseCase(SettingsRepository repository) {
        this.repository = repository;
    }
}
