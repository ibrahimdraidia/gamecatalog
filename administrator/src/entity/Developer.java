package entity;

import java.util.ArrayList;

public class Developer 
{
	private ArrayList<Developer> _listDev;
	private int _id_developer;
	
	public int get_id_developer() {
		return _id_developer;
	}


	public void set_id_developer(int _id_developer) {
		this._id_developer = _id_developer;
	}


	public String get_developer_name() {
		return _developer_name;
	}


	public void set_developer_name(String _developer_name) {
		this._developer_name = _developer_name;
	}


	private String _developer_name;
	

	public Developer()
	{
		_listDev = new ArrayList<>();
	}
	
	
	public ArrayList<Developer> getListDevelopers()
	{
		
		return _listDev;
	}
	

}
