/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author CARLOS
 */
public class circleclicklistener extends MouseAdapter{
  private jugador dragon;

    public circleclicklistener(jugador dragon) {
        this.dragon = dragon;
    }
  
   @Override
    public void mouseClicked(MouseEvent e) {
//        int m,x,x1,y = 400,y1;
//        x=dragon.getAnimal().getX();
//            m=((dragon.getAnimal().getY()-e.getY())/(dragon.getAnimal().getX()-e.getX()));
//        while(dragon.getAnimal().getX() < e.getX() && dragon.getAnimal().getY() < e.getY()){
//        
//            y=e.getY()+(m*(x-e.getX()));
//              dragon.getAnimal().setLocation(x,y);
//              x=x+10;
//        
//        }  
//          dragon.getAnimal().setLocation(x,y);
        dragon.setX(e.getX()-100);
        dragon.setY(e.getY()-100);


//
//             
           
         }
      
    }
    

