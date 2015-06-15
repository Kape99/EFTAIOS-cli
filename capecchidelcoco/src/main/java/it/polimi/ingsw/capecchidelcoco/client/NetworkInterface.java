package it.polimi.ingsw.capecchidelcoco.client;

import it.polimi.ingsw.capecchidelcoco.player.RemotePlayer;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;


public interface NetworkInterface {
	
	
	int connect(String Name) throws IOException;
	
	boolean close() throws IOException;
	
	String sendCommand(String command, int myGame, String player) throws RemoteException;
	
	boolean isEnded() throws RemoteException;

	String updateBrodcast(int myGame, String player) throws IOException;

}
