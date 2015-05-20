package it.polimi.ingsw.capecchidelcoco.deck.card;

import it.polimi.ingsw.capecchidelcoco.player.*;

public abstract class SectorCard extends Card {


	
	private boolean hasObject;

	public SectorCard (boolean obj){
		
		this.hasObject = obj;
		
		}
	
	public void doAction(Player currPlayer){
		if (hasObject){
			
		}
		
	}
	
}
