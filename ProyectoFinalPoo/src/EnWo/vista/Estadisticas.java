package EnWo.vista;

import EnWo.Admin;
import EnWo.data.dao.UsuariosDAO;
import EnWo.data.entidades.Usuario;
import java.awt.BorderLayout;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Tania Orellana
 */
public class Estadisticas extends JFrame {

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Estadisticas().setVisible(true);
            }
        });
    }

    // PUNTOS DE REFERENCIA Y DIMENSIONES
    private static final int xA = 50, xB = 145, y1 = 30, y2 = 70, y3 = 120, w = 130, h = 30;

    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    private JLabel nombre = new JLabel(), puntaje = new JLabel("" + Admin.getInstance().getJugadorActual().getPuntajeMax());

    private JButton regresar = new JButton("Regresar");
    private JPanel panel = new JPanel();
    private JLabel lblBackgroundImage = new JLabel(), pJugador = new JLabel(), bNombre = new JLabel(), bPuntaje = new JLabel();
    /* BOTONES */ public JButton seeRanking = new JButton("Ver ranking");

    // CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public Estadisticas() {
        super("EnWo: Estadísticas de la partida");

        setSize(380, 380);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());

        lblBackgroundImage.setLayout(new FlowLayout());

        lblBackgroundImage.setIcon(new ImageIcon("C:\\Users\\Tania Orellana\\Documents\\NetBeansProjects\\bg0.png"));
        lblBackgroundImage.setLayout(new BorderLayout());

        pJugador.setIcon(new ImageIcon("C:\\Users\\Tania Orellana\\Documents\\NetBeansProjects\\VW2DYbL2.gif"));
        bNombre.setIcon(new ImageIcon("C:\\Users\\Tania Orellana\\Documents\\NetBeansProjects\\bannerNombre.png"));
        bPuntaje.setIcon(new ImageIcon("C:\\Users\\Tania Orellana\\Documents\\NetBeansProjects\\bannerPuntaje.png"));

        regresar.setBounds(xA + 65, y3, w - 25, h);

        panel.add(seeRanking);

        lblBackgroundImage.add(panel);

        add(lblBackgroundImage);

        Box vBox = Box.createVerticalBox();
        Box hBox1 = Box.createHorizontalBox(), hBox2 = Box.createHorizontalBox();
        vBox.add(pJugador);
        vBox.add(Box.createRigidArea(new Dimension(10, 20)));
        hBox1.add(bNombre);
        hBox1.add(Box.createRigidArea(new Dimension(30, 10)));
        hBox1.add(nombre);
        vBox.add(hBox1);
        vBox.add(Box.createRigidArea(new Dimension(10, 20)));
        hBox2.add(bPuntaje);
        hBox2.add(Box.createRigidArea(new Dimension(30, 10)));
        hBox2.add(puntaje);
        vBox.add(hBox2);
        vBox.add(Box.createRigidArea(new Dimension(35, 20)));
        vBox.add(seeRanking);

        panel.add(vBox);

        events();
    }

    public void events() {

        seeRanking.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                // NUEVA VENTANA DE REGISTRO
                new Ranking().setVisible(true);
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
