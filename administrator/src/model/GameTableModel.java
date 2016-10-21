package model;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

import db.GameHandler;
import entity.Game;

public class GameTableModel extends AbstractTableModel{

	private final String[] _header = { "Game", "Editor", "Dev Team", "Platfrom", "Type",};
	
	private ArrayList<Game> listGame;
	
	
	@SuppressWarnings("unchecked")
	public GameTableModel() {
		listGame = (ArrayList<Game>)new GameHandler().getAll();
		System.out.println(listGame.size());
	}
	@Override
	public int getColumnCount() {
		return _header.length;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return _header[column];
	}

	@Override
	public TableModelListener[] getTableModelListeners() {
		// TODO Auto-generated method stub
		return super.getTableModelListeners();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		
	}

	@Override
	public int getRowCount() {
		return listGame.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {

		Game game = listGame.get(rowIndex);
		
		switch (columnIndex) {
		case 0: // game name
			return game.getNom_game();
			
			
		case 1: // name editor
			return game.getEditor_name();
			
			
		case 2: //name dev
			return game.getDeveloper_name();
			
			
		case 3: // name plat
			return game.getName_platform();
			
			
		case 4: // name typep
			return game.get_name_type();
			

		default: throw new IllegalArgumentException("C'est pas au menu ;) ");
			
		}
		
	}

}
