package com.example.lab2.data.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.lab2.data.database.entity.ProfileSettingListItem;

import java.util.List;

@Dao
public interface ProfileSettingDao {
    @Query("SELECT * FROM profile_settings_table")
    LiveData<List<ProfileSettingListItem>> getProfileSettingList();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(ProfileSettingListItem profileSettingListItem);
    @Query("SELECT * FROM profile_settings_table WHERE :id LIKE id")
    LiveData<ProfileSettingListItem> getItem(int id);
}
