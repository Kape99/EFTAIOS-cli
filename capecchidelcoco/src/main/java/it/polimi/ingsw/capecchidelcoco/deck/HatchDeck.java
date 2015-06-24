package it.polimi.ingsw.capecchidelcoco.deck;

import it.polimi.ingsw.capecchidelcoco.deck.card.hatch.GreenHatchCard;
import it.polimi.ingsw.capecchidelcoco.deck.card.hatch.HatchCard;
import it.polimi.ingsw.capecchidelcoco.deck.card.hatch.RedHatchCard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class HatchDeck implements Deck {
	
	List<HatchCard> deck;
	List<HatchCard> discardedCard;
	public static final int MAX_HATCH_CARD = 6;
	int cardsNotUsed = 6;
	
	public HatchDeck (){
		cardsNotUsed = 6;
		deck = new LinkedList<HatchCard>();
		for (int i = 0; i<MAX_HATCH_CARD; i++ ){
			this.deck.add(new GreenHatchCard());
			this.deck.add(new RedHatchCard());
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
	public HatchCard draw(){
		HatchCard tmp = deck.get(0);
		deck.remove(0);
		discardedCard.add(tmp);
		return tmp;
	}
	
		


}
