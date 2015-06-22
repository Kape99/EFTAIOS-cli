package it.polimi.ingsw.capecchidelcoco.sector;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class HatchSector extends Sector {

	private int count = 1;
	
	private int num;
	private boolean avaible = false;
	
	public HatchSector (int x, int y) {
		super (x, y, 'E', true);
		this.avaible = true;
		this.num = count;
		count++;
	}

	
	

	@Override
	public String doAction(Game game, Player pl) {
		// TODO Auto-generated method stub
		return "";
	}   

}
