/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


/**
 *
 * @author CARLOS
 */
public class circleclicklistener extends MouseAdapter{
private Personaje raqueta;

    public circleclicklistener(Personaje raqueta) {
        this.raqueta = raqueta;
    }

   @Override
    public void mouseClicked(MouseEvent e) {
       raqueta.xa=e.getX();
       raqueta.ya=e.getY();
       raqueta.m=e.getY()-raqueta.y/e.getX()-raqueta.x;
       if(raqueta.ya>raqueta.y){
           raqueta.bajar=true;
       }else{
          raqueta.bajar=false; 
       }
       if(raqueta.xa<raqueta.x){
           raqueta. retroceder=true;
       }else{
          raqueta. retroceder=false; 
       }
       raqueta.iniciado=true;
       raqueta.setDesplazar(true);
               
    }
    
}
