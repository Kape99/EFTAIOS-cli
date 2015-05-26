package it.polimi.ingsw.capecchidelcoco.player;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemotePlayer extends Remote {
	
	public String action() throws RemoteException;

	public String move() throws RemoteException ;
	
	public String getMap() throws RemoteException;
	
	public String connect() throws RemoteException;
	
	public String isEnded() throws RemoteException;
	
	public String getWinner() throws RemoteException;
	
	public String attack() throws RemoteException;
	
	public String showCard() throws RemoteException;
	
	public String useCard() throws RemoteException;
	
	public String discardCard() throws RemoteException;
	
	public String makeNoise()throws RemoteException;

}
