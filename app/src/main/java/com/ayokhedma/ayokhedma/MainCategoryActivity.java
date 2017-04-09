package com.ayokhedma.ayokhedma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;

public class MainCategoryActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        GridView grid = (GridView) findViewById(R.id.grid);

        ArrayList<CategoryModel> myarray = new ArrayList<CategoryModel>();
        myarray.add(new CategoryModel("Hotels",R.drawable.hotels));
        myarray.add(new CategoryModel("Market",R.drawable.market));
        myarray.add(new CategoryModel("Education",R.drawable.education));
        myarray.add(new CategoryModel("Caffe",R.drawable.cafee));
        myarray.add(new CategoryModel("Resturant",R.drawable.resturant));
        myarray.add(new CategoryModel("Work",R.drawable.work));
        myarray.add(new CategoryModel("Bank",R.drawable.bank));
        myarray.add(new CategoryModel("Goverment",R.drawable.gov));
        myarray.add(new CategoryModel("Lab",R.drawable.lab));
        myarray.add(new CategoryModel("Hospital",R.drawable.hospitals));
        myarray.add(new CategoryModel("Medicial",R.drawable.medicial));
        myarray.add(new CategoryModel("Pharmacy",R.drawable.pharmacy));

        CustomeAdapter adapter = new CustomeAdapter(this,myarray);
        grid.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.share) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
