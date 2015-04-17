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

        String str = new String("123456789000000000000000000123456789000000000000000000123456789000000000000000000");
        GameBoardManipulationsHelper  helper = new  GameBoardManipulationsHelper(str);
        char[] board= str.toCharArray();

        String str1 = new String("001001001002002002003003003004004004005005005006006006007007007008008008009009009");
        char[] board1=str1.toCharArray();

        String str2 = new String("000000000000000000987654321000000000000000000987654321000000000000000000987654321");
        char[] board2=str2.toCharArray();

        String str3 = new String("900900900800800800700700700600600600500500500400400400300300300200200200100100100");
        char[] board3 = str3.toCharArray();

        assertArrayEquals("Something was wrong with rotation",  helper.rotate(),board1);
        assertArrayEquals("Something was wrong with rotation",  helper.rotate(),board2);
        assertArrayEquals("Something was wrong with rotation",  helper.rotate(),board3);
        assertArrayEquals("Something was wrong with rotation",  helper.rotate(),board);
    }
}