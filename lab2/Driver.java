package lab2;

import java.awt.Color;

import lab2.level.Level;
import lab2.level.LevelGUI;
import lab2.level.Room;

public class Driver {

	Level level = new Level();
	
	@SuppressWarnings("unused")
	public void run() {

		
		
		Room room1 = new Room(40, 60, Color.BLUE);
		Room room2 = new Room(40, 60, Color.RED);
		Room room3 = new Room(40, 60, Color.GREEN);
		Room room4 = new Room(40, 60, Color.YELLOW);
		Room room5 = new Room(40, 60, Color.MAGENTA);
		Room room6 = new Room(40, 60, Color.ORANGE);
		Room room7 = new Room(40, 60, Color.ORANGE);

		room1.connectEastTo(room2);
		room2.connectSouthTo(room4);
		room2.connectEastTo(room3);
		room2.connectWestTo(room1);
		room3.connectWestTo(room2);
		room4.connectNorthTo(room2);
		room4.connectEastTo(room5);
		room5.connectWestTo(room4);
		room5.connectNorthTo(room6);
		room6.connectSouthTo(room5);

		level.place(room1, 20, 20);
		level.place(room2, 80, 20);
		level.place(room3, 140, 20);
		level.place(room4, 80, 200);
		level.place(room5, 240, 200);
		level.place(room6, 240, 100);
		level.place(room7, 20, 20);
		
		level.firstLocation(room2);

		LevelGUI lGui = new LevelGUI(level, "level");

		


	}
}