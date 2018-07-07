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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import newpackage.Monitos;
import newpackage.Personaje;
import newpackage.ClickListener;
import newpackage.Escenario;

@SuppressWarnings("serial")
public class Gui extends JFrame {

    private JLabel[] labels;
    public ArrayList<Monitos> balls;
    public ArrayList<Escenario> escenario;
    public Personaje racquet = new Personaje(this);
    private Random random;
    public int cont=1;
    public int y;
    public int vida=3;
    public boolean rellenar=false;
    public Gui() {
        super();                    // usamos el contructor de la clase padre JFrame
        configurarVentana();        // configuramos la ventana
        inicializarComponentes();
      
//            addMouseListener(new MouseListener() {
//                @Override
//                public void mouseClicked(MouseEvent e) {
//                   racquet.move2(e);
//                }
//
//                @Override
//                public void mousePressed(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void mouseReleased(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void mouseEntered(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//
//                @Override
//                public void mouseExited(MouseEvent e) {
//                    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//                }
//            });

////         addMouseMotionListener(new MouseMotionAdapter(){
////            @Override
////            public void mouseMoved(MouseEvent evento){
//             racquet.move2(evento);
//             }
//            
//          });
//    
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
				racquet.keyReleased(e);
			}

			@Override
			public void keyPressed(KeyEvent e) {
				racquet.keyPressed(e);
			}
		});
		setFocusable(true);
    }

 

    private void configurarVentana() {
        this.setTitle("EnWo");    
       
//            this.setUndecorated(true);
//             Puts the frame to full screen.
//            this.setExtendedState(this.MAXIMIZED_BOTH);
        this.setSize(1000, 600);                                 // colocamos tamanio a la ventana (ancho, alto)
        this.setLocationRelativeTo(null); 
               this.setResizable(false);// centramos la ventana en la pantalla
        this.setLayout(null);

        labels = new JLabel[30];

        Container container = getContentPane();

        labels[14] = new JLabel();
        
        labels[14].setIcon(new ImageIcon(getClass().getResource("megar" + ".gif")));
  labels[14].setBounds(10, 400, 200, 200);
        container.add(labels[14]);
       
        labels[0] = new JLabel();
        
        labels[0].setIcon(new ImageIcon(getClass().getResource("mega" + ".gif")));
        labels[0].setBounds(10, 400, 200, 200);
        container.add(labels[0]);
        racquet.setlabel(labels[0]);
        racquet.setLabel2(labels[14]);
        for(int i=1;i<10;i++){
            labels[i] = new JLabel();
        labels[i].setIcon(new ImageIcon(getClass().getResource("mon" + ".gif")));
    
        container.add(labels[i]);
        }
        for(int i=11;i<14;i++){
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

    }

    private void move() {
               if(System.nanoTime() - Monitos.lastDuckTime >= Monitos.timeBetweenDucks*5)
        {
            
            // Here we create new duck and add it to the array list.
            y=random.nextInt(600);
            labels[cont].setBounds(3432,y, 100, 100);
            balls.add(new Monitos(this,y,labels[cont]));
            
            
            cont+=1;
            System.out.println(cont);
            // Here we increase nextDuckLines so that next duck will be created in next line.
//            
//            if(Duck.nextDuckLines >= Duck.duckLines.length)
//                Duck.nextDuckLines = 0;
//            
            Monitos.lastDuckTime = System.nanoTime();
        }
               if(cont==9){
                   System.out.println("Surprise");
                   cont=1;
               }
//               if(System.nanoTime() - Monitos.lastDuckTime2 >= Monitos.timeBetweenDucks2*8)
//        {
//            // Here we create new duck and add it to the array list.
//            balls.remove(0);
//            
//            // Here we increase nextDuckLines so that next duck will be created in next line.
////            
////            if(Duck.nextDuckLines >= Duck.duckLines.length)
////                Duck.nextDuckLines = 0;
////            
//           Monitos.lastDuckTime2 = System.nanoTime();
//        }
        if(rellenar==false){
            escenario.add(new Escenario(this,0,labels[11]));
            escenario.add(new Escenario(this,600,labels[12]));
            escenario.add(new Escenario(this,1200,labels[13]));
            rellenar=true;
        }
        for(int i = 0; i < escenario.size(); i++){
            escenario.get(i).move();
        }
        // Update all of the ducks.
        for(int i = 0; i < balls.size(); i++)
        {
            // Move the duck.
            balls.get(i).move();
            
            // Checks if the duck leaves the screen and remove it if it does.
            if(balls.get(i).x<0){
                balls.get(i).label.setLocation(i, 8000);
                balls.remove(i);
            }
       
        }
        
        racquet.move();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        /// POR SI SE QUIERE REVISAR HIT BOX DESCOMENTAR ESTE FRAGMENTO
//        for(int i=0;i<balls.size();i++){
//            balls.get(i).paint(g2d);
//        }
//      racquet.paint(g2d);
    }

    public void gameOver() {
        JOptionPane.showMessageDialog(this, "Game Over", "Game Over", JOptionPane.YES_NO_OPTION);
       
    }

    public static void main(String[] args) throws InterruptedException {

        Gui game = new Gui();
        game.getContentPane().addMouseListener(new ClickListener(game.racquet));
        game.setVisible(true);

        while (true) {
            game.move();
            game.repaint();
            Thread.sleep(6);
        }
    }
}
