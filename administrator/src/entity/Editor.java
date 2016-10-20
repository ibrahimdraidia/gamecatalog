package entity;

public class Editor  extends Developer
{
	private int _id_editor;
	private String _editor_name;
	
	public int getId_editor()
	{
		return _id_editor;
	}
	
	public void setId_editor(int _id_editor)
	{
		this._id_editor = _id_editor;
	}

	public String getEditor_name()
	{
		return _editor_name;
	}

	public void setEditor_name(String _editor_name)
	{
		this._editor_name = _editor_name;
	}
	
	@Override
	public String toString() {
		
		return _editor_name;
	}
}
