package it.polimi.ingsw.capecchidelcoco.deck.card;


import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.*;

public class NoiseYour extends SectorCard {

	boolean hasObject;
	
	public NoiseYour (boolean obj){
		super (obj);
	}
	
	
	

	@Override
	public String doAction(Game game, Player pl) {
		// TODO Auto-generated method stub
		game.addNews(pl.getName()+": Noise in "+pl.getCurrentPosition().getName());
		return "YOUR";
		
	}
}
