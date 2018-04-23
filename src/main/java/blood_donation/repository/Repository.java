package blood_donation.repository;


import org.hibernate.Session;

import java.util.List;
import java.util.stream.Collectors;


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
        return (List<T>) session.createQuery("from " + tClass.getSimpleName()).list().stream()
                .filter(entity -> entity.getClass() == tClass).collect(Collectors.toList());

    }


    public T getByID(int id)
    {
        return session.load(tClass,id);
    }

    public void add(T entity)
    {
        try
        {
            session.getTransaction().begin();
            session.persist(entity);
            session.getTransaction().commit();
        }
        catch(Exception e)
        {
            System.out.println("Something went bad in sql");
        }
    }

    public void remove(int id)
    {
        T entity = getByID(id);
        session.getTransaction().begin();
        session.delete(entity);
        session.getTransaction().commit();
    }

    public void update(T newEntity)
    {
        //problem is that I can't set the ID here, it's generic, has no clue what functions
        // it got
        //could solve it by putting a master base class which has a id field
        //too much work right now
        //we need to make sure this newEntity comes with the proper ID that it will be
        // replacing in the database
        session.getTransaction().begin();
        session.merge(newEntity);
        session.getTransaction().commit();
    }

    @Override
    public String toString()
    {
        return tClass.getSimpleName() + " repository";
    }
}
