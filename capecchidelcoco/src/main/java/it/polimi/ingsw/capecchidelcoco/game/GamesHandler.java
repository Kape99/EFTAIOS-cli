package it.polimi.ingsw.capecchidelcoco.game;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lucacapecchi
 * This Class generate games, connect player to it,
 * handle the action asked by a client
 * 
 */
public class GamesHandler implements GamesHandlerInterface {
	
	private static List<Game> games;
	private static Game actualGame = null;
	private int count = 0;
	
	
	/**
	 * Constructor
	 */
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
		System.out.println("connecting to game "+(count-1)+" player "+name );
		actualGame.addPlayer(name);
		System.out.println("game " +actualGame.getID());
		int ret = actualGame.getID();
		if (actualGame.isFull()){
			actualGame.startGame();
			System.out.println("è pieno");
			createNewGame();	
		}
		return ret;
	}
	
	private void createNewGame(){
		System.out.println("Creating new Game "+ count);
		actualGame = new Game(count);
		games.add(actualGame);
		count++;
	}

	public Boolean isEnded() throws RemoteException {
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
		case ("MOVEMENTS"):{return games.get(game).getMovemets(name);}
		case ("TURN"):{return games.get(game).getTurn();}
		}
		if (!games.get(game).isStarted())
			return "Game not started yet";
		if (games.get(game).isTurnOf(name) && games.get(game).getPlayers().get(name).isAlive())
		switch (splitted[0]){
			case ("MOVE"):{
				
				return games.get(game).move(splitted[1], name);}
			case ("ATTACK"):{return games.get(game).attack(name);}
			case ("END"):{return games.get(game).nextTurn();}
			//"MOVE","INFO","MAP","USECARD","HELP","PLAYERS"
		}
		return "Isn't your turn.";
	}
	
	
	public String help(){
		return ";;Welcome in EFTAIOS;;;"
				+ "This is the list of command you can use to play this beautiful BoardGame;"
				+ ";"
				+ "(This interface is case-sensitive so you MUST use uppercase letter);"
				+ ";"
				+ "In any moment dureng the game you can use those command:;"
				+ "HELP       --> Will show you this list of command.;"
				+ "INFO       --> Will show you your character info,;"
				+ "               your status, position, 'object you have'.;"
				+ "MAP        --> Will show you the map where you are going to play.;"
				+ "MOVEMENTS  --> Will show you the list of your movement from the beginnig;"
				+ "TURN       --> The actual turn;"
				+ ";;"
				+ "During your turn you must move and then you have to decide if attack or not;"
				+ "MOVE 'CRR' --> If possible(your turn, valid input) move you in 'CRR';"
				+ "               'CRR' is C=collumn and RR=row of your detination;"
				+ "               Ex.  'MOVE A01' will move you in A01 Sector.;"
				+ "ATTACK     --> After the movement attack the current location;"
				+ "END        --> Will end your turn and draw a sector card if you have too;"
				+ "				  the game may ask you to chose a sector where you have to make a noise;";
	}
	//{"MOVE","INFO","MAP","HELP","ATTACK","END"}


	@Override
	public Boolean sendSector(String sector, int game, String name)throws RemoteException {
		if( games.get(game).valid(sector)){
			games.get(game).addNews(name+": Noise in "+sector);
			games.get(game).nextP();
			return true;
		}
		return false;
		
	}

}
