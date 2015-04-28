package it.polimi.ingsw.capecchidelcoco.sector;

public class Sector implements AbstractSector{

	private int row;
	private int col;
	/*
	 * Tell which type of sector is the one in coordinate [row][col]
	 * type:
	 * 0 - NullSector
	 * 1 - SecureSector
	 * 2 - DangerousSector
	 * 3 - 
	 */
	private int type;
	private String name;
	
	
	public Sector(int x, int y, int type){
		this.row = x;
		this.col = y;
		this.type = type;
	}
	
	
	public void setType (int x, int y, int type){
		this.type = type;
	}
	
	public int getType (){
		return this.type;
	}
	
	public void setX (int x){
		this.row = x;
	}
	
	public int getX (){
		return this.row;
	}
	
	public void setY (int y){
		this.col = y;
	}
	
	public int getY (){
		return this.col;
	}
	
	public void setName (int x, int y, String name){
		this.name = name;
	}
		
	public String getName (){
		return this.name;
	}
	
}
