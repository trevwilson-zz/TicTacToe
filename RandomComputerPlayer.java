//Class that represents a player that chooses a spot randomly. 
public class RandomComputerPlayer extends Player{

	char playerID;
	//Constructor. Takes in a char and set's it to the player's ID. 
	public RandomComputerPlayer(char inputID){
		playerID = inputID;
	}
	//Prompt's the player to pick a spot, and set's that spot to playerID. 
	public void prompt(TicTacToeBoard board){
		System.out.print("Please choose an open spot to mark between 1 and 9: ");
		int spot = (int)(Math.random() * 9) + 1;
		while((spot > 9) || (spot < 1) || (board.get(spot) != ' ')){
			System.out.println("Invalid spot: Please choose an open spot between 1 and 9.");
			spot = (int)(Math.random() * 9) + 1;
		}
		board.set(spot, playerID);
	}

	public char getID(){
		return playerID;
	}
}
