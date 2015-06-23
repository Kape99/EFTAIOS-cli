package it.polimi.ingsw.capecchidelcoco.deck.card.object;

import it.polimi.ingsw.capecchidelcoco.player.Player;
import it.polimi.ingsw.capecchidelcoco.sector.*;

import java.util.Set;

public class LightOn extends ObjectCard {
	

		
		
		
		private Set<Player> visible;

		public LightOn (){
			super(true);
		}
		
		@Override
		public void doAction(Player currPlayer, Sector target){
			visible = null;
			Set<Sector> tmp = currPlayer.getGame().getBoard().getNeighbors(target, 1);
			for (Player pl:currPlayer.getGame().getPlayers().values()){
				if (tmp.contains(pl.getCurrentPosition())){
					visible.add(pl);
				}
				
			}
			//scrive la lista dei giocatori in brodcast
		}

	}
