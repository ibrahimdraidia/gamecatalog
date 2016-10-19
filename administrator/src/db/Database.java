package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Database 
{
	
	private String _dbhost;
	private String _dbname;
	private String _username;
	private String _password;
	private String _url;
	private Connection _connection;
	
	public Database()
	{
		_dbhost = "localhost";
		_dbname = "gamecatalog";
		_username = "root";
		_password = "pass";
		_url = "jdbc:mysql://"+_dbhost+"/"+_dbname+"?useSSL=false";
	}
	
	public Connection getInstance()
	{
		if(_connection == null)
		{
			try {
				Class.forName( "com.mysql.jdbc.Driver" );
				Connection conn = DriverManager.getConnection(_url,_username,_password);
				_connection = conn;

			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error"+ e.getMessage(),"Mysql",JOptionPane.ERROR_MESSAGE);
				System.exit(0);
			} catch (ClassNotFoundException e) {
				JOptionPane.showMessageDialog(null, "Error"+ e.getMessage(),"Mysql",JOptionPane.ERROR_MESSAGE);
			}
		}		
		return _connection;
	}

}
