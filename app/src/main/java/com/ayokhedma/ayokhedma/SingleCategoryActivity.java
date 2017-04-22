package com.ayokhedma.ayokhedma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;

public class SingleCategoryActivity extends AppCompatActivity implements TaskListener {
ListView listv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_category);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home_black_24dp);


        listv = (ListView) findViewById(R.id.list_cat);
        Intent intent = getIntent();
        String catid =  intent.getStringExtra("id").toString();
        new CustomeAsync(this).execute("http://oriflamebeauty.net/ayokhedma/category.php?catid=" + catid);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onTaskFinsh(ArrayList<CategoryModel> models) {
        CustomeAdapter myadapter = new CustomeAdapter(this,R.layout.list_item,models);
        listv.setAdapter(myadapter);
    }
}
