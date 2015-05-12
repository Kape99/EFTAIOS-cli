package it.polimi.ingsw.capecchidelcoco.card;

public class SectorCard extends Card {

	private SectorCardType type;
	
	private boolean hasObject;

	public SectorCard (SectorCardType type,boolean obj){
		this.type = type;
		this.hasObject = obj;
		
		}
	
}
