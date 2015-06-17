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
	  	Scanner input = new Scanner(new File("src/galilei.txt"));
		String tmp;
		char[] value;
		board = new Sector[ROWS][COLS];	
		for (int row = 0; row < 14; row++ ){
			tmp = input.nextLine();
			value = tmp.toCharArray();
			int col = 0;
			for (int c = 0; c < value.length; c++ ){
				char v = value[c];
				if(v=='N' || v=='S' || v=='D' || v=='E' || v=='H' || v=='A')
					{
					board [row][col] = findSectorType(v,row,col);
					col++;
				}
			}
		}
	}
	
	public Sector getSector(int row, int col){
		return board[row][col];
	}
			
	
	public Set<Sector> getNeighbors(Sector centralSector,int distance){
		//TODO possibleMoves.clear();
		Set<Sector> visited = new HashSet<Sector>();
		for (int dir = 0; dir < 6; dir++){
			int parity = centralSector.getCol() % 2;
			try{
				if(board[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]].isUsable()){
					visited.add(board[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]]);
				}
			}catch(Exception e){}
		}
		if (distance >1 ){
			Set<Sector> appo = new HashSet<Sector>();
			appo.addAll(visited);
			for (Sector vi:appo){
					visited.addAll(getNeighbors(vi,distance-1));
				}
			}
		
	/*	for (int i = 0; i < distance; i++){
				for(Sector vi:visited){
					for (int dir = 0; dir < 6; dir++){
						int parity = vi.getCol() % 2;
						try{
							if(board[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]].isUsable()){
								visited.add(board[centralSector.getRow() + Direction.yDirection[parity][dir]][centralSector.getCol() + Direction.xDirection[dir]]);
							}
						}catch(Exception e){}
					}
				}
		}
		*/
		return visited;
	}
		  
	public Sector findSpawn(String faction){
		return null;
	}
	
	
	/**
	 * Return the istance of sector of the type indicated as input
	 * @param input		The type of the sector that permit the creation of the correct instance
	 * @param row 		
	 * @param col
	 * @return
	 */
	  public Sector findSectorType(char input,int row, int col){
		  
		  switch (input){
			case 'N':
			    return new NullSector(row, col);
			case 'S':
				return new SecureSector(row, col);	
			case 'D':
				return new DangerousSector(row, col);
			case 'E':
				return new HatchSector(row, col);
			case 'H':
				return new HumanSpawn(row, col);
			case 'A':
				return new AlienSpawn(row, col);
			}
			return null;
		}
	public static void main (String[] args) throws FileNotFoundException{
		

			//new Board();
		
	}
	
	


}


