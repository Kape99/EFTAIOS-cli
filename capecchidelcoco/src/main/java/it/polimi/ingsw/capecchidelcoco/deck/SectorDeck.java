package it.polimi.ingsw.capecchidelcoco.deck;

import it.polimi.ingsw.capecchidelcoco.card.*;

import java.util.ArrayList;

public class SectorDeck implements Deck {
	
	ArrayList<SectorCard> deck;
	ArrayList<SectorCard> discardedCard;
	
	int cardsNotUsed = 25;
	
	public SectorDeck (){
		cardsNotUsed = 25;
		for(int i = 0; i < 6;i++){
			this.deck.add(new SectorCard(SectorCardType.NOISE_ANY_SECTOR,false));
			this.deck.add(new SectorCard(SectorCardType.NOISE_THIS_SECTOR,false));
		}
		for(int i = 0; i < 4;i++){
			this.deck.add(new SectorCard(SectorCardType.NOISE_ANY_SECTOR,true));
			this.deck.add(new SectorCard(SectorCardType.NOISE_THIS_SECTOR,true));
		}
		for(int i = 0; i < 5;i++){
			this.deck.add(new SectorCard(SectorCardType.SILENCE,false));
		}
		  
		for ( int i = 0; i < deck.size() - 1; i++) {
			int rand = (int)(Math.random()*(deck.size()));
			SectorCard temp = deck.get(i);
			deck.set(i, deck.get(rand));
			deck.set(rand, temp);
		}

			
	}
	@Override
	public void shuffle() {
        
		for ( int i = 0; i < deck.size() - 1; i++) {
            int rand = (int)(Math.random()*(deck.size()));
            SectorCard temp = deck.get(i);
            deck.set(i, deck.get(rand));
            deck.set(rand, (SectorCard) temp);
        }
        
    } 
	@Override
	public SectorCard draw(){
		cardsNotUsed--;
		SectorCard tmp = deck.get(1);
		deck.remove(1);
		discardedCard.add(tmp);
		return tmp;
	}

}
