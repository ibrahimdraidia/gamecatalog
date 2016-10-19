package db;

import entity.Game;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import interfaces.CrudInterface;

/*
 * Database request, mysql request for the game entity.
 */
public class GameHandler extends Database implements CrudInterface{
	
	private Connection _connection;
	private PreparedStatement _ps;
	private ResultSet _rs;
        private Game _game;
	
	/*
	 * Principle database connection.
	 */
	public GameHandler() {
		_connection = getInstance();
                _game = new Game();
	}

	/*
	 * Add new game to database.
	 */
	@Override
	public void add(Map<String, ?> data) {
		if(data != null && data.size() != 0)
		{
			try {
				_ps = _connection.prepareStatement
						(
								"INSERT INTO GAME(ID_GAME,NAME_GAME,RELEASE_DATE,PIC_GAME,SUMMARY_GAME) VALUES(?,?,?,?,?)",
								Statement.RETURN_GENERATED_KEYS
						);
				
				_ps.setInt(1, 0);
				_ps.setString(2, data.get("name_game").toString());
				_ps.setString(3, data.get("release_date").toString());
				_ps.setString(4, data.get("pic_game").toString());
				_ps.setString(5, data.get("summary_game").toString());
				
				if(_ps.executeUpdate() == 1)
				{
					System.out.println("Game  has been added ;) ");
					_rs = _ps.getGeneratedKeys();
					if(_rs.next())
					{
						_game.setId_game((int)_rs.getLong(1));
                                                
                        _ps = _connection.prepareStatement("INSERT INTO DEVELOPS (ID_GAME, ID_DEV) VALUES (?,?)");
                        _ps.setInt(1, Integer.parseInt(String.valueOf(_game.getId_game())));
                        _ps.setInt(2, Integer.parseInt(data.get("id_dev").toString()));
                        if(_ps.executeUpdate() == 1){
                            System.out.println("Game has been added to Develops");                                                 
                        }
                        
                        _ps = _connection.prepareStatement("INSERT INTO EDITS (ID_GAME, ID_EDITOR) VALUES (?,?)");
                        _ps.setInt(1, Integer.parseInt(String.valueOf(_game.getId_game())));
                        _ps.setInt(2, Integer.parseInt(data.get("id_editor").toString()));
                         if(_ps.executeUpdate() == 1){
                            System.out.println("Game has been added to Edits");                                                 
                        }
                         
                        _ps = _connection.prepareStatement("INSERT INTO OF_THE_GENRE (ID_GAME, ID_GENRE) VALUES (?,?)");
                        _ps.setInt(1, Integer.parseInt(String.valueOf(_game.getId_game())));
                        _ps.setInt(2, Integer.parseInt(data.get("id_genre").toString()));
                         if(_ps.executeUpdate() == 1){
                            System.out.println("Game has been added to of_the_genre");                                                 
                        }
                         
                        _ps = _connection.prepareStatement("INSERT INTO ON_THE_PLATFORM (ID_GAME, ID_PLATFORM) VALUES (?,?)");
                        _ps.setInt(1, Integer.parseInt(String.valueOf(_game.getId_game())));
                        _ps.setInt(2, Integer.parseInt(data.get("id_platform").toString()));
                         if(_ps.executeUpdate() == 1){
                            System.out.println("Game has been added to on_the_platform");                                                 
                        }
                        
                        System.out.println("New game has been added");
                                               
					}
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(ArrayList<Integer> id, Map<String, ?> data) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(ArrayList<Integer> id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<?> getAll() {
		// TODO Auto-generated method stub
		return null;
	}



	

	

}
