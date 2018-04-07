package blood_donation.repository;

import org.hibernate.Session;

import java.util.List;


public class Repository<T>
{
    private Class<T> tClass;
    private Session session;

    public Repository(Class<T> tClass, Session session)
    {
        this.tClass = tClass;
        this.session = session;
    }

    public Session getSession()
    {
        return session;
    }

    public void setSession(Session session)
    {
        this.session = session;
    }

    public List<T> getAll()
    {
        return session.createNativeQuery("select * from " +
                                    tClass.getSimpleName() +
                                    " where type = ?",tClass)
                .setParameter(1,tClass.getSimpleName())
                .list();
    }

    public T getByID(int id)
    {
        return session.load(tClass,id);
    }

    public void add(T entity)
    {
        session.persist(entity);
    }

    public void remove(int id)
    {
        T entity = getByID(id);
        session.delete(entity);
    }

    public void update(T newEntity)
    {
        //problem is that I can't set the ID here, it's generic, has no clue what functions
        // it got
        //could solve it by putting a master base class which has a id field
        //too much work right now
        //we need to make sure this newEntity comes with the proper ID that it will be
        // replacing in the database
        session.merge(newEntity);
    }

    @Override
    public String toString()
    {
        return tClass.getSimpleName() + " repository";
    }
}
