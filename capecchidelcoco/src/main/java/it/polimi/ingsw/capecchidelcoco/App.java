package it.polimi.ingsw.capecchidelcoco;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.Scanner;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.sector.AlienSpawn;
import it.polimi.ingsw.capecchidelcoco.sector.DangerousSector;
import it.polimi.ingsw.capecchidelcoco.sector.HatchSector;
import it.polimi.ingsw.capecchidelcoco.sector.HumanSpawn;
import it.polimi.ingsw.capecchidelcoco.sector.NullSector;
import it.polimi.ingsw.capecchidelcoco.sector.Sector;
import it.polimi.ingsw.capecchidelcoco.sector.SecureSector;

/**
 * Hello world!
 *
 */
public class App 
{
	
	
    public static void main( String[] args ) throws RemoteException, FileNotFoundException
    {
    	
		Game g= new Game(1);
    	System.out.println(g.getMap().replace(";","\n"));
    }
    
  
    
    
}
