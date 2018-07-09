package EnWo.data.dao;


import EnWo.data.entidades.PXH;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Tania Orellana
 */
public class PersonajesxHabilidadDAO extends BaseDAO<PXH> {

    public PersonajesxHabilidadDAO() {
        table = new TableData("personajeXhabilidad", "_id",
                new String[]{"idPersonaje", "idHabilidad"});
    }

    @Override
    PXH mapToObject(ResultSet resultSet) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, PXH find, String by) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, PXH toDelete) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, PXH toInsert) {
                      PreparedStatement ps = null;
        String query = "INSERT INTO " + table.TABLE_NAME
                + "(" + table.fields[0] + ", " + table.fields[1] + ") VALUES (?, ?)";
        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toInsert.getIdPersonaje());
            ps.setInt(2, toInsert.getidHabilidad());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(PersonajesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, PXH toUpdate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

 

    
   
}
