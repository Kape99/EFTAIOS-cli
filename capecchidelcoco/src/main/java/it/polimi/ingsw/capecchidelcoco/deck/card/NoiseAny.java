package it.polimi.ingsw.capecchidelcoco.deck.card;

import it.polimi.ingsw.capecchidelcoco.player.Player;

public class NoiseAny extends SectorCard {
	
	boolean hasObject;
	
	public NoiseAny (boolean obj){
		super (obj);
	}
	
	
	@Override
	public void doAction(Player currPlayer){
		if (this.hasObject){
			currPlayer.addObjectCard(currPlayer.getGame().getObjectDeck().draw());
		}
	}
}
