package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.sector.*;
import it.polimi.ingsw.capecchidelcoco.game.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


/**
 * @author lucacapecchi
 *
 */

public abstract class Player{
	
	//private static final int MAX_OBJECT_CARDS = 3;
	protected ArrayList<Sector> listOfMove;
	protected String name;
	protected Sector currentPosition;
	private Set<Sector> possibleMoves;
	protected int speed;
	//private List<ObjectCard> objects;
	private int playerNumber;
	private int life;
	protected Game myGame;
	protected String characterName;
	protected String characterRole; 
	protected boolean hasMoved;
	protected boolean hadAttacked;
	protected boolean sedated;
	protected String faction;
 	
	
	
	
	
	
	/**
	 * Constructor of the Class
	 * specify and initialize all the variable needed to a player in general
	 * @param myGame - is the game in witch the player is playing
	 * @param num - is the counter that remember the order on witch the player are joined
	 * @param name - is the name of the user related to this player
	 	 */
	public Player(Game myGame, int num, String name){
		this.myGame = myGame;
		this.playerNumber = num;
		this.name = name;
		this.life = 1;
		this.possibleMoves = new HashSet<Sector>();
		setCharacter();
		this.listOfMove = new ArrayList<Sector>();
		//this.objects = new ArrayList<ObjectCard>();
		this.hasMoved = false;
		this.sedated = false;		
	}
	
	/**
	 * Method that return the number of this player
	 * @return this player's number
	 */
	public int getPlayerNumber (){
		return this.playerNumber;
	}
	
	/**
	 * Method that return the name of this player
	 * @return this player's name
	 */
	public String getName(){
		return this.name;
	}
	
	
	/**
	 * Returns the list of object (cards) currently owned by the player. 
	 * @return the objects
	 */
	/*
	public List<ObjectCard> getObjects() {
		return objects;
	}
	*/
	
	/**
	 * Return the character name related to this player 
	 * @return the name of the character.
	 */
	public String getCharacter (){
		return characterName;
	}
	
	/**
	 * Return the character role related to this player 
	 * @return the role of the character.
	 */
	public String getRole (){
		return characterRole;
	}
	
	/**
	 * Method use the get all the info related to this player
	 * @return a string with all the info(name, character, role,position...)
	 */
	public String getInfo(){
		String ret = "'"+name+"';";
		if (isAlive()){
			ret += "You are "+characterName+" <"+characterRole+"> faction:("+faction+").;";
			ret += "You can move up to "+speed +" tile";
			if (speed>1)
				ret += "s";
			ret += ".;Your actual location is "+currentPosition.getName()+".;";
			ret += "You can move on those Sector:;";
			ret += getPossibleMoves();
	 		
		}else{
			ret += "You were "+characterName+" <"+characterRole+"> faction:("+faction+").;";
			ret += "You are actualy death.";
		}
		return  ret;
	}
	
	/**
	 * Method use to list the possible move of the player and order them
	 * @return a string with the name of the sector he can move on (ordered)
	 */
	private String getPossibleMoves() {
		Set<String> tmp = new TreeSet<String>();
		String ret = "";
		possibleMoves = reachable(currentPosition, speed);
		for (Sector s:possibleMoves)
			tmp.add(s.getName());
		for (String t:tmp)
			ret += t + " ";
		return ret;
	}

	/**
	 * Set the name and the role of the character related to this player
	 */
	public void setCharacter() {
		this.characterName = myGame.getCharacters()[playerNumber];
		this.characterRole = myGame.getRoles()[playerNumber];
	}
	
	/**
	 * Method run to get a list of Sector where a player can move on
	 * @param cSector - the sector of the player before the move
	 * @param distance - the distance the player can cover each turn
	 * @return a set of reachable sector
	 */
	public Set<Sector> reachable(Sector cSector, int distance){
		Set<Sector> ret = new HashSet<Sector>();
		ret = myGame.getBoard().getNeighbors(cSector, distance);
		ret.remove(cSector);
		return ret;
	}

