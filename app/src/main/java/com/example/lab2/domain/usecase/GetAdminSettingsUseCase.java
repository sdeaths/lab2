package com.example.lab2.domain.usecase;

import com.example.lab2.domain.SettingsRepository;
import com.example.lab2.domain.entity.ProfileSettingListItem;

import java.util.List;

public class GetAdminSettingsUseCase {

    private final SettingsRepository repository;

    public List<ProfileSettingListItem> getAdminSettingsList(){
        return repository.getAdminSettingsList();
    }

    public GetAdminSettingsUseCase(SettingsRepository repository) {
        this.repository = repository;
    }
}
