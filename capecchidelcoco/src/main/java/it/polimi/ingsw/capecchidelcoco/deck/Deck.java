package it.polimi.ingsw.capecchidelcoco.deck;

import it.polimi.ingsw.capecchidelcoco.deck.card.Card;

/**
 * @author lucacapecchi
 * Define a general Structure of a Deck
 */
public interface Deck {

	/**
	 * Add all the discarded card in the deck,
	 * then it shuffle it
	 */
	public void shuffle();
	
	
	/**
	 * Draw the first card in the deck
	 * @return the card
	 */
	public Card draw();
}
