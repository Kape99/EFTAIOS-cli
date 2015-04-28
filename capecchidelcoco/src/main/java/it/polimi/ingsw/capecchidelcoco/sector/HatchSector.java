package it.polimi.ingsw.capecchidelcoco.sector;

public class HatchSector extends Sector {

	
	private int num;
	private boolean ready = true;
	private boolean broken = false;
	
	public HatchSector (int x, int y) {
		super (x, y, 3);
	}   

}
