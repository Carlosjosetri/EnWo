package EnWo.vista;

import EnWo.Admin;
import EnWo.data.dao.UsuariosDAO;
import EnWo.data.entidades.Jugador;
import EnWo.data.entidades.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import static javax.swing.Box.createHorizontalBox;
import static javax.swing.Box.createVerticalBox;
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

    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    /* LABELS */ public JLabel user_L = new JLabel("Usuario:"), password_L = new JLabel("Contraseña:");
    /* TEXT FIELDS */ public JTextField user_TF = new JTextField(), password_TF = new JTextField();
    /* BOTONES */ public JButton logIn = new JButton("Inicio sesión"), signUp = new JButton("Registrarse");
    private JPanel panel = new JPanel();
    private JLabel lblBackgroundImage = new JLabel();
    private JLabel iconGorillaz = new JLabel();
    private JLabel iconMegamanz = new JLabel();

// CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public LogIn() {
        super("EnWo: Inicio de sesión");

        setSize(450, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());

        lblBackgroundImage.setLayout(new FlowLayout());

        lblBackgroundImage.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bg0.png"));
//        lblBackgroundImage.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bg3.jpg"));
        iconGorillaz.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\gorillaz.gif"));
        iconMegamanz.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\megamanz.gif"));
        lblBackgroundImage.setLayout(new BorderLayout());

        lblBackgroundImage.add(panel);

        add(lblBackgroundImage);

        
        Box layout = createHorizontalBox();
        Box campos = createVerticalBox();
        Box campoUsuario = createHorizontalBox();
        Box campoContrasenna = createHorizontalBox();
        Box campoBotones = createHorizontalBox();

        campoUsuario.add(user_L);
        user_L.setForeground(Color.white);
        campoUsuario.add(Box.createRigidArea(new Dimension(30, 10)));
        campoUsuario.add(user_TF);

        campoContrasenna.add(password_L);
        password_L.setForeground(Color.white);
        campoContrasenna.add(Box.createRigidArea(new Dimension(30, 10)));
        campoContrasenna.add(password_TF);
        campoBotones.add(logIn);
        campoUsuario.add(Box.createRigidArea(new Dimension(30, 10)));
        campoBotones.add(signUp);

        campos.add(Box.createRigidArea(new Dimension(10, 50)));
        campos.add(campoUsuario);
        campos.add(Box.createRigidArea(new Dimension(10, 20)));
        campos.add(campoContrasenna);
        campos.add(Box.createRigidArea(new Dimension(10, 20)));
        campos.add(campoBotones);

        
        layout.add(iconGorillaz);
        layout.add(campos);
        layout.add(iconMegamanz);
        
        panel.add(layout);
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
