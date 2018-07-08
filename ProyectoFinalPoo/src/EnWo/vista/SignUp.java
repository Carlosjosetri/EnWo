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
import java.util.logging.Level;
import java.util.logging.Logger;
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
    private static final int xA = 50, xB = 145, y0 = 20, y1 = 60, y2 = 100, y3 = 165, y4 = 215, w = 130, h = 30;


    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    /* LABELS */ public JLabel msj = new JLabel("Ingrese su nuevo nombre de usuario y contraseña"),
            user_L = new JLabel("Usuario: "), password_L = new JLabel("Contraseña: ");
    /* TEXT FIELDS */ public JTextField user_TF = new JTextField(), password_TF = new JTextField();
    /* BOTONES */ public JButton signUp = new JButton("Crear nuevo usuario"), cancel = new JButton("Cancelar");

    // CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public SignUp() {
        super("Registro de usuarios");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
//        setLayout(new BorderLayout());
//        setContentPane(new JLabel(new ImageIcon("C:\\Users\\Tania Orellana\\Documents\\NetBeansProjects\\VW2DYbL0.png")));
//        setLayout(new FlowLayout());

        msj.setBounds(xA - 30, y0, 350, h);
        user_L.setBounds(xA + 24, y1, w - 30, h);
        password_L.setBounds(xA, y2, w - 30, h);
        user_TF.setBounds(xB, y1, w, h);
        password_TF.setBounds(xB, y2, w, h);
        signUp.setBounds(xA + 40, y3, w + 30, h);
        cancel.setBounds(xA + 65, y4, w - 25, h);

        Container container = getContentPane();
        container.add(msj);
        container.add(user_L);
        container.add(password_L);
        container.add(user_TF);
        container.add(password_TF);
        container.add(signUp);
        container.add(cancel);

        setSize(350, 350);
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
            if(registered){
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
