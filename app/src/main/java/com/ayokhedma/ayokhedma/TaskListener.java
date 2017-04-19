package com.ayokhedma.ayokhedma;

import com.ayokhedma.ayokhedma.models.CategoryModel;

import java.util.ArrayList;

/**
 * Created by SevenTG on 07/04/2017.
 */

public interface TaskListener {
    public void onTaskFinsh(ArrayList<CategoryModel> models);
}
