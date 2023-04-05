package com.example.lab2.data.datasource;

import android.content.Context;

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

    public AccountsRemoteDataSource(Context context) {
        this.context = context;
    }

    public boolean checkLoginUserValid(LoginUser loginUser){
        String filename = "Phone";
        String fileContents = loginUser.getPhone();
        File dir = context.getFilesDir();
        File file_email = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_email);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(fileContents);
            writer.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return !loginUser.getPhone().equals("") &&
                !loginUser.getPassword().equals("");
    }

    public boolean checkRegistrationValid(RegistrationUser registrationUser) {
        return !registrationUser.getName().equals("") &&
                !registrationUser.getPassword().equals("") &&
                !registrationUser.getPhone().equals("");
    }

    public boolean checkLoginAdminValid(LoginAdministrator loginAdministrator){
        return !loginAdministrator.getName().equals("") &&
                !loginAdministrator.getKey().equals("");
    }
}
