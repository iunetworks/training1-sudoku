package am.iunetworks.training.sudoku.logic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class GameManipulationsHelperTest {

    @Test
    public void testHelperBasicValidations() {
        try {
            new GameBoardManipulationsHelper(null);
            fail("Helper should throw NPE if initialized with null");
        }
        catch (NullPointerException e) {
            // this is OK
        }


        String[] allTheseValuesShouldThrowIAE = new String[]{
          "", // empty ,
          getEmptyBoard() + "0001", // longer,
          getEmptyBoard().replace('0',' '), // all wrong characters,
          getEmptyBoard().replaceFirst("\\d$", "x"), // one wrong character,
          "12312313" // short,
        };
        for (String board : allTheseValuesShouldThrowIAE) {
            try {
                new GameBoardManipulationsHelper(board);
                fail("Helper should throw NPE if initialized with null");
            } catch (IllegalArgumentException e) {
                // this is OK
            }
        }

        // and simple normal case
        new GameBoardManipulationsHelper(getEmptyBoard());
    }

    private String getEmptyBoard() {
        char[] board = new char[81];
        Arrays.fill(board,'0');
        return new String(board);
    }
    @Test
    public void rotateTest(){
        char[] board = new char[81];
        char[] newBoard = new char[81];
        Arrays.fill(board,'0');

        board[0]='1';
        board[1]='2';
        board[2]='3';
        board[3]='4';
        board[4]='5';
        board[5]='6';
        board[6]='7';
        board[7]='8';
        board[8]='9';
        newBoard=board;

        GameBoardManipulationsHelper.rotate();
        assertArrayEquals("Something was wrong with rotation", newBoard, board );

        GameBoardManipulationsHelper.rotate();
        assertArrayEquals("Something was wrong with rotation", newBoard, board );

        GameBoardManipulationsHelper.rotate();
        assertArrayEquals("Something was wrong with rotation", newBoard, board );

        GameBoardManipulationsHelper.rotate();
        assertArrayEquals("Something was wrong with rotation", newBoard, board );
    }
}