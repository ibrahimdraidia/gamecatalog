/*
 * 
 */
package entity;

import java.util.ArrayList;

public class Developer extends Platform
{
	private ArrayList<Developer> _listDev;
	private int _id_developer;
	
	public int getId_developer()
	{
		return _id_developer;
	}


	public void setId_developer(int _id_developer)
	{
		this._id_developer = _id_developer;
	}


	public String getDeveloper_name()
	{
		return _developer_name;
	}


	public void setDeveloper_name(String _developer_name)
	{
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
	
	@Override
	public String toString() {
		
		return _developer_name;
	}

}
