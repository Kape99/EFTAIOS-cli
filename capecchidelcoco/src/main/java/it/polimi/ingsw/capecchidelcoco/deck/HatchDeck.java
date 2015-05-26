package it.polimi.ingsw.capecchidelcoco.deck;

import it.polimi.ingsw.capecchidelcoco.deck.card.hatch.GreenHatchCard;
import it.polimi.ingsw.capecchidelcoco.deck.card.hatch.HatchCard;
import it.polimi.ingsw.capecchidelcoco.deck.card.hatch.RedHatchCard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HatchDeck implements Deck {
	
	LinkedList<HatchCard> deck;
	List<HatchCard> discardedCard;
	public static final int MAX_HATCH_CARD = 6;
	int cardsNotUsed = 6;
	
	public HatchDeck (){
		cardsNotUsed = 6;
		for (int i = 0; i<MAX_HATCH_CARD; i++ ){
			this.deck.add(new GreenHatchCard());
			this.deck.add(new RedHatchCard());
		}
			
		Collections.shuffle(this.deck);
		
			
	}
	
	public void shuffle() {
        this.deck.addAll(this.discardedCard);
		this.discardedCard.clear();
		Collections.shuffle(this.deck);	
        }
        
   
	
	public HatchCard draw(){
		cardsNotUsed--;
		HatchCard tmp = deck.get(1);
		deck.remove(1);
		discardedCard.add(tmp);
		return tmp;
	}
}
