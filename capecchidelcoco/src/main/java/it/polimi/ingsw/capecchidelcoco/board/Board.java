package it.polimi.ingsw.capecchidelcoco.board;

import it.polimi.ingsw.capecchidelcoco.sector.*;

import java.io.*;
import java.util.*;


public class Board {
	
	
	//possibile lettura da file
	
	public static  Sector[][] sectors;
	
	
	
	public Board () throws FileNotFoundException{
		
			Scanner input = new Scanner(new File("src/galileo.txt"));
			sectors = new Sector[BoardConstant.ROWS][BoardConstant.COLS];
			for (int row = 0; row < BoardConstant.ROWS; row++ ){
				for (int col = 0; col < BoardConstant.COLS; col++ ){
					if(input.hasNextInt())
			        {
						switch (input.nextInt()){
						case(0):{
							sectors[row][col] = new NullSector(row, col);
							}break;
							
						case(1):{
							sectors[row][col] = new SecureSector(row, col);						
							}break;
							
						case(2):{
							sectors[row][col] = new DangerousSector(row, col);
							}break;
							
						case(3):{
							sectors[row][col] = new HatchSector(row, col);
							}break;
							
						case(4):{
							sectors[row][col] = new HumanSpawn(row, col);
							}break;
							
						case(5):{
							sectors[row][col] = new AlienSpawn(row, col);
							}break;
							
						}
						
			        }
				}
			}
			input.close();
	}
	
	public static void main (String[] args){
		

			try {
				new Board();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
	


}


