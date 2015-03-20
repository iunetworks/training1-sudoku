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

        int[][] board = new int[9][9];
        int[][] newBoard = new int[9][9];
        board[0][0]=1;
        board[0][1]=2;
        board[0][2]=3;
        board[0][3]=4;
        board[0][4]=5;
        board[0][5]=6;
        board[0][6]=7;
        board[0][7]=8;
        board[0][8]=9;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                newBoard[i][j] = board[i][j];
            }
        }
        int rowLength = board.length;
        int columnLength = board[0].length;
        int i;
        int j;
        for ( i = 0; i < rowLength; i++){
            System.out.println();
            for ( j=0; j<columnLength;j++){
                System.out.print(board[i][j]);
            }
        }
        System.out.println();

        GameBoardManipulationsHelper.rotate(board, board.length);
        for ( i = 0; i < rowLength; i++){
            System.out.println();
            for ( j=0; j<columnLength;j++){

                System.out.print(board[i][j]);
            }
        }
        System.out.println();


        GameBoardManipulationsHelper.rotate(board, board.length);
        for ( i = 0; i < rowLength; i++){
            System.out.println();
            for ( j=0; j<columnLength;j++){
                System.out.print(board[i][j]);
            }
        }
        System.out.println();


        GameBoardManipulationsHelper.rotate(board, board.length);
        for ( i = 0; i < rowLength; i++){
            System.out.println();
            for ( j=0; j<columnLength;j++){
                System.out.print(board[i][j]);
            }
        }
        System.out.println();

        GameBoardManipulationsHelper.rotate(board, board.length);
        assertArrayEquals("Something was wrong with rotation", newBoard, board );
        for ( i = 0; i < rowLength; i++){
            System.out.println();
            for ( j=0; j<columnLength;j++){
                System.out.print(board[i][j]);
            }
        }
    }
}