package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.player.Player;

public class DangerousSector extends Sector {
	
	
	public DangerousSector(int x, int y) {
		super(x, y, 2, true);
	}

	@Override
	public void doAction(Player pl) {
		pl.getGame().getSectorDeck().draw().doAction(pl);
		
	}   
	

}
