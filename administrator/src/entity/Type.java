/*
 * Type, could be this could be that ...
 */
package entity;

import java.util.ArrayList;

/**
 *
 * @author iain
 */
public class Type 
{
	private int _id_type;
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

}
