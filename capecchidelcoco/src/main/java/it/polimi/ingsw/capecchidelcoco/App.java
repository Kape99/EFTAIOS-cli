package it.polimi.ingsw.capecchidelcoco;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.sector.AlienSpawn;
import it.polimi.ingsw.capecchidelcoco.sector.DangerousSector;
import it.polimi.ingsw.capecchidelcoco.sector.Direction;
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
    	Set<Sector> s = new TreeSet<Sector>();
		Game g= new Game(1);
		Sector d = g.getBoard().getSector (6, 2);
		System.out.println(g.getMap().replace(";", "\n"));
		System.out.println(d.getName());
    	for (Sector a:g.getBoard().getNeighbors(d, 1)){
    		System.out.println(a.getName());
    	}
    
    	
    }
    
    
    
  
    
    
}
