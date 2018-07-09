package EnWo.data.dao;

import EnWo.data.Connection;
import java.util.List;

/**
 *
 * @author Tania Orellana
 * @param <T>
 */
public interface DAO<T> {

    Connection con = Connection.getInstance();

    /**
     * funciones que retornan una lista de registros.
     *
     */
    /**
     * @return
     */
    List<T> findAll();

    /**
     *
     * @param find
     * @param by
     * @return
     */
    List<T> findBy(T find, String by);

    /**
     * Funciones que retornan un booleano que indique si la operación fue
     * exitosa.
     */
    /**
     *
     * @param ObjectToInsert
     * @return
     */
    boolean insert(T ObjectToInsert);

    /**
     *
     * @param ObjectToDelete
     * @return
     */
    boolean delete(T ObjectToDelete);

    /**
     *
     * @param ObjectToUpdate
     * @return
     */
    boolean update(T ObjectToUpdate);
}
