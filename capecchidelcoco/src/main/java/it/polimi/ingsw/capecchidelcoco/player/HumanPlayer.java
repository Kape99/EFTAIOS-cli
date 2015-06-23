package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.game.*;

/**
 * @author lucacapecchi
 *
 * this class define the method needed for an human Player
 * 
 */
public class HumanPlayer extends Player {

	/**Constructor of the class
	 * @param myGame - is the game in witch the player is playing
	 * @param num - is the counter that remember the order on witch the player are joined
	 * @param name - is the name of the user related to this player
	 */
	public HumanPlayer(Game myGame, int num, String name){
		super(myGame, num, name);
		this.speed = 1;
		this.faction = "Human";
		this.currentPosition = myGame.getBoard().findSpawn(faction);
		currentPosition.addPlayer(this);
		listOfMove.add(currentPosition);
	}

	
	@Override
	public String attack(){
		return "Humans can't attack;";
	}


}
