import java.util.Arrays;
/**
 * This class contains all board manipulations.
 *  - Rotate
 *  - Switch columns & rows
 *  - Re-arrange
 *  - others
 * Created by Gurgen Nersesyan on 01.02.2015.
 */
@SuppressWarnings("unused")
public class GameBoardManipulationsHelper {

    private char[] board;
     int range; 
     int range2;

    public GameBoardManipulationsHelper(String board) {
        
        this.board = board.toCharArray();
       
    }
   
 public char[] getBoard() {
	return board;
}


		
		//rotate metod
		protected char[] rotateRight() {

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
 
		
 }
