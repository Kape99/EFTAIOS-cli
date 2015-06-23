package it.polimi.ingsw.capecchidelcoco.board;

import it.polimi.ingsw.capecchidelcoco.sector.*;

import java.io.*;
import java.util.*;



/**
 * @author lucacapecchi
 *
 * Class Board
 * Generate the map where the player are playing,
 * Offer method to navigate through map.
 */
public class Board {
	
	

	public static final int ROWS = 14;
	public static final int COLS = 23;
	

	
	List<Sector> d;
	
	Sector humanSpawn;
	Sector alienSpawn;

	
	private Sector[][] board;
	
	
	
	/**Constructor of the class
	 * Read the map from the file and initialize each sector in the map
	 * 
	 * @throws FileNotFoundException
	 */
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
		input.close();
	}
	
	/**Method used to get a sector contained in the map
	 * @param row - row coordinate of the needed sector
	 * @param col - col coordinate of the needed sector  
	 * @return the requested sector
	 */
	public Sector getSector(int row, int col){
		return board[row][col];
	}
			
	
	public Set<Sector> getNeighbors(Sector centralSector,int distance){
		Set<Sector> visited = new HashSet<Sector>();
		for (int dir = 0; dir < 6; dir++){
			int parity = centralSector.getCol() % 2;
			try{
				if(board[centralSector.getRow() + Direction.getYDIRECTION()[parity][dir]][centralSector.getCol() + Direction.getXDIRECTION()[dir]].isUsable()){
					visited.add(board[centralSector.getRow() + Direction.getYDIRECTION()[parity][dir]][centralSector.getCol() + Direction.getXDIRECTION()[dir]]);
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
		return visited;
	}
		  
	/**Method use to find the Spawn sector of the given faction
	 * @param faction
	 * @return Sector asked
	 */
	public Sector findSpawn(String faction){
		if (faction == "Alien")
			return alienSpawn;
		return humanSpawn;
	}
	
	
	/**
	 * Return the instance of sector of the type indicated as input
	 * @param input The type of the sector that permit the creation of the correct instance
	 * @param row - row of the sector to be created
	 * @param col - col of the sector to be created
	 * @return the created sector
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
			case 'H':{Sector tmp = new HumanSpawn(row, col);
					humanSpawn = tmp;
					return tmp;}
			case 'A':{Sector tmp = new AlienSpawn(row, col);
					alienSpawn = tmp;
					return tmp;}
			}
			return null;
		}

	


}


