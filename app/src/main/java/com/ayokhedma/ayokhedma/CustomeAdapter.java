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
    Context context;
    LayoutInflater inflater;
    ArrayList<CategoryModel> modelloginlist = new ArrayList<>();

    public CustomeAdapter(Context context,ArrayList<CategoryModel> modelloginlist) {
        this.modelloginlist = modelloginlist;
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return modelloginlist.size();
    }

    @Override
    public Object getItem(int i) {
        return modelloginlist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflater.inflate(R.layout.listview,null);
        TextView txtname = (TextView) view.findViewById(R.id.txt_grid);
        ImageView imgv = (ImageView) view.findViewById(R.id.img_grid);
        txtname.setText(modelloginlist.get(i).getName());
        imgv.setImageResource(modelloginlist.get(i).getImg());

        return view;
    }
}
