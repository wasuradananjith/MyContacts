package com.example.wasuradananjith.myphonebook;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Wasura Dananjith on 21-Jun-17.
 */

public class PhoneBookAdapter2 extends BaseAdapter{
    private Activity activity;
    private LayoutInflater inflater;
    private List<PhoneBook> contactList;

    public PhoneBookAdapter2(Activity activity, List<PhoneBook> contacts){

        this.activity = activity;
        this.contactList = contacts;
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.contact_entry2, null);

        TextView name= (TextView) convertView.findViewById(R.id.contactName);
        TextView contact = (TextView) convertView.findViewById(R.id.contact);
        TextView type = (TextView) convertView.findViewById(R.id.contactType);


        PhoneBook list = contactList.get(position);

        name.setText(list.getName());
        contact.setText(list.getPhoneNumber());
        type.setText(list.getType());


        return convertView;
    }
}
