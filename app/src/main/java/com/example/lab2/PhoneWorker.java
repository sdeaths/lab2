package com.example.lab2;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PhoneWorker extends Worker {
    private final Context context;
    public static final String Phone = "obrezanie";
    public PhoneWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.context = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        String phone = getInputData().getString(Phone);
        String filename = "Phone";
        String fileContents = phone;
        File dir = context.getFilesDir();
        File file_phone = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_phone);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
            writer.write(fileContents);
            writer.close();
            fos.close();
            return Result.success();
        } catch (IOException e) {
            return Result.failure();
        }
    }
}
