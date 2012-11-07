//Class that represents the human player. 
import java.util.Scanner;
import java.util.InputMismatchException;

public class HumanPlayer extends Player{
	
	Scanner keyboard = new Scanner(System.in);

	private char playerID = 'x';

	public HumanPlayer(char inputID){
		playerID = inputID;
	}

	public void prompt(TicTacToeBoard board){
		int spot;	
		System.out.print("Player " + playerID + " please enter an open spot to mark: ");
		try {
			spot = keyboard.nextInt();
			while((spot > 9) || (spot < 1) || (board.get(spot) != ' ')){
				System.out.println("Invalid spot: Please choose an open spot between 1 and 9.");
				System.out.print("Player " + playerID + " please enter an open spot to mark: ");
				spot = keyboard.nextInt();
			}
			board.set(spot, playerID);
		}
		catch (InputMismatchException e) {
			System.out.println("You must enter a integer 1 - 9");
			System.out.println("You entered invalid input. Program Terminating.");
			System.exit(0);
		}
	}

	public char getID(){
		return playerID;
	}
}
