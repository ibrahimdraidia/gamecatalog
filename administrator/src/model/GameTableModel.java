package model;

import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

public class GameTableModel extends AbstractTableModel{

	private final String[] _header = { "Game", "Editor", "Dev Team", "Platfrom", "Type",};
	
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
		// TODO Auto-generated method stub
		super.setValueAt(aValue, rowIndex, columnIndex);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

}
