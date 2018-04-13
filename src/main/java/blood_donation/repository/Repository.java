package blood_donation.repository;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.people.Person;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public final class Repository<T>
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

        //Silly single-table strategy :(
        if(tClass == Blood.class || tClass == Person.class)
        {
            return session.createNativeQuery("select * from " +
                    tClass.getSimpleName() + "s" +
                    " where type = ?", tClass)
                    .setParameter(1, tClass.getSimpleName())
                    .list();
        }
        else if(tClass.getSuperclass() == Blood.class || tClass.getSuperclass() == Person.class)
        {
            return session.createNativeQuery("select * from " +
                    tClass.getSuperclass().getSimpleName() + "s" +
                    " where type = ?", tClass)
                    .setParameter(1, tClass.getSimpleName())
                    .list();
        }
        else
        {
            return session.createQuery("from " + tClass.getSimpleName())
                    .list();
        }

    }

    public T getByID(int id)
    {
        return session.load(tClass,id);
    }

    public void add(T entity)
    {
        session.getTransaction().begin();
        session.persist(entity);
        session.getTransaction().commit();
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
