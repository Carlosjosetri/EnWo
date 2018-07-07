/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Imagenes.Gui;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class Jefe {
	private static final int DIAMETER = 170;
	public int x = 8000;
	int y = -70;
	int xa = -1;
	int ya = 1;
	private Gui game;
         public JLabel label;
public static long timeBetweenDucks = 1000000000L / 2;
public static long lastDuckTime = 0;
public static long timeBetweenDucks2 = 1000000000L / 2;
public static long lastDuckTime2 = 0;
	public Jefe(Gui game,JLabel label,int x) {
            
		this.game= game;
                this.x=x;
                this.label=label;
	}

	public void move() {
		
	
                label.setLocation(x , y);
           
               if(x>600){
                   x = x - 1;
               } 
		
		
	}

	private boolean collision() {
		return game.Character.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x+90, y+120, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x+90, y+120, DIAMETER, DIAMETER);
	}
        
}