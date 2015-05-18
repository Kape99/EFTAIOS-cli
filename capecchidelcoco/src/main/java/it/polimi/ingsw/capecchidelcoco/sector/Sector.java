package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.sector.Coordinates;

public abstract class  Sector extends Coordinates {

	
	/*
	 * Tell which type of sector is the one in coordinate [row][col]
	 * type:
	 * 0 - NullSector
	 * 1 - SecureSector
	 * 2 - DangerousSector
	 * 3 - HatchSector
	 * 4 - HumanSpawn
	 * 5 - AlienSpawn
	 */
	private int type;
	private String name;
	private boolean usable;
	
	public Sector(int x, int y, int type, boolean usable){
		super(x, y);
		this.type = type;
		this.usable = usable;
		setName();
	}
	
	public boolean isUsable(){
		return this.usable;
	}
	
	
	public void setType (int x, int y, int type){
		this.type = type;
	}
	
	public int getType (){
		return this.type;
	}
	
	public void setCol (int x){
		this.setX(x);
	}

	public int getCol (){
		return this.getX();
	}
	
	public void setRow (int y){
		this.setY(y);
	}
	
	public int getRow (){
		return this.getY();
	}
	
	public void setName (){
		String name= new String();
		name += (char)('A'+(byte)getCol()); 
		name += String.format("%02d", getRow()+1);
		
		this.name = name;
	}
		
	public String getName (){
		return this.name;
	}
	
	
	public Coordinates getCoordinate(String name){
		int x =(int)((byte)name.charAt(0) - 'A');
		String appo =""+ name.charAt(1) + name.charAt(2);
    	int y = Integer.parseInt(appo);
		Coordinates co = new Coordinates(x, y);
		return co;
	}
}
