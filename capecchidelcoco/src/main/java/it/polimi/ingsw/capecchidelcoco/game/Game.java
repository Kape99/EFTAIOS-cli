package it.polimi.ingsw.capecchidelcoco.game;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.client.Client;
import it.polimi.ingsw.capecchidelcoco.deck.*;
import it.polimi.ingsw.capecchidelcoco.deck.card.SectorCard;
import it.polimi.ingsw.capecchidelcoco.player.*;
import it.polimi.ingsw.capecchidelcoco.sector.Coordinates;
import it.polimi.ingsw.capecchidelcoco.sector.DangerousSector;
import it.polimi.ingsw.capecchidelcoco.sector.Sector;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeSet;



public class Game implements Runnable {
	
	

	private int id;

	public static final String[] characterNameList = {"Piero Ceccarella", "Ennio Maria Dominoni", "Vittorio Martana", "Julia Niguloti",
		"Maria Galmbani", "Silvano Porpora", "Paolo Landon", "Tuccio Brendon"};
	public static final String[] characterRoleList = {"First Alien", "Captain", "Second Alien", "Pilot",
		"Third Alien", "Psychologist", "Fourth Alien", "Soldier"};
	
	private Map<String,Player> players;
	private String[] names;		
	
	//private List<Player> players;
	private Board board;
	private SectorDeck sectorDeck;
	private ObjectDeck objectDeck;
	private HatchDeck hatchDeck;
	private Player currentPlayer;
	
	
	private ArrayList<String> news;

	private boolean started = false;
	private boolean ended = false;
	private int turnOf;
	private int numberOfTurns = 0;
	private int maxNumberOfTurns;
	private boolean timerEnded;

	
	private boolean aliensWin = false;
	private List<Player> winnerPlayers;
	private int offset; 

