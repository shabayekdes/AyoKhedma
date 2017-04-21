package com.ayokhedma.ayokhedma;

import android.app.SearchManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements TaskListener{
    GridView grid;
    SearchView searchView;
    ShareActionProvider shareActionProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        grid = (GridView) findViewById(R.id.grid);
        new CustomeAsync(this).execute("http://oriflamebeauty.net/ayokhedma/category.php?limit=6");

       /* ArrayList<CategoryModel> myarray = new ArrayList<CategoryModel>();
        myarray.add(new CategoryModel("Hotels",R.drawable.hotels));
        myarray.add(new CategoryModel("Market",R.drawable.market));
        myarray.add(new CategoryModel("Education",R.drawable.education));
        myarray.add(new CategoryModel("Caffe",R.drawable.cafee));
        myarray.add(new CategoryModel("Resturant",R.drawable.resturant));
        myarray.add(new CategoryModel("Work",R.drawable.work));
*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        // Search Action
       MenuItem searchItem = menu.findItem(R.id.search_item);
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            searchView = (SearchView) searchItem.getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
            searchView.setIconified(true);
        // Share Action
        MenuItem shareItem = menu.findItem(R.id.share_item);
            shareActionProvider = (ShareActionProvider) MenuItemCompat.getActionProvider(shareItem);
            setShareActionIntent(createShareIntent());

        return true;
    }
    private void setShareActionIntent(Intent shareIntent){
        if (shareActionProvider != null){
            shareActionProvider.setShareIntent(shareIntent);
        }
    }
    private Intent createShareIntent() {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT,
                "http://ayokhedma.com");
        return shareIntent;
    }

    @Override
    public void onTaskFinsh(final ArrayList<CategoryModel> models) {
        CustomeAdapter myadapter = new CustomeAdapter(this,R.layout.grid_item,models);
        grid.setAdapter(myadapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String catId = models.get(position).getCategoryId();
                Intent intent = new Intent(MainActivity.this,SingleCategoryActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("id" , catId);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });

    }
}
