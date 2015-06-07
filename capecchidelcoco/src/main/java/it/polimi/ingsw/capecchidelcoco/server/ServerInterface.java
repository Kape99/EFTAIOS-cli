package it.polimi.ingsw.capecchidelcoco.server;

import it.polimi.ingsw.capecchidelcoco.client.Client;

import java.rmi.*;

public interface ServerInterface extends Remote{
	void register(Client c) throws RemoteException;
	void broadcast(String s) throws RemoteException;

}

