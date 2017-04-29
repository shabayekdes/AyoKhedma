package com.ayokhedma.ayokhedma;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.widget.Toast;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import static com.ayokhedma.ayokhedma.ConnectionManger.buReader;
import static com.ayokhedma.ayokhedma.ConnectionManger.buWriter;
import static com.ayokhedma.ayokhedma.ConnectionManger.openConnect;

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
        ArrayList<CategoryModel> categoryModels = null;
        String type = strings[0];
        String link = null;
        String res = null;
        HttpsURLConnection connection = null;
   if (type.equals("category")) {
            link = "https://www.oriflamebeauty.net/ayokhedma/category.php?limit=6";
            try {
                connection = openConnect(link, "GET");
                res = buReader(connection);
                categoryModels = categoryArray(res);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
      }else if (type.equals("listCategory")){
           String id = strings[1];
           link = "https://www.oriflamebeauty.net/ayokhedma/category.php?catid=" + id;
           try {
               connection = openConnect(link, "GET");
               res = buReader(connection);
               categoryModels = listCategoryArray(res);
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               connection.disconnect();
           }
       }else if (type.equals("search")) {
           String searchQuery = strings[1];
           link = "https://www.oriflamebeauty.net/ayokhedma/search.php";
           try {
               connection = openConnect(link, "POST");
               buWriter(connection,"searchQuery", searchQuery);
           } catch (IOException e1) {
               e1.printStackTrace();
           }
           try {
                res = buReader(connection);
                categoryModels = listCategoryArray(res);
           } catch (IOException e) {
               e.printStackTrace();
           } finally {
               connection.disconnect();
           }
      }
        return categoryModels;
    }
    @Override
    protected void onPostExecute(ArrayList<CategoryModel> models) {
        super.onPostExecute(models);
        taskListener.onTaskFinsh(models);
    }

    public ArrayList<CategoryModel> categoryArray(String res){
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

    public ArrayList<CategoryModel> listCategoryArray(String res){
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
                if (object.getString("obj_imgurl").toString().equals("")) {
                    model.setObjectImg("https://www.oriflamebeauty.net/ayokhedma/images/gov.png");
                }else {
                    model.setObjectImg(object.getString("obj_imgurl"));
                }
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
