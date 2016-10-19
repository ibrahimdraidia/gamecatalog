package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;

import entity.Developer;
import interfaces.CrudInterface;

public class DeveloperHandler extends Database implements CrudInterface{

	private Connection _connection;
	private PreparedStatement _ps;
	private Statement _s;
	private ResultSet _rs;
	
	/*
	 * Connect db
	 */
	public DeveloperHandler() {
		_connection = getInstance();
	}
	
	/*
	 * Add Developer
	 */
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
					System.out.println("Developer has been added ;) "); 
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void update(ArrayList<Integer> id, Map<String, ?> data) {
		// TODO Auto-generated method stub
		if(data != null && data.size() != 0)
		{
			if(id.size() != 0)
			{
				for (int i = 0; i < id.size(); i++) {
					try {
						_ps = _connection.prepareStatement
								("UPDATE DEVELOPER SET NAME_DEV = ? WHERE ID_DEV = ?");
						
						_ps.setString(1, data.get("name_dev").toString());
						_ps.setInt(2, id.get(i));
						
						
						if(_ps.executeUpdate() == 1)
						{
							System.out.println("Developer has been updated ;) "); 
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
              for (int i = 0; i < id.size(); i++){
                      try {
                              _ps = _connection.prepareStatement
                                              ("DELETE FROM DEVELOPER WHERE ID_DEV = ?");

                              _ps.setInt(1, id.get(i));

                              if(_ps.executeUpdate() == 1)
                              {
                                      System.out.println("Developer with " + String.valueOf(id.get(i)) + " has been deleted ;) "); 
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

					if(_s.execute("SELECT * FROM DEVELOPER"))
					{
						// temp platform obj
						Developer temp;
						
						// get result
						_rs = _s.getResultSet();
						
						while(_rs.next())
						{
							temp = new Developer();
							temp.setId_developer(_rs.getInt("ID_DEV"));
							temp.setDeveloper_name(_rs.getString("NAME_DEV"));
							
							tempList.add(temp);
						}
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return tempList;
	}

	
}
