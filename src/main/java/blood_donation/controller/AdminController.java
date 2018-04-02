package blood_donation.controller;

import blood_donation.domain.people.Doctor;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AdminController
{
    private Stage stage;

    @FXML
    private TextField firstnameTextField;

    @FXML
    private TextField lastnameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private TextField hospitalTextField;

    public void addDoctor()
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");;
        EntityManager entityManager =  entityManagerFactory.createEntityManager();

        Doctor doctor = new Doctor(firstnameTextField.getText(), lastnameTextField.getText(),
                            usernameTextField.getText(), passwordTextField.getText(),
                            hospitalTextField.getText());

        entityManager.getTransaction().begin();
        entityManager.persist(doctor);
        entityManager.getTransaction().commit();

        entityManagerFactory.close();
    }
}
