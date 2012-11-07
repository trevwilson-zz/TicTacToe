//Abstract class that the other types of players will extend. 
public abstract class Player{

	char playerID;
	
	public abstract void prompt(TicTacToeBoard board);
	
	public char getID(){
		return playerID;
	}

}
