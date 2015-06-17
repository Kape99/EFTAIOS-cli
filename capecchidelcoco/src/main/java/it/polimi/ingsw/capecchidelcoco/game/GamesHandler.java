package it.polimi.ingsw.capecchidelcoco.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public class GamesHandler implements GamesHandlerInterface {
	
	private static List<Game> games;
	private static Game actualGame = null;
	private int count = 0;
	
	
	public GamesHandler (){
		games = new ArrayList<Game>();
		System.out.println("GamesHandler");

	}

	public int connect(String name) throws RemoteException {

		for (Game g:games){
			if (g.getPlayers().containsKey(name))
				return -1;
		}
			
		if (actualGame == null){
			System.out.println("actualGame is null");
			createNewGame();	
		}
		if (actualGame.isFull()){
			//TODO start game
			System.out.println("è pieno?");
			createNewGame();	
		}
		System.out.println("connecting to game "+(count-1)+" player "+name );
		actualGame.addPlayer(name);
		System.out.println("game " +actualGame.getID());
		return actualGame.getID();
	}
	
	private void createNewGame(){
		System.out.println("Creating new Game "+ count);
		actualGame = new Game(count);
		games.add(actualGame);
		count++;
	}

	public Boolean isEnded() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public String sendAction(String action, int game, String name) throws RemoteException {
		String splitted[] = action.split(" ");
		if (games.isEmpty())
			return "Games empty";
		
		System.out.println(splitted[0]+", game:"+game+", player:"+name);
		switch (splitted[0]){
			case ("MOVE"):{		
				System.out.println("move in "+splitted[1]);
				return games.get(game).move(splitted[1], name);}
			case ("MAP"):{return games.get(game).getMap();}
			case ("INFO"):{return games.get(game).getInfo(name);}
		}
		return "casa";
	}

}
