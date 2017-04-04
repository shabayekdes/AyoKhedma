package com.ayokhedma.ayokhedma;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;

/**
 * Created by SevenTG on 02/04/2017.
 */

public class CustomeAdapter extends BaseAdapter {
    private ArrayList<CategoryModel> modelArrayList ;
    private LayoutInflater layoutInflater;
    public CustomeAdapter(Context context, ArrayList<CategoryModel> modelArrayList){
        this.layoutInflater = LayoutInflater.from(context);
        this.modelArrayList = modelArrayList;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return modelArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = layoutInflater.inflate(R.layout.listview,null);
        TextView txtgrid = (TextView) view.findViewById(R.id.txt_grid);
        ImageView imggrid = (ImageView) view.findViewById(R.id.img_grid);


        return view;
    }
}
