package com.ayokhedma.ayokhedma;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.GridView;
import android.widget.Toast;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TaskListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        GridView grid = (GridView) findViewById(R.id.grid);

        ArrayList<CategoryModel> myarray = new ArrayList<CategoryModel>();
        myarray.add(new CategoryModel("Hotels",R.drawable.hotels));
        myarray.add(new CategoryModel("Market",R.drawable.market));
        myarray.add(new CategoryModel("Education",R.drawable.education));
        myarray.add(new CategoryModel("Caffe",R.drawable.cafee));
        myarray.add(new CategoryModel("Resturant",R.drawable.resturant));
        myarray.add(new CategoryModel("Work",R.drawable.work));


        CustomeAdapter adapter = new CustomeAdapter(this,myarray);
        grid.setAdapter(adapter);

    }




    @Override
    public void onTaskFinsh(String se) {
        Toast.makeText(this, se, Toast.LENGTH_LONG).show();
    }
}
