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

import javax.net.ssl.HttpsURLConnection;

import static com.ayokhedma.ayokhedma.ConnectionManger.buReader;
import static com.ayokhedma.ayokhedma.ConnectionManger.openConnect;

/**
 * Created by SevenTG on 02/04/2017.
 */

public class CustomeAsync extends AsyncTask<String,String,ArrayList<CategoryModel>> {
    String res = null;
    private final TaskListener taskListener;

    public CustomeAsync(Activity activity){
        taskListener = (TaskListener) activity;
    }
    @Override
    protected ArrayList<CategoryModel> doInBackground(String... strings) {

        String type = strings[0];
        String id = strings[1];
        String data = null;
        String link = null;

       if (type.equals("category")) {
            link = "https://www.oriflamebeauty.net/ayokhedma/category.php?limit=6";
            try {
                HttpsURLConnection urlConnection = openConnect(link, "GET");
                res = buReader(urlConnection);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        ArrayList<CategoryModel> categoryModels = categoryArray();
        return categoryModels;
       }else if (type.equals("listCategory")){
           link = "https://www.oriflamebeauty.net/ayokhedma/category.php?catid=" + id;
           try {
               HttpsURLConnection urlConnection = openConnect(link, "GET");
               res = buReader(urlConnection);
           } catch (MalformedURLException e) {
               e.printStackTrace();
           } catch (IOException e) {
               e.printStackTrace();
           }
           ArrayList<CategoryModel> categoryModels = listCategoryArray();
           return categoryModels;
       }else if (type.equals("search")){
        link = "https://www.oriflamebeauty.net/ayokhedma/search.php?search=" + id;
        try {
            HttpsURLConnection urlConnection = openConnect(link, "GET");
            res = buReader(urlConnection);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        ArrayList<CategoryModel> categoryModels = listCategoryArray();
        return categoryModels;
    }
        return null;
    }


    @Override
    protected void onPostExecute(ArrayList<CategoryModel> models) {
        super.onPostExecute(models);
        taskListener.onTaskFinsh(models);

    }
    public ArrayList<CategoryModel> categoryArray(){
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
        return categoryModels;
    }
    public ArrayList<CategoryModel> listCategoryArray(){
        ArrayList<CategoryModel> categoryModels = new ArrayList<>();
        JSONArray jarray = null;
        try {
            jarray = new JSONArray(res);
            for (int i = 0; i <jarray.length() ; i++) {
                JSONObject object = jarray.getJSONObject(i);
                CategoryModel model = new CategoryModel();
                model.setObjectName(object.getString("obj_name"));
                model.setRegion(object.getString("reg_name"));
                model.setStreetName(object.getString("str_name"));
                model.setBeSides(object.getString("street_side"));
              //  model.setObjectImg(object.getString("obj_imgurl"));
                model.setCategoryName(object.getString("cat_name"));
                model.setCategoryImg(R.drawable.img1+i);
                categoryModels.add(model);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return categoryModels;
    }
}
