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
    
	@Test
	public void testBoardRotate() {
		// valid Board
		String testBoard = "375964182964182375182375964759641823641823759823759641596418237418237596237596418";
		GameBoardManipulationsHelper helper = new GameBoardManipulationsHelper(testBoard);
		// rotate 90+90+90+90
		helper.rotateBoardOn90Angle();
		helper.rotateBoardOn90Angle();
		helper.rotateBoardOn90Angle();
		helper.rotateBoardOn90Angle();

		assertEquals(testBoard, helper.getBoard());
	}

	@Test
	public void testSwitchRowsAndColumns() {
		//board
		String testBoard = "375964182964182375182375964759641823641823759823759641596418237418237596237596418";
		GameBoardManipulationsHelper helper = new GameBoardManipulationsHelper(testBoard);
		//switch Rows and Columns
		helper.switchRow(1, 3);
		helper.switchColumn(2, 5);
		helper.switchRow(3, 8);
		helper.switchColumn(5, 0);
		helper.switchRow(8, 1);
		helper.switchColumn(0, 5);
		helper.switchRow(8, 3);
		helper.switchColumn(5, 2);
		
		assertEquals(testBoard, helper.getBoard());
	}

    private String getEmptyBoard() {
        char[] board = new char[81];
        Arrays.fill(board,'0');
        return new String(board);
    }
}