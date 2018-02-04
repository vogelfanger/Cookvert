package com.cookvert.navigation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.cookvert.R;

import java.util.ArrayList;

public class DrawerListAdapter extends BaseAdapter {

    Context context;
    ArrayList<NavigationItem> navigationItems;

    public DrawerListAdapter(Context context, ArrayList<NavigationItem> navigationItems) {
        this.context = context;
        this.navigationItems = navigationItems;
    }

    @Override
    public int getCount() {
        return navigationItems.size();
    }

    @Override
    public Object getItem(int position) {
        return navigationItems.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View view;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater.from(context));
            view = inflater.inflate(R.layout.drawer_navigation_item, null);
        }else{
            view = convertView;
        }

        TextView textView = (TextView) view.findViewById(R.id.drawer_item_text);
        ImageView imgView = (ImageView) view.findViewById(R.id.drawer_item_icon);
        textView.setText(navigationItems.get(i).getText());
        imgView.setImageResource(navigationItems.get(i).getIconRes());

        return view;
    }
}
