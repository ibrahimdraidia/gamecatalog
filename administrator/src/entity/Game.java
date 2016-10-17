/*
 * The Game; it all strts here my friends, it all starts here.
 */
package entity;

public class Game extends Editor
{
	private int _id_game;
	private String _nom_game;
	
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
		return _nom_game;
	}

	public void setNom_game(String _nom_game)
	{
		this._nom_game = _nom_game;
	}
}
