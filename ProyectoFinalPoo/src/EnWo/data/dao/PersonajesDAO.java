package EnWo.data.dao;

import EnWo.data.entidades.Personaje;
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
public class PersonajesDAO extends BaseDAO<Personaje> {

    public PersonajesDAO() {
        table = new TableData("personaje", "_id",
                new String[]{"nombrePersonaje", "damage"});
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Personaje find, String by) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table.TABLE_NAME + " WHERE " + by + " = ?";
        try {
            ps = con.prepareStatement(query);
            if (by.equals(table.PRIMARY_KEY)) {
                ps.setInt(1, find.getIdPersonaje());
            } else if (by.equals(table.fields[0])) {
                ps.setString(1, find.getNombrePersonaje());
            } else if (by.equals(table.fields[1])) {
                ps.setInt(1, find.getDamage());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    Personaje mapToObject(ResultSet resultSet
    ) {
        Personaje p = new Personaje();

        try {
            p.setIdPersonaje(resultSet.getInt(table.PRIMARY_KEY));
            p.setNombrePersonaje(resultSet.getString(table.fields[0]));
            p.setDamage(resultSet.getInt(table.fields[1]));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Personaje toDelete
    ) {
        PreparedStatement ps = null;
        String query = "DELETE FROM " + table.TABLE_NAME + " WHERE " + table.PRIMARY_KEY + " = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toDelete.getIdPersonaje());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(JugadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Personaje toInsert
    ) {
        PreparedStatement ps = null;
        String query = "INSERT INTO " + table.TABLE_NAME
                + "(" + table.fields[0] + ", " + table.fields[1] + ") VALUES (?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, toInsert.getNombrePersonaje());
            ps.setInt(2, toInsert.getDamage());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Personaje toUpdate
    ) {
        PreparedStatement ps = null;

        String query = "UPDATE TABLE " + table.TABLE_NAME + "SET "
                + table.fields[0] + "  = ?,"
                + table.fields[1] + "  = ? "
                + "WHERE " + table.PRIMARY_KEY + "  = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, toUpdate.getNombrePersonaje());
            ps.setInt(2, toUpdate.getDamage());
            ps.setInt(3, toUpdate.getIdPersonaje());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    List<Personaje> findByNombrePersonaje(Personaje p) {
        return findBy(p, table.fields[0]);
    }
    
    List<Personaje> findByIDPersonaje(Personaje p) {
        return findBy(p, table.PRIMARY_KEY);
    }
}
