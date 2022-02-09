
package lab2.level;

import java.util.ArrayList;
import java.util.Observable;


public class Level extends Observable {
	
	Room location;

	ArrayList<Room> rooms = new ArrayList<Room>();
	
	//place funktion som kollar om något annat rum skulle överlappa med de som blir tillagt.
	//kollar om x koordinat lför båda sidor av rummet ligger innanför något annat rums koordinat
	//gör samma för y koordinater och ifall de inte ligger i läggs rummet till i rum listan.
	public boolean place(Room r, int x, int y)  {		
		for ( Room room : rooms){
			if (!((x + r.width <= room.x || x >= room.x + room.width) || (y + r.height <= room.y || y >= room.y + room.height))){				
				System.out.println("overlaps");
				return false;			
			}
		}

		r.x = x;
		r.y = y;
		rooms.add(r);
		return true;
	}
	
	//sätter first location till ett specifierat rum
	public void firstLocation(Room r) {
		this.location = r;
	}

	
	//försöker byta rum i en riktning, om det inte finns ett rum åt de hållet händer inget.
	public void changeLocationNorth(){
		if(location.roomNorth != null){
			location = location.roomNorth;
		}
	}
	public void changeLocationSouth(){
		if(location.roomSouth != null){
			location = location.roomSouth;
		}
	}
	public void changeLocationWest(){
		if(location.roomWest != null){
			location = location.roomWest;
		}
	}
	public void changeLocationEast(){
		if(location.roomEast != null){
			location = location.roomEast;
		}
	}
	

}
