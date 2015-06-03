package it.polimi.ingsw.capecchidelcoco.deck.card.object;

import it.polimi.ingsw.capecchidelcoco.player.Player;



public class Defense extends ObjectCard{
	

		public Defense (){
			super(true);
		
		}
		
		public void doAction(Player currPlayer){
			
			currPlayer.Defense();
		}

}
