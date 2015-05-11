package it.polimi.ingsw.capecchidelcoco.sector;

public class HatchSector extends Sector {

	private int count = 0;
	
	private int num;
	private boolean avaible = false;
	
	public HatchSector (int x, int y) {
		super (x, y, 3);
		this.avaible = true;
		this.num = count;
		count++;
	}   

}
