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

	public ArrayList<String> brodcast(int game, String name, int counter)throws RemoteException{
		
		return games.get(game).getNews(name, counter);
	}
	public String sendAction(String action, int game, String name) throws RemoteException {
		String splitted[] = action.split(" ");
		if (games.isEmpty())
			return "Games empty";
		switch (splitted[0]){
		case ("MAP"):{return games.get(game).getMap();}
		case ("INFO"):{return games.get(game).getInfo(name);}
		case ("HELP"):{return help();}
		
		}
		System.out.println(splitted[0]+", game:"+game+", player:"+name);
		//if (games.get(game).isTurnOf(name))
		switch (splitted[0]){
			case ("MOVE"):{return games.get(game).move(splitted[1], name);}
			//"MOVE","INFO","MAP","USECARD","HELP","PLAYERS"
		}
		return "Isn't your turn.";
	}
	public String help(){
		return "Welcome in EFTAIOS;"
				+ "This is the list of command you can use to play this beautiful BoardGame;"
				+ ";"
				+ "(This interface is case-sensitive so you MUST use uppercase letter);"
				+ ";"
				+ "HELP       --> Will show you this list of command.;"
				+ "INFO       --> Will show you your character info,;"
				+ "               your status, position, 'object you have'.;"
				+ "MAP        --> Will show you the map where you are going to play.;"
				+ "MOVE 'CRR' --> If possible(your turn, valid input) move you in 'CRR';"
				+ "               'CRR' is C=collumn and RR=row of your detination;"
				+ "               Ex.  'MOVE A01' will move you in A01 Sector.;";
	}

}
