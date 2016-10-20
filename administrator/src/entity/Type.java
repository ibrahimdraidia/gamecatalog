/*
 * Type, could be this could be that ...
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author GamyCats
 */
public class Type 
{
	private int _id_type;
	private String _name_type;
	
	public String get_name_type() {
		return _name_type;
	}

	public void set_name_type(String _name_type) {
		this._name_type = _name_type;
	}

	private ArrayList<String> _type;
	
	public Type()
	{
	}

	public int getId_type()
	{
		return _id_type;
	}

	public void setId_type(int _id_type)
	{
		this._id_type = _id_type;
	}

	public ArrayList<String> getType()
	{
		return _type;
	}

	public void setType(ArrayList<String> _type)
	{
		this._type = _type;
	}

	@Override
	public String toString() {
		
		return _name_type;
	}
	
	

}
