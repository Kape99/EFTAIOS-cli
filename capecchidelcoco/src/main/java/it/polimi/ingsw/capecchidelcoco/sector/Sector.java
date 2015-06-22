package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.sector.Coordinates;
import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.*;

import java.util.ArrayList;
import java.util.List;
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
	private char type;
	private String name;
	private List<Player> players;
	private boolean usable;
	
	public Sector(int y, int x, char type, boolean usable){
		super(x, y);
		players = new ArrayList<Player>();
		this.type = type;
		this.usable = usable;
		setName();
	}
	
	public abstract String  doAction(Game game, Player pl);
	
	public boolean isUsable(){
		return this.usable;
	}
	
	public void addPlayer(Player pl){
		players.add(pl);
	}
	
	public void removePlayer(Player pl){
		players.remove(pl);
	}
	
	public List<Player> playerList(){
		return players;
	}
	
	public void setType (char type){
		this.type = type;
	}
	
	public char getType (){
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
		if (this.type != 'N')
			return this.name;
		return "   ";
	}
	
	
	public static Coordinates GetCoordinate(String name){
		int x = -1;
		try {
			x = (int)((byte)name.charAt(0) - 'A');
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String appo =""+ name.charAt(1) + name.charAt(2);
    	int y = -1;
		try {
			y = Integer.parseInt(appo)-1;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Coordinates co = new Coordinates(x, y);
		return co;
	}
}
