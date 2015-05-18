package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.sector.*;
import it.polimi.ingsw.capecchidelcoco.card.*;
import java.util.List;

public abstract class Player {
	
	public static final int MAX_N_CARD = 3;

	private Table myTable;
	private Sector currentPosition;
	List<Sector> possibleMoves;
	int speed;
	private Card[] hand;
	private int id;
	private int life;
	private boolean alive;
	
	
	
	
	
	
	public Player(int num){
		this.id = num;
		this.myTable = new Table();
		this.possibleMoves.clear();
		this.life = 1;
		this.alive = true;
		this.hand[3] = new Card(); 
		for (int i = 0; i < MAX_N_CARD; i++){
			hand[i] = null;
		}
		
	}


	
	
	public void movePlayer(Sector nextPosition){
		this.currentPosition = nextPosition;
	}
	
}
