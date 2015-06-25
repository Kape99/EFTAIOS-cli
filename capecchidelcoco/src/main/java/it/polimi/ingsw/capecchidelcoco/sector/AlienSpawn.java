package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class AlienSpawn extends Sector {
	
	public AlienSpawn (int x, int y) {
		super (x, y, 'A', false);
	}

	
	
	@Override
	public String doAction(Game game, Player pl) {
		return "";
	}   

}
