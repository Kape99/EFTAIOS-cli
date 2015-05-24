package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.sector.*;

import java.util.Collection;; 

public class AlienPlayer extends Player{
	
	Collection<Player> killed;
	
	public AlienPlayer(Game myGame, int num){
		super(myGame, num);
		this.speed = 2;
		this.faction = "Alien";
		
	}
	
	public void attack(){
		killed.addAll(this.currentPosition.playerList());
		for (Player pl:killed){
			pl.attacked();
		}
	}
	
	public int returnSpeed(){
		if (killed.isEmpty()){
			return 2;
		}
		return 3;
	}
	

}
