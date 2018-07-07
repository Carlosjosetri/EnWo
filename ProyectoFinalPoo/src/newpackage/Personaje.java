/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class Personaje {

    private static final int WITH = 60;
    private static final int HEIGHT = 10;
    int x = 0;
    int xa = 0;
    int y = 500;
    int ya = 500;
    int m=0;
    private boolean desplazar;
    private JLabel label;
    private JLabel label2;
    private Game game;
    public boolean bajar;
    public boolean retroceder;
    public boolean iniciado;
    public Personaje(Game game) {
        this.game = game;
        desplazar = false;
        bajar=false;
        retroceder=false;
        iniciado=false;
    }

    public boolean isDesplazar() {
        return desplazar;
    }

    public void setDesplazar(boolean desplazar) {
        this.desplazar = desplazar;
    }

    public void move() {
 if(iniciado==false){
     label.setLocation(10 , 400);
     label2.setLocation(10 , 400);
     label.setVisible(true);
     label2.setVisible(false);
 }else{
if(bajar==false){
    label2.setVisible(true);
     label.setVisible(false);
        if (y + ya > 0 && y > 30 ) {
            if(retroceder==false){
             if (x <xa  ) {
            if (desplazar) {
                label.setLocation(label.getX() + 5, label.getY());
                label2.setLocation(label2.getX() + 5, label2.getY());
                x = x + 5;
            }
        }

            }if(retroceder==true){
                      if (x > xa  ) {
            if (desplazar) {
                label.setLocation(label.getX() - 5, label.getY());
                label2.setLocation(label2.getX() - 5, label2.getY());
                x = x - 5;
            }
        }
            }
            if (desplazar) {
                label.setLocation(label.getX(), label.getY() - 5);
                label2.setLocation(label2.getX(), label2.getY() - 5);
                y = y - 5;
            }
        }
}
if(bajar==true){
     label.setVisible(true);
     label2.setVisible(false);
        if (y< 500 ) {
            if(retroceder==false){
             if (x <xa   ) {
            if (desplazar) {
                label.setLocation(label.getX() + 5, label.getY());
                label2.setLocation(label2.getX() + 5, label2.getY());
                x = x + 5;
            }
        }

            }if(retroceder==true){
                      if (x > xa ) {
            if (desplazar) {
                label.setLocation(label.getX() - 5, label.getY());
                label2.setLocation(label2.getX() - 5, label2.getY());
                x = x - 5;
            }
        }
            }
            if (desplazar) {
                label.setLocation(label.getX(), label.getY() + 5);
                label2.setLocation(label2.getX(), label2.getY() + 5);
                y = y + 5;
            }
        }

}

 }
       
        
        
    }

    public void move2(MouseEvent evento) {

//	x=evento.getX();
//        y=evento.getYOnScreen();
//            System.out.println(evento.getPoint());
    }

    public void paint(Graphics2D g) {
        g.fillRect(x, y, WITH, HEIGHT);
    }

    public void keyReleased(KeyEvent e) {
        xa = 0;
        ya = 0;
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            xa = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            xa = 1;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            ya = -1;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            ya = 1;
        }

    }

    public JLabel getlabel() {
        return label;
    }

    public void setlabel(JLabel label) {
        this.label = label;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, WITH, HEIGHT);
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

}
