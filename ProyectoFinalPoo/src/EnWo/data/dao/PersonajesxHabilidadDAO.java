package EnWo.data.dao;

import EnWo.data.entidades.Habilidad;
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
public class PersonajesxHabilidadDAO extends BaseDAO<Personaje> {

    public PersonajesxHabilidadDAO() {
        table = new TableData("personajeXhabilidad", "_id",
                new String[]{"PkFkpersonaje", "PkFkHabilidad"});
    }

 

    
    @Override
    PreparedStatement getSelectStatement(Connection con, Personaje find, String by) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Personaje toDelete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    PreparedStatement getInsertStatement(Connection con, Personaje toInsert,Habilidad toInsert2) {
               PreparedStatement ps = null;
        String query = "INSERT INTO " + table.TABLE_NAME
                + "(" + table.fields[0] + ", " + table.fields[1] + ") VALUES (?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toInsert.getIdPersonaje());
            ps.setInt(2, toInsert2.getIdHabilidad());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Personaje toUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    Personaje mapToObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Personaje toInsert) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
