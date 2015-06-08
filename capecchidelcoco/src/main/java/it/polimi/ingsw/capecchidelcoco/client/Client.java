package it.polimi.ingsw.capecchidelcoco.client;

import it.polimi.ingsw.capecchidelcoco.player.RemotePlayer;
import it.polimi.ingsw.capecchidelcoco.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Scanner;



public class Client  extends UnicastRemoteObject implements ClientInterface, Runnable {
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Server mycs;
	
	public Client (Server cs) throws RemoteException
	{
	mycs=cs;
	mycs.register(this);
	}

	public synchronized void receive (String s) throws RemoteException{
		System.out.println("Message: "+s);
	}
	
	public void run (){
		Scanner in=new Scanner(System.in);
		String msg;

		while(true){
			try{
				msg=in.nextLine();
				mycs.broadcast(msg);
			}
			catch(Exception e){
				System.err.println("Problem….");
			}
		}
	}

		public static void main (String[] args){{
		
			String url = "rmi://localhost:1413/Server";
			try{
				RemotePlayer me= (RemotePlayer) Naming.lookup(url);
				System.out.println(me.action());
			}
			catch (Exception e){
				e.printStackTrace();
				
			}
		}
			
		
	}

	

	

}