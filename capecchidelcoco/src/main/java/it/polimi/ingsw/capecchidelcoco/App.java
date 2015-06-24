package it.polimi.ingsw.capecchidelcoco;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Test;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.game.Game;
import it.polimi.ingsw.capecchidelcoco.player.HumanPlayer;
import it.polimi.ingsw.capecchidelcoco.player.Player;
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
    	Game game = new Game(0);
    	Player p1 = new HumanPlayer(game, 0, "p1");
    	
    	
    	System.out.println(p1.move("K06"));
    	
    	
    }
    
    
    
  
    
    
}
