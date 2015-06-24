package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.sector.Coordinates;
import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author lucacapecchi
 * Class that describe the attribute of a sector and all method needed
 * to interact with Sectors
 * Each sector contain the list of player so it become easier find all
 * players that are in that sector
 */
public abstract class  Sector extends Coordinates {

	
	/*
	 * Tell which type of sector is the one in coordinate [row][col]
	 * type:
	 * N - NullSector
	 * S - SecureSector
	 * D - DangerousSector
	 * E - HatchSector
	 * H - HumanSpawn
	 * A - AlienSpawn
	 */
	
	
	private char type;
	private String name;
	private List<Player> players;
	private boolean usable;
	
	
	/**
	 * Constructor of the class
	 * @param y - row of this sector
	 * @param x - col of this sector
	 * @param type - type of sector 
	 * @param usable - tell if the sector can be the destination of a movement 
	 */
	public Sector(int y, int x, char type, boolean usable){
		super(x, y);
		players = new ArrayList<Player>();
		this.type = type;
		this.usable = usable;
		setName();
	}
	
	/**
	 * Define the action that a player must do if end is turn on this sector
	 * @param game
	 * @param pl
	 * @return
	 */
	public abstract String  doAction(Game game, Player pl);
	
	/**
	 * 
	 * @return if this sector can be a destination of a movement
	 */
	public boolean isUsable(){
		return this.usable;
	}
	
	/**
	 * Add the player pl to the list of players in this sector
	 * @param pl - player to be added in this sector
	 */
	public void addPlayer(Player pl){
		players.add(pl);
	}
	
	/**
	 * Remove the player pl from the list of players in this sector
	 * @param pl - player to be removed from this sector
	 */
	public void removePlayer(Player pl){
		players.remove(pl);
	}
	
	/**
	 * Show all the players that are in this sector
	 * @return the list of players
	 */
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
	
	/**
	 * Generate the name of this sector from his coordinate
	 */
	public void setName (){
		String name= new String();
		name += (char)('A'+(byte)getCol()); 
		//return the given integer with 2 digit
		name += String.format("%02d", getRow()+1);
		this.name = name;
	}
		
	/**
	 * Return the name to be displayed ("   " if is a null sector)
	 * @return a String containing the name to be print
	 */
	public String getName (){
		if (this.type != 'N')
			return this.name;
		return "   ";
	}
	
	
	/**
	 * Method use to get a Coordinates from a given String 
	 * @param name - name of the sector you want
	 * @return a Coordinates variable with the coordinates related
	 * 		   to the given name(-1 if row or col can't be converted)  
	 */
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
