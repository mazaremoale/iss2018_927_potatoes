package blood_donation.controller.donor;

import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public final class DonorRegistrationWindowController implements Initializable
{

    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    public DonorRegistrationWindowController()
    {

    }

    public DonorRegistrationWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public DonorRegistrationWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public DonorRegistrationWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
