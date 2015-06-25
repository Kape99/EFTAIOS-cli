package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class HatchSector extends Sector {

	
	private boolean avaible = false;
	
	public HatchSector (int x, int y) {
		super (x, y, 'E', true);
		this.avaible = true;
	}

	
	

	@Override
	public String doAction(Game game, Player pl) {
		if (pl.getFaction()=="Human"){
			game.addWinner(pl);
			game.setEnded(true);
			return ";";
		}
		return "";
	}   

}
