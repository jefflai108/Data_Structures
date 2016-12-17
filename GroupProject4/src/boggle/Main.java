package boggle;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import tests.TestsSupport;
import utils.LetterGrid;
import utils.SimpleGrid;

public class Main {

	public static void main(String[] args) {
		
         	//  -------------
			//  | F | A | Z |
			//  -------------
			//  | G | I | D |
			//  -------------
			//  | Y | T | N |
			//  -------------
//	     BoggleGame game = new BoggleGame(SimpleGrid.createSimpleGridOne());
//		
//		/*
//		 * 	r must be true
//		 */
//
//		
//		boolean l = game.findWord("FIND");
//		if(l){
//			System.out.println("Found");
//		}else{
//			System.out.println("NOT Found");
//		}

		BoggleGame game = new BoggleGame(SimpleGrid.createSimpleGridOne());
		
		// these should be true
		String path = game.findWordPath("FIND");
		System.out.println(path);
		//ssertTrue(path.replaceAll("\\s+", "").equals("(0,0)(1,1)(2,2)(1,2)"));
		
		// notice that the following should be false
		//System.out.println(game.findWord("ADA"));

		/*
		 * path is: (0,0)
					(1,1)
					(2,2)
					(1,2)	
//		 */
//		String path = game.findWordPath("FIND");
//		System.out.println(path);
	}

}
