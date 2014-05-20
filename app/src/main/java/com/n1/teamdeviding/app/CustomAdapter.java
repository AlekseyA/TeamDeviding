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
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by aleksey on 5/19/14.
 */
public class CustomAdapter extends ArrayAdapter<Player> {
    private ArrayList<Player> playerList;
    private Context context;

    public CustomAdapter(Context ctx, ArrayList<Player> list){
        super(ctx,R.layout.item, list);
        this.playerList = list;
        this.context = ctx;
    }


    public long getItemId(int pos){
        return pos;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        CheckableLayout checkableLayout;

        if(convertView == null){
            checkableLayout = new CheckableLayout(context);
            checkableLayout.setLayoutParams(new CheckableLayout.LayoutParams(CheckableLayout.LayoutParams.MATCH_PARENT, CheckableLayout.LayoutParams.MATCH_PARENT));
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        } else {
            checkableLayout = (CheckableLayout)convertView;
        }

// TODO
//        checkableLayout.setTextResId(get);

        TextView textView = (TextView)convertView.findViewById(R.id.textItem);
        Player player = playerList.get(position);
        textView.setText(player.getName());
        return convertView;
    }

}
