package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class DangerousSector extends Sector {
	
	
	public DangerousSector(int x, int y) {
		super(x, y, 'D', true);
	}

	@Override
	public String doAction(Game game,Player pl) {
		return game.getSectorDeck().draw().doAction(game, pl);		
	}   
	

}
