package it.polimi.ingsw.capecchidelcoco.deck;

import it.polimi.ingsw.capecchidelcoco.deck.card.*;
import it.polimi.ingsw.capecchidelcoco.deck.card.object.ObjectCard;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ObjectDeck implements Deck {
	
	
	LinkedList<ObjectCard> deck;
	List<ObjectCard> discardedCards;

	
	public ObjectDeck (){
		
		
		//lista di carte oggetto

			
	}
	@Override
	public void shuffle() {
        this.deck.addAll(this.discardedCards);
		this.discardedCards.clear();
		Collections.shuffle(this.deck);
		
        }
        
   public void discard(ObjectCard objectCard){
	   discardedCards.add(objectCard);
   }
	
	@Override
	public ObjectCard draw(){
		ObjectCard tmp = deck.get(1);
		deck.remove(1);
		return tmp;
	}

}
