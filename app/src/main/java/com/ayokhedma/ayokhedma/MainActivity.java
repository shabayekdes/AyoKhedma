package com.ayokhedma.ayokhedma;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TaskListener{
    GridView grid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        grid = (GridView) findViewById(R.id.grid);
        new CustomeAsync(this).execute("https://www.oriflamebeauty.net/ayokhedma/category.php");

    }


    @Override
    public void onTaskFinsh(final ArrayList<CategoryModel> categoryModels) {
        CustomeAdapter myadapter = new CustomeAdapter(this,categoryModels);
        grid.setAdapter(myadapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String id = categoryModels.get(i).getId();
                String name = categoryModels.get(i).getName();
                Intent intent = new Intent(getApplicationContext(),SingleCategoryActivity.class);
                intent.putExtra("id",id);
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
    }
}
