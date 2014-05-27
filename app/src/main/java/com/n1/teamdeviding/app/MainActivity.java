package com.n1.teamdeviding.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static com.n1.teamdeviding.app.R.drawable.player;
import static com.n1.teamdeviding.app.R.drawable.selector;


public class MainActivity extends Activity {//implements AdapterView.OnItemSelectedListener {

    public ArrayList<Player> playersList = new ArrayList<Player>();
    public ArrayList<Player> currentGamePlayers = new ArrayList<Player>();
    ActionMode actionMode;
    CustomAdapter adapter;
    GridView gridView;
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();

        adapter = new CustomAdapter(this, playersList);
//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.test, data);
        gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        gridView.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);
        gridView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int pos, long id, boolean checked) {
                Log.d(LOG_TAG, "pos = " + pos + ", checked = " + checked);
                int selectCount = gridView.getCheckedItemCount();
                if(checked){
                    currentGamePlayers.add(playersList.get(pos));
                } else {
                    currentGamePlayers.remove(playersList.get(pos));
                }
                switch (selectCount){
                    case 1:
                        actionMode.setSubtitle("One player selected");
                        break;
                    default:
                        actionMode.setSubtitle("" + selectCount + " player selected");
                        break;
                }
                System.out.println("List:" + currentGamePlayers);
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                actionMode.setTitle("Select players");
                actionMode.setSubtitle("One player selected");
                actionMode.getMenuInflater().inflate(R.menu.context, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return true;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                System.out.println("CLICK");
                Intent intent = new Intent(MainActivity.this, TotalTeams.class);
                intent.putExtra("list", currentGamePlayers);
                startActivity(intent);
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {
                currentGamePlayers.clear();
            }
        });
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void onClick(View v){
        if(actionMode == null)
            Toast.makeText(this, "GO!", Toast.LENGTH_SHORT).show();
            //actionMode = startActionMode(callback);
        else
            Toast.makeText(this, "STOP", Toast.LENGTH_SHORT).show();
    }

    /*private ActionMode.Callback callback = new ActionMode.Callback() {
        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.getMenuInflater().inflate(R.menu.context, menu);
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            Log.d(LOG_TAG,"item " + menuItem.getTitle());
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {
            actionMode = null;
        }
    };*/

    private void createList(){

        Player Aleksey = new Player("Алексей", 7, R.drawable.aleksey);
        Player Ilya = new Player("Илья", 4, R.drawable.ilay);
        Player Anton = new Player("Антон", 4, R.drawable.anton);
        Player Alex_Ch = new Player("Саша Ч.", 5);
        Player Alex_R = new Player("Саша Р.", 5, R.drawable.sasha_r);
        Player Alex_H = new Player("Саша Х.", 4);
        Player Alex_P = new Player("Саша П.", 3, R.drawable.sasha_p);
        Player Vadim = new Player("Вадим", 4);
        Player Igor = new Player("Игорь", 4, R.drawable.igor);
        Player Sergei = new Player("Сергей", 4, R.drawable.sergei);
        Player Artem = new Player("Артем", 4, R.drawable.artem);
        Player Nikolay = new Player("Николай", 5, R.drawable.nikolay);
        Player Ivan = new Player("Иван", 4, R.drawable.ivan);
        Player Zhenya = new Player("Женя", 5);
        Player Maxim_k = new Player("Макс К.", 5, R.drawable.max_k);
        Player Maxim_t = new Player("Макс Т.", 5);
        Player Valek = new Player("Валентин", 5);
        playersList.add(Aleksey);
        playersList.add(Ilya);
        playersList.add(Anton);
        playersList.add(Alex_Ch);
        playersList.add(Alex_R);
        playersList.add(Alex_H);
        playersList.add(Alex_P);
        playersList.add(Vadim);
        playersList.add(Igor);
        playersList.add(Sergei);
        playersList.add(Artem);
        playersList.add(Nikolay);
        playersList.add(Ivan);
        playersList.add(Zhenya);
        playersList.add(Maxim_k);
        playersList.add(Maxim_t);
        playersList.add(Valek);
    }

    private void adjustGridView() {
        gridView.setNumColumns(3);
        gridView.setVerticalSpacing(10);
        gridView.setHorizontalSpacing(10);
//        gridView.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
    }

    private class myAdapter extends BaseAdapter {

        public myAdapter(){

        }

        @Override
        public int getCount() {
            return playersList.size();
        }

        @Override
        public Object getItem(int i) {
            return playersList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int pos, View convertView, ViewGroup parent) {

            CheckableLayout checkableLayout;
            ImageView img = null;
            TextView textView;
            if (convertView == null){
//                img = new ImageView(MainActivity.this);
//                img.setScaleType(ImageView.ScaleType.FIT_CENTER);
//                img.setLayoutParams(new ViewGroup.LayoutParams(150, 150));
//
//                textView = new TextView(MainActivity.this);
//                textView.setLayoutParams(new ViewGroup.LayoutParams(150, 80));

                checkableLayout = new CheckableLayout(MainActivity.this);
                checkableLayout.setLayoutParams(new GridView.LayoutParams(GridView.LayoutParams.WRAP_CONTENT, GridView.LayoutParams.WRAP_CONTENT));
//                checkableLayout.addView(img);
//                checkableLayout.addView(textView);
            } else {
                checkableLayout = (CheckableLayout)convertView;
//                img = (ImageView)checkableLayout.getChildAt(0);
            }
//            img.setImageResource(R.drawable.player);
            return checkableLayout;
        }
    }
}
