package it.polimi.ingsw.capecchidelcoco.deck.card.object;

import it.polimi.ingsw.capecchidelcoco.player.Player;


public class Teleport extends ObjectCard{

		
		public void FindSpawn(){
			super(true);
		}
	
		public void doAction(Player currPlayer){
			currPlayer.FindSpawn();
		}

}
