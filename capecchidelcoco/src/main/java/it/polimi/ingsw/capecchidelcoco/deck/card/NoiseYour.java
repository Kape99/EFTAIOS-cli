package it.polimi.ingsw.capecchidelcoco.deck.card;


import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.*;

public class NoiseYour extends SectorCard {

	boolean hasObject;
	
	public NoiseYour (boolean obj){
		super (obj);
	}
	
	
	@Override
	public void doAction(Player currPlayer){
		//TODO notify noise thsi sector
		
		/*
		if (this.hasObject){
			currPlayer.addObjectCard(currPlayer.getGame().getObjectDeck().draw());
		}*/
	}


	@Override
	public void doAction(Game game, Player pl) {
		// TODO Auto-generated method stub
		game.addNews(pl.getName()+": Noise in "+pl.getCurrentPosition().getName());
		
		
	}
}
