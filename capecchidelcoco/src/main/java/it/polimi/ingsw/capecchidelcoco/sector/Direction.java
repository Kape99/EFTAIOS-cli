package it.polimi.ingsw.capecchidelcoco.sector;

/**
 * @author lucacapecchi
 *
 * Use to find the sector around a given sector by adding these constant to 
 * his Y and X coordinates
 */
public class Direction {

	
	/**The 2 dimension are needed for the parity 
	 * if the X coordinate of the given sector is odd i use the first array
	 * if the X coordinate of the given sector is even i use the second array
	 * 
	 */
	private static final int[][] YDIRECTION={
			{-1,-1,0,+1,0,-1},
			{-1,0,+1,+1,+1,0}
	};
			
	
	private static final int[] XDIRECTION={0,+1,+1,0,-1,-1};


	/**
	 * @return the ydIRECTION
	 */
	public static int[][] getYDIRECTION() {
		return YDIRECTION;
	}


	/**
	 * @return the xdIRECTION
	 */
	public static int[] getXDIRECTION() {
		return XDIRECTION;
	}

	    	               
}
