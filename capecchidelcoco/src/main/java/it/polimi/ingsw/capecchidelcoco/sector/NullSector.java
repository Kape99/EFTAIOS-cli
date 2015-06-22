package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class NullSector extends Sector {

	
	public NullSector(int x, int y) {
		super(x, y, 'N' , false);
	}

	
	public void doAction(Player pl) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String doAction(Game game, Player pl) {
		// TODO Auto-generated method stub
		return "";
	}   

}
