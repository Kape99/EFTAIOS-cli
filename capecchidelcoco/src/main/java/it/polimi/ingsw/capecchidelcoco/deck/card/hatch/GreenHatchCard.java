package it.polimi.ingsw.capecchidelcoco.deck.card.hatch;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class GreenHatchCard extends HatchCard{

	public GreenHatchCard(){
		
	}

	@Override
	public void doAction(Player pl) {
		// TODO Auto-generated method stub
		pl.getGame().addWinner(pl);
		
	}

	@Override
	public void doAction(Game game, Player pl) {
		// TODO Auto-generated method stub
		
	}
	

}
