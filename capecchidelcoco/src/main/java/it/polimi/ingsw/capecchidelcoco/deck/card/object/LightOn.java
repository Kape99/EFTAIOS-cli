package it.polimi.ingsw.capecchidelcoco.deck.card.object;

import it.polimi.ingsw.capecchidelcoco.player.Player;
import it.polimi.ingsw.capecchidelcoco.sector.*;

import java.util.List;

public class LightOn extends ObjectCard {
	

		
		
		
		public LightOn (){
			super(true);
		}
		
		@Override
		public void doAction(Player currPlayer, Sector target){
			List<Player> visible = null;
			List<Sector> tmp = currPlayer.getGame().board.getNeighbors(target, 1);
			for (Player pl:currPlayer.getGame().players){
				if (tmp.contains(pl.getCurrentPosition())){
					visible.add(pl);
				}
				
			}
			//scrive la lista dei giocatori in brodcast
		}

	}
