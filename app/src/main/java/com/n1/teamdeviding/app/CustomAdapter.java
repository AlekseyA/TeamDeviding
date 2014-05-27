package com.n1.teamdeviding.app;

import android.app.ActionBar;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ArrayAdapter;
import android.widget.Checkable;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aleksey on 5/19/14.
 */
public class CustomAdapter extends ArrayAdapter<Player> {
    private ArrayList<Player> playerList;
    private Context context;
    boolean smallItems;

    public CustomAdapter(Context ctx, ArrayList<Player> list){
        super(ctx, R.layout.item, list);
        this.playerList = list;
        this.context = ctx;
    }

    public CustomAdapter(Context ctx, ArrayList<Player> list, boolean small){
        super(ctx, R.layout.item_small, list);
        this.playerList = list;
        this.context = ctx;
        this.smallItems = small;
    }


    public long getItemId(int pos){
        return pos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        CheckableLayout checkableLayout;

        if(convertView == null){
            checkableLayout = new CheckableLayout(context);
            checkableLayout.setLayoutParams(new GridView.LayoutParams(CheckableLayout.LayoutParams.WRAP_CONTENT, GridView.LayoutParams.WRAP_CONTENT));
        } else {
            checkableLayout = (CheckableLayout)convertView;
        }

        ImageView imageView = (ImageView)checkableLayout.findViewById(smallItems ? R.id.imgItemSmall : R.id.imgItem);
        TextView textView = (TextView)checkableLayout.findViewById(smallItems ? R.id.textItemSmall : R.id.textItem);
        Player player = playerList.get(position);
        imageView.setImageResource(player.getPhoto());
        textView.setText(player.getName());
        return checkableLayout;
    }

}
