/**
Authors: Trevor Wilson and Christopher Lange
Purpose: Class that allows the user to play tic tac toe with another person or a computer, or let two computer players play
against each other. 

*/
public class TicTacToe{
	public static void main(String[] args){
		//Checks that the user input the correct amount of arguments. 
		if(args.length != 2){
			System.out.println("Invalid number of arguments.");
			terminate();
		}
		//Creating the board object, and instantiating the two players. 
		TicTacToeBoard board = new TicTacToeBoard();
		Player playerX = new HumanPlayer('X');
		Player playerO = new HumanPlayer('O');;
		
		//Checking the user input and setting the players to the correct type. 
		//If the user's input doesn't match one of the predetermined classes, the progam
		//tells the user and terminates. 
		if(args[0].equalsIgnoreCase("human")){
			playerX = new HumanPlayer('X');
		}
		else if(args[0].equalsIgnoreCase("random")){
			playerX = new RandomComputerPlayer('X');
		}
		
		else if(args[0].equalsIgnoreCase("naive")){
			playerX = new NaiveComputerPlayer('X');
		}
		
		else if(args[0].equalsIgnoreCase("cutthroat")){
			playerX = new CutThroatComputerPlayer('X');
		}
		else{
			System.out.println("First player type invalid.");
			terminate();
		}
		
		if(args[1].equalsIgnoreCase("human")){
			playerO = new HumanPlayer('O');
		}
		else if(args[1].equalsIgnoreCase("random")){
			playerO = new RandomComputerPlayer('O');
		}
		else if(args[1].equalsIgnoreCase("naive")){
			playerO = new NaiveComputerPlayer('O');
		}
		else if(args[1].equalsIgnoreCase("cutthroat")){
			playerO = new CutThroatComputerPlayer('O');
		}
		else{
			System.out.println("Second player type invalid.");
			terminate();
		}

		System.out.println("Tic-tac-toe Game");
		board.display();		

		//Prompt's each player for input, displays the board, and then checks to see if the game is over. 
		while(true){
			playerX.prompt(board);
			board.display();
			board.gameOver(board);
			playerO.prompt(board);
			board.display();
			board.gameOver(board);
		}
	}
	//Method to allow the program to exit easily, providing a message to the user
	public static void terminate(){
		System.out.println("Program terminating.");
		System.exit(0);
	}
}
