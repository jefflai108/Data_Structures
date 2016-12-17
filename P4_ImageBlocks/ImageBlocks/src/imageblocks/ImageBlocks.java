package imageblocks;

import java.awt.Color;

import utils.Picture;

public class ImageBlocks {
	static Color BLACK = new Color(0, 0, 0);
	static Color WHITE = new Color(255, 255, 255);
	private int height;
	private int width;
	private int counter;
	int[][] visited; // value is set to 0 when the block is visited
	Picture pic;

	public ImageBlocks() {
		counter = 0;
		height = 0;
		width = 0;
	}

	private boolean isBlack(int x, int y) {
		return pic.get(x, y).equals(BLACK);
	}

	private boolean isWhite(int x, int y) {
		return pic.get(x, y).equals(WHITE);
	}

	/*
	 * The method counts the number of image blocks in the given image.
	 * 
	 * @param filename if a black and white bitmap image.
	 * 
	 * @return number of black blocks
	 */
	public int CountConnectedBlocks(String fileName) {
		setter(fileName);
		// iterate through the 2D array
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				if (solvePic(i, j))
					counter++;
			}
		}
		return counter;
	}

	/*
	 * This method uses recursion to solve the image blocks in the given image.
	 * 
	 * @param int i x coordinate in the 2D array
	 * 
	 * @param int j y coordinate in the 2D array
	 * 
	 * @return boolean if the method actually solves any block
	 */
	private boolean solvePic(int i, int j) {
		if (i < 0 || j < 0 || i == width || j == height)
			return false; // out of bound values
		if (visited[i][j] == 1)
			return false; // skip the visited blocks
		if (isWhite(i, j))
			return false; // skip the white blocks
		if (isBlack(i, j))
			visited[i][j] = 1;
		// recursive solve 8 different directions
		solvePic(i + 1, j);
		solvePic(i - 1, j);
		solvePic(i + 1, j + 1);
		solvePic(i - 1, j + 1);
		solvePic(i + 1, j - 1);
		solvePic(i, j + 1);
		solvePic(i, j - 1);
		solvePic(i - 1, j - 1);
		// Did solve the image blocks
		return true;
	}

	/*
	 * This method initializes variables by calling Picture constructor.
	 * 
	 * @param String filename
	 */
	private void setter(String fileName) {
		pic = new Picture(fileName);
		this.height = pic.height();
		this.width = pic.width();
		visited = new int[width][height];
	}

	public static void main(String[] args) {

		String fileName = "images/14.png";
		ImageBlocks block = new ImageBlocks();
		try {
			int c = block.CountConnectedBlocks(fileName);
			System.out.println("Number of connected blocks=" + c);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
