package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map;

import entity.Developer;
import entity.Editor;
import entity.Platform;
import entity.Type;
import interfaces.CrudInterface;

public  class TypeHandler extends Database implements CrudInterface{

	private Connection _connection;
	private PreparedStatement _ps;
	private Statement _s;
	private ResultSet _rs;
	
	/*
	 * Connect db.
	 */
	public TypeHandler() {
		_connection = getInstance();
	}

	/*
     * Add platform.
     */
	@Override
	public void add(Map<String, ?> data) {
		if(data != null && data.size() != 0)
		{
			try {
				_ps = _connection.prepareStatement
						("INSERT INTO GENRE(ID_GENRE,NAME_GENRE) VALUES(?,?)");
				
				_ps.setInt(1, 0);
				_ps.setString(2, data.get("name_genre").toString());
				
				if(_ps.executeUpdate() == 1)
				{
					System.out.println("Genre has been added ;) "); 
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
								("UPDATE GENRE SET NAME_GENRE = ? WHERE ID_GENRE = ?");
						
						_ps.setString(1, data.get("name_genre").toString());
						_ps.setInt(2, id.get(i));
						
						
						if(_ps.executeUpdate() == 1)
						{
							System.out.println("Genre has been updated ;) "); 
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
		// TODO Auto-generated method stub
                 if(id != null && id.size() != 0){
                        for (int i = 0; i < id.size(); i++){
                                try {
                                        _ps = _connection.prepareStatement
                                                        ("DELETE FROM GENRE WHERE ID_GENRE = ?");

                                        _ps.setInt(1, id.get(i));

                                        if(_ps.executeUpdate() == 1)
                                        {
                                                System.out.println("Genre with " + String.valueOf(id.get(i)) + " has been deleted ;) "); 
                                        }
                                } catch (SQLException e) {
                                        e.printStackTrace();
                                }
                        }
                }
		
	}

	@Override
	public ArrayList<?> getAll() {
		
				ArrayList<Type> tempList = new ArrayList<>();
				try {
					_s = _connection.createStatement();

					if(_s.execute("SELECT * FROM GENRE"))
					{
						// temp platform obj
						Type temp;
						
						// get result
						_rs = _s.getResultSet();
						
						while(_rs.next())
						{
							temp = new Type();
							temp.setId_type(_rs.getInt("ID_GENRE"));
							temp.set_name_type(_rs.getString("NAME_GENRE"));
							
							tempList.add(temp);
						}
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return tempList;
	}


}

