package it.polimi.ingsw.capecchidelcoco.deck.card;

/**
 * @author lucacapecchi
 * Extends Card structure and add the object variable
 * (only needed in sector card)
 */
public abstract class SectorCard extends Card {


	
	private boolean hasObject;

	/**
	 * Constructor
	 * @param obj - tell if this card has an object
	 */
	public SectorCard (boolean obj){
		this.hasObject = obj;
	}

}
