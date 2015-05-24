package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.game.*;

public class HumanPlayer extends Player {

	public HumanPlayer(Game myGame, int num){
		super(myGame, num);
		this.speed = 1;
		this.faction = "Human";
	}

}
