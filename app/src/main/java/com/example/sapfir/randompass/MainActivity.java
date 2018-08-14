package com.example.sapfir.randompass;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainContract.View {


    private static final String TAG = "MainActivity";

    private MainContract.Presenter presenter;

    private Button button;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onButtonWasClicked();
            }
        });


        //создадим Presenter и передавем ему вьюху

        presenter = new MainPresenter(this);


        Log.d(TAG, "onCreate()");
    }

    @Override
    public void showText(String message) {
        textView.setText(message);
        Log.d(TAG, "showMessage()");

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDestroy();
        Log.d(TAG, "onDestroy()");
    }
}
