package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import interfaces.CrudInterface;

public class GameHandler extends Database implements CrudInterface{
	
	private Connection _connection;
	private PreparedStatement _ps;
	private ResultSet _rs;
	
	public GameHandler() {
		_connection = getInstance();
	}

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
				_ps.setString(4, data.get("pic_url").toString());
				_ps.setString(5, data.get("summary_game").toString());
				
				if(_ps.executeUpdate() == 1)
				{
					System.out.println("Game  has been added ;) ");
					_rs = _ps.getGeneratedKeys();
					if(_rs.next())
					{
						long id = _rs.getLong(1);
						System.out.println("The new game ID: " + id);
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
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

	

	

}
