package it.polimi.ingsw.capecchidelcoco.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface GamesHandlerInterface extends Remote{

	public int connect(String name) throws RemoteException;
	
	public Boolean isEnded() throws RemoteException;

	public String sendAction(String action, int game, String name) throws RemoteException ;
	
	public ArrayList<String> brodcast (int game, String name, int counter) throws RemoteException;

	public Boolean sendSector(String sector, int game, String name) throws RemoteException;
}
