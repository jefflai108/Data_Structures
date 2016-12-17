/*
 * 	Implement the findWord and findPath method in the BoggleGame class.
 * 
 */

package boggle;

import java.util.ArrayList;
import java.util.Stack;

import utils.LetterGrid;

public class BoggleGame {
	
	/**
	 * The grid that contains all the letters. @see boggle.LetterGrid
	 */
	public LetterGrid grid;
	
	/**
	 * The stack that stores the path when you search the word path
	 */
	Stack<String> path;
	Stack<String> path2;
	
	boolean done; 
	
	int index; 
	
	ArrayList<Character> ch; 
	
	/**
	 * A boolean array to mark any location (row,col) as visited
	 */
	boolean[][] visited; 
	
	public BoggleGame(LetterGrid g) {
		grid = g;
		visited = new boolean[grid.getNumRows()][grid.getNumCols()];
		path = new Stack<>();
		path2 = new Stack<>();
	}
	/*
	 * return true if "word" can be found in "grid". return false otherwise
	 * private member variable grid has the letter grid.
	 * 
	 */
	public boolean findWord(String word) {
		int l = word.length(); 
		ch = new ArrayList<>();
		done = false;
		index = 0;
		while (!path.isEmpty()) {
			path.pop();
		}
		while (!path2.isEmpty()) {
			path2.pop();
		}
		clearVisited();
		for (int i=0; i<grid.getNumCols(); i++) { 
			for (int j=0; j<grid.getNumRows(); j++) { 
			    System.out.println(i + "" + j);
				solve(i, j, word);
				if (done != true) { 
					while (!path.isEmpty()) { 
						path.pop();
					}
					index = 0;
					ch.clear();
					clearVisited();
				}
			}
		}
		if (done) return true;
		return false;
	}
	
	private void clearVisited() {
	    for (int i=0; i<grid.getNumCols(); i++) { 
            for (int j=0; j<grid.getNumRows(); j++) { 
                visited[i][j] = false;
            }
        }        
    }
    private void solve(int x, int y, String word) { 
		if (x == -1 || y == -1 || x == grid.getNumCols() || y == grid.getNumRows()) {
			if (!path.isEmpty() && index == (word.length()-1)) { 
				String str = path.peek();
				int tx = Integer.parseInt(str.substring(1,2));
				int ty = Integer.parseInt(str.substring(3,4));
				if ((tx == x + 1) && (ty == y + 1)) {
					path.pop();
					index--;
					ch.remove(index);
				}
			}
			return;
		}
		if (done || visited[x][y] || grid.getLetter(x, y) != word.charAt(index)) {
			if (!path.isEmpty() && index == (word.length()-1)) { 
				String str = path.peek();
				int tx = Integer.parseInt(str.substring(1,2));
				int ty = Integer.parseInt(str.substring(3,4));
				if ((tx == x + 1) && (ty == y + 1)) {
					path.pop();
					index--;
					ch.remove(index);
				}
			}
			return;
		}
		if (grid.getLetter(x, y) == word.charAt(index))
			System.out.println("" + x + " " + y);
		ch.add(word.charAt(index));
		path.push("(" + x + "," + y + ")");
		visited[x][y] = true; 
		index++; 
		String dummy = "";
		for (int i=0; i<ch.toArray().length; i++) { 
			dummy += ch.get(i);
		}
		if (dummy.equals(word)) done = true; 
		
		solve(x, y+1, word); 
		solve(x, y-1, word); 
		solve(x+1, y, word); 
		solve(x-1, y, word); 
		solve(x+1, y+1, word); 
		solve(x+1, y-1, word); 
		solve(x-1, y+1, word);
		solve(x-1, y-1, word);

		
	}
	
	/*
	 * return the path (cell index) of each letter
	 * 
	 */
	public String findWordPath(String word) {
		String str = "";
		if (findWord(word)) { 
			while (!path.isEmpty()) {
				path2.push(path.pop());
			}
			while (!path2.isEmpty()) {
				str += path2.pop();
			}
		} 
		return str; 
		
	}
}
