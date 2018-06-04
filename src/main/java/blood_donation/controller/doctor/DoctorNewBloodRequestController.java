package blood_donation.controller.doctor;

import blood_donation.domain.people.Doctor;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class DoctorNewBloodRequestController implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Doctor currentDoctor;

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DoctorNewBloodRequestController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DoctorNewBloodRequestController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DoctorNewBloodRequestController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Doctor getCurrentDoctor()
    {
        return currentDoctor;
    }

    public DoctorNewBloodRequestController setCurrentDonor(Doctor currentDoctor)
    {
        this.currentDoctor = currentDoctor;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
