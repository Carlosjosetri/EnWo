package EnWo.data.dao;

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
 * @param <T> se adaptará a cada entidad
 */
public abstract class BaseDAO<T> implements DAO<T> {

    protected TableData table;

    // CONSTRUCTORES
    public BaseDAO() {
    }

    public BaseDAO(TableData table) {
        this.table = table;
    }

    // IMPLEMENTANDO MÉTODOS DE LA INTERFAZ
    @Override
    public List<T> findAll() {
        Connection con = null;
        ArrayList<T> found = new ArrayList<>();

        try {
            con = this.con.getConnection();
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("SELECT * FROM " + table.TABLE_NAME);

            while (rs.next()) {
                T registro = mapToObject(rs);
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

    @Override
    public List<T> findBy(T find, String by) {
        Connection con = null;
        ArrayList<T> list = new ArrayList<>();
        try {
            con = this.con.getConnection();
            PreparedStatement preparedStatement = getSelectStatement(con, find, by);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                T row = mapToObject(resultSet);
                list.add(row);
            }
            resultSet.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(con);
        }
        return list;
    }

    @Override
    public boolean insert(T ObjectToInsert) {
        Connection con = null;
        boolean inserted = false;

        try {
            con = this.con.getConnection();

            PreparedStatement ps = getInsertStatement(con, ObjectToInsert);
            inserted = (ps.executeUpdate() > 0);

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }
        return inserted;
    }

    @Override
    public boolean delete(T ObjectToDelete) {
        Connection con = null;
        boolean deleted = false;

        try {
            con = this.con.getConnection();

            PreparedStatement ps = getDeleteStatement(con, ObjectToDelete);
            deleted = (ps.executeUpdate() > 0);
            ps.close();

        } catch (SQLException ex) {
//            ex.printStackTrace();
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }

        return deleted;
    }

    @Override
    public boolean update(T ObjectToUpdate) {
        Connection con = null;
        boolean updated = false;

        try {
            con = this.con.getConnection();

            PreparedStatement ps = getUpdateStatement(con, ObjectToUpdate);
            updated = (ps.executeUpdate() > 0);

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            close(con);
        }

        return updated;
    }

    // CERRAR CONEXIÓN
    public void close(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(BaseDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // MÉTODOS ABSTRACTOS QUE LAS SUBCLASES VAN A IMPLEMENTAR
    abstract T mapToObject(ResultSet resultSet);

    abstract PreparedStatement getSelectStatement(Connection con, T find, String by);

    abstract PreparedStatement getDeleteStatement(Connection con, T toDelete);

    abstract PreparedStatement getInsertStatement(Connection con, T toInsert);

    abstract PreparedStatement getUpdateStatement(Connection con, T toUpdate);
}
