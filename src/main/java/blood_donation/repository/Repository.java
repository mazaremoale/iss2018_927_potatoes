package blood_donation.repository;


import java.util.Map;
import java.util.Set;

public class Repository<T>
{

    private Map<Integer,T> elems;
    /**
     * Find the entity with the given {@code id}.
     *
     * @param id
     *            must be not null.
     * @return the entity with the given id.
     */
    T findOne(int id)
    {
        return null;
    }


    /**
     *
     * @return all entities.
     */
    Set<T> findAll()
    {
        return null;
    }


    /**
     * Saves the given entity.
     *
     * @param entity
     *            must not be null.
     */
    void save(T entity)
    {
        //elems.put(elem.getId(),elem);
        //entityManager.persist(elem);
    }


    /**
     * Removes the entity with the given id.
     *
     * @param id
     *            must not be null.
     */
    void delete(int id)
    {
        //entityManager.remove(elem);

    }


    /**
     * Updates the given entity.
     *
     * @param entity
     *            must not be null.
     */
    void update(T entity)
    {

    }


}
