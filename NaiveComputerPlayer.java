//Class that represents a player that pick the first open spot every time. 
public class NaiveComputerPlayer extends Player{
	
	char playerID;
	//Constructor. Takes in a char and sets it to playerID. 
	public NaiveComputerPlayer(char inputID){
		playerID = inputID;
	}
	
	//Getter method to return the playerID
	public char getID(){
		return playerID;
	}

	//Prompt's the player to pick a spot, then sets that spot to player ID. Player will always choose the first available spot.
	public void prompt(TicTacToeBoard board){
		System.out.print("Please choose an open spot to mark between 1 and 9: ");
		for(int spot = 1; spot <= 9; spot++){
			if(board.get(spot) == ' '){
				board.set(spot, playerID);
				break;
			}
		}
	}
}
