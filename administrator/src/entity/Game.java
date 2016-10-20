/*
 * The Game; it all starts here my friends, it all starts here.
 */
package entity;

public class Game extends Editor
{
	private int _id_game;
	private String _name_game;
	
	public Game()
	{
	}

	public int getId_game()
	{
		return _id_game;
	}

	public void setId_game(int _id_game)
	{
		this._id_game = _id_game;
	}

	public String getNom_game()
	{
		return _name_game;
	}

	public void setNom_game(String _name_game)
	{
		this._name_game = _name_game;
	}
	
	@Override
	public String toString() {
		
		return _name_game;
	}
}
