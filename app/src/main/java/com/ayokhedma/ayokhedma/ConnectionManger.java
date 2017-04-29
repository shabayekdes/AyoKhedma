package com.ayokhedma.ayokhedma;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by SevenTG on 04/04/2017.
 */

public class ConnectionManger {

    public static boolean isInternetConnected(Context context){
        ConnectivityManager connectivity = (ConnectivityManager) context.getSystemService(context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
        if (networkInfo != null){
            return true;
        }else {
        return false;
        }
    }

    public static HttpsURLConnection openConnect(String link,String method) throws IOException {
        URL url = new URL(link);
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();

        if(method == "get"){
            urlConnection.setReadTimeout(3000);
            urlConnection.setConnectTimeout(3000);
            urlConnection.setRequestMethod(method);
            urlConnection.setDoInput(true);
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode != HttpsURLConnection .HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }
        }else if(method == "post"){
            urlConnection.setReadTimeout(3000);
            urlConnection.setConnectTimeout(3000);
            urlConnection.setRequestMethod(method);
            // setDoInput and setDoOutput to true as we send and recieve data
            urlConnection.setDoInput(true);
            urlConnection.setDoOutput(true);
            urlConnection.connect();
            int responseCode = urlConnection.getResponseCode();
            if (responseCode != HttpsURLConnection .HTTP_OK) {
                throw new IOException("HTTP error code: " + responseCode);
            }

        }

        return urlConnection;
    }
    public static String buReader (HttpURLConnection urlConnection) throws IOException {
        InputStream inputStream = urlConnection.getInputStream();
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream,"UTF-8"));
        StringBuffer buffer = new StringBuffer();
        String line;
        while ((line = bufferedReader.readLine()) != null){
            buffer.append(line);
        }
        inputStream.close();
        urlConnection.disconnect();
        return buffer.toString();
    }
   public static void buWriter (HttpURLConnection urlConnection,String searchQuery,String type) throws IOException {
        OutputStream outputStream = urlConnection.getOutputStream();
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
        Uri.Builder builder = new Uri.Builder().appendQueryParameter(type, searchQuery);
        String query = builder.build().getEncodedQuery();
        bufferedWriter.write(query);
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStream.close();
        urlConnection.disconnect();
    }


}
