package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.sector.*;
import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.deck.card.*;
import it.polimi.ingsw.capecchidelcoco.deck.card.object.ObjectCard;
import it.polimi.ingsw.capecchidelcoco.game.*;

import java.util.List;

public abstract class Player {
	
	protected static final int MAX_OBJECT_CARDS = 3;

	protected Board board;
	protected Sector currentPosition;
	List<Sector> possibleMoves;
	int speed;
	protected List<ObjectCard> objects;
	protected int playerNumber;
	protected int life;
	protected boolean alive;
	protected Game myGame;
	protected String characterName;
	protected String characterRole; 
	protected boolean hasMoved;
	protected boolean sedated;
	protected String faction;
 	
	
	
	
	
	
	public Player(Game myGame, int num){
		this.myGame = myGame;
		this.playerNumber = num;
		this.possibleMoves.clear();
		this.life = 1;
		this.alive = true;
		
		
	}
	
	/**
	 * Method that return the number of this player.
	 * @return number of this player.
	 */
	public int getPlayerNumber (){
		return this.playerNumber;
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
	
	/**
	 *Set the name and the role of the character related to this player.  
	 */
	public void setCharacter() {
		this.characterName = Game.characterNameList[playerNumber];
		this.characterRole = Game.characterRoleList[playerNumber];
	}
	
	public List<Sector> reachable(Sector cSector, int distance){
		return board.getNeighbors(cSector, distance);
	}

	public void addObjectCard(ObjectCard currentCard){
		if (objects.size() >= MAX_OBJECT_CARDS){
			objects.remove(1);
		}
		objects.add(currentCard);
	}
	
	public void attacked(){
		this.life--;
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
	
	public Sector getCurrentPosition(){
		return currentPosition;
	}
	/**
	 * @param nextPosition
	 */
	public void move(Sector nextPosition){
		if (!hasMoved){
			currentPosition.removePlayer(this);
			currentPosition = nextPosition;
			currentPosition.addPlayer(this);
			hasMoved = true;
			if (!sedated){
				currentPosition.doAction(this);
				
				//decidere come fare eseguire qualcosa alle carte
				
			}
		}
	}
	
	public boolean isAlive(){
		return alive;
	}
	
	
	
}
