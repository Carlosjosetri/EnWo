/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;

import Imagenes.Gui;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JLabel;

public class Personaje {

    private static final int WITH = 60;
    private static final int HEIGHT = 90;
    int x = 0;
    int xa = 0;
    int y = 500;
    int ya = 500;
    int m = 0;
    public static long timeBetween = 1000000000L / 2;
    public static long lastTime = 0;

    private ArrayList<PlayerShoot> disparos;
    public boolean disparar;
    private boolean desplazar;
    private JLabel label;
    private JLabel label2;
    private Gui game;
    public boolean bajar;
    public boolean retroceder;
    public boolean recargar;
    public boolean iniciado;

    public Personaje(Gui game) {
        this.game = game;
        desplazar = false;
        bajar = false;
        retroceder = false;
        iniciado = false;
        disparar = false;
        recargar = true;

    }

    public boolean isDesplazar() {
        return desplazar;
    }

    public void setDesplazar(boolean desplazar) {
        this.desplazar = desplazar;
    }

    public void move() {
        if (iniciado == false) {
            label.setLocation(10, 400);
            label2.setLocation(10, 400);
            label.setVisible(true);
            label2.setVisible(false);
        } else {
            if (bajar == false) {
                label2.setVisible(true);
                label.setVisible(false);
                if (y + ya > 0 && y > 30) {
                    if (retroceder == false) {
                        if (x < xa) {
                            if (desplazar) {
                                label.setLocation(label.getX() + 5, label.getY());
                                label2.setLocation(label2.getX() + 5, label2.getY());
                                x = x + 5;
                            }
                        }

                    }
                    if (retroceder == true) {
                        if (x > xa) {
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
            if (bajar == true) {
                label.setVisible(true);
                label2.setVisible(false);
                if (y < 500) {
                    if (retroceder == false) {
                        if (x < xa) {
                            if (desplazar) {
                                label.setLocation(label.getX() + 5, label.getY());
                                label2.setLocation(label2.getX() + 5, label2.getY());
                                x = x + 5;
                            }
                        }

                    }
                    if (retroceder == true) {
                        if (x > xa) {
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
        if (disparos == null) {
            disparos = new ArrayList<>();
        }
        if (System.nanoTime() - lastTime >= timeBetween * 4) {

            recargar = true;
            lastTime = System.nanoTime();
        }
        if (disparar) {
            if (recargar) {
                disparos.add(new PlayerShoot(getGame(), y, x, getGame().CrearDisparos()));
               
                disparar = false;
                recargar = false;
            }else{
                disparar = false;
            }
            
        }
        for (int i = 0; i < disparos.size(); i++) {
            disparos.get(i).move();
            if (disparos.get(i).x >= 1200) {
                disparos.remove(i);
            }
         
        }

    }

    public void move2(MouseEvent evento) {

//	x=evento.getX();
//        y=evento.getYOnScreen();
//            System.out.println(evento.getPoint());
    }

    public void paint(Graphics2D g) {
        g.fillRect(x + 60, y, WITH, HEIGHT);
    }

    public ArrayList<PlayerShoot> getDisparos() {
        return disparos;
    }

    public void setDisparos(ArrayList<PlayerShoot> disparos) {
        this.disparos = disparos;
    }

    public JLabel getlabel() {
        return label;
    }

    public void setlabel(JLabel label) {
        this.label = label;
    }

    public Rectangle getBounds() {
        return new Rectangle(x + 60, y, WITH, HEIGHT);
    }

    public JLabel getLabel2() {
        return label2;
    }

    public void setLabel2(JLabel label2) {
        this.label2 = label2;
    }

    public Gui getGame() {
        return game;
    }

    public void setGame(Gui game) {
        this.game = game;
    }

}
