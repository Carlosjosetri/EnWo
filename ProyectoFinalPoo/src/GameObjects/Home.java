/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GameObjects;



import EnWo.EnWo;
import Imagenes.Gui;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Tania Orellana
 */
public class Home extends JFrame {
public static boolean jugaras=false;
//   public static void main(String... args) {
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Home().setVisible(true);
//                
//                    try {
//                        Gui.jugar();
//                    } catch (InterruptedException ex) {
//                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//                    }
//                
//            }
//        });
//    }

    // PUNTOS DE REFERENCIA Y DIMENSIONES
    private static final int xA = 50, xB = 145, y1 = 130, y2 = 175, y3 = 220, w = 130, h = 30;

    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    /* LABELS */ public JLabel user_L = new JLabel("Usuario: "), password_L = new JLabel("Contraseña: ");
    /* TEXT FIELDS */ public JTextField user_TF = new JTextField(), password_TF = new JTextField();
    /* BOTONES */ public JButton infoPlayer = new JButton("Info player"), jugar = new JButton("Iniciar juego"), tienda = new JButton("Tienda");

    // CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public Home() {
        super("EnWo: Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        setLayout(null);
//        setLayout(new BorderLayout());
//        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Tania Orellana\\Documents\\NetBeansProjects\\VW2DYbL0.png")));
//        setLayout(new FlowLayout());

        user_L.setBounds(xA + 24, y1, w - 30, h);
        password_L.setBounds(xA, y2, w - 30, h);
        user_TF.setBounds(xB, y1, w, h);
        password_TF.setBounds(xB, y2, w, h);
        infoPlayer.setBounds(xA + 10, y1, w - 25, h);
        tienda.setBounds(xA + 10, y2, w - 25, h);
        jugar.setBounds(xA + 10, y3, w - 25, h);

        Container container2 = getContentPane();
        container2.add(tienda);
        container2.add(infoPlayer);
        container2.add(jugar);

        setSize(900, 600);
        events();
    }

    public void events() {

        infoPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                    close();
//                        new infoPlayer().setVisible(true);
                    
            }
        }
        );

        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
            jugaras=true;
            }
        }
        );

        tienda.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                // NUEVA VENTANA DE REGISTRO
//                new Tienda().setVisible(true);
                close();
            }
        }
        );
    }

    public void close() {
//        this.setVisible(false);
        this.dispose();
    }

    public void shadysBackTellAFriend() {
        this.setVisible(true);
    }
}
