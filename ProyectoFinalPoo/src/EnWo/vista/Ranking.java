package EnWo.vista;

import EnWo.data.dao.JugadoresDAO;
import EnWo.data.dao.UsuariosDAO;
import EnWo.data.entidades.Jugador;
import EnWo.data.entidades.Usuario;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Tania Orellana
 */
public class Ranking extends JFrame {

    public static void main(String... args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Ranking().setVisible(true);
            }
        });
    }

    // PUNTOS DE REFERENCIA Y DIMENSIONES
    private static final int xA = 20, y1 = 22, y2 = 70, w = 105, h = 30;

    // CREAN INSTANCIAS DE TODOS LOS ELEMENTOS A USAR
//    /* LABELS */ public JLabel bg;
    /* BOTONES */ public JButton goHome = new JButton("HOME");
    /* TABLA RANKING */ public JTable resultados;
    public JPanel table;
    DefaultTableModel tm;

    public Ranking() {
        super("EnWo: TOP PLAYERS");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        setLocationRelativeTo(null);
        setLayout(null);

//        setLayout(new BorderLayout());
//        setContentPane(new JLabel(new ImageIcon("src\\EnWo\\vista\\img\\VW2DYbL0.png")));
//        setLayout(new FlowLayout());
        goHome.setBounds(xA, y1, w, h);

        resultados = new JTable();
        table = new JPanel();
        table.setBounds(5, y2, 475, 80);
        table.add(new JScrollPane(resultados));

        llenarTabla();
//        bg = new JLabel();
//        bg.setIcon(new ImageIcon("src\\EnWo\\vista\\img\\VW2DYbL0.png"));
//        bg.setBounds(0, 0, 500, 600);
//        container.add(bg);
        Container container = getContentPane();
        container.add(goHome);
        container.add(table);

        setSize(500, 300);
        events();
    }

    public void events() {
        goHome.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                // NUEVA VENTANA DE REGISTRO
                new Home().setVisible(true);
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

    private void llenarTabla() {
        tm = new DefaultTableModel() {
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0:
                        return String.class;
                    default:
                        return int.class;
                }
            }
        };

        tm.addColumn("Nombre");
        tm.addColumn("Nivel");
        tm.addColumn("Puntaje");

        JugadoresDAO jDAO = new JugadoresDAO();
        List<Jugador> jugadores = new ArrayList<>();
        jugadores = jDAO.getRanking();

        UsuariosDAO uDAO = new UsuariosDAO();
        Usuario u = new Usuario();

        jugadores.forEach((player) -> {
            u.setIdUsuario(player.getIdUsuario());
            tm.addRow(new Object[]{
                uDAO.findFromID(u).getUsername(), // para colocar el nombre
                player.getMaximoNivelAlcanzado(),
                player.getPuntajeMax()});
        });
        resultados.setModel(tm);
    }
}
