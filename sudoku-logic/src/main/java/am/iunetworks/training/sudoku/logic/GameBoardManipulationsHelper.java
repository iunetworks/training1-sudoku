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
    
    public GameBoardManipulationsHelper rotateBoardOn90Angle() {
		char[] boardRotate = new char[board.length];
		int digitPosition = board.length - 1;
		for (int i = 1; i < 10; i++) {
			for (int j = board.length - (10 - i); j >= 0; j -= 9) {
				boardRotate[j] = board[digitPosition];
				digitPosition--;
			}
		}
		board = boardRotate;
		return this;
	}
    
    public String getBoard() {
		return new String(board);
	}

}
