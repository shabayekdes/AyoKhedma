package com.ayokhedma.ayokhedma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TextView;

public class SingleCategoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_category);
      //  TextView txtshow = (TextView) findViewById(R.id.txtshow);
      //  Intent intent = getIntent();
     //   txtshow.setText(intent.getStringExtra("id")+ " " +intent.getStringExtra("name"));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);

        return super.onCreateOptionsMenu(menu);
    }
}
