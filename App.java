import ticatactoe.Board;
import ticatactoe.BoardRepository;
import ticatactoe.MoveRepository;

public class App {

    public static void main(String[] args) throws Exception {
        BoardRepository boardRepository = new BoardRepository();
        MoveRepository moveRepository = new MoveRepository();
        
        Board board = new Board();
        boardRepository.render(board);

        boolean gameResult = false;
        while (gameResult == false) {
            boolean validMoveResult = false;
            int moveXY = 0;
            int moveXX = 0;

            while (validMoveResult == false) {
                moveXY = moveRepository.getMove("X", "Y");
                moveXX = moveRepository.getMove("X", "X");
                validMoveResult = moveRepository.validateMove(board, moveXY, moveXX);
                if (validMoveResult == false) {
                    System.out.println("");
                    System.out.println("Invalid move, try again");
                    System.out.println("");
                }
            }

            board = moveRepository.makeMove(board, moveXY, moveXX, "X");
            boardRepository.render(board);
            gameResult = boardRepository.getWinner(board, "X");
            if (gameResult == true) {
                System.out.println("X wins");
                return;
            }

            gameResult = boardRepository.anyMoveLeft(board);
            if (gameResult == true) {
                System.out.println("Draw");
                return;
            }

            validMoveResult = false;
            int moveOY = 0;
            int moveOX = 0;
            while (validMoveResult == false) {
                moveOY = moveRepository.getMove("O", "Y");
                moveOX = moveRepository.getMove("O", "X");
                validMoveResult = moveRepository.validateMove(board, moveOY, moveOX);
                if (validMoveResult == false) {
                    System.out.println("");
                    System.out.println("Invalid move, try again");
                    System.out.println("");
                }
            }
            board = moveRepository.makeMove(board, moveOY, moveOX, "O");
            gameResult = boardRepository.getWinner(board, "O");

            boardRepository.render(board);
            if (gameResult)
            {
                System.out.println("O wins");
                return;
            }

            gameResult = boardRepository.anyMoveLeft(board);
            if (gameResult) {
                System.out.println("Draw");
                return;
            }
        }
    }
}
