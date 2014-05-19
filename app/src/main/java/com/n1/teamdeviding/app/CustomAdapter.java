package com.n1.teamdeviding.app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

    public View getView(int position, View convertView, ViewGroup parent){
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.textItem);
        Player player = playerList.get(position);
        textView.setText(player.getName());
        return convertView;
    }
}
