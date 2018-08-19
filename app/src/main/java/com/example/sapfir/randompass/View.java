package com.example.sapfir.randompass;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.arellomobile.mvp.MvpView;



  interface View  extends MvpView {
        /**
         * @param message for password
         */

         void showText(String message);
    }





