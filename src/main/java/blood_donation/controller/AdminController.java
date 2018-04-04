package blood_donation.controller;

import blood_donation.domain.utils.Hospital;
import blood_donation.domain.utils.Location;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable
{
    private Stage stage;

    private EntityManager entityManager;
    private EntityManagerFactory entityManagerFactory;


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




        entityManager.getTransaction().begin();
        //entityManager.persist(doctor);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");;
        entityManager =  entityManagerFactory.createEntityManager();

        //hospitalComboBox.setValue;

        ObservableList<Hospital> hospitals = FXCollections.observableArrayList();


        Hospital hospital1 = entityManager.find(Hospital.class,1);
        Hospital hospital2 = entityManager.find(Hospital.class,2);

        hospitals.add(hospital1);
        hospitals.add(hospital2);


        hospitalComboBox.setItems(hospitals);
    }
}
