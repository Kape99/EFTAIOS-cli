package it.polimi.ingsw.capecchidelcoco.deck;

import it.polimi.ingsw.capecchidelcoco.deck.card.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class SectorDeck implements Deck {
	
	LinkedList<SectorCard> deck;
	List<SectorCard> discardedCard;
	
	int cardsNotUsed = 25;
	
	public SectorDeck (){
		cardsNotUsed = 25;
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
	public void shuffle() {
        this.deck.addAll(this.discardedCard);
		this.discardedCard.clear();
		Collections.shuffle(this.deck);
		
        }
        
   
	public SectorCard draw(){
		cardsNotUsed--;
		SectorCard tmp = deck.get(1);
		deck.remove(1);
		discardedCard.add(tmp);
		return tmp;
	}

}
