package com.example.sapfir.randompass;

import android.util.Log;

public class MainRepository implements Repository {


    private static final String TAG = "MainRepository";

    String message = null;

    @Override
    public String loadMessage() {


        GetPassTask thread = new GetPassTask(this);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        Log.d(TAG, "loadMessage()");
        return message;
    }
}

