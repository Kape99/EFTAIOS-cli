package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.sector.*;
import it.polimi.ingsw.capecchidelcoco.card.*;

import java.util.List;

public class Player {

	private Table myTable;
	private Sector currentPosition;
	List<Sector> possibleMoves;
	int speed;
	private Card[] hand;
	private int num;
	
	public Player(int num){
		this.num = num;
		this.myTable = new Table();
		this.possibleMoves.clear();
		
		
	}
	
	public List<Sector> possibleMove(Sector cp,int speed){
		//possibleMoves.clear();
		
		if(cp.getX() % 2 == 0){
			
			//da ripetere o migliorare per tutti gli elementi 
			if ( Board.sectors[cp.getX() + 1][cp.getY()].getType() == 1 || Board.sectors[cp.getX() + 1][cp.getY()].getType() == 2)
				if (!possibleMoves.contains(Board.sectors[cp.getX() + 1][cp.getY()]))
					possibleMoves.add( Board.sectors[cp.getX() + 1][cp.getY()]);
			possibleMoves.add( Board.sectors[cp.getX() - 1][cp.getY()]);
			possibleMoves.add( Board.sectors[cp.getX()][cp.getY() + 1]);
			possibleMoves.add( Board.sectors[cp.getX()][cp.getY() - 1]);
			possibleMoves.add( Board.sectors[cp.getX() + 1][cp.getY() - 1]);
			possibleMoves.add( Board.sectors[cp.getX() - 1][cp.getY() - 1]);

		}if(cp.getX() % 2 == 1){
			possibleMoves.add( Board.sectors[cp.getX() + 1][cp.getY()]);
			possibleMoves.add( Board.sectors[cp.getX() - 1][cp.getY()]);
			possibleMoves.add( Board.sectors[cp.getX()][cp.getY() + 1]);
			possibleMoves.add( Board.sectors[cp.getX()][cp.getY() - 1]);
			possibleMoves.add( Board.sectors[cp.getX() + 1][cp.getY() + 1]);
			possibleMoves.add( Board.sectors[cp.getX() - 1][cp.getY() + 1]);

		}
		
			//riguardare 
		
		speed--;
		for (int i = 0; i<possibleMoves.size(); i++){
			possibleMove(possibleMoves.get(i),speed);
		}
			
		
		return possibleMoves;
	}
	
	public void movePlayer(Sector nextPosition){
		this.currentPosition = nextPosition;
	}
	
}
