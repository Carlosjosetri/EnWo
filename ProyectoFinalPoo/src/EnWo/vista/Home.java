package EnWo.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tania Orellana
 */
public class Home extends JFrame {

    private JPanel panel = new JPanel();
    private JLabel lblBackgroundImage = new JLabel();
    /* BOTONES */ public JButton infoPlayer = new JButton("Info player"),
            jugar = new JButton("Iniciar juego"),
            ranking = new JButton("Ver ranking");

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    public Home() {
        super("EnWo: Home");

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());

        lblBackgroundImage.setLayout(new FlowLayout());

        lblBackgroundImage.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bg3.jpg"));
        lblBackgroundImage.setLayout(new BorderLayout());

        panel.add(infoPlayer);
        panel.add(jugar);
        panel.add(ranking);

        lblBackgroundImage.add(panel);

        add(lblBackgroundImage);

        Box vBox = Box.createVerticalBox();

        vBox.add(Box.createRigidArea(new Dimension(35, 100)));
        vBox.add(infoPlayer);
        vBox.add(Box.createRigidArea(new Dimension(10, 20)));

        vBox.add(jugar);
        vBox.add(Box.createRigidArea(new Dimension(10, 20)));

        vBox.add(ranking);
        vBox.add(Box.createRigidArea(new Dimension(35, 35)));
        panel.add(vBox);

        events();
    }

    public void events() {

        infoPlayer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                close();
                new infoPlayer().setVisible(true);

            }
        }
        );

        jugar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                close();
                new Juego().setVisible(true);

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