	/*
	public void addObjectCard(ObjectCard currentCard){
		if (objects.size() >= MAX_OBJECT_CARDS){
			objects.remove(1);
		}
		objects.add(currentCard);
	}
	*/
	
	/**
	 * Method use when a player is attacked by another player
	 * and check his condition 
	 * in case he is dead he is removed from the map
	 */
	public void attacked(){
		this.life--;
		if (!isAlive()){
			currentPosition.removePlayer(this);
			currentPosition = null;
			hasMoved = true;
			hadAttacked = true;
		}
	}
	
	/**
	 * @return the faction of this player
	 */
	public String getFaction(){
		return faction;
	}
	
	/**
	 * @return the game this player is playing
	 */
	public Game getGame(){
		return myGame;
	}
	
	/*
	public void setSedated(){
		sedated = true;
	}
	*/
	
	/*
	public void resetSedated(){
		sedated = false;
	}
	*/
	
	/*
	public void setAdrenaline(){
		speed = 2;
	}
	*/
	
	/*
	public void resetAdrenaline(){
		speed = 1;
	}
	*/
	
	/**
	 * Reset the condition of a player so he can re-perform some action 
	 * (when he start a new turn)
	 */
	public void reset(){
		hasMoved = false;
		hadAttacked = false;
		//sedated = false;	
	}
	
	/**
	 * @return the Sector where is located this player
	 */
	public Sector getCurrentPosition(){
		return currentPosition;
	}
	
	/**
	 * Method that check if destination of a movement if valid
	 * and if it is move the player on that location 
	 * @param nextPosition - destination of the movement
	 * @return - String containing the information of this action
	 */
	public String move(String nextPosition){
		String ret;
		if (Sector.GetCoordinate(nextPosition).getY()< 0 || Sector.GetCoordinate(nextPosition).getX() < 0 || Sector.GetCoordinate(nextPosition).getY() > 14 || Sector.GetCoordinate(nextPosition).getX() >23){
			return "Wrong Sector name;";
		}
		Sector s = myGame.getBoard().getSector(Sector.GetCoordinate(nextPosition).getY(),Sector.GetCoordinate(nextPosition).getX());
		possibleMoves = reachable(currentPosition, speed);
		if (possibleMoves.contains(s)){
			if (!hasMoved){
				currentPosition.removePlayer(this);
				currentPosition = s;
				currentPosition.addPlayer(this);
				listOfMove.add(s);
				hasMoved = true;
				return "You are in "+currentPosition.getName()+";";
			}
			return "You alrady moved this turn;";
		}
		ret = "Invalid destination, you can move here:;";
		ret += getPossibleMoves();

		return ret+";";
	
	}
	
	/**
	 * Check the status of this player
	 * @return the status (true if he is alive,
	 * false otherwise)
	 */
	public boolean isAlive(){
		if (life > 0)
			return true;
		return false;
	}
	
	/*
	public void defense(){
		this.life++;
	}
	*/

	/**
	 * Method use to perform action needed on the location at the end of this turn
	 * (draw a sector card, add this player to the winner of this game...)
	 * @return the result of the action
	 */
	public String action(){
		if (!sedated && !hadAttacked){
			return currentPosition.doAction(myGame, this);
		}
		return "";
	}

	/**
	 * @return  the hasMoved value
	 */
	public boolean hasMoved() {
		return hasMoved;
	}

	/**
	 * Method that perform the attack of a player on his sector if he is Alien
	 * 
	 * @return the info of the attack 
	 */
	public String attack(){
		return null;	
	}

	/**
	 * @return the list of all movement performed by this player
	 */
	public String printMovements() {
		String ret = "";
		int i=0;
		for (Sector s:listOfMove){
			ret += i+"["+s.getName()+"]    ";
			i++;
		}
		return ret+";";
	}
	
}
