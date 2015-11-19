package com.eventhorizonwebdesign.ladispute;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Trenton on 11/13/2015.
 */
public class LyricListAdapter extends ArrayAdapter<String> {
    private List<String> l;
    public LyricListAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    public LyricListAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        this.l = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) super.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.expandlist_child_item, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.tvChild);
        String array[] = new String[l.size()];
        for(int j =0;j<l.size();j++){
            array[j] = l.get(j);
        }
        textView.setText(array[position]);
        return rowView;
    }

}