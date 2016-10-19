package main;


import view.MainWindow;


public class Main {

	public static void main(String[] args) 
	{
<<<<<<< HEAD
		new MainWindow();
=======
		GameHandler game = new GameHandler();
		DeveloperHandler developer = new DeveloperHandler();
		EditorHandler editor = new EditorHandler ();
		PlatformHandler platform = new PlatformHandler ();
		
		/*
		 * Tempory data
		 */
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> dev = new HashMap<String, Object>();
		Map<String,Object> edit = new HashMap<String, Object>();
		Map<String, Object> pf = new HashMap<String, Object>();
		Map<String, Object> updateMap = new HashMap<String, Object>();
		
		ArrayList<Integer> listeID = new ArrayList<>();
		
		listeID.add(2);
		
		updateMap.put("name_dev", "pute pute pute");
		
		/*
		map.put("name_game", "MErde je ne sais pas");
		map.put("release_date", "1985-05-29");
		map.put("pic_url", "fdsfdsfsdfsd");
		map.put("summary_game", "bref c'est de la merde");
		
		dev.put("name_dev", "Google vs Oracle vs Microsoft");
		
		edit.put("name_editor", "Team Rocket");
		
		pf.put("name_platform", "super console");
				
		System.out.println("Here we go !");
		
		
		game.add(map);
		developer.add(dev);
		editor.add(edit);
		platform.add(pf);
		*/
		developer.update(listeID, updateMap);
		
		
		MainWindow start = new MainWindow();
>>>>>>> c5f0f5f53a07bff7c38a3bbecff69545b59f1847
	}
}
