package controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class userSelectController
{
    public void doSomething()
    {
        System.out.println("I work");
    }

    public void exit()
    {
        System.exit(0);
    }

    public void forget()
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManagerFactory.close();
    }
}
