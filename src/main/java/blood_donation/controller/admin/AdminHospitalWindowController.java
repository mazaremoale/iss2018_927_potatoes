package blood_donation.controller.admin;

import blood_donation.domain.utils.Hospital;
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

public final class AdminHospitalWindowController implements Initializable
{
    private Session session;
    private Stage primaryStage;
    private Scene previousScene;

    private Repository<Hospital> hospitalRepository;
    private Repository<Location> locationRepository;

    @FXML
    private TextField hospitalNameTextField;

    @FXML
    private ComboBox<Location> locationComboBox;

    @FXML
    private TableColumn<Hospital, String> hospitalIDColumn;

    @FXML
    private TableColumn<Hospital, String> hospitalNameColumn;

    @FXML
    private TableColumn<Hospital, String> hospitalLocationColumn;

    @FXML
    private TableView<Hospital> hospitalTableView;


    public AdminHospitalWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public AdminHospitalWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public AdminHospitalWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public AdminHospitalWindowController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    public AdminHospitalWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    @FXML
    public void addHospital()
    {
        if(hospitalNameTextField.getText().length() > 0 &&
                !locationComboBox.getSelectionModel().isEmpty())
        {
            String hospitalName = hospitalNameTextField.getText();
            Location location = locationComboBox.getSelectionModel().getSelectedItem();

            Hospital hospital = new Hospital(location, hospitalName);

            hospitalRepository.add(hospital);
            hospitalTableView.getItems().add(hospital);

            hospitalNameTextField.clear();
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
    public void removeHospital()
    {
        if(!hospitalTableView.getSelectionModel().isEmpty())
        {
            Hospital hospital = hospitalTableView.getSelectionModel().getSelectedItem();

            hospitalTableView.getItems().remove(hospital);
            hospitalRepository.remove(hospital.getId());
        }

    }

    @FXML
    public void updateHospital()
    {
        if(!hospitalTableView.getSelectionModel().isEmpty())
        {
            int id = hospitalTableView.getSelectionModel().getSelectedItem().getId();
            int index = hospitalTableView.getSelectionModel().getSelectedIndex();

            String hospitalName = hospitalNameTextField.getText();
            Location location = locationComboBox.getSelectionModel().getSelectedItem();

            Hospital hospital = new Hospital(location, hospitalName);
            hospital.setId(id);

            hospitalTableView.getItems().set(index, hospital);
            hospitalRepository.update(hospital);

        }

    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
        primaryStage.setTitle("Admin management panel");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        ObservableList<Location> locations = FXCollections.observableArrayList();
        locations.addAll(locationRepository.getAll());
        locationComboBox.setItems(locations);

        ObservableList<Hospital> hospitals = FXCollections.observableArrayList();
        hospitals.addAll(hospitalRepository.getAll());

        hospitalIDColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        hospitalNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        hospitalLocationColumn.setCellValueFactory(data -> data.getValue().locationProperty());

        hospitalTableView.setItems(hospitals);

        hospitalTableView.getSelectionModel().selectedItemProperty()
                .addListener((observable, oldValue, newValue) ->
                {
                    if(newValue != null)
                    {
                        hospitalNameTextField.setText(newValue.getName());
                        locationComboBox.getSelectionModel().select(newValue.getLocation());
                    }
                });

    }
}
