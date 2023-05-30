package ticatactoe;

import java.util.Scanner;

public class MoveRepository {
    public int getMove(String symbol, String axis) {
        var result = false;
        String input = "";
        while (!result) {
            System.out.println("Enter " + symbol + " " + axis + " coordinate: ");
            // read inout from terminal
            Scanner scanner = new Scanner(System.in);
            input = scanner.nextLine();
            result = validateInputMove(input);
        }
        return Integer.parseInt(input);
    }

    public boolean validateInputMove(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3")) {
            return true;
        }
        return false;
    }
    
    public Board makeMove(Board board, int coordY, int coordX, String symbol) {
        board.rows.get(coordY).set(coordX, symbol);
        return board;
    }

    public boolean validateMove(Board board, int coordY, int coordX) {
        if (board.rows.get(coordY).get(coordX).equals("X") || board.rows.get(coordY).get(coordX).equals("O")) {
            return false;
        }
        return true;
    }

}