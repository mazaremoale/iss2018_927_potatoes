package blood_donation.controller;

import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Personnel;
import blood_donation.repository.Repository;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserSelectController
{
    private Repository<Doctor> doctorRepository;
    private Repository<Donor> donorRepository;
    private Repository<Personnel> personnelRepository;

    private Stage primaryStage;

    public UserSelectController(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    public void exit()
    {
        System.exit(0);
    }

    public void openAdminLogin() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/loginWindow.fxml"));
        loader.setController(new LoginController(primaryStage));
        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Login");
    }

    public void forget()
    {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("org.hibernate.tutorial.jpa");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManagerFactory.close();
    }
}
