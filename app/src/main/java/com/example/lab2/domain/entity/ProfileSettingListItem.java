package com.example.lab2.domain.entity;

public class ProfileSettingListItem {
    private int settingIcon;
    private String settingsTitle;
    private boolean isTitle;

    public ProfileSettingListItem(int settingIcon, String settingsTitle, boolean isTitle) {
        this.settingIcon = settingIcon;
        this.settingsTitle = settingsTitle;
        this.isTitle = isTitle;
    }

    public int getSettingIcon() {
        return settingIcon;
    }

    public String getSettingsTitle() {
        return settingsTitle;
    }

    public boolean isTitle() {
        return isTitle;
    }
}
