package it.polimi.ingsw.capecchidelcoco.deck.card.object;

import it.polimi.ingsw.capecchidelcoco.player.Player;

public class Sedative extends ObjectCard {
	
	
	
	public Sedative (){
		super(true);
	}
	
	@Override
	public void doAction(Player currPlayer){
		//currPlayer.setSedated();
	}

}
