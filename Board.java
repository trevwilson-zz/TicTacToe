//Generic interface for a game board.

public interface Board{

	public void set(int spot, char playerID);

	public char get(int spot);

	public void display();	
}
