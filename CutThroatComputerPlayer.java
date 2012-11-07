//Class that represents a player that will never lose. 
public class CutThroatComputerPlayer extends Player {

	private char playerID;
	//Constructor. Takes in char and sets it to playerID. 
	public CutThroatComputerPlayer(char inputID) {
		playerID = inputID;
	}
	
	public char getID(){
		return playerID;
	}
	//Prompt's the player to pick a spot on the board. The player will never lose. 
	public void prompt(TicTacToeBoard board){
		System.out.print("Player " + playerID + " enter an open spot to mark: ");
		char otherID = 'X';
		if(playerID == 'X'){
			otherID = 'O';
		}
		if(rowChecker(board, playerID, playerID) || colChecker(board, playerID, playerID) || diagChecker(board, playerID, playerID)){
		}
		else if(rowChecker(board, otherID, playerID) || colChecker(board, otherID, playerID) || diagChecker(board, otherID, playerID)){
		}
		else if(specialFork(board, otherID, playerID)){
		}
		else if(forkChecker(board, playerID, playerID)){
		}
		else if(forkChecker(board, otherID, playerID)){
		}
		else if (board.get(5) == ' ') {
			board.set(5, playerID);
		}
		else if (oppCorner(board, otherID, playerID)){
		}
		else if (corner(board, playerID)) {
		}
		else if (side(board, playerID)) {
		}
	}
	//Blocks opponent fork in a special case by setting up two in a row of its own playerID
	private boolean specialFork(TicTacToeBoard board, char checkID, char markID){
		boolean markedSpot = false;
		if(board.get(1) == checkID && board.get(9) == checkID){
			side(board, markID);
			markedSpot = true;
		}
		else if(board.get(3) == checkID && board.get(7) == checkID){
			side(board, markID);
			markedSpot = true;
		}
		return markedSpot;
	}
	//Set's an open side spot to the player's ID.
	private boolean side(TicTacToeBoard board, char playerID) {
		boolean markedSpot = false;
		if (board.get(2) == ' ') {
			board.set(2, playerID);
			markedSpot = true;
		}
		else if (board.get(4) == ' ') {
			board.set(4, playerID);
			markedSpot = true;
		}
		else if (board.get(6) == ' ') {
			board.set(6, playerID);
			markedSpot = true;
		}
		else if (board.get(8) == ' ') {
			board.set(8, playerID);
			markedSpot = true;
		}
		return markedSpot;
	}
	//Set's an open corner to the player's ID.
	private boolean corner(TicTacToeBoard board, char playerID) {
		boolean markedSpot = false;
		if (board.get(1) == ' ') {
			board.set(1, playerID);
			markedSpot = true;
			}
		else if (board.get(3) == ' ') {
			board.set(3, playerID);
			markedSpot = true;
			}
		else if (board.get(7) == ' ') {
			board.set(7, playerID);
			markedSpot = true;
			}
		else if (board.get(9) == ' ') {
			board.set(9, playerID);
			markedSpot = true;
			}
		return markedSpot;
	}
	//Checks to see if the opponent marked a corner. If it dide, this method will set the opposite corner to the player's ID. 
	private boolean oppCorner(TicTacToeBoard board, char checkPlayerID, char markPlayerID) {
		boolean markedSpot = false;
		
		if (board.get(1) == checkPlayerID && board.get(9) == ' ') {
			board.set(9, markPlayerID);
			markedSpot = true;
		}
		else if (board.get(9) == checkPlayerID && board.get(1) == ' ') {
			board.set(1, markPlayerID);
			markedSpot = true;
		}
		else if (board.get(7) == checkPlayerID && board.get(3) == ' ') {
			board.set(3, markPlayerID);
			markedSpot = true;
		}
		else if (board.get(3) == checkPlayerID && board.get(7) == ' ') {
			board.set(7, markPlayerID);
			markedSpot = true;
		}
		else if (board.get(3) == checkPlayerID && board.get(7) == ' ') {
			board.set(7, markPlayerID);
			markedSpot = true;
		}
		return markedSpot;
	}
	//Checks if there are two marked spots of the same ID and one open spot on the same row.	
	private boolean rowChecker(TicTacToeBoard board, char checkPlayerID, char markPlayerID){
		boolean markedSpot = false;
		for(int row = 0; row <= 2; row++){
			if(board.get(row, 0) == checkPlayerID && board.get(row, 1) == checkPlayerID && board.get(row,2) == ' '){
				board.set(row, 2, markPlayerID);
				markedSpot = true;
			}
			else if(board.get(row, 0) == checkPlayerID && board.get(row, 1) == ' ' && board.get(row,2) == checkPlayerID){
				board.set(row, 1, markPlayerID); 
				markedSpot = true;
			}
			else if(board.get(row, 0) == ' ' && board.get(row, 1) == checkPlayerID && board.get(row,2) == checkPlayerID){
				board.set(row, 0, markPlayerID); 
				markedSpot = true;
			}
		}
		return markedSpot;
	}
	//Checks if there are two marked spots of the same ID and one open spot on the same column.
	private boolean colChecker(TicTacToeBoard board, char checkPlayerID, char markPlayerID){
		boolean markedSpot = false;
		for(int col = 0; col <= 2; col++){
			if(board.get(0, col) == checkPlayerID && board.get(1, col) == checkPlayerID && board.get(2, col) == ' '){
				board.set(2, col, markPlayerID);
				markedSpot = true;
			}
			else if(board.get(0, col) == checkPlayerID && board.get(1, col) == ' ' && board.get(2, col) == checkPlayerID){
				board.set(1, col, markPlayerID); 
				markedSpot = true;
			}
			else if(board.get(0, col) == ' ' && board.get(1, col) == checkPlayerID && board.get(2, col) == checkPlayerID){
				board.set(0, col, markPlayerID); 
				markedSpot = true;
			}
		}
		return markedSpot;		
	}
	//Checks if there are two marked spots of the same ID and one open spot on one of the diagonal lines.
	private boolean diagChecker(TicTacToeBoard board, char checkPlayerID, char markPlayerID){
		boolean markedSpot = false;
		if (board.get(1) == checkPlayerID && board.get(5) == checkPlayerID && board.get(9) == ' '){
			board.set(9, markPlayerID);
			markedSpot = true;
		}	
		else if (board.get(1) == checkPlayerID && board.get(9) == checkPlayerID && board.get(5) == ' '){
			board.set(5, markPlayerID);
			markedSpot = true;
		}
		else if (board.get(5) == checkPlayerID && board.get(9) == checkPlayerID && board.get(1) == ' '){
			board.set(1, markPlayerID);
			markedSpot = true;
		}	
		else if (board.get(7) == checkPlayerID && board.get(5) == checkPlayerID && board.get(3) == ' '){
			board.set(3, markPlayerID);
			markedSpot = true;
		}	
		else if (board.get(7) == checkPlayerID && board.get(3) == checkPlayerID && board.get(5) == ' '){
			board.set(5, markPlayerID);
			markedSpot = true;
		}	
		else if (board.get(3) == checkPlayerID && board.get(5) == checkPlayerID && board.get(7) == ' '){
			board.set(7, markPlayerID);
			markedSpot = true;
		}
		return markedSpot;
	}
	//Checks for fork oppurtunities. Used to make forks, and block opponents forks. 
	private boolean forkChecker(TicTacToeBoard board, char checkPlayerID, char markPlayerID){
		boolean markedSpot = false;
		if(board.get(1) == checkPlayerID && board.get(9) == checkPlayerID){
			if(board.get(2) == ' ' && board.get(6) == ' '){
				board.set(3, markPlayerID);
				markedSpot = true;
			}
			else if(board.get(4) == ' ' && board.get(8) == ' '){
				board.set(7, markPlayerID);
				markedSpot = true;
			}
		}
		else if(board.get(3) == checkPlayerID && board.get(7) == checkPlayerID){
			if(board.get(2) == ' ' && board.get(4) == ' '){
				board.set(1, markPlayerID);
				markedSpot = true;
			}
			else if(board.get(6) == ' ' && board.get(8) == ' '){
				board.set(9, markPlayerID);
				markedSpot = true;
			}
		}
		else if(board.get(1) == checkPlayerID && board.get(7) == checkPlayerID){
			if(board.get(3) == ' ' && board.get(9) == ' '){
				board.set(5, markPlayerID);
				markedSpot = true;
			}
		}
		else if(board.get(3) == checkPlayerID && board.get(9) == checkPlayerID){
			if(board.get(1) == ' ' && board.get(7) == ' '){
				board.set(5, markPlayerID);
				markedSpot = true;
			}
		}
		else if(board.get(1) == checkPlayerID && board.get(3) == checkPlayerID){
			if(board.get(7) == ' ' && board.get(9) == ' '){
				board.set(5, markPlayerID);
				markedSpot = true;
			}
		}
		else if(board.get(7) == checkPlayerID && board.get(9) == checkPlayerID){
			if(board.get(3) == ' ' && board.get(1) == ' '){
				board.set(5, markPlayerID);
				markedSpot = true;
			}
		}
		return markedSpot;
	}

}
