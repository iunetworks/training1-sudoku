package am.iunetworks.training.sudoku.logic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class GameManipulationsHelperTest {
    private char[] board= new char[81];

    private int row;
    private int row2;


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




    

//Row switch or replace manipulation

    @Test
     public void testSwitchRow () {

        Arrays.fill(board,'0');

        String art = new String(board);

        String temp = art.replaceFirst(".{81}", "123456789123456789123456789123456789123456789123456789123456789123456789123456789");
        this.board = temp.toCharArray();
        GameBoardManipulationsHelper  rot = new GameBoardManipulationsHelper(temp);


       this.row = (int)(Math.random()*8);
       this.row2 = (int)(Math.random()*8);





         assertArrayEquals("after switch ", switchTest() ,rot.switchRow(row, row2));
         assertArrayEquals("after switch ", switchTest(),rot.switchRow(row, row2));
         assertArrayEquals("after switch ", switchTest(),rot.switchRow(row, row2));
         assertArrayEquals("after switch ", switchTest(),rot.switchRow(row, row2));
         assertArrayEquals("after switch ", switchTest(),rot.switchRow(row, row2));

        assertEquals("after switch ",String.valueOf(switchTest()[1]),String.valueOf(rot.switchRow(1, 7)[7]));

         assertEquals("after switch ",String.valueOf(switchTest()[8]) ,String.valueOf(rot.switchRow(8, 2)[2]));


    }




    char[] switchTest(){
        int length=9;

        char [][] matrix =new char[length][length];
        char [][] temp =new char[length][length];
        int index= 0;

        for (int i = 0; i < length;i++ ){
            for(int j = 0; j < length; j++) {
                temp[i][j] = board[index];
                index++;

            }
        }

        int index2=0;

        for (int i = 0; i < length;i++ ){
            for(int j = 0; j < length; j++) {
                if (j == row  ||  j==row2){
                    matrix [i][row]=temp[i][row2];
                    matrix [i][row2]=temp[i][row];
                }
                else{ matrix [i][j]=temp[i][j]; }

                board[index2] = matrix[i][j];
                index2++;
            }
        }
        return board;}
  }