package it.polimi.ingsw.capecchidelcoco.client;

import java.io.IOException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;


public interface NetworkInterface {
	
	
	int connect(String Name) throws IOException;
	
	boolean close() throws IOException;
	
	String sendCommand(String command, int myGame, String player) throws RemoteException;
	
	boolean isEnded() throws RemoteException;

	ArrayList<String> updateBrodcast(int game, String player, int counter) throws IOException;

	boolean sendSector(String sector, int game, String name) throws RemoteException ;
}
