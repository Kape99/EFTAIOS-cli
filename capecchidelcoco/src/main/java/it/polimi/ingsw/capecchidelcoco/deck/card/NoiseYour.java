package it.polimi.ingsw.capecchidelcoco.deck.card;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.*;

/**
 * @author lucacapecchi
 * Define the action to be made if use a NoiseYour card 
 */
public class NoiseYour extends SectorCard {

	
	public NoiseYour (boolean obj){
		super (obj);
	}

	@Override
	public String doAction(Game game, Player pl) {
		game.addNews(pl.getName()+": Noise in "+pl.getCurrentPosition().getName());
		return "YOUR";
	}
}
