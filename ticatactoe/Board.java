package ticatactoe;

import java.util.ArrayList;

public class Board {
    public ArrayList<ArrayList<String>> rows;

    public ArrayList<String> row1;
    public ArrayList<String> row2;
    public ArrayList<String> row3;

    public Board() {
        row1 = new ArrayList<String>() {{ add(" "); add(" "); add(" "); }};
        row2 = new ArrayList<String>() {{ add(" "); add(" "); add(" "); }};
        row3 = new ArrayList<String>() {{ add(" "); add(" "); add(" "); }};

        rows = new ArrayList<ArrayList<String>>();
        rows.add(row1);
        rows.add(row2);
        rows.add(row3);
    }
}