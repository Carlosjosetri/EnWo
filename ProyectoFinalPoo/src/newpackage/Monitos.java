/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import Imagenes.Gui;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import javax.swing.JLabel;

public class Monitos {
	private static final int DIAMETER = 55;
	public int x = 1000;
	int y = 0;
	int xa = -1;
	int ya = 1;
	private Gui game;
         public JLabel label;
public static long timeBetweenDucks = 1000000000L / 2;
public static long lastDuckTime = 0;
public static long timeBetweenDucks2 = 1000000000L / 2;
public static long lastDuckTime2 = 0;
	public Monitos(Gui game,int y,JLabel label) {
            
		this.game= game;
                this.y=y;
                this.label=label;
	}

	public void move() {
		
		if (x + xa > game.getWidth() - DIAMETER)
                    
			xa = -1;
		if (y + ya < 0)
			ya = 1;
		if (y + ya > game.getHeight() - DIAMETER)
			ya = -1;
//			y = game.racquet.getTopY() - DIAMETER;
		if (collision()){
                    game.vida-=1;
		game.gameOver();
		}
           
                label.setLocation(x + xa-30, y + ya-50);
		x = x + xa;
		y = y + ya;
	}

	private boolean collision() {
		return game.racquet.getBounds().intersects(getBounds());
	}

	public void paint(Graphics2D g) {
		g.fillOval(x, y, DIAMETER, DIAMETER);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETER, DIAMETER);
	}
        
}