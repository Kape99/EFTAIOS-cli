package it.polimi.ingsw.capecchidelcoco.game;

import it.polimi.ingsw.capecchidelcoco.board.Board;
import it.polimi.ingsw.capecchidelcoco.client.Client;
import it.polimi.ingsw.capecchidelcoco.deck.*;
import it.polimi.ingsw.capecchidelcoco.deck.card.SectorCard;
import it.polimi.ingsw.capecchidelcoco.player.*;

import java.io.FileNotFoundException;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;



public class Game implements Runnable {
	
	
	//TODO sistemare problema che non trova il le info sulla sdeconda partita
	
	private int id;

	public static final String[] characterNameList = {"Piero Ceccarella", "Ennio Maria Dominoni", "Vittorio Martana", "Julia Niguloti",
		"Maria Galmbani", "Silvano Porpora", "Paolo Landon", "Tuccio Brendon"};
	public static final String[] characterRoleList = {"First Alien", "Captain", "Second Alien", "Pilot",
		"Third Alien", "Psychologist", "Fourth Alien", "Soldier"};
	
	private Map<String,Player> players;
	//private String[] names;		
	
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
	private int cycle;
	private boolean timerEnded;

	
	private boolean aliensWin = false;
	private List<Player> winnerPlayers;


	public static final int MAX_PLAYERS = 2;
	private static final int MAX_TURNS = 39;

		
		public	Game(int id) {
			this.id = id;
			players = new HashMap<String,Player>();
			news = new ArrayList<String>();
			sectorDeck =new SectorDeck();
			hatchDeck = new HatchDeck();
			try {
				board = new Board();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
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
			for (String s:this.players.keySet()){
				System.out.println(s);
			}
			if (this.players.containsKey(name))
				return players.get(name).getInfo();
			return "fallito INFO";
		}
		
		

		void nextTurn() {
			if (ended)
				return;
			numberOfTurns++;
			if (numberOfTurns > maxNumberOfTurns && getNumberOfAliveHumanPlayers() > 0
					|| numberOfTurns <= maxNumberOfTurns
					&& getNumberOfAliveHumanPlayers() == 0) {
				aliensWin = true;
				currentPlayer = null;
				ended = true;
				return;
			}
			turnOf = (turnOf + 1) % players.size();
			currentPlayer = players.get(turnOf);
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
			System.out.println("G size of players "+players.size());
		}
		
		public int getID(){
			return this.id;
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
