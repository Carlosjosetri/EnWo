package EnWo.vista;

import EnWo.Admin;
import EnWo.data.dao.UsuariosDAO;
import EnWo.data.entidades.Usuario;
import java.awt.BorderLayout;
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

/**
 *
 * @author Tania Orellana
 */
public class infoPlayer extends JFrame {

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new infoPlayer().setVisible(true);
            }
        });
    }

    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    private JLabel nombre = new JLabel(findNombre()), puntaje = new JLabel("" + Admin.getInstance().getJugadorActual().getPuntajeMax());
    private JButton regresar = new JButton("Regresar");
    private JPanel panel = new JPanel();
    private JLabel lblBackgroundImage = new JLabel(), pJugador = new JLabel(),
            bNombre = new JLabel(), bPuntaje = new JLabel(), bInfoJugador = new JLabel();

    public infoPlayer() {
        super("Información del jugador");

        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setResizable(false);// centramos la ventana en la pantalla

        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());

        lblBackgroundImage.setLayout(new FlowLayout());

        lblBackgroundImage.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bg1.png"));
        lblBackgroundImage.setLayout(new BorderLayout());

        pJugador.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\mm.gif"));
        bInfoJugador.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bannerPlayerInfo.png"));
        bNombre.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bannerNombre.png"));
        bPuntaje.setIcon(new ImageIcon("C:src\\EnWo\\vista\\img\\bannerPuntaje.png"));

        lblBackgroundImage.add(panel);

        add(lblBackgroundImage);

        Box vBox1 = Box.createVerticalBox(), banners = Box.createVerticalBox(), values = Box.createVerticalBox();
        Box allData = Box.createHorizontalBox();

        banners.add(bNombre);
        banners.add(Box.createRigidArea(new Dimension(15, 20)));
        banners.add(bPuntaje);

        values.add(nombre);
        values.add(Box.createRigidArea(new Dimension(15, 20)));
        values.add(puntaje);

        allData.add(banners);
        allData.add(Box.createRigidArea(new Dimension(30, 10)));
        allData.add(values);

        vBox1.add(bInfoJugador);
        vBox1.add(Box.createRigidArea(new Dimension(30, 10)));
        vBox1.add(pJugador);
        vBox1.add(Box.createRigidArea(new Dimension(20, 30)));
        vBox1.add(allData);
        vBox1.add(Box.createRigidArea(new Dimension(20, 30)));
        vBox1.add(regresar);

        panel.add(vBox1);

        events();
    }

    public void events() {

        regresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                close();
                new Home().shadysBackTellAFriend();
            }
        });
    }

    public void close() {
//        this.setVisible(false);
        this.dispose();
    }

    private String findNombre() {
        Usuario u = new Usuario();
        UsuariosDAO uD = new UsuariosDAO();
        u.setIdUsuario(Admin.getInstance().getJugadorActual().getIdUsuario());
        return uD.findFromID(u).getUsername();
    }
}
