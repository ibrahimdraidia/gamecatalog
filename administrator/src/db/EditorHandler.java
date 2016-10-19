package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;


import entity.Editor;
import interfaces.CrudInterface;

/*
 * Add editor.
 */
public class EditorHandler extends Database implements CrudInterface{

	private Connection _connection;
	private PreparedStatement _ps;
	private Statement _s;
	private ResultSet _rs;
	
	/*
	 * Connect database.
	 */
	public EditorHandler() {
		_connection = getInstance();
	}
<<<<<<< HEAD
	
=======

	/*
	 * Add Editor.
	 */
>>>>>>> c5f0f5f53a07bff7c38a3bbecff69545b59f1847
	@Override
	public void add(Map<String, ?> data) {
		if(data != null && data.size() != 0)
		{
			try {
				_ps = _connection.prepareStatement
						("INSERT INTO EDITOR(ID_EDITOR,NAME_EDITOR) VALUES(?,?)");
				
				_ps.setInt(1, 0);
				_ps.setString(2, data.get("name_editor").toString());
				
				if(_ps.executeUpdate() == 1)
				{
					System.out.println("Editor  has been added ;) "); 
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
								("UPDATE EDITOR SET NAME_EDITOR = ? WHERE ID_EDITOR = ?");
						
						_ps.setString(1, data.get("name_editor").toString());
						_ps.setInt(2, id.get(i));
						
						
						if(_ps.executeUpdate() == 1)
						{
							System.out.println("Editor has been updated ;) "); 
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
		if(id != null && id.size() != 0){
            for (int i = 0; i < id.size(); i++){
                    try {
                            _ps = _connection.prepareStatement
                                            ("DELETE FROM EDITOR WHERE ID_EDITOR = ?");

                            _ps.setInt(1, id.get(i));

                            if(_ps.executeUpdate() == 1)
                            {
                                    System.out.println("Editor with " + String.valueOf(id.get(i)) + " has been deleted ;) "); 
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

			if(_s.execute("SELECT * FROM EDITOR"))
			{
				// temp platform obj
				Editor temp;
				
				// get result
				_rs = _s.getResultSet();
				
				while(_rs.next())
				{
					temp = new Editor();
					temp.setId_platform(_rs.getInt("ID_EDITOR"));
					temp.setName_platform(_rs.getString("NAME_EDITOR"));
					
					tempList.add(temp);
				}
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tempList;
	}

	
}

