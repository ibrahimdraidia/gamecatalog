package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import entity.Platform;
import interfaces.CrudInterface;

public class PlatformHandler extends Database implements CrudInterface{

	private Connection _connection;
	private PreparedStatement _ps;
	private Statement _s;
	private ResultSet _rs;
	
	public PlatformHandler() {
		_connection = getInstance();
	}
	@Override
	public void add(Map<String, ?> data) {
		if(data != null && data.size() != 0)
		{
			try {
				_ps = _connection.prepareStatement
						("INSERT INTO PLATFORM(ID_PLATFORM,NAME_PLATFORM) VALUES(?,?)");
				
				_ps.setInt(1, 0);
				_ps.setString(2, data.get("name_platform").toString());
				
				if(_ps.executeUpdate() == 1)
				{
					System.out.println("Platform has been added ;) "); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(ArrayList<Integer> id, Map<String, ?> data) {
		if(data != null && data.size() != 0)
		{
			if(id.size() != 0)
			{
				for (int i = 0; i < id.size(); i++) {
					try {
						_ps = _connection.prepareStatement
								("UPDATE PLATFORM SET NAME_PLATFORM = ? WHERE ID_PLATFORM = ?");
						
						_ps.setString(1, data.get("name_platform").toString());
						_ps.setInt(2, id.get(i));
						
						
						if(_ps.executeUpdate() == 1)
						{
							System.out.println("Platform has been updated ;) "); 
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
                }
	}

	@Override
	public void remove(ArrayList<Integer> id) {
		if(id != null && id.size() != 0)
		{
            for (int i = 0; i < id.size(); i++)
            {
                    try 
                    {
                            _ps = _connection.prepareStatement
                                            ("DELETE FROM PLATFORM WHERE ID_PLATFORM = ?");

                            _ps.setInt(1, id.get(i));

                            if(_ps.executeUpdate() == 1)
                            {
                                    System.out.println("Platform with " + String.valueOf(id.get(i)) + " has been deleted ;) "); 
                            }
                    } catch (SQLException e) {
                            e.printStackTrace();
                    }
            }
		}
	}
	@Override
	public ArrayList<?> getAll() {
		
		// temp arrayList
		ArrayList<Object> tempList = new ArrayList<>();
		
		try {
			_s = _connection.createStatement();

			if(_s.execute("SELECT * FROM PLATFORM"))
			{
				// temp platform obj
				Platform temp;
				
				// get result
				_rs = _s.getResultSet();
				
				while(_rs.next())
				{
					temp = new Platform();
					temp.setId_platform(_rs.getInt("ID_PLATFORM"));
					temp.setName_platform(_rs.getString("NAME_PLATFORM"));
					
					tempList.add(temp);
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempList;
	}

	

}
