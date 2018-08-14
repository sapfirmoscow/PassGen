package com.example.sapfir.randompass;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class GetPassTask extends Thread {


    MainRepository mainRepository;

    protected GetPassTask(MainRepository mainRepository) {
        this.mainRepository = mainRepository;
    }


    @Override
    public void run() {
        try {
            URL url = new URL("https://lexa20.000webhostapp.com/rapi/index.php");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            InputStream stream = new BufferedInputStream(urlConnection.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(stream));
            StringBuilder builder = new StringBuilder();

            String inputString;
            while ((inputString = bufferedReader.readLine()) != null) {
                builder.append(inputString);
            }

            // JSONObject topLevel = new JSONObject(builder.toString());
            // JSONObject main = topLevel.getJSONObject("main");
            // mainRepository.message = String.valueOf(topLevel.toString());
            mainRepository.message = builder.toString();


            urlConnection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
