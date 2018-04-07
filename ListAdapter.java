package com.example.timesaver;


import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.nfc.Tag;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Imane on 4/7/18.
 */

public class ListAdapter extends ArrayAdapter <ItemList> {

    public ListAdapter(Context context, ArrayList<ItemList> items) {
        super(context, 0, items);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ItemList item = getItem(position);
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.item_layout, parent, false);
        }
        TextView appName = (TextView) convertView.findViewById(R.id.appNameLabel);

        ImageView appIcon = (ImageView) convertView.findViewById(R.id.appIconLabel);
        appName.setText(item.appName);
        appIcon.setImageDrawable(item.appIcon);
        appName.setTag("hello");
      //  Toast.makeText(getContext(), (String)convertView.getTag(), Toast.LENGTH_LONG).show();
        return convertView;
    }



}
