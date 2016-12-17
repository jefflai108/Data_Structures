/* Data Structure
 * Cheng-I Lai 
 * clai24 
 */

package model;

import java.util.Random;

/* This class must extend Game */
public class SimpleTetris extends Game {
	//private int rowNum;
	private int scoreVal; 
	private Random random; 
	BoardCell dummy; 
	
	public SimpleTetris(int maxRows, int maxCols, java.util.Random random, int strategy) {
	// constructor 
		super(maxRows, maxCols);
		this.random = random; 
	}

	@Override
	public boolean isGameOver() {
	// Return true if game is over, else return false
		for (int i=0; i<getMaxCols(); i++)
			if (board[getMaxRows()-1][i] != BoardCell.EMPTY) return true;  
		return false; 
	}

	@Override
	public int getScore() {
		return scoreVal; 
	}

	@Override
	public void nextAnimationStep() {	
	// This method will attempt to insert a row of random BoardCell objects if the last board row 
	// (row with index board.length -1) corresponds to the empty row; otherwise no operation will take place.
		if (!isGameOver()) { 
			for (int i=rowNum; i>=1; i--) { 
				for (int j=0; j<getMaxCols(); j++) { 
					board[i][j] = board[i-1][j]; // First swipe down the whole row 
				}
			} 
			for (int i=0; i<getMaxCols(); i++) { 
				setBoardCell(0, i, BoardCell.getNonEmptyRandomBoardCell(random)); // insert a new row at the top of the board 
			}
			rowNum++; // update the rowNum
		}
	}

	private void checkDir (int rowIndex, int colIndex, int tempR, int tempC, BoardCell dummy) { 
	// helper method for processCell in 8 different directions 
		rowIndex += tempR; 
		colIndex += tempC;
		while (colIndex<getMaxCols() && rowIndex<getMaxRows() && colIndex>=0 && rowIndex>=0 && (board[rowIndex][colIndex] == dummy)) { 
			setBoardCell(rowIndex, colIndex, BoardCell.EMPTY);  
			rowIndex += tempR; 
			colIndex += tempC;
			scoreVal++; 
		}
	}
	
	@Override
	public void processCell(int rowIndex, int colIndex) {	
		dummy = board[rowIndex][colIndex];
		if (dummy == BoardCell.EMPTY) return; 
		setBoardCell(rowIndex, colIndex, BoardCell.EMPTY); 
		scoreVal++; 
		// helper method to check for same color in different directions 
		for (int i=-1; i<2; i++) { 
			for (int j=-1; j<2; j++) { 
				checkDir(rowIndex, colIndex, i, j, dummy);
			}
		}
		// check if the row is empty
		for (int i=0; i<getMaxCols(); i++) 
			if (board[rowIndex][i] != BoardCell.EMPTY) return;
		// swipe up a row
		for (int i=rowIndex; i<rowNum-1; i++) { 
			for (int j=0; j<getMaxCols(); j++) { 
				board[i][j] = board[i+1][j]; 
			}
		}
		for (int i=0; i<getMaxCols(); i++)
			board[rowNum-1][i] = BoardCell.EMPTY;
		rowNum--;
		
	}

}