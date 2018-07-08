package EnWo.data.dao;

import EnWo.data.entidades.Habilidad;
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
public class HabilidadesDAO extends BaseDAO<Habilidad> {

    public HabilidadesDAO() {
        table = new TableData("habilidad", "_id",
                new String[]{"nombreHabilidad", "descripcionHabilidad",
                    "nivelDisponibilidad", "costoHabilidad"});
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Habilidad find, String by) {
        PreparedStatement ps = null;
        String query = "SELECT * FROM " + table.TABLE_NAME + " WHERE " + by + " = ?";
        try {
            ps = con.prepareStatement(query);
            if (by.equals(table.PRIMARY_KEY)) {
                ps.setInt(1, find.getIdHabilidad());
            } else if (by.equals(table.fields[0])) {
                ps.setString(1, find.getNombreHabilidad());
            } else if (by.equals(table.fields[1])) {
                ps.setString(1, find.getDescripcionHabilidad());
            } else if (by.equals(table.fields[2])) {
                ps.setInt(1, find.getNivelDisponibilidad());
            } else if (by.equals(table.fields[3])) {
                ps.setInt(1, find.getCostoHabilidad());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    Habilidad mapToObject(ResultSet resultSet) {
        Habilidad h = new Habilidad();
        try {
            h.setIdHabilidad(resultSet.getInt(table.PRIMARY_KEY));
            h.setNombreHabilidad(resultSet.getString(table.fields[0]));
            h.setDescripcionHabilidad(resultSet.getString(table.fields[1]));
            h.setNivelDisponibilidad(resultSet.getInt(table.fields[2]));
            h.setCostoHabilidad(resultSet.getInt(table.fields[3]));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return h;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Habilidad toDelete) {
        PreparedStatement ps = null;
        String query = "DELETE FROM " + table.TABLE_NAME + " WHERE " + table.PRIMARY_KEY + " = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toDelete.getIdHabilidad());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(JugadoresDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Habilidad toInsert) {
        PreparedStatement ps = null;
        String query = "INSERT INTO " + table.TABLE_NAME
                + "(" + table.fields[0] + ", " + table.fields[1] + ", "
                + table.fields[2] + ", " + table.fields[3]
                + ") VALUES (?, ?, ?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, toInsert.getNombreHabilidad());
            ps.setString(2, toInsert.getDescripcionHabilidad());
            ps.setInt(3, toInsert.getNivelDisponibilidad());
            ps.setInt(4, toInsert.getCostoHabilidad());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Habilidad toUpdate) {
        PreparedStatement ps = null;

        String query = "UPDATE TABLE " + table.TABLE_NAME + "SET "
                + table.fields[0] + "  = ?,"
                + table.fields[1] + "  = ? "
                + table.fields[2] + "  = ? "
                + table.fields[3] + "  = ? "
                + "WHERE " + table.PRIMARY_KEY + "  = ?";
        try {
            ps = con.prepareStatement(query);
            ps.setString(1, toUpdate.getNombreHabilidad());
            ps.setString(2, toUpdate.getDescripcionHabilidad());
            ps.setInt(3, toUpdate.getNivelDisponibilidad());
            ps.setInt(4, toUpdate.getCostoHabilidad());
            ps.setInt(5, toUpdate.getIdHabilidad());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    List<Habilidad> findByNombreHabilidad(Habilidad h) {
        return findBy(h, table.fields[0]);
    }

    List<Habilidad> findByNivelHabilidad(Habilidad h) {
        return findBy(h, table.fields[2]);
    }

    List<Habilidad> findByIDHabilidad(Habilidad h) {
        return findBy(h, table.PRIMARY_KEY);
    }
}
