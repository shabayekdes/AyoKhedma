package com.ayokhedma.ayokhedma;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class SearchableActivity extends AppCompatActivity implements TaskListener{
    SearchView searchView;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_searchable);
       listView = (ListView) findViewById(R.id.search_list);
        /* handleIntent(getIntent());

        SearchManager searchManager = (SearchManager) this.getSystemService(Context.SEARCH_SERVICE);
        searchView = (SearchView) findViewById(R.id.search_view);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setIconified(false);*/

    }



    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            if (searchView != null) {
                searchView.clearFocus();
            }
            new CustomeAsync(this).execute();
        }

    }

    @Override
    public void onTaskFinsh(ArrayList<CategoryModel> models) {
        CustomeAdapter myadapter = new CustomeAdapter(this,R.layout.list_item,models);
        listView.setAdapter(myadapter);
    }

}
