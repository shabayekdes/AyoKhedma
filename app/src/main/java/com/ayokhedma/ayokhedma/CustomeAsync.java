package com.ayokhedma.ayokhedma;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by SevenTG on 02/04/2017.
 */

public class CustomeAsync extends AsyncTask<String,String,ArrayList<CategoryModel>> {

    private final TaskListener taskListener;

    public CustomeAsync(Activity activity){
        taskListener = (TaskListener) activity;
    }
    @Override
    protected ArrayList<CategoryModel> doInBackground(String... strings) {
        publishProgress("Open connection");
        String link = strings[0];
        String res = "";
        try {
            ConnectionManger connectionManger = new ConnectionManger();
            HttpURLConnection urlConnection = connectionManger.openConnect(link);
            res = connectionManger.getResult(urlConnection);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        publishProgress("Read Json file");
        ArrayList<CategoryModel> categoryModels = new ArrayList<>();
        JSONArray jarray = null;
        try {
            jarray = new JSONArray(res);
            for (int i = 0; i <jarray.length() ; i++) {
                JSONObject object = jarray.getJSONObject(i);
                CategoryModel model = new CategoryModel();
                model.setCategoryId(object.getString("id"));
                model.setCategoryName(object.getString("cat_name"));
                model.setCategoryImg(R.drawable.img1+i);
                categoryModels.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        publishProgress("Finish and retrun values");
        return categoryModels;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        super.onProgressUpdate(values);
        // Toast.makeText(, values[0], Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(ArrayList<CategoryModel> models) {
        super.onPostExecute(models);
        taskListener.onTaskFinsh(models);

    }
}
