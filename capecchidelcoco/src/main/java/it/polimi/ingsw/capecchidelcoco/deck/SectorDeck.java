package it.polimi.ingsw.capecchidelcoco.deck;

import it.polimi.ingsw.capecchidelcoco.deck.card.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

/**
 * @author lucacapecchi
 * Define a sector deck defining the abstract method of deck
 */
public class SectorDeck implements Deck {
	
	//List of card contained
	List<SectorCard> deck;
	//List of card used 
	List<SectorCard> discardedCard;
	

	/**
	 * Constructor
	 * create the sector deck with the needed card
	 */
	public SectorDeck (){
		deck = new LinkedList<SectorCard>();
		discardedCard = new LinkedList<SectorCard>();
		for(int i = 0; i < 6;i++){
			this.deck.add(new NoiseYour(false));
			this.deck.add(new NoiseAny(false));
		}
		for(int i = 0; i < 4;i++){
			this.deck.add(new NoiseYour(true));
			this.deck.add(new NoiseAny(true));
		}
		for(int i = 0; i < 5;i++){
			this.deck.add(new Silence(false));
		}
		 
		Collections.shuffle(this.deck);

			
	}
	
	@Override
	public void shuffle() {
        this.deck.addAll(this.discardedCard);
		this.discardedCard.clear();
		Collections.shuffle(this.deck);
		
        }
	
	@Override
	public SectorCard draw(){
		if (deck.isEmpty())
			shuffle();
		SectorCard tmp = deck.get(0);
		deck.remove(0);
		discardedCard.add(tmp);
		return tmp;
	}

}
