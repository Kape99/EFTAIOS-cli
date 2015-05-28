package it.polimi.ingsw.capecchidelcoco.board;

import it.polimi.ingsw.capecchidelcoco.sector.*;

import java.io.*;
import java.util.*;



public class Board {
	
	

	public static final int ROWS = 14;
	public static final int COLS = 23;
	

	
	List<Sector> d;
	
	
	//possibile lettura da file
	
	private Sector[][] board;
	
	
	
	public Board () throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("src/galileo.txt"));
		board = new Sector[ROWS][COLS];
		for (int row = 0; row < ROWS; row++ ){
			for (int col = 0; col < COLS; col++ ){
				if(input.hasNextInt()){
					board[row][col] = findSectorType(input.nextInt(), row, col);
			
				}	
			}
		}
		input.close();
	}
			
	
	public List<Sector> getNeighbors(Sector centralSector,int distance){
		//possibleMoves.clear();
		List<Sector> visited = new LinkedList<Sector>();
		visited.add(centralSector);
		for (int i = 0; i < distance; i++){
			for(Sector vi:visited){
				for (int dir = 0; dir < 6; dir++){
					int parity = vi.getCol() % 2;
					if (!visited.contains(board[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]])){
						if(board[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]].isUsable()){
							visited.add(board[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]]);
						   }
					   }
				   }
			
			}	   
		}
		visited.remove(centralSector);
		return visited;
	}
		  
	public Sector findSpawn(){
		return null;
	}
	
	
	/**
	 * Return the istance of sector of the type indicated as input
	 * @param input		The type of the sector that permit the creation of the correct instance
	 * @param row 		
	 * @param col
	 * @return
	 */
	public Sector findSectorType(int input,int row, int col){
		Sector tmp = null;
		switch (input){
		case(0):
			tmp = new NullSector(row, col);
			break;
			
		case(1):
			tmp = new SecureSector(row, col);						
			break;
			
		case(2):
			tmp = new DangerousSector(row, col);
			break;
			
		case(3):
			tmp = new HatchSector(row, col);
			break;
			
		case(4):
			tmp = new HumanSpawn(row, col);
			break;
			
		case(5):
			tmp = new AlienSpawn(row, col);
			break;
			
		}
		return tmp;
	}
	public static void main (String[] args) throws FileNotFoundException{
		

			//new Board();
		
	}
	
	


}


