package com.ayokhedma.ayokhedma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;

/**
 * Created by SevenTG on 02/04/2017.
 */

public class CustomeAdapter extends BaseAdapter {
    Context context;
    LayoutInflater inflater;
    int resource;
    ArrayList<CategoryModel> models = new ArrayList<>();

    public CustomeAdapter(Context context,int resource, ArrayList<CategoryModel> models) {
        this.models = models;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
        this.resource=resource;
    }

    @Override
    public int getCount() {
        return models.size();
    }

    @Override
    public Object getItem(int i) {
        return models.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (resource == R.layout.list_item) {
            View view_list = inflater.inflate(resource, null);
            TextView objectName = (TextView) view_list.findViewById(R.id.object_name);
           // ImageView objectImage = (ImageView) view_list.findViewById(R.id.object_image);
            TextView objectRegion = (TextView) view_list.findViewById(R.id.object_region);
            TextView objectAddress = (TextView) view_list.findViewById(R.id.object_address);
           // RatingBar objectRatingBar = (RatingBar) view_list.findViewById(R.id.object_rating);

            objectName.setText(models.get(i).getObjectName());
           // objectImage.setImageResource(models.get(i).getObjectImg());
            objectRegion.setText(models.get(i).getRegion());
            objectAddress.setText(models.get(i).getStreetName() + " " + models.get(i).getBeSides());
           // objectRatingBar.setRating(models.get(i).getRating());
            return view_list;
        }
        else if(resource == R.layout.grid_item){
            View view_grid = inflater.inflate(resource, null);
            ImageView categoryImage = (ImageView) view_grid.findViewById(R.id.category_img);
            TextView objectName = (TextView) view_grid.findViewById(R.id.category_name);
            categoryImage.setImageResource(models.get(i).getCategoryImg());
            objectName.setText(models.get(i).getCategoryName());
            return view_grid;
        }
        return null;
    }
}
