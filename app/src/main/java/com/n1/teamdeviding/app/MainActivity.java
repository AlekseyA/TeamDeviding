package com.n1.teamdeviding.app;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    public static ArrayList<Player> playersList;

    public Player Aleksey = new Player("Алексей", 7);
    public Player Ilya = new Player("Илья", 4);
    public Player Anton = new Player("Антон", 4);
    public Player Alex_Ch = new Player("Саша Ч.", 5);
    public Player Alex_R = new Player("Саша Р.", 5);
    public Player Alex_H = new Player("Саша Х.", 4);
    public Player Alex_P = new Player("Саша П.", 2);
    public Player Vadim = new Player("Вадим", 4);
    public Player Igor = new Player("Игорь", 4);
    public Player Sergei = new Player("Сергей", 4);
    public Player Artem = new Player("Артем", 4);
    public Player Nikolay = new Player("Николай", 5);
    public Player Ivan = new Player("Иван", 4);
    public Player Zhenya = new Player("Женя", 5);
    public Player Maxim = new Player("Максим", 5);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
