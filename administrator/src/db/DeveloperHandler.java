package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import interfaces.CrudInterface;

public class DeveloperHandler extends Database implements CrudInterface{

	private Connection _connection;
	private PreparedStatement _ps;
	private ResultSet _rs;
	
	public DeveloperHandler() {
		_connection = getInstance();
	}
	@Override
	public void add(Map<String, ?> data) {
		if(data != null && data.size() != 0)
		{
			try {
				_ps = _connection.prepareStatement
						("INSERT INTO DEVELOPER(ID_DEV,NAME_DEV) VALUES(?,?)");
				
				_ps.setInt(1, 0);
				_ps.setString(2, data.get("name_dev").toString());
				
				if(_ps.executeUpdate() == 1)
				{
					System.out.println("Developer  has been added ;) "); 
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
