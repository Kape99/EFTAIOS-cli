package it.polimi.ingsw.capecchidelcoco.deck.card;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;

/**
 * @author lucacapecchi
 * Define the action to be made if use a Silence card
 */
public class Silence extends SectorCard {

	
	public Silence (boolean obj){
		super (obj);
	}

	@Override
	public String doAction(Game game, Player pl) {
		game.addNews(pl.getName()+": Silence;");
		return "SILENCE";
	}
}
