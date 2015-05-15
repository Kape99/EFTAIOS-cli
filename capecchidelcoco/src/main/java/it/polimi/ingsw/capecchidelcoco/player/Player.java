package it.polimi.ingsw.capecchidelcoco.player;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.sector.*;
import it.polimi.ingsw.capecchidelcoco.card.*;
import it.polimi.ingsw.capecchidelcoco.sector.Direction;

import java.util.List;
import java.util.Collection;

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
	
	public List<Sector> getNeighbors(Sector centralSector,int distance){
		//possibleMoves.clear();
		
		   Collection<Sector> visited = null;
		   visited.add(centralSector);
		   for (int i = 0; i < distance; i++){
			   for(Sector vi:visited){
				   for (int dir = 0; dir < 6; dir++){
					   int parity = vi.getCol() % 2;
					   if (!visited.contains(Board.sectors
							   			[centralSector.getRow() + Direction.yDirection[parity][dir]]
							   			[centralSector.getCol() + Direction.xDirection[dir]])){
						   if(Board.sectors
				   			[centralSector.getRow() + Direction.yDirection[parity][dir]]
				   			[centralSector.getCol() + Direction.xDirection[dir]] instanceof NullSector){
							   
						   }
					   }
				   }
			   }
			   
		   }
			/*	
				   

				    for each 1 < k ≤ movement:
				        fringes.append([])
				        for each cube in fringes[k-1]:
				            for each 0 ≤ dir < 6:
				                var neighbor = cube_neighbor(cube, dir)
				                if neighbor not in visited, not blocked:
				                    add neighbor to visited
				                    fringes[k].append(neighbor)

				    return visited
		
		*/
		
		/*
		
		if(centralSector.getX() % 2 == 0){
			
			//da ripetere o migliorare per tutti gli elementi 
			if ( Board.sectors[centralSector.getX() + 1][centralSector.getY()].getType() == 1 || Board.sectors[centralSector.getX() + 1][centralSector.getY()].getType() == 2)
				if (!possibleMoves.contains(Board.sectors[centralSector.getX() + 1][centralSector.getY()]))
					possibleMoves.add( Board.sectors[centralSector.getX() + 1][centralSector.getY()]);
			possibleMoves.add( Board.sectors[centralSector.getX() - 1][centralSector.getY()]);
			possibleMoves.add( Board.sectors[centralSector.getX()][centralSector.getY() + 1]);
			possibleMoves.add( Board.sectors[centralSector.getX()][centralSector.getY() - 1]);
			possibleMoves.add( Board.sectors[centralSector.getX() + 1][centralSector.getY() - 1]);
			possibleMoves.add( Board.sectors[centralSector.getX() - 1][centralSector.getY() - 1]);

		}if(centralSector.getX() % 2 == 1){
			possibleMoves.add( Board.sectors[centralSector.getX() + 1][centralSector.getY()]);
			possibleMoves.add( Board.sectors[centralSector.getX() - 1][centralSector.getY()]);
			possibleMoves.add( Board.sectors[centralSector.getX()][centralSector.getY() + 1]);
			possibleMoves.add( Board.sectors[centralSector.getX()][centralSector.getY() - 1]);
			possibleMoves.add( Board.sectors[centralSector.getX() + 1][centralSector.getY() + 1]);
			possibleMoves.add( Board.sectors[centralSector.getX() - 1][centralSector.getY() + 1]);

		}
		
			//riguardare 
		
		distance--;
		for (int i = 0; i<possibleMoves.size(); i++){
			possibleMove(possibleMoves.get(i),speed);
		}
			
		*/
		return possibleMoves;
	}
	
	public void movePlayer(Sector nextPosition){
		this.currentPosition = nextPosition;
	}
	
}
