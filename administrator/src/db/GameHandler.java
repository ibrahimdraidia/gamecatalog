package db;

import java.sql.Connection;

import interfaces.CrudInterface;

public class GameHandler extends Database implements CrudInterface{
	
	private Connection _connection;
	
	public GameHandler() {
		_connection = getInstance();
	}

	@Override
	public void add() {
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAll() {
		// TODO Auto-generated method stub
		
	}

}
