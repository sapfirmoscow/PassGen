package com.example.sapfir.randompass;

import android.util.Log;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<View> implements Presenter   {

    private static final String TAG = "MainPresenter";
    private String message;
    private Repository repository;


    MainPresenter() {
        this.repository = new MainRepository();
        Log.d(TAG, "Constructor");
    }

    @Override
    public void onButtonWasClicked() {
        message = repository.loadMessage();
     //   MainActivity.showText(message);
        getViewState().showText(message);
        Log.d(TAG, "buttonclick");
    }


    @Override
    public void onDestroy() {

        Log.d(TAG, "onDestroy() and bla bla");

    }
}
