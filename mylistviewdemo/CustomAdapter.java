package com.myapp.mylistviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
    int[] flags;
    String[] countryNames;
    Context context;
    private LayoutInflater layoutInflater;

    CustomAdapter(Context context, String[] countryNames, int[] flags){
        this.context = context;
        this.countryNames = countryNames;
        this.flags = flags;
    }
    @Override
    public int getCount() {
        return countryNames.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertview, ViewGroup viewGroup) {

        if (convertview == null){
           layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            convertview= layoutInflater.inflate(R.layout.sample,viewGroup,false);
            ImageView imageView = (ImageView) convertview.findViewById(R.id.imageViewId);
            TextView textView = (TextView) convertview.findViewById(R.id.countryNameId);
            imageView.setImageResource(flags[i]);
            textView.setText(countryNames[i]);
        }
        return convertview;
    }
}
