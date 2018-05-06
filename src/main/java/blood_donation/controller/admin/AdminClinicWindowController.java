package blood_donation.controller.admin;

import blood_donation.domain.utils.Clinic;
import blood_donation.domain.utils.Location;
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

public final class AdminClinicWindowController implements Initializable
{
    private Session session;
    private Stage primaryStage;
    private Scene previousScene;

    private Repository<Clinic> clinicRepository;
    private Repository<Location> locationRepository;

    @FXML
    private TextField clinicNameTextField;

    @FXML
    private ComboBox<Location> locationComboBox;

    @FXML
    private TableView<Clinic> clinicTableView;

    @FXML
    private TableColumn<Clinic, String> clinicIDColumn;

    @FXML
    private TableColumn<Clinic, String> clinicNameColumn;

    @FXML
    private TableColumn<Clinic, String> clinicLocationColumn;

    public AdminClinicWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public AdminClinicWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public AdminClinicWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public AdminClinicWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public AdminClinicWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    @FXML
    public void addClinic()
    {
        if(clinicNameTextField.getText().length() > 0 &&
                !locationComboBox.getSelectionModel().isEmpty())
        {
            String clinicName = clinicNameTextField.getText();
            Location location = locationComboBox.getSelectionModel().getSelectedItem();

            Clinic clinic = new Clinic(location, clinicName);

            clinicRepository.add(clinic);
            clinicTableView.getItems().add(clinic);

            clinicNameTextField.clear();
            locationComboBox.getSelectionModel().clearSelection();
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
    public void removeClinic()
    {
        if(!clinicTableView.getSelectionModel().isEmpty())
        {
            Clinic clinic = clinicTableView.getSelectionModel().getSelectedItem();

            clinicTableView.getItems().remove(clinic);
            clinicRepository.remove(clinic.getId());
        }

    }

    @FXML
    public void updateClinic()
    {
        if(!clinicTableView.getSelectionModel().isEmpty())
        {
            int id = clinicTableView.getSelectionModel().getSelectedItem().getId();
            int index = clinicTableView.getSelectionModel().getSelectedIndex();

            String clinicName = clinicNameTextField.getText();
            Location location = locationComboBox.getSelectionModel().getSelectedItem();

            Clinic clinic = new Clinic(location, clinicName);
            clinic.setId(id);

            clinicTableView.getItems().set(index, clinic);
            clinicRepository.update(clinic);

        }

    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<Location> locations = FXCollections.observableArrayList();
        locations.addAll(locationRepository.getAll());
        locationComboBox.setItems(locations);

        ObservableList<Clinic> clinics = FXCollections.observableArrayList();
        clinics.addAll(clinicRepository.getAll());

        clinicIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        clinicNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        clinicLocationColumn.setCellValueFactory(data -> data.getValue().locationProperty());

        clinicTableView.setItems(clinics);

        clinicTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) ->
                {
                    if(newValue != null)
                    {
                        clinicNameTextField.setText(newValue.getName());
                        locationComboBox.getSelectionModel().select(newValue.getLocation());
                    }
                });
    }
}
