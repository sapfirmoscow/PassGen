package com.example.sapfir.randompass;

import android.util.Log;


public class MainPresenter implements MainContract.Presenter {

    private static final String TAG = "MainPresenter";
    private String message;
    private MainContract.View view;
    private MainContract.Repository repository;


    public MainPresenter(MainContract.View view) {
        this.view = view;
        this.repository = new MainRepository();
        Log.d(TAG, "Constructor");
    }

    @Override
    public void onButtonWasClicked() {
        message = repository.loadMessage();
        view.showText(message);
        Log.d(TAG, "buttonclick");
    }


    @Override
    public void onDestroy() {

        Log.d(TAG, "onDestroy() and bla bla");

    }
}
