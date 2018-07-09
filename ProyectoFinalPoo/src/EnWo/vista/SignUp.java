package EnWo.vista;

import EnWo.Admin;
import EnWo.data.dao.JugadoresDAO;
import EnWo.data.dao.UsuariosDAO;
import EnWo.data.entidades.Jugador;
import EnWo.data.entidades.Usuario;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class SignUp extends JFrame {

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SignUp().setVisible(true);
            }
        });
    }

    // PUNTOS DE REFERENCIA Y DIMENSIONES

    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    /* LABELS */ public JLabel msj = new JLabel("Ingrese sus datos"),
            user_L = new JLabel("Usuario: "), password_L = new JLabel("Contraseña: ");
    /* TEXT FIELDS */ public JTextField user_TF = new JTextField(), password_TF = new JTextField();
    /* BOTONES */ public JButton signUp = new JButton("Crear nuevo usuario"), cancel = new JButton("Cancelar");
    private JPanel panel = new JPanel();
    private JLabel lblBackgroundImage = new JLabel();
    private JLabel iconGorillaz = new JLabel();
    private JLabel iconMegamanz = new JLabel();

    // CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public SignUp() {
        super("Registro de usuarios");
        setSize(500, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());
        lblBackgroundImage.setLayout(new FlowLayout());

        lblBackgroundImage.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bg0.png"));
//        lblBackgroundImage.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bg3.jpg"));
        iconGorillaz.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\gorillaz1.gif"));
        iconMegamanz.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\megamanz1.gif"));
        lblBackgroundImage.setLayout(new BorderLayout());
        msj.setForeground(Color.white);

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

        campoBotones.add(signUp);
        campoUsuario.add(Box.createRigidArea(new Dimension(30, 10)));
        campoBotones.add(cancel);

        campos.add(msj);
        campos.add(Box.createRigidArea(new Dimension(10, 50)));
        campos.add(campoUsuario);
        campos.add(Box.createRigidArea(new Dimension(10, 20)));
        campos.add(campoContrasenna);
        campos.add(Box.createRigidArea(new Dimension(10, 20)));
        campos.add(campoBotones);

        layout.add(iconMegamanz);
        layout.add(campos);
        layout.add(iconGorillaz);
        

        panel.add(layout);
        events();
    }

    public void events() {
        signUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (!(user_TF.getText().isEmpty() && password_TF.getText().isEmpty())) {

                    Usuario user = new Usuario(user_TF.getText(), password_TF.getText());

                    try {
                        if (signingUp(user) == false) {
                            JOptionPane.showMessageDialog(null,
                                    "Se produjo un error.\nIntente de nuevo.");
                            LogIn.limpiarCampos(user_TF, password_TF);
                        } else {
                            // NUEVA VENTANA: HOME
                            JOptionPane.showMessageDialog(null,
                                    "Usuario creado con éxito.");
                            close();
                            new Home().setVisible(true);
                        }
                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null,
                                "El nombre de usuario que ha escogido ya existe.");
                        LogIn.limpiarCampos(user_TF, password_TF);
                        Logger.getLogger(SignUp.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Por favor, no deje campos vacíos.");
                }
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                close();
                new LogIn().shadysBackTellAFriend();
            }
        });
    }

    public boolean signingUp(Usuario user) throws SQLException {
        boolean registered = new UsuariosDAO().signUp(user);

        if (registered) {
            Jugador j = Admin.getInstance().getJugadorActual();
            j.setIdUsuario(user.getIdUsuario());
            registered = new JugadoresDAO().insert(j);
            if (registered) {
                Admin.getInstance().getInfoJugadorActual();
                System.out.println(j.toString());
            }
        }
        return registered;
    }

    public void close() {
//        this.setVisible(false);
        this.dispose();
    }
}
