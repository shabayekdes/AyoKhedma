package com.ayokhedma.ayokhedma;

import android.content.Context;
import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;

/**
 * Created by SevenTG on 02/04/2017.
 */

public class CustomeAsync extends AsyncTask<String,String,String> {

    private final Context context;

    public CustomeAsync(Context context){
        this.context = context;
    }

    @Override
    protected String doInBackground(String... strings) {
        String s = null;
        try {
           HttpURLConnection urlConnection = ConnectionManger.openConnect(strings[0]);
           s = ConnectionManger.getResult(urlConnection);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
