//Abstract class representing any Computer-controlled player
public abstract class ComputerPlayer{

	char playerID;

	public abstract void prompt();

	public char getID(){
		return playerID;
	}

}
