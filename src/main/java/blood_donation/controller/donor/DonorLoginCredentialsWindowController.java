package blood_donation.controller.donor;

import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Person;
import blood_donation.domain.utils.Donation;
import blood_donation.repository.Repository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class DonorLoginCredentialsWindowController implements Initializable
{

    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Donor currentDonor;
    private Repository<Donor> donorRepository;
    private Repository<Donation> donationRepository;

    private List<String> usernames;


    @FXML
    private TextField usernameTextField;

    @FXML
    private Label usernameAvailableLabel;

    @FXML
    private PasswordField passwordPasswordField;

    @FXML
    private Label passwordValidLabel;

    @FXML
    private PasswordField confirmationPasswordField;

    @FXML
    private Label passwordsMatchLabel;


    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DonorLoginCredentialsWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DonorLoginCredentialsWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DonorLoginCredentialsWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Donor getCurrentDonor()
    {
        return currentDonor;
    }

    public DonorLoginCredentialsWindowController setCurrentDonor(Donor currentDonor)
    {
        this.currentDonor = currentDonor;
        return this;
    }

    public Repository<Donor> getDonorRepository()
    {
        return donorRepository;
    }

    public DonorLoginCredentialsWindowController setDonorRepository(Repository<Donor> donorRepository)
    {
        this.donorRepository = donorRepository;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public DonorLoginCredentialsWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    public void register() throws IOException
    {
        if(!usernameTextField.getText().isEmpty() &&
                !confirmationPasswordField.getText().isEmpty() &&
                !passwordPasswordField.getText().isEmpty() &&
                !usernames.contains(usernameTextField.getText()))
        {
            currentDonor.setUsername(usernameTextField.getText());
            currentDonor.setPassword(passwordPasswordField.getText());

            donorRepository.add(currentDonor);
            usernames.add(currentDonor.getUsername());

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/donor/donorMainWindow.fxml"));
            loader.setController(new DonorMainWindowController()
                    .setPrimaryStage(primaryStage)
                    .setSession(session)
                    .setPreviousScene(primaryStage.getScene())
                    .setCurrentDonor(currentDonor)
                    .setDonationRepository(donationRepository));


            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Donor registration");

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("All the fields must be filled");
            alert.setContentText("Please fill in all the fields");

            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        usernameAvailableLabel.setText("");
        passwordValidLabel.setText("");
        passwordsMatchLabel.setText("");

        usernames = donorRepository.getAll().stream().map(Person::getUsername).collect(Collectors.toList());


        usernameTextField.textProperty().addListener((observable, oldValue, newValue) ->
        {

            if(newValue.equals(""))
            {
                usernameAvailableLabel.setText("");
            }
            else if(usernames.contains(newValue))
            {
                usernameAvailableLabel.setText("Username already taken");
                usernameAvailableLabel.setTextFill(Color.web("#ff0000"));//red
            }
            else
            {
                usernameAvailableLabel.setText("Username available");
                usernameAvailableLabel.setTextFill(Color.web("#33cc33"));//green
            }
        });

        passwordPasswordField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if(newValue.equals(""))
            {
                passwordValidLabel.setText("");
            }
            else if(passwordPasswordField.getText().length() < 4 || passwordPasswordField.getText().length() > 20 ||
                    !passwordPasswordField.getText().matches(".*[0-9].*"))
            {
                passwordValidLabel.setText("Must have 4-20 characters and a digit");
                passwordValidLabel.setTextFill(Color.web("#ff0000"));//red
            }
            else
            {
                passwordValidLabel.setText("Password meets all requirements");
                passwordValidLabel.setTextFill(Color.web("#33cc33"));//green
            }
        });

        confirmationPasswordField.textProperty().addListener((observable, oldValue, newValue) ->
        {
            if(newValue.equals(""))
            {
                passwordsMatchLabel.setText("");
            }
            else if(passwordPasswordField.getText().equals(confirmationPasswordField.getText()))
            {
                passwordsMatchLabel.setText("Passwords match");
                passwordsMatchLabel.setTextFill(Color.web("#33cc33"));//green
            }
            else
            {
                passwordsMatchLabel.setText("Passwords don't match");
                passwordsMatchLabel.setTextFill(Color.web("#ff0000"));//red

            }
        });


    }
}
