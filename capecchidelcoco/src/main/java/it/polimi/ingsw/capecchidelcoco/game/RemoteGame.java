package it.polimi.ingsw.capecchidelcoco.game;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteGame extends Remote {
	
	public String action() throws RemoteException;

	public String move(String sector,String player) throws RemoteException ;
	
	public String getMap() throws RemoteException;
	
	public String connect() throws RemoteException;
	
	public String isEnded() throws RemoteException;
	
	public String getWinner() throws RemoteException;
	
	public String attack() throws RemoteException;
	
	public String showCard() throws RemoteException;
	
	public String useCard(String card) throws RemoteException;
	
	public String discardCard(String card) throws RemoteException;
	
	public String makeNoise(String Sector)throws RemoteException;

}
