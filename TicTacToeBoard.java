/** This class creates a tic tac toe board. It contains methods to set and check any position on the board
and to display the current board state through print line statements. 
*/

public class TicTacToeBoard implements Board{
	
	char[][] board;
	
	//Default constructor. Creates a 3x3 multi-dimensional array filled with blank spaces that we are going to use as our board. 
	public TicTacToeBoard(){
		board = new char[3][3];
		for(int row = 0; row <=2; row++){
			for(int column = 0; column <=2; column++){
				board[row][column] = ' ';
			}
		}
	}
	//Sets a spot on the board to the current player's ID. Uses one int to represent a spot on the board. 
	public void set(int spot, char playerID){  
		System.out.println(spot);
		spot--;
		int row = spot / 3;
		int column = spot % 3;
		board[row][column] = playerID;
	}
	//Sets a spot on the board to the current player's ID. Uese two ints to represent a spot on the board. 
	public void set(int row, int column, char playerID){
		int spot = (row * 3) + (column + 1);
		System.out.println(spot);
		board[row][column] = playerID;
	}
	//Returns a spot on the board. 
	public char get(int spot){
		spot--;
		int row = spot / 3;
		int column = spot % 3;
		return board[row][column];
	}
	//Returns a sopt on the board. 
	public char get(int row, int column){
		return board[row][column];
	}
	//Displays the current board state through a series of print line statements. 
	public void display(){
		for(int row = 0; row <= 2; row++){
			for(int column = 0; column <=2; column++){
				System.out.print(board[row][column]);
				if(column != 2){
					System.out.print("|");
				}
			}
			System.out.println("\n-----");
		}
	}
	//Checks to see if the game is over (either a tie or a win).
	public void gameOver(TicTacToeBoard board){
		char spot1 = board.get(1);		
		char spot2 = board.get(2);
		char spot3 = board.get(3);
		char spot4 = board.get(4);
		char spot5 = board.get(5);
		char spot6 = board.get(6);
		char spot7 = board.get(7);
		char spot8 = board.get(8);
		char spot9 = board.get(9);
		
		if(spot1 == spot2 && spot2 == spot3){
			idCheck(spot1);
		}
		else if(spot4 == spot5 && spot5 == spot6){
			idCheck(spot4);
		}
		else if(spot7 == spot8 && spot8 == spot9){
			idCheck(spot7);
		}
		else if(spot1 == spot4 && spot4 == spot7){
			idCheck(spot1);
		}
		else if(spot2 == spot5 && spot5 == spot8){
			idCheck(spot2);
		}
		else if(spot3 == spot6 && spot6 == spot9){
			idCheck(spot3);
		}
		else if(spot1 == spot5 && spot5 == spot9){
			idCheck(spot1);
		}
		else if(spot3 == spot5 && spot5 == spot7){
			idCheck(spot3);
		}
		else if(spot1 != ' ' && spot2 != ' ' && spot3 != ' ' && spot4 != ' ' && spot5 != ' ' && spot6 != ' ' && spot7 != ' ' && spot8 != ' ' && spot9 != ' '){
			System.out.println("Game over! Tie Game!");	
			System.exit(0);
			}
	}
	//Used by gameOver method to determine which player won. Then prints out appropriate win statement and terminates the program.
	private void idCheck(char spot){	
		String xWins = "Game over! Player x wins!";
		String oWins = "Game over! Player o wins!";
		if(spot == 'X'){
			System.out.println(xWins);
			System.exit(0);
		}
		else if(spot == 'O'){
			System.out.println(oWins);
			System.exit(0);
		}
	}
}
