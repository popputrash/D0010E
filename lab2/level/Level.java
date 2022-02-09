
package lab2.level;

import java.util.ArrayList;
import java.util.Observable;


public class Level extends Observable {
	
	Room location;

	ArrayList<Room> rooms = new ArrayList<Room>();
	
	//place funktion som kollar om n�got annat rum skulle �verlappa med de som blir tillagt.
	//kollar om x koordinat lf�r b�da sidor av rummet ligger innanf�r n�got annat rums koordinat
	//g�r samma f�r y koordinater och ifall de inte ligger i l�ggs rummet till i rum listan.
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
	
	//s�tter first location till ett specifierat rum
	public void firstLocation(Room r) {
		this.location = r;
	}

	
	//f�rs�ker byta rum i en riktning, om det inte finns ett rum �t de h�llet h�nder inget.
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
