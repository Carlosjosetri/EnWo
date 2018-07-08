package EnWo.data.dao;

import EnWo.data.entidades.Usuario;
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
public class UsuariosDAO extends BaseDAO<Usuario> {

    public UsuariosDAO() {
        table = new TableData("usuario", "_id",
                new String[]{"username", "password"});
    }

    @Override
    PreparedStatement getSelectStatement(Connection con, Usuario find, String by) {
        // BASE DEL QUERY
        String query = "SELECT * FROM " + table.TABLE_NAME;
        // CREAR UN PS VACIO
        PreparedStatement ps = null;
        try {
            if (table.fields[0].equals(by)) {
                query += " WHERE " + table.fields[0] + " = ?";
                ps = con.prepareStatement(query);
//                ps.setInt(1, findAll.getIdUsuario());
                ps.setString(1, find.getUsername());
            } else if (by.equals(table.PRIMARY_KEY)) {
                query += " WHERE " + table.PRIMARY_KEY + " = ?";
                ps = con.prepareStatement(query);
                ps.setInt(1, find.getIdUsuario());
            } else if (by.equals("login")) {
                query += " WHERE " + table.fields[0] + " = ? "
                        + "AND " + table.fields[1] + " = ?";
                ps = con.prepareStatement(query);
                ps.setString(1, find.getUsername());
                ps.setString(2, find.getPassword());
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ps;
    }

    @Override
    Usuario mapToObject(ResultSet resultSet) {
        Usuario user = new Usuario();

        try {
            user.setIdUsuario(resultSet.getInt(table.PRIMARY_KEY));
            user.setUsername(resultSet.getString(table.fields[0]));
            user.setPassword(resultSet.getString(table.fields[1]));
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    PreparedStatement getDeleteStatement(Connection con, Usuario toDelete) {

        PreparedStatement ps = null;

        String query = "DELETE FROM " + table.TABLE_NAME
                + " WHERE " + table.PRIMARY_KEY + " = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setInt(1, toDelete.getIdUsuario());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getInsertStatement(Connection con, Usuario toInsert) {
        PreparedStatement ps = null;

        String query = "INSERT INTO " + table.TABLE_NAME
                + "(" + table.fields[0] + "," + table.fields[1] + ")"
                + " VALUES (?, ?)";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, toInsert.getUsername());
            ps.setString(2, toInsert.getPassword());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    @Override
    PreparedStatement getUpdateStatement(Connection con, Usuario toUpdate) {
        PreparedStatement ps = null;

        String query = "UPDATE TABLE " + table.TABLE_NAME + "SET "
                + table.fields[0] + "  = ?,"
                + table.fields[1] + "  = ? "
                + "WHERE " + table.PRIMARY_KEY + "  = ?";

        try {
            ps = con.prepareStatement(query);
            ps.setString(1, toUpdate.getUsername());
            ps.setString(2, toUpdate.getPassword());
            ps.setInt(3, toUpdate.getIdUsuario());
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public boolean logIn(Usuario user) {
        List<Usuario> matched = findBy(user, "login");
        boolean loggedIn = (matched.size() == 1);
        if (loggedIn) {
            user.setIdUsuario(matched.get(0).getIdUsuario());
        }
        return loggedIn;
    }

    public boolean signUp(Usuario u) throws SQLException {
        boolean registered = (insert(u));

        if (registered) {
            Usuario user = findFromUsername(u);
            u.setIdUsuario(user.getIdUsuario());
        }
        return registered;
    }

    List<Usuario> findByIDUsuario(Usuario u) {
        return findBy(u, table.PRIMARY_KEY);
    }

    List<Usuario> findByUsername(Usuario u) {
        return findBy(u, table.fields[0]);
    }

    public Usuario findFromID(Usuario user) {
        List<Usuario> matched = findByIDUsuario(user);
        boolean notFound = (matched.isEmpty());
        if (notFound) {
            return null;
        } else {
            return matched.get(0);
        }
    }

    public Usuario findFromUsername(Usuario user) {
        List<Usuario> matched = findByUsername(user);
        boolean notFound = (matched.isEmpty());
        if (notFound) {
            return null;
        } else {
            return matched.get(0);
        }
    }
}
