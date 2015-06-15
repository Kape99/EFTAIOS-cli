package it.polimi.ingsw.capecchidelcoco.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public class GamesHandler implements GamesHandlerInterface {
	
	private static List<Game> games;
	private static Game actualGame = null;
	private int i = 0;
	
	
	public GamesHandler (){
		actualGame = new Game(i);
	}

	public int connect(String name) throws RemoteException {
		
		if (actualGame.isFull()){
			games.add(actualGame);
			i++;
			actualGame = null;
		}
		if (actualGame == null){
			createNewGame();	
		}
		
		actualGame.addPlayer(name);
		if (actualGame.isFull()){
			//TODO actualGame.start();
			games.add(actualGame);
			i++;
			actualGame = null;
		}
		return actualGame.getID();
	}
	
	private void createNewGame(){
		i++;
		actualGame = new Game(i);
	}

	public Boolean isEnded() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String sendAction(String action, int game, String name) throws RemoteException {
		String splitted[] = action.split(" ");
		switch (splitted[0]){
		case ("MAP"):{return games.get(game).getMap();}
		case ("MYCHARACTER"):{return games.get(game).getCharacter(name);}
		}
		return null;
	}

}
