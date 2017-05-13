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
	public void testSwitchRows() {
		// board
		String testBoard = "375964182964182375182375964759641823641823759823759641596418237418237596237596418";
		try {
			new GameBoardManipulationsHelper(testBoard).switchRows(10, 10);
			fail("Helper should throw NPE if initialized with null");
		} catch (IllegalArgumentException e) {

		}

		GameBoardManipulationsHelper helper = new GameBoardManipulationsHelper(testBoard);

		helper.switchRows(1, 1);
		assertEquals(testBoard, helper.getBoard());

		helper.switchRows(0, 1);
		helper.switchRows(1, 0);

		assertEquals(testBoard, helper.getBoard());

	}
	
	@Test
	public void testSwitchColumns() {
		// board
		String testBoard = "375964182964182375182375964759641823641823759823759641596418237418237596237596418";
		try {
			new GameBoardManipulationsHelper(testBoard).switchColumns(10, 10);
			fail("Helper should throw NPE if initialized with null");
		} catch (IllegalArgumentException e) {

		}

		GameBoardManipulationsHelper helper = new GameBoardManipulationsHelper(testBoard);

		helper.switchColumns(1, 1);
		assertEquals(testBoard, helper.getBoard());

		helper.switchColumns(0, 1);
		helper.switchColumns(1, 0);

		assertEquals(testBoard, helper.getBoard());

	}

    private String getEmptyBoard() {
        char[] board = new char[81];
        Arrays.fill(board,'0');
        return new String(board);
    }
}