package com.ayokhedma.ayokhedma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        listv = (ListView) findViewById(R.id.list_cat);
        Intent intent = getIntent();
        String catid =  intent.getStringExtra("id").toString();
        new CustomeAsync(this).execute("http://oriflamebeauty.net/ayokhedma/category.php?catid=" + catid);
        //  TextView txtshow = (TextView) findViewById(R.id.txtshow);
      //  Intent intent = getIntent();
     //   txtshow.setText(intent.getStringExtra("id")+ " " +intent.getStringExtra("name"));

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
