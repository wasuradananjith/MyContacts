package com.example.wasuradananjith.myphonebook;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class PhonebookAdapter extends BaseAdapter {

    private Activity activity;
    private LayoutInflater inflater;
    private List<PhoneBook> contactList;

    public PhonebookAdapter(Activity activity, List<PhoneBook> contacts){

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
            convertView = inflater.inflate(R.layout.contact_entry, null);

        TextView name= (TextView) convertView.findViewById(R.id.contactName);
        TextView contact = (TextView) convertView.findViewById(R.id.contact);
        TextView type = (TextView) convertView.findViewById(R.id.contactType);
        Button delete = (Button) convertView.findViewById(R.id.delete);

        PhoneBook list = contactList.get(position);

        name.setText(list.getName());
        contact.setText(list.getPhoneNumber());
        type.setText(list.getType());
        delete.setOnClickListener(new ListItemClickListener(position, list));

        return convertView;
    }


    private class ListItemClickListener implements View.OnClickListener {

        int position;
        PhoneBook list;

        public ListItemClickListener(int position, PhoneBook list){
            this.position = position;
            this.list = list;
        }

        @Override
        public void onClick(final View v) {
            AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);

            // Setting Dialog Title
            alertDialog.setTitle("Confirm ...");
            alertDialog.setIcon(R.drawable.warningalert);

            // Setting Dialog Message
            alertDialog.setMessage("Are you sure you want to delete this contact?");

            // Setting Icon to Dialog
            //alertDialog.setIcon(R.drawable.save);

            // Setting Positive "Yes" Button
            alertDialog.setNegativeButton("YES", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // User pressed YES button. Write Logic Here
                    PhoneBookHandler db = new PhoneBookHandler(activity);
                    db.deleteContact(list);
                    contactList.remove(position);
                    notifyDataSetChanged();
                    Snackbar.make(v, "Contact "+list.name+" deleted", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();

                }
            });

            // Setting Negative "NO" Button
            alertDialog.setPositiveButton("NO", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int which) {
                    // Write your code here to invoke NO event
                    //Toast.makeText(getApplicationContext(), "You selected \"No\"", Toast.LENGTH_SHORT).show();
                    dialog.cancel();
                }
            });
            // Showing Alert Message
            alertDialog.show();


        }
    }
}
