/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagenes;

import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import GameObjects.Monitos;
import GameObjects.Personaje;
import GameObjects.ClickListener;
import GameObjects.Escenario;
import GameObjects.Jefe;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Gui extends JFrame {

    private JLabel[] labels;
    public ArrayList<Monitos> balls;
    public ArrayList<Monitos> balls2;
    public ArrayList<Escenario> escenario;
    public Personaje Character = new Personaje(this);
    public Jefe jefe;
    public boolean jefevivo = false;
    private Random random;
    public int cont = 1;
    public int conttiros = 24;
    public int contexplo = 46;
    public int y;
    public int vida = 5;
    public int vidarelativa = 100;
    public boolean rellenar = false;
    public Container container = getContentPane();

    public Gui() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();

    }

    private void configurarVentana() {
        this.setTitle("EnWo");

        this.setSize(1000, 600);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null);
        this.setResizable(false);// centramos la ventana en la pantalla
        this.setLayout(null);

        labels = new JLabel[60];

        labels[24] = new JLabel();
        labels[24].setIcon(new ImageIcon(getClass().getResource("explo" + ".gif")));
        container.add(labels[24]);

        labels[47] = new JLabel();
        labels[47].setIcon(new ImageIcon(getClass().getResource("gorilla" + ".gif")));
       
        container.add(labels[47]);

        labels[14] = new JLabel();

        labels[14].setIcon(new ImageIcon(getClass().getResource("megar" + ".gif")));
        labels[14].setBounds(10, 400, 200, 200);
        container.add(labels[14]);

        labels[0] = new JLabel();

        labels[0].setIcon(new ImageIcon(getClass().getResource("mega" + ".gif")));
        labels[0].setBounds(10, 400, 200, 200);
        container.add(labels[0]);
        Character.setlabel(labels[0]);
        Character.setLabel2(labels[14]);
        for (int i = 1; i < 10; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource("mon" + ".gif")));

            container.add(labels[i]);
        }
        for (int i = 15; i < 24; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource("vidap" + ".gif")));

            container.add(labels[i]);
        }
        for (int i = 25; i < 36; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource("shoot" + ".png")));
            labels[i].setBounds(100, 2000, 400, 400);
            container.add(labels[i]);
        }
        for (int i = 36; i < 36 + vida; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource("cora" + ".gif")));
            labels[i].setBounds(10 + (i - 36) * 20, -150, 400, 400);
            container.add(labels[i]);
        }

        for (int i = 48; i < 51; i++) {
            labels[i] = new JLabel();
            labels[i].setIcon(new ImageIcon(getClass().getResource("jungle" + ".jpg")));
            labels[i].setBounds(0, 0, 3000, 600);
            container.add(labels[i]);
        }

        // no usamos ningun layout, solo asi podremos dar posiciones a los componentes
        // hacemos que la ventana no sea redimiensionable
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // hacemos que cuando se cierre la ventana termina todo proceso
    }

    private void inicializarComponentes() {

        random = new Random();
        balls = new ArrayList<Monitos>();
        escenario = new ArrayList<Escenario>();
        labels[24].setBounds(1010, -70, 400, 400);
        labels[47].setBounds(1010, -70, 400, 400);
        jefe = new Jefe(this, labels[47], 960, labels[24]);

    }

    private void move() {
        if (System.nanoTime() - Monitos.lastDuckTime >= Monitos.timeBetweenDucks * 8) {

            // Here we create new duck and add it to the array list.
            y = random.nextInt(600);
            labels[cont].setBounds(3432, y, 100, 100);
            labels[cont + 14].setBounds(2345, y, 200, 200);
            balls.add(new Monitos(this, y, labels[cont], labels[cont + 14]));

            cont += 1;

            Monitos.lastDuckTime = System.nanoTime();
        }
        if (cont == 3 && jefevivo == false) {
            jefevivo = true;

        }
        if (cont == 9) {

            cont = 1;
        }
        if (jefevivo == true) {
            jefe.move();
        }

        if (rellenar == false) {
            escenario.add(new Escenario(this, 0, labels[48]));
            escenario.add(new Escenario(this, 600, labels[49]));
            escenario.add(new Escenario(this, 1200, labels[50]));
            rellenar = true;
        }
        for (int i = 0; i < escenario.size(); i++) {
            escenario.get(i).move();
        }
        // Update all of the ducks.
        for (int i = 0; i < balls.size(); i++) {
            // Move the duck.
            balls.get(i).move();

            // Checks if the duck leaves the screen and remove it if it does.
            if (balls.get(i).x < 0) {
                balls.get(i).label.setLocation(i, 8000);
                balls.get(i).golpe.setLocation(i, 8000);
                balls.remove(i);
            }

        }

        Character.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        /// POR SI SE QUIERE REVISAR HIT BOX DESCOMENTAR ESTE FRAGMENTO
//        for (int i = 0; i < balls.size(); i++) {
//            balls.get(i).paint(g2d);
//        }
//        Character.paint(g2d);
//        if (jefevivo == true) {
//            jefe.paint(g2d);
//        }
//        for (int i = 0; i < Character.getDisparos().size(); i++) {
//            Character.getDisparos().get(i).paint(g2d);
//        }
    }

    public JLabel CrearDisparos() {
        conttiros += 1;
        labels[conttiros].setBounds(-234, 4000, 200, 200);
        if (conttiros >= 35) {
            conttiros = 25;
        }
        return labels[conttiros];
    }

    public JLabel[] getLabels() {
        return labels;
    }

    public void setLabels(JLabel[] labels) {
        this.labels = labels;
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
        this.dispose();
    }

    public void Victory() {
        JOptionPane.showMessageDialog(this, "VICTORY", "YOU WIN", JOptionPane.YES_NO_OPTION);
        this.dispose();
    }

    public static void main(String[] args) throws InterruptedException {

        Gui game = new Gui();
        game.getContentPane().addMouseListener(new ClickListener(game.Character));
        game.setVisible(true);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(6);
        }
    }
}
