package am.iunetworks.training.sudoku.logic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class GameManipulationsHelperTest {
    private char[] board= new char[81];

    private int range;
    private int range2;


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
    public  void rotate( ) {


        Arrays.fill(board,'0');
        String art = new String(board);

        String temp = art.replaceFirst(".{9}", "123456789");

        GameBoardManipulationsHelper  rot = new  GameBoardManipulationsHelper(temp);

        board = temp.toCharArray();


        //rotateTest

        assertArrayEquals("after rotafter ", rot.rotateRight() ,rotTest (board));
        assertEquals("after rotafter ","1" ,String.valueOf((rot.getBoard()[8])));
        System.out.println( rot.getBoard()[8]);


        assertArrayEquals("after rotafter ", rot.rotateRight() ,rotTest (board));
        assertEquals("after rotafter ","1" ,String.valueOf((rot.getBoard()[80])));
        System.out.println( board);

        assertArrayEquals("after rotafter ", rot.rotateRight() ,rotTest (board));
        assertEquals("after rotafter ","1" ,String.valueOf((rot.getBoard()[72])));
        System.out.println( board);

        assertArrayEquals("after rotafter ", rot.rotateRight() ,rotTest (board));
        assertEquals("after rotafter ","1" ,String.valueOf((rot.getBoard()[0])));
        System.out.println( board);

        assertArrayEquals("after rotafter ", rot.rotateRight() ,rotTest (board));
        System.out.println( board);




    }

    private char[] rotTest (char[] board ) {

        int length=9;
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
                board[index2] = temp[length-j-1][i];
                index2++;

            }

        }

        return board;}
//

//Row swich or replace manipulation
//



    @Test
     public void testReplaceRow () {

        Arrays.fill(board,'0');

        String art = new String(board);

        String temp = art.replaceFirst(".{81}", "123456789123456789123456789123456789123456789123456789123456789123456789123456789");
        this.board = temp.toCharArray();
        GameBoardManipulationsHelper  rot = new GameBoardManipulationsHelper(temp);
        range = rot.getRange();
        range2 = rot.getRange2();


        assertArrayEquals("after rotafter ", swichTest( ) ,rot.replaceRow());
        assertArrayEquals("after rotafter ", swichTest( ) ,rot.replaceRow());
        assertArrayEquals("after rotafter ", swichTest( ) ,rot.replaceRow());
        assertArrayEquals("after rotafter ", swichTest( ) ,rot.replaceRow());
        assertArrayEquals("after rotafter ", swichTest( ) ,rot.replaceRow());
        assertArrayEquals("after rotafter ", swichTest( ) ,rot.replaceRow());





//test1



    }




    char[] swichTest(){


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
                if (j == range  ||  j==range2){
                    matrix [i][range]=temp[i][range2];
                    matrix [i][range2]=temp[i][range];

                }
                else{ matrix [i][j]=temp[i][j]; }

                board[index2] = matrix[i][j];
                index2++;

            }

        }

        return board;}
  }