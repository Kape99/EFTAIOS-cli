package it.polimi.ingsw.capecchidelcoco.client;

import it.polimi.ingsw.capecchidelcoco.game.RemoteGame;
import it.polimi.ingsw.capecchidelcoco.player.RemotePlayer;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public class NetworkInterface {
private RemotePlayer player;
	
	public String connect() {
		String name = "RemotemyGame";
        Registry registry;
		try {
			registry = LocateRegistry.getRegistry(2026);
		} catch (RemoteException e) {			
			e.printStackTrace();
			return "";
		}
        try {
			player = (RemotePlayer) registry.lookup(name);
		} catch (AccessException e) {
			e.printStackTrace();
			return "";
		} catch (RemoteException e) {
			e.printStackTrace();
			return "";
		} catch (NotBoundException e) {
			e.printStackTrace();
			return "";
		}
		try {
			return player.connect();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	public boolean close() {
		return true;
	}

	public String getMap() throws RemoteException {
		return player.getMap();
	}

	public String move() throws RemoteException {
		return player.move();
	}

	public String isEnded() throws RemoteException {
		return player.isEnded();
	}

	public String getWinner() throws RemoteException {
		return player.getWinner();
	}

	

}
