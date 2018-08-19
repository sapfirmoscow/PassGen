package com.example.sapfir.randompass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;

public class MainActivity extends MvpAppCompatActivity implements View {


    @InjectPresenter
    MainPresenter mainPresenter;


    private static final String TAG = "MainActivity";



    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new android.view.View.OnClickListener() {
            public void onClick(android.view.View view) {
                mainPresenter.onButtonWasClicked();
            }
        });


        //создадим Presenter и передавем ему вьюху

      //  presenter = new MainPresenter(this);


        Log.d(TAG, "onCreate()");
    }

    @Override
    public  void showText(String message) {
        textView.setText(message);
        Log.d(TAG, "showMessage()");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
