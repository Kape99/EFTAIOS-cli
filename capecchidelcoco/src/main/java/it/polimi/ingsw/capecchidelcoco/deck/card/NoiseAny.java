package it.polimi.ingsw.capecchidelcoco.deck.card;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class NoiseAny extends SectorCard {
	
	boolean hasObject;
	
	public NoiseAny (boolean obj){
		super (obj);
	}
	
	
	@Override
	public String doAction(Game game, Player currPlayer){
		//TODO ask which sector
		return "ANY";
		/*if (this.hasObject){
			currPlayer.addObjectCard(currPlayer.getGame().getObjectDeck().draw());
		}*/
	}
}
