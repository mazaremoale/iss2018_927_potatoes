package repository;

import domain.people.Person;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.HashMap;

public class Repository<T extends Person>
{
    private HashMap<Integer, T> elems;
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public Repository()
    {
        this.elems = new HashMap<>();
//        this.entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");;
        //this.entityManager =  entityManagerFactory.createEntityManager();
    }
    // entityManagerFactory.close();

    public void add(T elem)
    {
        elems.put(elem.getId(),elem);
        entityManager.persist(elem);
    }

    public void remove(T elem)
    {
        elems.remove(elem.getId());
        entityManager.remove(elem);
    }

    public void update(T elem)
    {
        elems.put(elem.getId(),elem);
        Person persistentElem = entityManager.find(Person.class, elem.getId());

        entityManager.flush();
    }

}
