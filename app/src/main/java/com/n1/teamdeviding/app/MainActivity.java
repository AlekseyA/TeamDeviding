package com.n1.teamdeviding.app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.ActionMode;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

import static com.n1.teamdeviding.app.R.drawable.selector;


public class MainActivity extends Activity {//implements AdapterView.OnItemSelectedListener {

    public ArrayList<Player> playersList = new ArrayList<Player>();
    CustomAdapter adapter;
    GridView gridView;
    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createList();

        adapter = new CustomAdapter(this, playersList);
        gridView = (GridView)findViewById(R.id.gridView);
        gridView.setAdapter(adapter);
        gridView.setSelected(true);
        adjustGridView();
//        gridView.setChoiceMode(GridView.CHOICE_MODE_MULTIPLE_MODAL);
//        gridView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
//            @Override
//            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
//                System.out.println("clicked to: " + i);
//            }
//        });
        gridView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                view.setBackgroundColor(selector);

                Log.d(LOG_TAG, "Was checked " + i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Log.d(LOG_TAG, "Nothing :(");
            }
        });

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
//                System.out.println("Was touched " + i);
                Log.d(LOG_TAG, "Was touched " + i);
            }
        });
;
    }

    private void createList(){

        Player Aleksey = new Player("Алексей", 7);
        Player Ilya = new Player("Илья", 4);
        Player Anton = new Player("Антон", 4);
        Player Alex_Ch = new Player("Саша Ч.", 5);
        Player Alex_R = new Player("Саша Р.", 5);
        Player Alex_H = new Player("Саша Х.", 4);
        Player Alex_P = new Player("Саша П.", 2);
        Player Vadim = new Player("Вадим", 4);
        Player Igor = new Player("Игорь", 4);
        Player Sergei = new Player("Сергей", 4);
        Player Artem = new Player("Артем", 4);
        Player Nikolay = new Player("Николай", 5);
        Player Ivan = new Player("Иван", 4);
        Player Zhenya = new Player("Женя", 5);
        Player Maxim = new Player("Максим", 5);
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
        playersList.add(Maxim);
    }

    private void adjustGridView() {
        gridView.setNumColumns(3);
        gridView.setVerticalSpacing(10);
        gridView.setHorizontalSpacing(10);
//        gridView.setStretchMode(GridView.STRETCH_SPACING_UNIFORM);
    }
}
