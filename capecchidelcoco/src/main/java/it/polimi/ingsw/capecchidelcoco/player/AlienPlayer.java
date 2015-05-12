package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.sector.*;
import java.util.Collection;; 

public class AlienPlayer extends Player{
	
	Collection<Player> killed;
	
	public AlienPlayer(int num){
		super(num);
		this.speed = 2;
		
	}
	
	public Collection<Player> attack(Sector cp){
		killed.clear();
		/*for (int = 0 ; i<8 ;i++){
			if (playerList[i].getPosition() == cp && playerList[i] != this)
				
		}*/
		return killed;
	}
}
