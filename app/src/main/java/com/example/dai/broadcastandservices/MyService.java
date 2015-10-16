package com.example.dai.broadcastandservices;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;

import java.io.*;

public class MyService extends Service {
    private final String logFileName = "log.txt";

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new WriteToFileTask().execute(startId);

        return 1;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");

    }

    private class WriteToFileTask extends AsyncTask<Integer, Void, Void> {

        @Override
        protected Void doInBackground(Integer... params) {

            String log = "Service was started";
            FileOutputStream outputStream;

            try {
                outputStream = openFileOutput(logFileName, Context.MODE_PRIVATE);
                outputStream.write(log.getBytes());
                outputStream.close();
                stopSelf(params[0]);

            } catch (Exception e) {
                e.printStackTrace();
            }

            return null;


        }
    }
}
