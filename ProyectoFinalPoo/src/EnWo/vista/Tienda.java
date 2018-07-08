package EnWo.vista;

import EnWo.data.dao.UsuariosDAO;
import EnWo.data.entidades.Usuario;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Tania Orellana
 */
public class Tienda extends JFrame {

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Tienda().setVisible(true);
            }
        });
    }

    // PUNTOS DE REFERENCIA Y DIMENSIONES
    private static final int xA = 50, xB = 145, y1 = 30, y2 = 70, y3 = 120, w = 130, h = 30;


    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    /* LABELS */ public JLabel user_L = new JLabel("Usuario: "), password_L = new JLabel("Contraseña: ");
    /* TEXT FIELDS */ public JTextField user_TF = new JTextField(), password_TF = new JTextField();
    /* BOTONES */ public JButton goBack = new JButton("Regresar");

    // CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public Tienda() {
        super("EnWo: TIENDA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        goBack.setBounds(xB + 30, y3, w - 25, h);

        Container container = getContentPane();
        container.add(goBack);
        
        setSize(900, 600);
        events();
    }


    public void events() {

        goBack.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                close();
                new Home().shadysBackTellAFriend();
            }
        });
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
