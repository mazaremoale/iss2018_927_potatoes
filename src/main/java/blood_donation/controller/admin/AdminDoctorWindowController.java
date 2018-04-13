package blood_donation.controller.admin;

import blood_donation.domain.people.Doctor;
import blood_donation.domain.utils.Hospital;
import blood_donation.repository.Repository;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class AdminDoctorWindowController implements Initializable
{
    private Session session;
    private Stage primaryStage;

    private Repository<Hospital> hospitalRepository;
    private Repository<Doctor> doctorRepository;

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

    @FXML
    private Label warningLabel;

    @FXML
    private TableColumn<Doctor, String> doctorIDColumn;

    @FXML
    private TableColumn<Doctor, String> doctorLastNameColumn;

    @FXML
    private TableColumn<Doctor, String> doctorFirstNameColumn;

    @FXML
    private TableColumn<Doctor, String> doctorUsernameColumn;

    @FXML
    private TableColumn<Doctor, String> doctorPasswordColumn;

    @FXML
    private TableColumn<Doctor, String> doctorHospitalColumn;

    @FXML
    private TableView<Doctor> doctorTableView;


    public AdminDoctorWindowController setDoctorRepository(Repository<Doctor> doctorRepository)
    {
        this.doctorRepository = doctorRepository;
        return this;
    }

    public AdminDoctorWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public AdminDoctorWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public AdminDoctorWindowController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    @FXML
    public void addDoctor()
    {
        ObservableList<Doctor> doctorObservableList = FXCollections.observableArrayList();

        if(firstNameTextField.getText().length() > 0 &&
                lastNameTextField.getText().length() > 0 &&
                usernameTextField.getText().length() > 0 &&
                passwordTextField.getText().length() > 0 &&
                !hospitalComboBox.getSelectionModel().isEmpty()
                )
        {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            Hospital hospital = hospitalComboBox.getSelectionModel().getSelectedItem();

            Doctor doctor = new Doctor(firstName,lastName,username,password,hospital);

            session.getTransaction().begin();
            session.persist(doctor);
            session.getTransaction().commit();
            doctorTableView.getItems().add(doctor);
            firstNameTextField.clear();
            lastNameTextField.clear();
            usernameTextField.clear();
            passwordTextField.clear();
            hospitalComboBox.getSelectionModel().clearSelection();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("All the fields are required in order to continue");
            alert.setContentText("Please fill in all the fields");

            Optional<ButtonType> result = alert.showAndWait();
        }


    }




    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        warningLabel.setVisible(false);

        ObservableList<Hospital> hospitals = FXCollections.observableArrayList();
        hospitals.addAll(hospitalRepository.getAll());
        hospitalComboBox.setItems(hospitals);

        ObservableList<Doctor> doctors = FXCollections.observableArrayList();
        doctors.addAll(doctorRepository.getAll());

        doctorIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        doctorLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        doctorFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        doctorUsernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        doctorPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        doctorHospitalColumn.setCellValueFactory(data -> data.getValue().hospitalProperty());

        doctorTableView.setItems(doctors);

    }
}
