package EnWo.vista;

import EnWo.Admin;
import java.awt.BorderLayout;
import java.awt.Color;
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

    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
    private JLabel haGanado = new JLabel(Admin.getInstance().getHaGanado() ? "Sí" : "No"),
            puntaje = new JLabel("" + Admin.getInstance().getPuntajeTotal()),
            monedas = new JLabel("" + Admin.getInstance().getMonedasAtrapadas());

    private JPanel panel = new JPanel();
    private JLabel lblBackgroundImage = new JLabel(), pJugador = new JLabel(), bEsGanador = new JLabel(), bPuntaje = new JLabel(), bMonedas = new JLabel();
    /* BOTONES */ public JButton B_Ranking = new JButton("Ver ranking");

    // CONSTRUCTOR: SE INICIALIZA TODO. SUPER(<NOMBRE_VENTANA>. SETDEFAULTCLOSEOPERATION(JFRAME.EXIT_ON_CLOSE))
    public Estadisticas() {
        super("EnWo: Estadísticas de la partida");

        setSize(734, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        panel.setOpaque(false);
        panel.setLayout(new FlowLayout());

        lblBackgroundImage.setLayout(new FlowLayout());

        lblBackgroundImage.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bg2.jpg"));
        lblBackgroundImage.setLayout(new BorderLayout());

        pJugador.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\BannerGameInfo.png"));
        bEsGanador.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bannerGanador.png"));
        bPuntaje.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bannerPuntaje.png"));
        bMonedas.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\bannerMonedas.png"));

        panel.add(B_Ranking);

        lblBackgroundImage.add(panel);

        add(lblBackgroundImage);

        Box vBox = Box.createVerticalBox();
        Box hBox1 = Box.createHorizontalBox(), hBox2 = Box.createHorizontalBox(), hBox3 = Box.createHorizontalBox();
        
        vBox.add(pJugador);
        vBox.add(Box.createRigidArea(new Dimension(10, 20)));
        hBox1.add(bEsGanador);
        hBox1.add(Box.createRigidArea(new Dimension(30, 10)));
        haGanado.setForeground(Color.white);
        hBox1.add(haGanado);
        vBox.add(hBox1);
        vBox.add(Box.createRigidArea(new Dimension(10, 20)));
        puntaje.setForeground(Color.white);
        hBox2.add(bPuntaje);
        hBox2.add(Box.createRigidArea(new Dimension(30, 10)));
        hBox2.add(puntaje);
        vBox.add(hBox2);
        vBox.add(Box.createRigidArea(new Dimension(10, 20)));
        hBox3.add(bMonedas);
        hBox3.add(Box.createRigidArea(new Dimension(30, 10)));
        monedas.setForeground(Color.white);
        hBox3.add(monedas);
        vBox.add(hBox3);
        vBox.add(Box.createRigidArea(new Dimension(35, 20)));
        vBox.add(B_Ranking);

        panel.add(vBox);

        events();
    }

    public void events() {

        B_Ranking.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                // NUEVA VENTANA DE RANKING
                new Ranking().setVisible(true);
                close();
            }
        }
        );
    }

    public void close() {
        this.dispose();
    }

    public void shadysBackTellAFriend() {
        this.setVisible(true);
    }
}
