package main;
import java.util.HashMap;
import java.util.Map;

import db.DeveloperHandler;
import db.GameHandler;
import view.MainWindow;


public class Main {

	public static void main(String[] args) 
	{
		GameHandler game = new GameHandler();
		DeveloperHandler developer = new DeveloperHandler();
		
		Map<String,Object> map = new HashMap<String, Object>();
		Map<String,Object> dev = new HashMap<String, Object>();
		map.put("name_game", "MErde je ne sais pas");
		map.put("pic_url", 243242);
		map.put("summary_game", "bref c'est de la merde");
		
		dev.put("name_dev", "Google vs Oracle vs Microsoft");
		
		System.out.println("Here we go !");
		
		game.add(map);
		developer.add(dev);
		
		
		MainWindow start = new MainWindow();
	}
}
