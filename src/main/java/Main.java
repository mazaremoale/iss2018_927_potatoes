import domain.people.Doctor;
import domain.people.Donor;
import domain.people.Person;
import org.hibernate.Session;
import org.hibernate.query.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();


        Doctor d = new Doctor();
        d.setLastName("ManLan");
        d.setFirstName("Arad-Napoca");
        Donor q = new Donor();
        q.setResidenceCity("Arad");
        q.setIdCounty("Arad");


        entityManager.getTransaction().begin();
        //entityManager.persist(d);
        //entityManager.persist(q);
        Doctor docup = new Doctor();
        docup.setFirstName("Updated");
        Doctor doc = entityManager.find(Doctor.class,1);
        doc = docup;
        System.out.println(doc.getFirstName());
        entityManager.getTransaction().commit();

        Session session = (Session) entityManager.getDelegate();

        Query query = session.createQuery("from Person where type = 'doctor'");
        List list = query.list();

        list.forEach(System.out::println);

        entityManagerFactory.close();

    }


}

