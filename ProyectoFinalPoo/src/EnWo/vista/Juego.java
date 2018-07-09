package EnWo.vista;

import EnWo.game.Gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Tania Orellana
 */
public class Juego extends JFrame {

    static Gui gui = new Gui();
    private JPanel panel = new JPanel();
    private JLabel lblBackgroundImage = new JLabel();
    private JButton statistics = new JButton("Ver estadísticas de juego");

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    public Juego() {
        super("EnWo: Bienvenido a la aventura");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());

        lblBackgroundImage.setLayout(new FlowLayout());

        lblBackgroundImage.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bg0.png"));
        lblBackgroundImage.setLayout(new BorderLayout());

        panel.add(statistics);

        lblBackgroundImage.add(panel);

        add(lblBackgroundImage);

        Box vBox = Box.createVerticalBox();
        vBox.add(Box.createRigidArea(new Dimension(10, 35)));
        vBox.add(statistics);
        vBox.add(Box.createRigidArea(new Dimension(35, 35)));
        panel.add(vBox);
//        try {
//            gui.jugar();
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Juego.class.getName()).log(Level.SEVERE, null, ex);
//        }
        events();

    }

    public void events() {
        statistics.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                // NUEVA VENTANA DE REGISTRO
                new Estadisticas().setVisible(true);
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
