import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Arrays;

 

public class ManipulationsHelperTest {

  char[] board= new char[81];
  
  
  
  
  

  private String getEmptyBoard() {
      char[] board = new char[81];
      Arrays.fill(board,'0');
      return new String(board);
  }



@Test
public    void rotate( ) {

	  	 
			Arrays.fill(board,'*');
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

protected char[] rotTest (char[] board) {
	 
	 
	
	 
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
