package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class HumanSpawn extends Sector {

	public HumanSpawn (int x, int y) {
		super(x, y, 'H', false);
}


	@Override
	public String doAction(Game game, Player pl) {
		return "";
	}   

}
