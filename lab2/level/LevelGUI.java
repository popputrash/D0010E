
package lab2.level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class LevelGUI implements Observer {

	private Level lv;
	private Display d;
	
	public LevelGUI(Level level, String name) {
		
		this.lv = level;
		
		JFrame frame = new JFrame(name);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// TODO: You should change 200 to a value 
		// depending on the size of the level
		d = new Display(lv,300,300);
		
		frame.getContentPane().add(d);
		frame.pack();
		frame.setLocation(0,0);
		frame.setVisible(true);

	}
	
	
	public void update(Observable arg0, Object arg1) {
		d.repaint();
	}
	
	private class Display extends JPanel {
		
		public Display(Level fp, int x, int y) {
		
			
			addKeyListener(new Listener());
			
			setBackground(Color.black);
			setPreferredSize(new Dimension(x+20,y+20));
			setFocusable(true);
		}
	
		
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			drawRooms(g);
			drawConnections(g);
			drawLocation(g);
		}
		
		
		//går igenom alla rum och ritar en rektangel
		private void drawRooms(Graphics g){
			for (Room room  : lv.rooms) {
				g.setColor(room.color);
				g.drawRect(room.x, room.y, room.width, room.height);
				
			}
		}
		
		//går igenom alla rum o dess connections och ritar ett streck mellan rummet och connectionen.
		private void drawConnections(Graphics g){
			g.setColor(Color.WHITE);
			for (Room room : lv.rooms) {
				if(room.roomEast != null){
					g.drawLine(room.x + room.width/2 , room.y + room.height/2, room.roomEast.x + room.roomEast.width/2, room.roomEast.y + room.roomEast.height/2);
				}
				if(room.roomWest != null){
					g.drawLine(room.x + room.width/2 , room.y + room.height/2, room.roomWest.x + room.roomWest.width/2, room.roomWest.y + room.roomWest.height/2);
				}			
				if(room.roomSouth != null){
					g.drawLine(room.x + room.width/2 , room.y + room.height/2, room.roomSouth.x + room.roomSouth.width/2, room.roomSouth.y + room.roomSouth.height/2);
				}
				if(room.roomNorth != null){
					g.drawLine(room.x + room.width/2 , room.y + room.height/2, room.roomNorth.x + room.roomNorth.width/2, room.roomNorth.y + room.roomNorth.height/2);
				}
			}
		}

		//ritar en cirkel i de rummet där man befinner sig.
		private void drawLocation(Graphics g){
			g.setColor(Color.CYAN);
			g.drawOval(lv.location.x + lv.location.width/2 - 5, lv.location.y + lv.location.height/2 - 5, 10, 10);

		}

	 	private class Listener implements KeyListener {

	 		
	 		public void keyPressed(KeyEvent arg0) {
	 		}

	 		public void keyReleased(KeyEvent arg0) {
				 
	 		}

	 		//om WASD blir tryckt försöker programet gå åt de hållet och ritar om JFramen.
	 		
	 		public void keyTyped(KeyEvent event) {
				 
				switch (event.getKeyChar()){
					case 'w':
						lv.changeLocationNorth();
						d.repaint();
						break;					
					case 'a':
						lv.changeLocationWest();
						d.repaint();
						break;
					case 's':
						lv.changeLocationSouth();
						d.repaint();
						break;
					case 'd':
						lv.changeLocationEast();
						d.repaint();
						break;
					default:
						break;
				}

	 		}
	 	}

	}
	
}
