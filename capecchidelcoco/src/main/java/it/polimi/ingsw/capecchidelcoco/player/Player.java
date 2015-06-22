package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.sector.*;
import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.deck.card.*;
import it.polimi.ingsw.capecchidelcoco.deck.card.object.ObjectCard;
import it.polimi.ingsw.capecchidelcoco.game.*;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;


public abstract class Player{
	
	protected static final int MAX_OBJECT_CARDS = 3;

	//protected Board board;

	protected ArrayList<Sector> listOfMove;
	protected String name;
	protected Sector currentPosition;
	protected Set<Sector> possibleMoves;
	int speed;
	protected List<ObjectCard> objects;
	protected int playerNumber;
	protected int life;
	protected boolean alive;
	protected Game myGame;
	protected String characterName;
	protected String characterRole; 
	protected boolean hasMoved;
	protected boolean hadAttacked;
	protected boolean sedated;
	protected String faction;
 	
	
	
	
	
	
	public Player(Game myGame, int num, String name){
		this.myGame = myGame;
		this.playerNumber = num;
		this.name = name;
		this.life = 1;
		this.alive = true;
		possibleMoves = new HashSet<Sector>();
		setCharacter();
		listOfMove = new ArrayList<Sector>();
		objects = new ArrayList<ObjectCard>();
		hasMoved = false;
		sedated = false;		
	}
	
	/**
	 * Method that return the number of this player.
	 * @return number of this player.
	 */
	public int getPlayerNumber (){
		return this.playerNumber;
	}
	
	public String getName(){
		return this.name;
	}
	
	
	/**
	 * Returns the list of object (cards) currently owned by the player. 
	 * @return the objects
	 */
	public List<ObjectCard> getObjects() {
		return objects;
	}
	
	/**
	 * Return the character name related to this player 
	 * @return the name of the character.
	 */
	public String getCharacter (){
		return characterName;
	}
	
	public String getRole (){
		return characterRole;
	}
	
	public String getInfo(){
		String ret = "";
		if (isAlive()){
			ret += "You are "+characterName+" <"+characterRole+"> ("+faction+").;";
			ret += "You can move up to "+speed +" tile";
			if (speed>1)
				ret += "s";
			ret += ".;Your actual location is "+currentPosition.getName()+".;";
			ret += "You can move on those Sector:;";
			ret += getPossibleMoves();
	 		
		}else{
			ret += "You were "+characterName+" <"+characterRole+"> ("+faction+").;";
			ret += "You are actualy death.";
		}
		return  ret;
	}
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
	 *Set the name and the role of the character related to this player.  
	 */
	public void setCharacter() {
		this.characterName = myGame.getCharacters()[playerNumber];
		this.characterRole = myGame.getRoles()[playerNumber];
	}
	
	public Set<Sector> reachable(Sector cSector, int distance){
		Set<Sector> ret = new HashSet<Sector>();
		ret = myGame.getBoard().getNeighbors(cSector, distance);
		ret.remove(cSector);
		return ret;
	}

	public void addObjectCard(ObjectCard currentCard){
		if (objects.size() >= MAX_OBJECT_CARDS){
			objects.remove(1);
		}
		objects.add(currentCard);
	}
	
	public void attacked(){
		this.life--;
		if (!isAlive()){
			currentPosition = null;
			hasMoved = true;
			hadAttacked = true;
		}
		//TODO notificare morte
	}
	
	public String getFaction(){
		return faction;
	}
	
	public Game getGame(){
		return myGame;
	}
	
	public void setSedated(){
		sedated = true;
	}
	
	public void resetSedated(){
		sedated = false;
	}
	
	public void setAdrenaline(){
		speed = 2;
	}
	
	public void resetAdrenaline(){
		speed = 1;
	}
	
	public void reset(){
		hasMoved = false;
		hadAttacked = false;
		sedated = false;
		
			 	
			
	}
	
	public Sector getCurrentPosition(){
		return currentPosition;
	}
	/**
	 * @param nextPosition
	 */
	public String move(String nextPosition){
		String ret;
		if (Sector.GetCoordinate(nextPosition).getY()< 0 || Sector.GetCoordinate(nextPosition).getX() < 0 || Sector.GetCoordinate(nextPosition).getY() > 14 || Sector.GetCoordinate(nextPosition).getX() >23){
			return "Wrong Sector name";
		}
		Sector s = myGame.getBoard().getSector(Sector.GetCoordinate(nextPosition).getY(),Sector.GetCoordinate(nextPosition).getX());
		System.out.println(s.getName());
		possibleMoves = reachable(currentPosition, speed);
		if (possibleMoves.contains(s)){
			if (!hasMoved){
				currentPosition.removePlayer(this);
				currentPosition = s;
				currentPosition.addPlayer(this);
				listOfMove.add(s);
				hasMoved = true;
				
				return "You are in "+currentPosition.getName();
			}
			return "You alrady moved this turn";
		}
		ret = "Invalid destination, you can move here:;";
		ret += getPossibleMoves();

		return ret;
	
	}
	
	public boolean isAlive(){
		if (life > 0)
			return true;
		return false;
	}
	
	
	
	public void defense(){
		this.life++;
	}
	
	public void findSpawn(){
	}

	public String action(){
		if (!sedated && !hadAttacked){
			return currentPosition.doAction(myGame, this);
		
		}
		return "";
	}

	public String move() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getMap() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String connect() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String isEnded() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String getWinner() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract String attack();

	public String showCard() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String useCard() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String discardCard() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String makeNoise() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
}
