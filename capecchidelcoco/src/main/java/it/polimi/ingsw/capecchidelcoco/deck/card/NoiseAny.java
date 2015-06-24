package it.polimi.ingsw.capecchidelcoco.deck.card;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

/**
 * @author lucacapecchi
 * Define the action to be made if use a NoiseAny card
 */
public class NoiseAny extends SectorCard {
	
	
	public NoiseAny (boolean obj){
		super (obj);
	}
	
	@Override
	public String doAction(Game game, Player currPlayer){
		return "ANY";	
	}
}
