package it.polimi.ingsw.capecchidelcoco.server;


import java.io.IOException;
import java.rmi.NotBoundException;

public class MainServer {
	
	private MainServer(){
		
	}

	public static void main(String[] args) throws IOException, NotBoundException{
	
		Server.getServer();	 
			
	}
	 
	
	
}
