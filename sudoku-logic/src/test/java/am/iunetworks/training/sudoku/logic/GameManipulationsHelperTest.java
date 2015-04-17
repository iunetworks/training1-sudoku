package am.iunetworks.training.sudoku.logic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class GameManipulationsHelperTest {
    private char[] board = new char[81];

    private int row;
    private int row2;


    @Test
    public void testHelperBasicValidations() {
        try {
            new GameBoardManipulationsHelper(null);
            fail("Helper should throw NPE if initialized with null");
        } catch (NullPointerException e) {
            // this is OK
        }


        String[] allTheseValuesShouldThrowIAE = new String[]{
                "", // empty ,
                getEmptyBoard() + "0001", // longer,
                getEmptyBoard().replace('0', ' '), // all wrong characters,
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
        Arrays.fill(board, '0');
        return new String(board);
    }


    @Test
    public void rotate() {


        Arrays.fill(board, '0');
        String stringBoard = new String(board);

        String temp = stringBoard.replaceFirst(".{9}", "123456789");

        GameBoardManipulationsHelper rot = new GameBoardManipulationsHelper(temp);

        board = temp.toCharArray();
        char[] boardOriginal = temp.toCharArray();
        //rotateTest

        assertArrayEquals("after rotafter ", rot.rotateRight(), rotTest1());
        assertEquals("after rotafter ", "1", String.valueOf((rot.getBoard()[8])));
        System.out.println(rot.getBoard());


        assertArrayEquals("after rotafter ", rot.rotateRight(), rotTest2());
        assertEquals("after rotafter ", "1", String.valueOf((rot.getBoard()[80])));
        System.out.println(rot.getBoard());


        assertArrayEquals("after rotafter ", rot.rotateRight(), rotTest3());
        assertEquals("after rotafter ", "1", String.valueOf((rot.getBoard()[72])));
        System.out.println(rot.getBoard());

        assertArrayEquals("after rotafter ", rot.rotateRight(), boardOriginal);
        assertEquals("after rotafter ", "1", String.valueOf((rot.getBoard()[0])));
        System.out.println(rot.getBoard());
        System.out.println(boardOriginal);


    }

    private char[] rotTest3( ) {

        return "900000000800000000700000000600000000500000000400000000300000000200000000100000000".toCharArray();
    }

    private char[] rotTest2( ) {

        return "000000000000000000000000000000000000000000000000000000000000000000000000987654321".toCharArray();
    }

    private char[] rotTest1( ) {

        return "000000001000000002000000003000000004000000005000000006000000007000000008000000009".toCharArray();
    }

}