package ticatactoe;

import java.util.ArrayList;
import java.util.List;

public class BoardRepository {
    public void render(Board board) {
        System.out.println("---------");
        for (ArrayList<String> row : board.rows)
        {
            List<String> printList = new ArrayList<String>();

            for (String position : row)
            {
                if (position.equals("X") || position.equals("O"))
                {
                    printList.add(position);
                } else
                {
                    printList.add(" ");
                }
            }
            System.out.println(
                    printList.get(0) + " | " + printList.get(1) + " | " + printList.get(2));
            System.out.println("---------");
        }
    }

    public boolean getWinner(Board board, String symbol) {
        for (var row : board.rows) {
            if(row.get(0).equals(symbol) && row.get(1).equals(symbol) && row.get(2).equals(symbol)) {
                return true;
            }
        }

        var i = 0;
        while (i < 3) {
            if(board.rows.get(0).get(i).equals(symbol) && board.rows.get(1).get(i).equals(symbol) && board.rows.get(2).get(i).equals(symbol)) {
                return true;
            }
            i++;
        }

        if(board.rows.get(0).get(0).equals(symbol) && board.rows.get(1).get(1).equals(symbol) && board.rows.get(2).get(2).equals(symbol)) {
            return true;
        }
        if(board.rows.get(0).get(2).equals(symbol) && board.rows.get(1).get(1).equals(symbol) && board.rows.get(2).get(0).equals(symbol)) {
            return true;
        }
        return false;
    }

    public boolean anyMoveLeft(Board board) {
        for (var row : board.rows) {
            for (var item : row) {
                if (item.equals(" ")) {
                    return false;
                }
            }
        }
        return true;
    }
}
