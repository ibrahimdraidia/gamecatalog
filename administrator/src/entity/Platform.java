/*
 * It is wot the games run on init ...
 */
package entity;

/**
 *
 * @author iain
 */
public class Platform extends Type
{
	private int _id_platform;
	private String _platform;

	public Platform()
	{
	}

	public int getId_platform()
	{
		return _id_platform;
	}

	public void setId_platform(int _id_platform)
	{
		this._id_platform = _id_platform;
	}

	public String getPlatform()
	{
		return _platform;
	}

	public void setPlatform(String _platform)
	{
		this._platform = _platform;
	}

}
