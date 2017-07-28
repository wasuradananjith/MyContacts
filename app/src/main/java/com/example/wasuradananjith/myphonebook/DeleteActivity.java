package com.example.wasuradananjith.myphonebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.List;

public class DeleteActivity extends AppCompatActivity {

    ListView listview;
    PhoneBookHandler db;
    List<PhoneBook> contactList;
    private PhonebookAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loadList = new Intent(getBaseContext(), AddActivity.class);
                startActivity(loadList);
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
            }
        });

        listview = (ListView) findViewById(R.id.allContactsDelete);

        db = new PhoneBookHandler(this);

        contactList = db.getAllContacts();

        adapter = new PhonebookAdapter(this, contactList);
        listview.setAdapter(adapter);
    }

}
