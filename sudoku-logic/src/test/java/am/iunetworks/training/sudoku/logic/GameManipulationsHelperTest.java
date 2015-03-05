package am.iunetworks.training.sudoku.logic;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


public class GameManipulationsHelperTest {

    @http://www.list.am/item/1965943Test
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
    public void testRotate () {


          char [] board = new char[81];
          Arrays.fill(board,'*');


          String art = new String(board);

          String temp = art.replaceFirst(".{9}", "123456789");
          GameBoardManipulationsHelper  rot = new GameBoardManipulationsHelper(temp);
//rotate1
          assertEquals("after rotafter "rot.board ,rot.RotateRight());
          assertEquals("after rotatet 9-index=1"rot.board[9],1);
//rotate2         
          assertEquals("after rotafter "rot.board ,rot.RotateRight());
          assertEquals("after rotatet 9-index=1"rot.board[81],1);
//rotate3        
          assertEquals("after rotafter "rot.board ,rot.RotateRight());
          assertEquals("after rotatet 9-index=1"rot.board[1],9);
//rotate4        
          assertFalse("after rotafter "temp ,rot.RotateRight());


      }





    }






}