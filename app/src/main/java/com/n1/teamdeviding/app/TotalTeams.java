package com.n1.teamdeviding.app;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


public class TotalTeams extends Activity {

    CustomAdapter adapter;
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_teams);

        adapter = new CustomAdapter(this, MainActivity.currentGamePlayers);
        gridView = (GridView)findViewById(R.id.gridViewTotal);
        gridView.setAdapter(adapter);
    }
}
