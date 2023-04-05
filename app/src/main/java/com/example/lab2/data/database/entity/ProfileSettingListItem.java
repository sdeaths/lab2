package com.example.lab2.data.database.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "profile_settings_table")
public class ProfileSettingListItem {
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    public Integer uid;
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
