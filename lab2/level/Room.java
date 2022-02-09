
package lab2.level;

import java.awt.Color;


public class Room { 
	Color color;
	int width,  height;
	int x, y;

	Room roomNorth = null, roomSouth = null, roomEast =  null , roomWest = null;
	
	public Room(int width, int height, Color color) {
		this.color = color;
		this.width = width;
		this.height = height;
	}

	public void connectNorthTo(Room r) {
		roomNorth = r;
	}
	public void connectEastTo(Room r) {
		roomEast = r;
	}
	public void connectSouthTo(Room r) {
		roomSouth = r;
	}
	public void connectWestTo(Room r) {
		roomWest = r;
	}


}
