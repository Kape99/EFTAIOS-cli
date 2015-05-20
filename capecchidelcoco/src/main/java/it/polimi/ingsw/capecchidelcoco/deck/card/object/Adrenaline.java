package it.polimi.ingsw.capecchidelcoco.deck.card.object;

import it.polimi.ingsw.capecchidelcoco.player.Player;

public class Adrenaline extends ObjectCard{
	

	public Adrenaline (){
		super(true);
	}
	
	@Override
	public void doAction(Player currPlayer){
		currPlayer.setAdrenaline();
	}

}



