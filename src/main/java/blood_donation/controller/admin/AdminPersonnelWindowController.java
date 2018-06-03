package blood_donation.controller.admin;

import blood_donation.domain.people.Personnel;
import blood_donation.domain.utils.Clinic;
import blood_donation.repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public final class AdminPersonnelWindowController implements Initializable
{
    private Session session;
    private Stage primaryStage;
    private Scene previousScene;

    private Repository<Clinic> clinicRepository;
    private Repository<Personnel> personnelRepository;



    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordTextField;

    @FXML
    private ComboBox<Clinic> clinicComboBox;

    @FXML
    private TableColumn<Personnel, String> personnelIDColumn;

    @FXML
    private TableColumn<Personnel, String> personnelLastNameColumn;

    @FXML
    private TableColumn<Personnel, String> personnelFirstNameColumn;

    @FXML
    private TableColumn<Personnel, String> personnelUsernameColumn;

    @FXML
    private TableColumn<Personnel, String> personnelPasswordColumn;

    @FXML
    private TableColumn<Personnel, String> personnelClinicColumn;

    @FXML
    private TableView<Personnel> personnelTableView;


    public AdminPersonnelWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public AdminPersonnelWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public AdminPersonnelWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public AdminPersonnelWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public AdminPersonnelWindowController setPersonnelRepository(Repository<Personnel> personnelRepository)
    {
        this.personnelRepository = personnelRepository;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
        primaryStage.setTitle("Admin management panel");
    }

    @FXML
    public void addPersonnel()
    {
        if(firstNameTextField.getText().length() > 0 &&
                lastNameTextField.getText().length() > 0 &&
                usernameTextField.getText().length() > 0 &&
                passwordTextField.getText().length() > 0 &&
                !clinicComboBox.getSelectionModel().isEmpty()
                )
        {
            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            Clinic clinic = clinicComboBox.getSelectionModel().getSelectedItem();

            Personnel personnel = new Personnel(firstName, lastName, username, password, clinic);

            personnelRepository.add(personnel);

            personnelTableView.getItems().add(personnel);

            firstNameTextField.clear();
            lastNameTextField.clear();
            usernameTextField.clear();
            passwordTextField.clear();
            clinicComboBox.getSelectionModel().clearSelection();
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

    @FXML
    public void removePersonnel()
    {
        if(!personnelTableView.getSelectionModel().isEmpty())
        {
            int selectedIndex = personnelTableView.getSelectionModel().getSelectedIndex();

            Personnel personnel = personnelTableView.getSelectionModel().getSelectedItem();

            personnelTableView.getItems().remove(selectedIndex);
            personnelRepository.remove(personnel.getId());
        }
    }

    @FXML
    public void updatePersonnel()
    {
        if(!personnelTableView.getSelectionModel().isEmpty())
        {
            int id = personnelTableView.getSelectionModel().getSelectedItem().getId();
            int index = personnelTableView.getSelectionModel().getSelectedIndex();

            String firstName = firstNameTextField.getText();
            String lastName = lastNameTextField.getText();
            String username = usernameTextField.getText();
            String password = passwordTextField.getText();

            Clinic clinic = clinicComboBox.getSelectionModel().getSelectedItem();
            Personnel personnel = new Personnel(firstName, lastName, username, password, clinic);
            personnel.setId(id);

            personnelTableView.getItems().set(index, personnel);
            personnelRepository.update(personnel);
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<Clinic> clinics = FXCollections.observableArrayList();
        clinics.addAll(clinicRepository.getAll());
        clinicComboBox.setItems(clinics);

        ObservableList<Personnel> personnels = FXCollections.observableArrayList();
        personnels.addAll(personnelRepository.getAll());

        personnelIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        personnelLastNameColumn.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        personnelFirstNameColumn.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        personnelUsernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
        personnelPasswordColumn.setCellValueFactory(new PropertyValueFactory<>("password"));
        personnelClinicColumn.setCellValueFactory(data -> data.getValue().clinicProperty());

        personnelTableView.setItems(personnels);

        personnelTableView.getSelectionModel()
                .selectedItemProperty()
                .addListener(((observable, oldValue, newValue) ->
                {
                    if(newValue != null)
                    {
                        lastNameTextField.setText(newValue.getLastName());
                        firstNameTextField.setText(newValue.getFirstName());
                        usernameTextField.setText(newValue.getUsername());
                        passwordTextField.setText(newValue.getPassword());
                        clinicComboBox.getSelectionModel().select(newValue.getClinic());
                    }
                }));
    }
}
