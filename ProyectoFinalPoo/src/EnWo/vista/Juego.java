package EnWo.vista;

import EnWo.data.dao.UsuariosDAO;
import EnWo.data.entidades.Usuario;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Tania Orellana
 */
public class Juego extends JFrame {

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Juego().setVisible(true);
            }
        });
    }

    // PUNTOS DE REFERENCIA Y DIMENSIONES
    private static final int xA = 50, xB = 145, y1 = 30, y2 = 70, y3 = 120, w = 130, h = 30;


    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    /* LABELS */ public JLabel user_L = new JLabel("Usuario: "), password_L = new JLabel("Contraseña: ");
    /* TEXT FIELDS */ public JTextField user_TF = new JTextField(), password_TF = new JTextField();
    /* BOTONES */ public JButton statistics = new JButton("Estadísticas del juego");

    // CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public Juego() {
        super("EnWo: Bienvenido a la aventura");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        user_L.setBounds(xA + 24, y1, w - 30, h);
        password_L.setBounds(xA, y2, w - 30, h);
        user_TF.setBounds(xB, y1, w, h);
        password_TF.setBounds(xB, y2, w, h);
        statistics.setBounds(xB + 30, y3, w - 25, h);

        setLayout(new BorderLayout());
        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Tania Orellana\\Documents\\NetBeansProjects\\VW2DYbL.png")));
        setLayout(new FlowLayout());

        Container container = getContentPane();

        container.add(statistics);

        setSize(900, 600);
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

    public static void limpiarCampos(JTextField user_TF, JTextField password_TF) {
        user_TF.setText("");
        password_TF.setText("");
    }

    public void close() {
//        this.setVisible(false);
        this.dispose();
    }

    public void shadysBackTellAFriend() {
        this.setVisible(true);
    }
}
