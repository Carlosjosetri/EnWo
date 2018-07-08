package EnWo.data.dao;

import EnWo.data.entidades.Partida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tania Orellana
 */
public class PartidasDAO extends BaseDAO<Partida> {

    public PartidasDAO() {
        table = new TableData("partida", "_id",
                new String[]{"idJugador", "puntajeObtenido", "monedasObtenidas"});
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Partida find, String by) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table.TABLE_NAME + " WHERE " + by + " = ?";
        try {
            ps = con.prepareStatement(query);
            if (by.equals(table.PRIMARY_KEY)) {
                ps.setInt(1, find.getIdPartida());
            } else if (by.equals(table.fields[0])) {
                ps.setInt(1, find.getIdJugador());
            } else if (by.equals(table.fields[1])) {
                ps.setInt(1, find.getPuntajeObtenido());
            } else if (by.equals(table.fields[2])) {
                ps.setInt(1, find.getMonedasObtenidas());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    Partida mapToObject(ResultSet resultSet) {
        Partida p = new Partida();

        try {
            p.setIdPartida(resultSet.getInt(table.PRIMARY_KEY));
            p.setIdJugador(resultSet.getInt(table.fields[0]));
            p.setPuntajeObtenido(resultSet.getInt(table.fields[1]));
            p.setMonedasObtenidas(resultSet.getInt(table.fields[2]));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Partida toDelete) {
        PreparedStatement ps = null;
        String query = "DELETE FROM " + table.TABLE_NAME + " WHERE " + table.PRIMARY_KEY + " = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toDelete.getIdPartida());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(JugadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Partida toInsert) {
        PreparedStatement ps = null;
        String query = "INSERT INTO " + table.TABLE_NAME
                + "(" + table.fields[0] + ", " + table.fields[1] + ", " + table.fields[2]
                + ") VALUES (?, ?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toInsert.getIdJugador());
            ps.setInt(2, toInsert.getPuntajeObtenido());
            ps.setInt(2, toInsert.getMonedasObtenidas());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Partida toUpdate) {
        PreparedStatement ps = null;

        String query = "UPDATE TABLE " + table.TABLE_NAME + "SET "
                + table.fields[0] + "  = ?,"
                + table.fields[1] + "  = ? "
                + table.fields[2] + "  = ? "
                + "WHERE " + table.PRIMARY_KEY + "  = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toUpdate.getIdJugador());
            ps.setInt(2, toUpdate.getPuntajeObtenido());
            ps.setInt(3, toUpdate.getMonedasObtenidas());
            ps.setInt(4, toUpdate.getIdPartida());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    List<Partida> findByIDJugador(Partida p) {
        return findBy(p, table.fields[0]);
    }
    
    List<Partida> findByIDPartida(Partida p) {
        return findBy(p, table.PRIMARY_KEY);
    }
    
    List<Partida> findByNivelPartida(Partida p) {
        return findBy(p, table.PRIMARY_KEY);
    }
}
