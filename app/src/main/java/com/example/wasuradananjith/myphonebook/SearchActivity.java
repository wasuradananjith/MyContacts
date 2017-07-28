package com.example.wasuradananjith.myphonebook;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    Button searchButton;
    EditText name;
    private List<PhoneBook> contactList;
    private ListView listView;
    private PhonebookAdapter adapter;
    PhoneBookHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        listView = (ListView) findViewById(R.id.searchList);

        db = new PhoneBookHandler(this);

        contactList = db.getAllContacts();

        adapter = new PhonebookAdapter(this, contactList);
        listView.setAdapter(adapter);

        searchButton = (Button)findViewById(R.id.btnSearch2);
        name = (EditText)findViewById(R.id.txtName);

        /*name.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                String val = name.getText().toString();
                if (!TextUtils.isEmpty(val)) {
                    listView = (ListView) findViewById(R.id.searchList);

                    db = new PhoneBookHandler(v.getContext());

                    contactList = db.getContactMatch(val);

                    adapter = new PhonebookAdapter((Activity) v.getContext(), contactList);
                    listView.setAdapter(adapter);


                }
                return true;
            }
        });*/

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                String val = name.getText().toString();
                if(!TextUtils.isEmpty(val)){
                    listView = (ListView) findViewById(R.id.searchList);

                    db = new PhoneBookHandler(v.getContext());

                    contactList = db.getContactMatch(val);

                    adapter = new PhonebookAdapter((Activity) v.getContext(), contactList);
                    listView.setAdapter(adapter);


                }

            }
        });
    }
}
