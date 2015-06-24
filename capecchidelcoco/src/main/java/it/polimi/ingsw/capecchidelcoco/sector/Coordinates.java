package it.polimi.ingsw.capecchidelcoco.sector;

/**
 * @author lucacapecchi
 * Class that define the Coordinates of a given sector 
 */
public class Coordinates {



	private int x;
	private int y;
	
	/**
	 * Constructor of the Class
	 * @param x - column
	 * @param y - row
	 */
	public Coordinates (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public void setX (int x){
		this.x = x;
	}
	
	public int getX (){
		return this.x;
	}

	
	public void setY (int y){
		this.y = y;
	}
	
	public int getY (){
		return this.y;
	}

}
