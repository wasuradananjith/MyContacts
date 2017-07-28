package com.example.wasuradananjith.myphonebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView add,deleteButton,searchButton;
    public Button viewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        add = (ImageView)findViewById(R.id.btnAdd);
        viewButton = (Button)findViewById(R.id.btnView);
        deleteButton = (ImageView) findViewById(R.id.btnDelete);
        searchButton = (ImageView) findViewById(R.id.btnSearch);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, AddActivity.class));
                overridePendingTransition(R.anim.slide_out_top,R.anim.slide_in_bottom);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadList = new Intent(getBaseContext(), ViewAllActivity.class);
                startActivity(loadList);
                overridePendingTransition(R.anim.slide_out_top,R.anim.slide_in_bottom);
            }
        });

        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadList = new Intent(getBaseContext(), DeleteActivity.class);
                startActivity(loadList);
                overridePendingTransition(R.anim.slide_out_top,R.anim.slide_in_bottom);
            }
        });

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loadList = new Intent(getBaseContext(), SearchActivity.class);
                startActivity(loadList);
                overridePendingTransition(R.anim.slide_out_top,R.anim.slide_in_bottom);
            }
        });
    }
}
