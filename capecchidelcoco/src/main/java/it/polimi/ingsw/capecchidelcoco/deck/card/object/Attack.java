package it.polimi.ingsw.capecchidelcoco.deck.card.object;

import it.polimi.ingsw.capecchidelcoco.player.Player;


public class Attack extends ObjectCard{

		public Attack (){
			super(true);
		}

		
		public void doAction(Player currPlayer){
			currPlayer.Attack();
		}
}
