package it.polimi.ingsw.capecchidelcoco.deck;

import it.polimi.ingsw.capecchidelcoco.deck.card.Card;

public interface Deck {

	public void shuffle();
	public Card draw();
}
