package EnWo.vista;

import EnWo.Admin;
import EnWo.data.dao.JugadoresDAO;
import EnWo.data.dao.UsuariosDAO;
import EnWo.data.entidades.Jugador;
import EnWo.data.entidades.Usuario;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
public class LogIn extends JFrame {

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }

    // PUNTOS DE REFERENCIA Y DIMENSIONES
    private static final int xA = 50, xB = 145, y1 = 130, y2 = 170, y3 = 220, w = 130, h = 30;


    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    /* LABELS */ public JLabel user_L = new JLabel("Usuario: "), password_L = new JLabel("Contraseña: ");
    /* TEXT FIELDS */ public JTextField user_TF = new JTextField(), password_TF = new JTextField();
    /* BOTONES */ public JButton logIn = new JButton("Inicio sesión"), signUp = new JButton("Registrarse");

    // CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public LogIn() {
        super("EnWo: Inicio de sesión");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

//        setLayout(new BorderLayout());
//        setContentPane(new JLabel(new ImageIcon("src\\EnWo\\vista\\img\\VW2DYbL0.png")));
//        setLayout(new FlowLayout());
        user_L.setBounds(xA + 24, y1, w - 30, h);
        password_L.setBounds(xA, y2, w - 30, h);
        user_TF.setBounds(xB, y1, w, h);
        password_TF.setBounds(xB, y2, w, h);
        logIn.setBounds(xA + 10, y3, w - 25, h);
        signUp.setBounds(xB + 30, y3, w - 25, h);

        Container container = getContentPane();
        container.add(user_L);
        container.add(password_L);
        container.add(user_TF);
        container.add(password_TF);
        container.add(logIn);
        container.add(signUp);

        setSize(350, 350);
        events();
    }

    public void events() {
        logIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!(user_TF.getText().isEmpty() && password_TF.getText().isEmpty())) {
                    UsuariosDAO uDAO = new UsuariosDAO();
                    Usuario user = new Usuario(user_TF.getText(), password_TF.getText());
                    if (!loggingIn(user)) {
                        JOptionPane.showMessageDialog(null,
                                "Datos incorrectos.\nIntente de nuevo.");
                        limpiarCampos(user_TF, password_TF);
                    } else {
                        // NUEVA VENTANA: HOME

                        close();
                        new Home().setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Por favor, no deje campos vacíos.");
                }
            }
        }
        );

        signUp.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                // NUEVA VENTANA DE REGISTRO
                new SignUp().setVisible(true);
                close();
            }
        }
        );
    }

    public boolean loggingIn(Usuario user) {
        boolean loggedIn = new UsuariosDAO().logIn(user);

        if (loggedIn) {
            Jugador j = Admin.getInstance().getJugadorActual();
            j.setIdUsuario(user.getIdUsuario());
            Admin.getInstance().getInfoJugadorActual();
        }
        return loggedIn;
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
