package com.example.lab2.data.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.lab2.data.database.dao.ProfileSettingDao;
import com.example.lab2.data.database.entity.ProfileSettingListItem;

@Database(entities = {ProfileSettingListItem.class}, version = 1, exportSchema = false)
public abstract class SettingsDataBase extends RoomDatabase {
    private static volatile SettingsDataBase INSTANCE;

    public abstract ProfileSettingDao profileSettingDao();

    public static SettingsDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SettingsDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    SettingsDataBase.class, "settings_profile_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
