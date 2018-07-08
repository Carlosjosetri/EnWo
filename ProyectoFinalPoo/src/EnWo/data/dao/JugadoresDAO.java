package EnWo.data.dao;

import EnWo.data.entidades.Jugador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tania Orellana
 */
public class JugadoresDAO extends BaseDAO<Jugador> {

    private final int toDisplay;

    public JugadoresDAO() {
        this.toDisplay = 3;
        table = new TableData("jugador", "_id",
                new String[]{"maximoNivelAlcanzado", "cantMonedas",
                    "idUsuario", "puntajeMax"});
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Jugador find, String by) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table.TABLE_NAME + " WHERE " + by + " = ?";
        try {
            ps = con.prepareStatement(query);
            if (by.equals(table.PRIMARY_KEY)) {
                ps.setInt(1, find.getIdJugador());
            } else if (by.equals(table.fields[0])) {
                ps.setInt(1, find.getMaximoNivelAlcanzado());
            } else if (by.equals(table.fields[1])) {
                ps.setInt(1, find.getCantMonedas());
            } else if (by.equals(table.fields[2])) {
                ps.setInt(1, find.getIdUsuario());
            } else if (by.equals(table.fields[3])) {
                ps.setInt(1, find.getPuntajeMax());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    Jugador mapToObject(ResultSet resultSet) {
        Jugador j = new Jugador();
        try {
            j.setIdJugador(resultSet.getInt(table.PRIMARY_KEY));
            j.setMaximoNivelAlcanzado(resultSet.getInt(table.fields[0]));
            j.setCantMonedas(resultSet.getInt(table.fields[1]));
            j.setIdUsuario(resultSet.getInt(table.fields[2]));
            j.setPuntajeMax(resultSet.getInt(table.fields[3]));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return j;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Jugador toDelete) {
        PreparedStatement ps = null;
        String query = "DELETE FROM " + table.TABLE_NAME + " WHERE " + table.PRIMARY_KEY + " = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toDelete.getIdJugador());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(JugadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Jugador toInsert) {
        PreparedStatement ps = null;
        String query = "INSERT INTO " + table.TABLE_NAME
                + "(" + table.fields[2] + ") VALUES (?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toInsert.getIdUsuario());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Jugador toUpdate) {
        PreparedStatement ps = null;

        String query = "UPDATE TABLE " + table.TABLE_NAME + "SET "
                + table.fields[0] + "  = ?,"
                + table.fields[1] + "  = ? "
                + table.fields[2] + "  = ? "
                + table.fields[3] + "  = ? "
                + "WHERE " + table.PRIMARY_KEY + "  = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toUpdate.getMaximoNivelAlcanzado());
            ps.setInt(2, toUpdate.getCantMonedas());
            ps.setInt(3, toUpdate.getIdUsuario());
            ps.setInt(4, toUpdate.getPuntajeMax());
            ps.setInt(5, toUpdate.getIdJugador());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    List<Jugador> findByIDUsuario(Jugador j) {
        return findBy(j, table.fields[2]);
    }

    List<Jugador> findByIDJugador(Jugador j) {
        return findBy(j, table.PRIMARY_KEY);
    }

    public Jugador findFromUser(Jugador player) {
        List<Jugador> matched = findByIDUsuario(player);
        boolean notFound = (matched.isEmpty());
        if (notFound) {
            return null;
        } else {
            return matched.get(0);
        }
    }

    public List<Jugador> getRanking() {
        Connection con = null;
        ArrayList<Jugador> found = new ArrayList<>();

        try {
            con = this.con.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(
                    "SELECT *"
                    + " FROM " + table.TABLE_NAME
                    + " ORDER BY " + table.fields[3]
                    + " DESC LIMIT " + toDisplay);

            while (rs.next()) {
                Jugador registro = mapToObject(rs);
                found.add(registro);
            }
            rs.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return found;
    }

}
