package com.example.lab2.data.datasource;

import android.content.Context;

import androidx.core.view.OneShotPreDrawListener;
import androidx.room.Dao;
import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;

import com.example.lab2.PhoneWorker;
import com.example.lab2.data.models.LoginAdministrator;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AccountsRemoteDataSource {
    private final Context context;
    private final WorkManager workManager;

    public AccountsRemoteDataSource(Context context) {
        this.context = context;
        workManager = WorkManager.getInstance(context);
    }

    private Data createInputData(String phone){
        Data.Builder builder = new Data.Builder();
        builder.putString(PhoneWorker.Phone, phone);
        return builder.build();
    }

    public boolean checkLoginUserValid(LoginUser loginUser){
        OneTimeWorkRequest request = new OneTimeWorkRequest.Builder(PhoneWorker.class)
                .setInputData(createInputData(loginUser.getPhone()))
                .build();
        workManager.enqueue(request);
        return !loginUser.getPhone().equals("") &&
                !loginUser.getPassword().equals("");
    }

    public boolean checkRegistrationValid(RegistrationUser registrationUser) {
        return !registrationUser.getName().equals("") &&
                !registrationUser.getPassword().equals("") &&
                !registrationUser.getPhone().equals("");
    }

    public boolean checkLoginAdminValid(LoginAdministrator loginAdministrator, boolean allowed){
//        if (allowed) {
//            String filename = "Key";
//            String fileContents = loginAdministrator.getKey();
//            File file_key = new File("/storage/emulated/0/Android/data", filename);
//            try {
//                FileOutputStream fos = new FileOutputStream(file_key);
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//                writer.write(fileContents);
//                writer.close();
//                fos.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return !loginAdministrator.getName().equals("") &&
                !loginAdministrator.getKey().equals("");
    }
}
