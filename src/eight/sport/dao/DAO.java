package eight.sport.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * E-Entity -> snimamo u bazu i koji nam služi da mapiramo podatke iz baze
 * <p>
 * E -> PlayerInfo, Sport, User
 * <p>
 * <ol>CRUD
 * <li>Create
 * <li>Retrieve
 * <li>Update
 * <li>Delete
 *
 * @author grupa 1
 * @param <E>
 */
public interface DAO<E> {

    //CREATE
    void save(E entity) throws SQLException;

    //READ
    List<E> loadAll() throws SQLException;

    E get(int id) throws SQLException;

    //UPDATE
    void update(E entity) throws SQLException;

    //DELETE
    void delete(E entity) throws SQLException;
}