	public static final int MAX_PLAYERS = 3;
	private static final int MAX_TURNS = 39;

		
		public	Game(int id) {
			this.id = id;
			names = new String[8];
			players = new HashMap<String,Player>();
			news = new ArrayList<String>();
			sectorDeck =new SectorDeck();
			hatchDeck = new HatchDeck();
			try {
				board = new Board();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			winnerPlayers = new ArrayList<Player>();
			
		}
	
		public void addNews(String inf){
			news.add(inf);
		}
		

		public Map<String,Player> getPlayers() {
			return players;
		}
		
		public List<Player> getPlayersOfType(String faction) {
			List<Player> result = new ArrayList<Player>();
			for(Player p: players.values()) {
				if(p.getFaction() == faction)
					result.add(p);
			}
			return result;
		}

		public int getNumberOfPlayers() {
			return players.size();
		}

		private int getNumberOfAliveHumanPlayers() {
			int n = 0;
			for (Player p : players.values()) {
				if (p instanceof HumanPlayer && p.isAlive())
					n++;
			}
			return n;
		}

	
		public boolean isFull(){
			return (players.size() == MAX_PLAYERS);
		}

		

		public void startGame(){
			
			offset = (int) (Math.random()*players.size());
			turnOf = offset;
			currentPlayer = players.get(names[offset]);
			started = true;
			maxNumberOfTurns = MAX_TURNS*players.size();
			ended = false;
			TreeSet<String> tmp = new TreeSet<String>();
			tmp.addAll(players.keySet());
			news.add(";;Game is started;;those are the player in this game:");
			for (String s:tmp)
				news.add("'"+s+"'");
			news.add(";;Is the turn of: '"+names[offset]+"';");

		}
		
		
		
		
		
		
		public void run(){
		
			boolean turnEnded = false;
			boolean needSector = false;
			currentPlayer = players.get(0);
			started = true;
			maxNumberOfTurns = MAX_TURNS*players.size() ;
			ended = false;
			while(!ended){
				while(!timerEnded && !turnEnded){
					synchronized (this){
						try {
							this.wait();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						if (timerEnded){
							// TODO handle disconnect(even if the client is connected i kick him out of the game)
						}
						if (turnEnded){
							//TODO reset player parameter
						}
						if (needSector){
							//TODO Request sector for noise
						}
					}
					
				}
				
			}
			
			
		}

		private boolean isEnded() {
			return ended;
		}



		/**
		 * Has the game started?
		 * 
		 * @return true if the game has started
		 */
		public boolean isStarted() {
			return started;
		}

		public String[] getCharacters(){
			return characterNameList;
		}
		
		public String[] getRoles(){
			return characterRoleList;
		}
	
		public String getInfo(String  name){
		
			if (this.players.containsKey(name))
				return players.get(name).getInfo();
			return "fallito INFO ";
		}
		
		

		public String nextTurn() {
			if (ended){
				return"game ended";
				}
			numberOfTurns++;
			if (numberOfTurns > maxNumberOfTurns+offset && getNumberOfAliveHumanPlayers() > 0
					|| numberOfTurns <= maxNumberOfTurns+offset
					&& getNumberOfAliveHumanPlayers() == 0) {
				aliensWin = true;
				currentPlayer = null;
				ended = true;
				for (int i = 0; i < players.size(); i++)
					if (players.get(names[i]).getFaction()=="Alien")
						winnerPlayers.add(players.get(names[i]));
				news.add("Game ended");
				news.add("Those are the winners:");
				for(Player p:winnerPlayers)
					news.add("'"+p.getName()+"' "+p.getCharacter()+" <"+p.getRole()+"> ("+p.getFaction()+").;");
				return ";";
			}
			if (currentPlayer.isAlive() && currentPlayer.action()=="ANY")
				return "ANY% Where do you want to make a noise?;";
			nextP();
			return "Turn ended;";
		}
		public void nextP(){
			turnOf = (turnOf + 1) % players.size();
			currentPlayer = players.get(names[turnOf]);
			currentPlayer.reset();
			news.add("Is the turn of: '"+ currentPlayer.getName()+"'");
			if (!currentPlayer.isAlive())
				nextTurn();
		}
		

		/**
		 * @return the winnerPlayer
		 */
		public List<Player> getWinnerPlayers() {
			return winnerPlayers;
		}
		
		public void addWinner(Player pl){
			this.winnerPlayers.add(pl);
		}

		/**
		 * @return the currentPlayer
		 */
		public Player getCurrentPlayer() {
			return currentPlayer;
		}

	
		public boolean valid(String sector){
			Coordinates c = Sector.GetCoordinate(sector);
			if (c.getY() >= 0 && c.getY() < 14 && c.getX() >= 0 && c.getX() < 23)
				if (board.getSector(c.getY(),c.getX()) instanceof DangerousSector)
					return true;
			return false;
		}

		/**
		 * Add a player to game
		 * 
		 * @param player
		 * @throws GamePlayException
		 */
		void addPlayer(String  name){
			if (this.players.size()%2==0)
				this.players.put(name,new AlienPlayer(this, this.players.size(), name));
			else this.players.put(name,new HumanPlayer(this, this.players.size(), name));
			names[players.size()-1] = name;
		}
		
		public int getID(){
			return this.id;
		}

		public String attack(String name){
			return players.get(name).attack();
			
		}
		
		public SectorCard pickDangerousSectorCard() {
			return getSectorDeck().draw();
		}

		
		public void escaped(HumanPlayer human) {
			winnerPlayers.add(human);
		}

			
		boolean isTurnOf(String player) {
			if (started)			
				return currentPlayer.equals(players.get(player));
			return false;
		}


		public ObjectDeck getObjectDeck() {
			return objectDeck;
		}

		public void setObjectDeck(ObjectDeck objectDeck) {
			this.objectDeck = objectDeck;
		}

		/**
		 * @return the hatchDeck
		 */
		public HatchDeck getHatchDeck() {
			return hatchDeck;
		}

		/**
		 * @param hatchDeck the hatchDeck to set
		 */
		public void setHatchDeck(HatchDeck hatchDeck) {
			this.hatchDeck = hatchDeck;
		}

		/**
		 * @return the board
		 */
		public Board getBoard() {
			return board;
		}

		/**
		 * @param board the board to set
		 */
		public void setBoard(Board board) {
			this.board = board;
		}

		/**
		 * @return the sectorDeck
		 */
		public SectorDeck getSectorDeck() {
			return sectorDeck;
		}

		/**
		 * @param sectorDeck the sectorDeck to set
		 */
		public void setSectorDeck(SectorDeck sectorDeck) {
			this.sectorDeck = sectorDeck;
		}
		public ArrayList<String> getNews(String name, int counter){
			ArrayList<String> ret = new ArrayList<String>();
			for (int i = counter; i<news.size(); i++){
				ret.add(news.get(i));
			}
			return ret;
		}

		public String move(String sector, String player)  {
			String ret =players.get(player).move(sector)+";";
			return ret;
			
		}

		public String getMap() {
			String map = new String() ;
		
			for (int row = 0 ; row < Board.ROWS; row++){
				for  (int col = 0 ; col < Board.COLS; col =  col + 2){
					
					switch (board.getSector(row, col).getType()){
					case('N'):{
						map+=("       ");
						break;
					}
					case('S'):{
						map+=("("+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+")");
						break;
					}
					case('D'):{
						map+=("{"+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+"}");
						break;
					}
					case('E'):{
						map+=("<"+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+">");
						break;
					}
					case('H'):{
						map+=("|"+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+"|");
						break;
					}
					case('A'):{
						map+=("|"+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+"|");
						break;
					}	
				}
					map+=("       ");
				}
				map+=(";");
				map+=("       ");
				for  (int col = 1; col < Board.COLS; col =  col + 2){
					switch (board.getSector(row, col).getType()){
					case('N'):{
						map+=("       ");
						break;
					}
					case('S'):{
						map+=("("+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+")");
						break;
					}
					case('D'):{
						map+=("{"+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+"}");
						break;
					}
					case('E'):{
						map+=("<"+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+">");
						break;
					}
					case('H'):{
						map+=("|"+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+"|");
						break;
					}
					case('A'):{
						map+=("|"+board.getSector(row, col).getName()+" "+board.getSector(row, col).getType()+"|");
						break;
					}
					}
					map+=("       ");
				}
				map+=(";");
			}
		
			return map;
		}




	

	


}
