package it.polimi.ingsw.capecchidelcoco.board;

import it.polimi.ingsw.capecchidelcoco.sector.*;
import it.polimi.ingsw.capecchidelcoco.sector.Direction;

import java.io.*;
import java.util.*;
import java.util.List;
import java.util.Collection;



public class Board {
	
	List<Sector> d;
	
	
	//possibile lettura da file
	
	private Sector[][] sectors;
	
	
	
	public Board () throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("src/galileo.txt"));
		sectors = new Sector[BoardConstant.ROWS][BoardConstant.COLS];
		for (int row = 0; row < BoardConstant.ROWS; row++ ){
			for (int col = 0; col < BoardConstant.COLS; col++ ){
				if(input.hasNextInt()){
					findSectorType(input.nextInt(), row, col);
			
				}	
			}
		}
		input.close();
	}
			
	public Collection<Sector> getNeighbors(Sector centralSector,int distance){
		//possibleMoves.clear();
		Collection<Sector> visited = null;
		visited.add(centralSector);
		for (int i = 0; i < distance; i++){for(Sector vi:visited){
			for (int dir = 0; dir < 6; dir++){
				int parity = vi.getCol() % 2;
				if (!visited.contains(sectors[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]])){
					if(sectors[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]].isUsable()){
						visited.add(sectors[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]]);
					   }
				   }
			   }
			}	   
		}
		 return visited;
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
	}
		  
	
	
	
	public void findSectorType(int in,int row, int col){
		switch (in){
		case(0):
			sectors[row][col] = new NullSector(row, col);
			break;
			
		case(1):
			sectors[row][col] = new SecureSector(row, col);						
			break;
			
		case(2):
			sectors[row][col] = new DangerousSector(row, col);
			break;
			
		case(3):
			sectors[row][col] = new HatchSector(row, col);
			break;
			
		case(4):
			sectors[row][col] = new HumanSpawn(row, col);
			break;
			
		case(5):
			sectors[row][col] = new AlienSpawn(row, col);
			break;
			
		}
	}
	public static void main (String[] args) throws FileNotFoundException{
		

			//new Board();
		
	}
	
	


}


