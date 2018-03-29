package blood_donation.controller;

import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Personnel;
import blood_donation.repository.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class userSelectController
{
    private Repository<Doctor> doctorRepository;
    private Repository<Donor> donorRepository;
    private Repository<Personnel> personnelRepository;
    private String adminUsername = "root";
    private String adminPassword = "cartofi3";


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
