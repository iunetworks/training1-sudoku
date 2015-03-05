package am.iunetworks.training.sudoku.logic;

import java.util.Arrays;

/**
 * This class contains all board manipulations.
 *  - Rotate
 *  - Switch columns & rows
 *  - Re-arrange
 *  - others
 * Created by Gurgen Nersesyan on 01.02.2015.
 */
public class GameBoardManipulationsHelper {

    //private char[] board;
private static int board[][]={{1,2,3,4,5,6,7,8,9},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0}};

    public GameBoardManipulationsHelper(String board) {
        checkIsBoardValid(board);
        //this.board = board.toCharArray();
    }

    private void checkIsBoardValid(String board) {
        if (board == null) {
            throw new NullPointerException("Game board can't be null");
        }
        if (board.length() != 81) {
            throw new IllegalArgumentException("Game board must be 81 chars long");
        }

        if (!board.matches("^\\d{81}$")) {
            throw new IllegalArgumentException("Game board can only have 0-9 chars");
        }
    }
    public static void rotate() {
        int temp[][] = new int[9][9];
        int rowLength = board.length;
        int columnLength = board[0].length;
        int i;
        int j;
        for ( i = 0; i < rowLength; i++) {
            for (j = 0; j < columnLength; j++) {
                temp[i][j]=board[columnLength-j-1][i];
            }
        }

        for ( i = 0; i < rowLength; i++){
            System.out.println();
            for ( j=0; j<columnLength;j++){
                board[i][j]=temp[i][j];
            }
        }
        for ( i = 0; i < rowLength; i++){
            System.out.println();
            for ( j=0; j<columnLength;j++){
                System.out.print(board[i][j]);
            }
        }

    }
}
