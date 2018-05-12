package blood_donation.controller.donor;

import blood_donation.domain.people.Donor;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

public class DonorMainWindowController
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Donor currentDonor;

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DonorMainWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DonorMainWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DonorMainWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Donor getCurrentDonor()
    {
        return currentDonor;
    }

    public DonorMainWindowController setCurrentDonor(Donor currentDonor)
    {
        this.currentDonor = currentDonor;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }
}
