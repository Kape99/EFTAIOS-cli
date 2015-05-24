package it.polimi.ingsw.capecchidelcoco.deck.card;


import it.polimi.ingsw.capecchidelcoco.player.*;
import it.polimi.ingsw.capecchidelcoco.deck.*;

public class NoiseYour extends SectorCard {

	boolean hasObject;
	
	public NoiseYour (boolean obj){
		super (obj);
	}
	
	
	@Override
	public void doAction(Player currPlayer){
		if (this.hasObject){
			currPlayer.addObjectCard(currPlayer.getGame().getObjectDeck().draw());
		}
	}
}
