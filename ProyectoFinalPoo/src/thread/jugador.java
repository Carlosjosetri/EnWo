/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import gui.Gui;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JLabel;
/**
 *
 * @author LN710Q
 */
public class jugador extends Thread {
    private String nombre;
    public int limite,x,y,x1,y1;
    private JLabel animal;
   
    public Gui gui;
    
    public int cont;
    public jugador() {
    }

    public jugador(String nombre, int limite, int x, int y, JLabel animal) {
        this.nombre = nombre;
        this.limite = limite;
        this.x = x;
        this.y = y;
        this.animal = animal;

    }
    
     @Override
     public void run(){
         x1=getAnimal().getX();
         y1=getAnimal().getY();
      while(true){
          if(getAnimal().getX()!=x){
              System.out.println("hola");
          }
    getAnimal().setLocation(x, y);
          
    
      }
     }

    public JLabel getAnimal() {
        return animal;
    }

    public void setAnimal(JLabel animal) {
        this.animal = animal;
    }
 


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
