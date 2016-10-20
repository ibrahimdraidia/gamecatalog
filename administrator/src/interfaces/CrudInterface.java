package interfaces;


import java.util.ArrayList;
import java.util.Map;


public interface CrudInterface {
	
	public void add(Map<String, ?> data);
	public void update(ArrayList<Integer> id, Map<String, ?> data);
	public void remove(ArrayList<Integer> id);
	public ArrayList<?> getAll();

}
