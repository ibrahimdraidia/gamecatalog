package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
						("INSERT INTO GAME(ID_GAME,NAME_GAME,PIC_GAME,SUMMARY_GAME) VALUES(?,?,?,?)");
				
				_ps.setInt(1, 0);
				_ps.setString(2, data.get("name_game").toString());
				_ps.setString(3, data.get("pic_url").toString());
				_ps.setString(4, data.get("summary_game").toString());
				
				if(_ps.executeUpdate() == 1)
				{
					System.out.println("Game  has been added ;) "); 
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