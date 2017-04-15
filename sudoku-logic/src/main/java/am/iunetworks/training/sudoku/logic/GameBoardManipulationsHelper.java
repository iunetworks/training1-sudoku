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
    
    public GameBoardManipulationsHelper switchRow(int selectRow, int changeRow) {
		if (selectRow < 0 || selectRow > 8 || changeRow < 0 || changeRow > 8 || selectRow == changeRow) {
			return this;
		}
		char tmp;
		for (int i = 0; i < 9; i++) {
			tmp = board[i + (changeRow * 9)];
			board[i + (changeRow * 9)] = board[i+(selectRow*9)];
			board[i+(selectRow*9)] = tmp;
		}
		return this;
	}
    
    public GameBoardManipulationsHelper switchColumn(int selectColumn, int changeColumn) {
		if (selectColumn < 0 || selectColumn > 8 || changeColumn < 0 || changeColumn > 8 || selectColumn == changeColumn) {
			return this;
		}
		char tmp;
		for(int i = 0; i < 9; i++) {
			tmp = board[selectColumn + (9 * i)];
			board[selectColumn + (9 * i)] = board[changeColumn + (9 * i)];
			board[changeColumn + (9 * i)] = tmp;
		}
		return this;
	}
    
    public String getBoard() {
		return new String(board);
	}

}
