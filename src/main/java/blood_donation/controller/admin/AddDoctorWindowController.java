package blood_donation.controller.admin;

import blood_donation.domain.people.Doctor;
import blood_donation.domain.utils.Hospital;
import blood_donation.repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class AddDoctorWindowController implements Initializable
{
    private Session session;
    private Stage primaryStage;

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

    private Repository<Doctor> doctorRepository;

    public AddDoctorWindowController setDoctorRepository(Repository<Doctor> doctorRepository)
    {
        this.doctorRepository = doctorRepository;
        return this;
    }

    public AddDoctorWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public AddDoctorWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    @FXML
    private void addDoctor()
    {
        ObservableList<Doctor> doctorObservableList = FXCollections.observableArrayList();

        String firstName = firstNameTextField.getText();
        String lastName = lastNameTextField.getText();
        String username = usernameTextField.getText();
        String password = passwordTextField.getText();


        Hospital hospital = hospitalComboBox.getSelectionModel().getSelectedItem();

        Doctor doctor = new Doctor(firstName,lastName,username,password,hospital);


        System.out.println(doctor);

    }




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        //ObservableList<Hospital> hospitals = FXCollections.observableArrayList();


        // hospitals.addAll(hospitalRepository.getAll());

        //hospitalComboBox.setItems(hospitals);
    }
}
