package blood_donation.controller.doctor;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Patient;
import blood_donation.domain.utils.*;
import blood_donation.repository.Repository;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DoctorMainWindowController implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Doctor currentDoctor;

    private Repository<DonationRequest> donationRequestRepository;
    private Repository<Location> locationRepository;
    private Repository<Donation> donationRepository;
    private Repository<Blood> bloodRepository;
    private Repository<Hospital> hospitalRepository;
    private Repository<Patient> patientRepository;
    private Repository<BloodRequest> bloodRequestRepository;
    private Repository<BloodGroup> bloodGroupRepository;

    @FXML
    private TabPane tabPane;

    //-----------> First tab controls
    @FXML
    private TableView<DonationRequest> donationRequestTableView;

    @FXML
    private TableColumn<DonationRequest, String> drNameColumn;

    @FXML
    private TableColumn<DonationRequest, String> drAgeColumn;

    @FXML
    private TableColumn<DonationRequest, String> drBloodPressureColumn;

    @FXML
    private TableColumn<DonationRequest, String> drPulseColumn;

    @FXML
    private TableColumn<DonationRequest, String> drWeightColumn;

    @FXML
    private Button approveButton;

    @FXML
    private Button notApproveButton;

    @FXML
    private Label additionalInfoLabel;


    //-----------> Second tab controls
    @FXML
    private ComboBox<Location> locationComboBox;

    @FXML
    private TableView<Blood> bloodStockTableView;

    @FXML
    private TableColumn<Blood, String> bloodStockBloodTypeTableColumn;

    @FXML
    private TableColumn<Blood, String> bloodStockGroupTableColumn;

    @FXML
    private TableColumn<Blood, String> bloodStockQuantityTableColumn;

    @FXML
    private TableColumn<Blood, String> bloodStockExpirationDateTableColumn;

    @FXML
    private TableColumn<Blood, String> bloodStockLocationTableColumn;


    //-----------> Third tab controls
    @FXML
    private TableView<BloodRequest> bloodRequestsTableView;

    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsPatientColumn;

    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsBloodGroupColumn;

    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsQuantityColumn;

    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsPriorityColumn;

    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsHospitalColumn;

    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsStatusColumn;

    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsRequestDateColumn;

    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsDonatedBloodColumn;

    @FXML
    private Button deleteRequestButton;

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DoctorMainWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DoctorMainWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DoctorMainWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Doctor getCurrentDoctor()
    {
        return currentDoctor;
    }

    public DoctorMainWindowController setCurrentDonor(Doctor currentDoctor)
    {
        this.currentDoctor = currentDoctor;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public DoctorMainWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public DoctorMainWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public DoctorMainWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public DoctorMainWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<Hospital> getHospitalRepository()
    {
        return hospitalRepository;
    }

    public DoctorMainWindowController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public DoctorMainWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<BloodRequest> getBloodRequestRepository()
    {
        return bloodRequestRepository;
    }

    public DoctorMainWindowController setBloodRequestRepository(Repository<BloodRequest> bloodRequestRepository)
    {
        this.bloodRequestRepository = bloodRequestRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public DoctorMainWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    public void refreshTables()
    {
        String selectedTab = tabPane.getSelectionModel().getSelectedItem().getText();
        switch (selectedTab)
        {
            case "Donation requests":
                initializeDonationRequestTab();
                break;
            case "Available stocks":
                populateBloodStockTableView();
                break;
            case "Blood requests":
                initializeBloodRequestsTab();
                break;
        }
    }

    @FXML
    public void openMakeNewRequestForm() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/doctor/doctorNewBloodRequestWindow.fxml"));

        loader.setController(new DoctorNewBloodRequestController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setPreviousScene(primaryStage.getScene())
                .setCurrentDonor(currentDoctor)
                .setHospitalRepository(hospitalRepository)
                .setPatientRepository(patientRepository)
                .setBloodRequestRepository(bloodRequestRepository)
                .setBloodGroupRepository(bloodGroupRepository));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Doctor management panel");
    }

    @FXML
    private void deleteSelectedRequest()
    {
        bloodRequestsTableView.getItems().remove(bloodRequestsTableView.getSelectionModel().getSelectedItem());

        bloodRequestRepository.remove(bloodRequestsTableView.getSelectionModel().getSelectedItem().getId());
    }

    @FXML
    public void approveDonor()
    {
        DonationRequest currentDonationRequest = donationRequestTableView.getSelectionModel().getSelectedItem();

        currentDonationRequest.setValidatedByDoctor(true);
        donationRequestRepository.update(currentDonationRequest);

        //System.out.println(donationRequestTableView.getSelectionModel().getSelectedItem());
        donationRequestTableView.getItems().remove(donationRequestTableView.getSelectionModel().getSelectedItem());
        additionalInfoLabel.setText("");
    }

    @FXML
    public void notApproveDonor()
    {
        DonationRequest currentDonationRequest = donationRequestTableView.getSelectionModel().getSelectedItem();

        currentDonationRequest.setValidatedByDoctor(false);
        donationRequestRepository.update(currentDonationRequest);

        donationRequestTableView.getItems().remove(donationRequestTableView.getSelectionModel().getSelectedItem());
        additionalInfoLabel.setText("");

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //Donation requests tab
        initializeDonationRequestTab();

        //Available stocks tab
        initializeAvailableStocksTab();

        //Blood requests tab
        initializeBloodRequestsTab();
    }

    private void initializeDonationRequestTab()
    {
        List<DonationRequest> donationRequests = donationRequestRepository.getAll().stream()
                .filter(donationRequest -> donationRequest.getValidatedByPersonnel() != null)
                .filter(DonationRequest::getValidatedByPersonnel)
                .filter(donationRequest -> donationRequest.getValidatedByDoctor() == null)
                .collect(Collectors.toList());

        ObservableList<DonationRequest> donationRequestsObservableList
                = FXCollections.observableList(donationRequests);

        drNameColumn.setCellValueFactory(data -> data.getValue().getDonor().fullNameProperty());
        drAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        drPulseColumn.setCellValueFactory(new PropertyValueFactory<>("pulse"));
        drWeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        drBloodPressureColumn.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));

        donationRequestTableView.setItems(donationRequestsObservableList);

        approveButton.setDisable(true);
        notApproveButton.setDisable(true);

        donationRequestTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            approveButton.setDisable(false);
            notApproveButton.setDisable(false);

            if (newValue != null) //dummy thingy, necessary because, after removing a row, this listener is again called
                additionalInfoLabel.setText(newValue.getOtherInformation());
        });

    }

    private void initializeAvailableStocksTab()
    {
        List<Location> locations = locationRepository.getAll();
        ObservableList<Location> locationsObservableList = FXCollections.observableList(locations);
        locationComboBox.setItems(locationsObservableList);

        locationComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                populateBloodStockTableView());
    }


    private void populateBloodStockTableView()
    {
        Location currentLocation = locationComboBox.getSelectionModel().getSelectedItem();

        if (currentLocation != null)
        {
            List<Donation> donations = donationRepository.getAll().stream()
                    .filter(d -> d.getClinic().getLocation().getName().equals(currentLocation.getName()))
                    .collect(Collectors.toList());

            List<Blood> bloodFromDonations = donations.stream()
                    .map(Donation::getDonatedBlood)
                    .filter(blood -> blood.getReadyForUse() != null)
                    .filter(Blood::getReadyForUse)
                    .filter(blood -> blood.getQuantity() != 0)
                    .collect(Collectors.toList());

            bloodStockBloodTypeTableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClass().getSimpleName()));
            bloodStockGroupTableColumn.setCellValueFactory(data -> data.getValue().bloodGroupProperty());
            bloodStockQuantityTableColumn.setCellValueFactory(data -> data.getValue().quantityProperty().asString());
            bloodStockExpirationDateTableColumn.setCellValueFactory(data ->
                    data.getValue().expirationDateProperty());
            bloodStockLocationTableColumn.setCellValueFactory(data -> {

                List<Donation> donationRelatedToBlood = donations.stream()
                        .filter(d -> d.getDonatedBlood() == data.getValue())
                        .collect(Collectors.toList());

                Clinic clinicRelatedToBlood = donationRelatedToBlood.get(0).getClinic();
                return new SimpleStringProperty(clinicRelatedToBlood.getName() + ", " +
                        clinicRelatedToBlood.getLocation());
            });

            ObservableList<Blood> bloodObservableList = FXCollections.observableList(bloodFromDonations);
            bloodStockTableView.setItems(bloodObservableList);
        }

    }

    private void initializeBloodRequestsTab()
    {
//        List<BloodRequest> bloodRequests = bloodRequestRepository.getAll().stream()
//                .filter(bloodRequest -> bloodRequest.getQuantity()
//                        >= bloodRequest.calculateQuantityOfGivenBlood())
//                .collect(Collectors.toList());

        List<BloodRequest> bloodRequests = bloodRequestRepository.getAll().stream()
                .filter(bloodRequest -> bloodRequest.getQuantity()
                        >= bloodRequest.getGivenBlood())
                .collect(Collectors.toList());


        ObservableList<BloodRequest> allBloodRequestsObservableList = FXCollections.observableList(bloodRequests);

        bloodRequestsPatientColumn.setCellValueFactory(data -> data.getValue().getPatient().fullNameProperty());
        bloodRequestsBloodGroupColumn.setCellValueFactory(data -> data.getValue().bloodGroupProperty());
        bloodRequestsQuantityColumn.setCellValueFactory(data -> data.getValue().quantityProperty().asString());
        bloodRequestsPriorityColumn.setCellValueFactory(data -> data.getValue().priorityProperty());
        bloodRequestsHospitalColumn.setCellValueFactory(data -> data.getValue().hospitalProperty());
        bloodRequestsStatusColumn.setCellValueFactory(data -> data.getValue().statusProperty());
        bloodRequestsRequestDateColumn.setCellValueFactory(data -> data.getValue().requestDateProperty());
//        bloodRequestsDonatedBloodColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().calculateQuantityOfGivenBlood())));
        bloodRequestsDonatedBloodColumn.setCellValueFactory(data -> new SimpleStringProperty(String.valueOf(data.getValue().getGivenBlood())));


        deleteRequestButton.setDisable(true);
        bloodRequestsTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                deleteRequestButton.setDisable(false));

        bloodRequestsTableView.setItems(allBloodRequestsObservableList);
    }
}
