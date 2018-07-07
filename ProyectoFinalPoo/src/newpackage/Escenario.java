/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;


import Imagenes.Gui;
import javax.swing.JLabel;

public class Escenario {
	
	int x = 0;
	int y = 0;
	
	private Gui game;
         public JLabel label;
       

	public Escenario(Gui game,int x,JLabel label) {
             
		this.game= game;
                this.x=x;
                this.label=label;
	}

	public void move() {
		x=x-1;
                label.setLocation(x, y);
                if(x==-600){
                    x=1200;
                }

	}


        
}