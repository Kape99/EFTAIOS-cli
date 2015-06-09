package it.polimi.ingsw.capecchidelcoco.server;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.LinkedList;
import java.util.List;

import it.polimi.ingsw.capecchidelcoco.client.Client;
import it.polimi.ingsw.capecchidelcoco.game.*;
import it.polimi.ingsw.capecchidelcoco.player.AlienPlayer;
import it.polimi.ingsw.capecchidelcoco.player.HumanPlayer;
import it.polimi.ingsw.capecchidelcoco.player.Player;

public class Server implements ServerInterface {
	
	private static Server server = null;
	
	private List<Game> games;
	private static Game actualGame = null;
	private int i = 0;
	
	
	private Server(){
		games = new LinkedList<Game>();
		 try{
			 	Game game = new  Game();
			 	RemoteGame stub = (RemoteGame) UnicastRemoteObject.exportObject(game, 0);	
	            Registry registry = LocateRegistry.createRegistry(1413);
	            registry.rebind("Server", stub);
	            System.out.println("Running?");
	        } catch(Exception ex){
	            ex.printStackTrace();
	        }
	        while(true){
	        	
	        }
		
	}
	
	public static Server getServer() {
		if (server==null){
			server= new Server();
		}
		
		return server;
    }
	
	

	
	public synchronized void register (Client c) throws RemoteException{
	actualGame.addClient(c);
	}

	public synchronized void broadcast (String s) throws RemoteException{
		System.out.println(s);
	}



	
	
	
}


