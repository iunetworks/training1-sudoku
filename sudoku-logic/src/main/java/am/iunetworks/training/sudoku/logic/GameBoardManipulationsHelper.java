package am.iunetworks.training.sudoku.logic;

/**
 * This class contains all board manipulations.
 *  - Rotate
 *  - Switch columns & rows
 *  - Re-arrange
 *  - others
 * Created by Gurgen Nersesyan on 01.02.2015.
 */
public class GameBoardManipulationsHelper {

    private char[] board;

    public GameBoardManipulationsHelper(String board) {
        checkIsBoardValid(board);
        this.board = board.toCharArray();
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
    public char[] rotate() {
        char temp[][] = new char[9][9];
        int rowLength = 9;
        int columnLength = 9;
        int i;
        int j;
        int index=0;
        for ( i = 0; i < rowLength; i++) {
            for (j = 0; j < columnLength; j++) {
                temp[i][j]= board[index];
                index++;
            }
        }
        int index1=0;
        for ( i = 0; i < rowLength; i++){
            for ( j=0; j<columnLength;j++){
                board[index1]=temp[columnLength-j-1][i];
                index1++;

            }
        }
        return board;
    }

}
