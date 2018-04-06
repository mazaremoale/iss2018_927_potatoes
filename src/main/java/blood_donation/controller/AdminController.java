package blood_donation.controller;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.utils.Hospital;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable
{
    private Stage primaryStage;

    private EntityManager entityManager;


    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private ComboBox<Hospital> hospitalComboBox;


    public void addDoctor()
    {


        //design a drop-down menu @hospital field in the GUI from where you can pick from a list
        //of hospitals from the database





    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        /*
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");;

        entityManager =  entityManagerFactory.createEntityManager();

        ObservableList<Hospital> hospitals = FXCollections.observableArrayList();

        Query query = entityManager.createQuery("from Hospital",Hospital.class);
        List<Hospital> hospitalsList = query.getResultList();
        hospitals.addAll(hospitalsList);

        hospitalComboBox.setItems(hospitals);

        Configuration configuration = new Configuration();
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        session.persist(new Blood());


        session.getTransaction().commit();
        */
    }
}
