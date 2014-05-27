package com.n1.teamdeviding.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;


public class TotalTeams extends Activity {

    CustomAdapterThreeTeams adapter;
    CustomAdapterThreeTeams adapter2;
    CustomAdapterThreeTeams adapter3;
    GridView gridView1;
    GridView gridView2;
    GridView gridView3;
    public ArrayList<Player> currentGamePlayers = new ArrayList<Player>();
    ArrayList<Player> team1 = new ArrayList<Player>();
    ArrayList<Player> team2 = new ArrayList<Player>();
    ArrayList<Player> team3 = new ArrayList<Player>();
    int r1,r2;
    int ts1, ts2,ts3 = 0;
    String tss1 = "";
    String tss2 = "";
    String tss3 = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_teams);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        currentGamePlayers.clear();
        currentGamePlayers = (ArrayList<Player>)intent.getSerializableExtra("list");
        fillTeams();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu items for use in the action bar
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.total_teams, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem item){
        fillTeams();
        return true;
    }

    public void fillTeams(){
        generatePlayers();
        adapter = new CustomAdapterThreeTeams(this, team1);
        gridView1 = (GridView)findViewById(R.id.gridViewTotal1);
        gridView1.setAdapter(adapter);

        adapter2 = new CustomAdapterThreeTeams(this, team2);
        gridView2 = (GridView)findViewById(R.id.gridViewTotal2);
        gridView2.setAdapter(adapter2);

        if(currentGamePlayers.size() > 13){
            adapter3 = new CustomAdapterThreeTeams(this, team3);
            gridView3 = (GridView)findViewById(R.id.gridViewTotal3);
            gridView3.setAdapter(adapter3);
        }
    }

    public void generatePlayers(){
        int totalSkill = 0;
        System.out.println("Total players: " + currentGamePlayers.size());
        for (Player pl :currentGamePlayers ) {
            totalSkill += pl.getSkill();
        }
        System.out.println("totalSkill is " + totalSkill + "; half: " + totalSkill/2);

        ArrayList<Player> sortBox = new ArrayList<Player>(currentGamePlayers);

        team1.clear();
        team2.clear();
        team3.clear();
        ts1 = 0;
        ts2 = 0;
        ts3 = 0;
        tss1 = "";
        tss2 = "";
        tss3 = "";

        Random rnd = new  Random();
        // int r = rnd.nextInt(sortBox.size()-1);
        r1 = rnd.nextInt(sortBox.size());
        int size = sortBox.size();
        int k = 1;
        for (int i = 0; i < size; i++ ) {
            r1 = rnd.nextInt(sortBox.size());
            if (k == 1) {
                team1.add(sortBox.get(r1));
                k++;
            } else if (k == 2) {
                team2.add(sortBox.get(r1));
                if (currentGamePlayers.size() < 14) {
                    k = 1;
                } else {
                    k++;
                }
            } else if( k == 3) {
                team3.add(sortBox.get(r1));
                k = 1;
            } else {
                System.out.println("ooops");
            }
            sortBox.remove(r1);

        }

        for (Player t1: team1){
            tss1 += t1.getName() + ", ";
            ts1 += t1.getSkill();
        }
        for (Player t2: team2){
            tss2 += t2.getName() + ", ";
            ts2 += t2.getSkill();
        }
        for (Player t3: team3){
            tss3 += t3.getName() + ", ";
            ts3 += t3.getSkill();
        }

        if ((ts1 < (totalSkill/2 - 1) & (ts1 > (totalSkill/2 + 2) ))) {
            System.out.println("Let's go again!");
            generatePlayers();
        }

        System.out.println("Team1: " + tss1 + " skill[" + ts1 + "]\n"
                + "Team2: " + tss2 + " skill[" + ts2 + "]\n"
                + "Team3: " + tss3 + " skill[" + ts3 + "]");
    }

    public class CustomAdapterThreeTeams extends ArrayAdapter<Player> {

        private ArrayList<Player> playerList;
        private Context context;

        public CustomAdapterThreeTeams(Context ctx, ArrayList<Player> list) {
            super(ctx, R.layout.item_small, list);
            this.playerList = list;
            this.context = ctx;
        }

        public long getItemId(int pos){
            return pos;
        }

        public View getView(int position, View convertView, ViewGroup parent) {

            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.item_small, parent, false);
            }
            ImageView imageView = (ImageView) convertView.findViewById(R.id.imgItemSmall);
            TextView textView = (TextView) convertView.findViewById(R.id.textItemSmall);
            Player player = playerList.get(position);
            imageView.setImageResource(player.getPhoto());
            textView.setText(player.getName());
            return convertView;
        }
    }
}
