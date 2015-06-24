package it.polimi.ingsw.capecchidelcoco.deck.card.object;

import it.polimi.ingsw.capecchidelcoco.deck.card.Card;
import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.Player;
import it.polimi.ingsw.capecchidelcoco.sector.Sector;

public class ObjectCard extends Card{
	
	private String description;
	private boolean usable;

	public  ObjectCard (boolean usable) {
		this.usable = usable;
	}

	
	public String getDescription() {
		return description;
	}

	public boolean isUsable() {
		return usable;
	}

	@Override
	public String doAction(Game game, Player pl) {
		return "";
	}
}