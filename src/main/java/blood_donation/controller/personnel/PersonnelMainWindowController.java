package blood_donation.controller.personnel;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Patient;
import blood_donation.domain.people.Personnel;
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
import javafx.stage.Stage;
import javafx.scene.control.*;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PersonnelMainWindowController implements Initializable
{

    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Personnel currentPersonnel;

    private Repository<Donation> donationRepository;
    private Repository<DonationRequest> donationRequestRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Blood> bloodRepository;
    private Repository<BloodGroup> bloodGroupRepository;
    private Repository<Distance> distanceRepository;
    private Repository<Patient> patientRepository;
    private Repository<DonationAppointment> donationAppointmentRepository;
    private Repository<Location> locationRepository;

    @FXML
    private Button backButton;
    @FXML
    private Button refreshButton;
    @FXML
    private Button checkAvailableStocksButton;
    @FXML
    private Button notifyNearestAvailableDonorsButton;
    @FXML
    private Button sendDonationRequestButton;
    @FXML
    private Button donorMedicalDataButton;
    @FXML
    private Button cancelDonationRequestButton;
    @FXML
    private Button journeySetBloodGroupButton;
    @FXML
    private Button journeyBeginPreparationButton;
    @FXML
    private Button journeyBeginBiologicalQualityControlButton;
    @FXML
    private Button journeyBeginRedistributionButton;
    @FXML
    private Button journyBeginSamplingButton;

    @FXML
    private void journeySetBloodGroup()
    {

    }

    @FXML
    private void journeyBeginPreparation()
    {

    }

    @FXML
    private void journeyBeginBiologicalQualityControl()
    {

    }

    @FXML
    private void journeyBeginRedistribution()
    {

    }


    @FXML
    private TableView<DonationAppointment> donationRequestsTableView;
    @FXML
    private TableColumn<DonationAppointment, String> donationRequestDonorFirstNameTableColumn;
    @FXML
    private TableColumn<DonationAppointment, String> donationRequestDonorLastNameTableColumn;
    @FXML
    private TableColumn<DonationAppointment, String> donationRequestAppointmentDateTableColumn;
    @FXML
    private TableColumn<DonationAppointment, String> donationRequestAppointmentHourTableColumn;
    @FXML
    private TableColumn<DonationAppointment, String> donationRequestStatusTableColumn;

    @FXML
    private TableView bloodRequestsTableView;
    @FXML
    private TableColumn bloodRequestsDoctorNameTableColumn;
    @FXML
    private TableColumn bloodRequestsPatientNameTableColumn;
    @FXML
    private TableColumn bloodRequestsPriorityTableColumn;
    @FXML
    private TableColumn bloodRequestsRequestedBloodTableColumn;
    @FXML
    private TableColumn bloodRequestsStatusTableColumn;

    @FXML
    private TableView<Blood> stocksTableView;
    @FXML
    private TableColumn<Blood, String> stocksBloodTypeTableColumn;
    @FXML
    private TableColumn<Blood, String> stocksBloodGroupTableColumn;
    @FXML
    private TableColumn<Blood, String> stocksQuantityTableColumn;
    @FXML
    private TableColumn<Blood, String> stocksExpirationDateTableColumn;
    @FXML
    private TableColumn<Blood, String> stocksLocationTableColumn;
    @FXML
    private ComboBox<Location> stocksLocationComboBox;

    @FXML
    private TableView<Donation> journeyBloodInTestingTableView;
    @FXML
    private TableColumn<Donation, String> journeyTestingDonationDateTableColumn;
    @FXML
    private TableColumn<Donation, String> journeyTestingBloodGroupTableColumn;
    @FXML
    private TableColumn<Donation, String> journeyTestingStatusTableColumn;

    @FXML
    private TableView<DonationRequest> approvedDonationRequestsTableView;
    @FXML
    private TableColumn<DonationRequest, String> approvedDonationRequestsDonorNameTableColumn;
    @FXML
    private TableColumn<DonationRequest, String> approvedDonationRequestsAprovedByDoctorTableColumn;

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public PersonnelMainWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public PersonnelMainWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public PersonnelMainWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Personnel getCurrentPersonnel()
    {
        return currentPersonnel;
    }

    public PersonnelMainWindowController setCurrentPersonnel(Personnel currentPersonnel)
    {
        this.currentPersonnel = currentPersonnel;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public PersonnelMainWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public PersonnelMainWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public PersonnelMainWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public PersonnelMainWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public PersonnelMainWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public PersonnelMainWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public PersonnelMainWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public PersonnelMainWindowController setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public PersonnelMainWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    public void refresh()
    {
        //should be checked... it might have some issues
        populateDonationAppointmentTable();
        initializeBloodRequestsTable(); //not sure this is the right function
        populateBloodStockTableView();
        populatePendingDonationRequestsTable();
        populateDonationsInTestingTable();
    }

    @FXML
    public void checkAvailableStocks()
    {

    }

    @FXML
    public void notifyNearestAvailableDonors()
    {

    }

    @FXML
    public void  updateDonorMedicalData() throws IOException
    {
        // change to Personnel Donor Medical Data Form Window
        if(!donationRequestsTableView.getSelectionModel().isEmpty())
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/personnel/personnelDonorMedicalDataWindow.fxml"));


            loader.setController(new PersonnelDonorMedicalDataWindowController()
                    .setPrimaryStage(primaryStage)
                    .setSession(session)
                    .setPreviousScene(primaryStage.getScene())
                    .setCurrentPersonnel(currentPersonnel)
                    // current donation = selected item in table view
                    .setDonationAppointment(donationRequestsTableView.getSelectionModel().getSelectedItem())
                    .setDonationRepository(donationRepository)
                    .setDonationRequestRepository(donationRequestRepository)
                    .setClinicRepository(clinicRepository)
                    .setBloodRepository(bloodRepository)
                    .setBloodGroupRepository(bloodGroupRepository)
                    .setDistanceRepository(distanceRepository)
                    .setPatientRepository(patientRepository)
                    .setDonationAppointmentRepository(donationAppointmentRepository)
                    .setBloodGroupRepository(bloodGroupRepository)
                    .setLocationRepository(locationRepository)
            );

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Personnel main menu");
        }
    }

//    @FXML
//    public void cancelDonationRequest()
//    {
//        if(!donationRequestsTableView.getSelectionModel().isEmpty())
//        {
//            // TODO check if all fields are set (or add another flag to the class donation request
//
//            DonationRequest selectedDonationRequest = donationRequestsTableView.getSelectionModel().getSelectedItem().getDonationRequest();
//
//            selectedDonationRequest.setValidatedByPersonnel(false);
//
//            donationRequestRepository.update(selectedDonationRequest);
//        }
//    }

    private LocalDate computeExpirationDate(LocalDate donationDate)
    {
        return donationDate.plusDays(42);  // blood expires after 42 days
    }

    @FXML
    public void beginSampling()
    {
        if(!approvedDonationRequestsTableView.getSelectionModel().isEmpty())
        {
            DonationRequest selectedDonationRequest = approvedDonationRequestsTableView.getSelectionModel().getSelectedItem();

            // create a donation
            Blood blood = new Blood();

            Donation donation = new Donation();

            // check if the donor has donated before
            if(selectedDonationRequest.getDonor().getBloodGroup() == null)
            {
                // first time donor : alert with combo box to select blood group; set the blood group of donor
                List<BloodGroup> choices = bloodGroupRepository.getAll();

                ChoiceDialog<BloodGroup> dialog = new ChoiceDialog<>(choices.get(0), choices);
                dialog.setTitle("Choose Donor Blood Group Dialog");
                dialog.setHeaderText("This person is donating for the first time");
                dialog.setContentText("Choose their blood group:");

                Optional<BloodGroup> result = dialog.showAndWait();

                result.ifPresent(bloodGroup -> selectedDonationRequest.getDonor().setBloodGroup(bloodGroup));
                blood.setBloodGroup(selectedDonationRequest.getDonor().getBloodGroup());
            }

            blood.setBloodGroup(selectedDonationRequest.getDonor().getBloodGroup());
            blood.setExpirationDate(LocalDate.now());
            blood.setQuantity(0.35f);

            bloodRepository.add(blood);


            donation.setDonationRequest(selectedDonationRequest);
            donation.setDonatedBlood(blood);
            donation.setDonor(selectedDonationRequest.getDonor());
            donation.setDonationDate(LocalDate.now());
            donation.setStatus(Status.PENDING);
            donation.setPatient(selectedDonationRequest.getPatient());
            donation.setClinic(currentPersonnel.getClinic());
            donation.setBloodContainerJourneyStatus(JourneyStatus.SAMPLING);

//            blood.setDonation(donation);  // DO I HAVE TO DO THIS TOO????

            donationRepository.add(donation);
        }
    }

    private void populateDonationAppointmentTable()
    {
        donationRequestDonorFirstNameTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDonationRequest().getDonor().getFirstName()));
        donationRequestDonorLastNameTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDonationRequest().getDonor().getLastName()));
        donationRequestAppointmentDateTableColumn.setCellValueFactory(data ->
                data.getValue().appointmentDateProperty());
        donationRequestAppointmentHourTableColumn.setCellValueFactory(data ->
                data.getValue().appointmentTimeProperty());
        // TODO figure this out
//        donationRequestStatusTableColumn.setCellValueFactory(data ->
//                data.getValue().getDonationRequest().getStatus());

        List<DonationAppointment> thisPersonnelDonationAppointments =
                donationAppointmentRepository.getAll()
                        .stream()
                        // TODO might need to check the flags from DonationRequest (to see only unhandled requests)
                        .filter(donationAppointment -> donationAppointment.getClinic() == currentPersonnel.getClinic())
                        .filter(donationAppointment -> donationAppointment.getDonationRequest().getValidatedByPersonnel() == null)
                        .collect(Collectors.toList());

        ObservableList<DonationAppointment> thisPersonnelDonationAppointmentsObservableList =
                FXCollections.observableArrayList(thisPersonnelDonationAppointments);

        donationRequestsTableView.setItems(thisPersonnelDonationAppointmentsObservableList);
    }

    private void initializeDonationRequestsTab()
    {
        // DONATION REQUESTS TAB

        // populate donation requests table
        // a personnel can only see the requests made at their clinic
        populateDonationAppointmentTable();

    }

    private void initializeBloodRequestsTable()
    {
        // TODO wait for Tatiana to add some attributes to class BloodRequest
    }

    private void populateDonationsInTestingTable()
    {
        journeyTestingDonationDateTableColumn.setCellValueFactory(data ->
                data.getValue().donationDateProperty());
        journeyTestingBloodGroupTableColumn.setCellValueFactory(data ->
                data.getValue().donatedBloodProperty());
        journeyTestingStatusTableColumn.setCellValueFactory(data ->
                data.getValue().bloodContainerStatusProperty());

        List<Donation> donationsInTesting = donationRepository.getAll()
                .stream()
                .filter(donation -> donation.getDonationRequest().getValidatedByPersonnel() && donation.getDonationRequest().getValidatedByDoctor())
                .collect(Collectors.toList());

        ObservableList<Donation> donationObservableList = FXCollections.observableList(donationsInTesting);

        journeyBloodInTestingTableView.setItems(donationObservableList);
    }

    private void populatePendingDonationRequestsTable()
    {
        approvedDonationRequestsDonorNameTableColumn.setCellValueFactory(data ->
                data.getValue().getDonor().fullNameProperty());
        approvedDonationRequestsAprovedByDoctorTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getValidatedByDoctor().toString()));

        List<DonationRequest> pendingDonationRequests = donationRequestRepository.getAll()
                .stream()
                .filter(donationRequest -> donationRequest.getValidatedByDoctor() != null)
                .filter(donationRequest -> donationRequest.getValidatedByPersonnel() && donationRequest.getValidatedByDoctor())
                .collect(Collectors.toList());

        ObservableList<DonationRequest> pendingDonationRequestsObservableList = FXCollections.observableList(pendingDonationRequests);

        approvedDonationRequestsTableView.setItems(pendingDonationRequestsObservableList);
    }

    private void initializeAvailableStocksTable()
    {
        List<Location> locations = locationRepository.getAll();
        ObservableList<Location> locationsObservableList = FXCollections.observableList(locations);
        stocksLocationComboBox.setItems(locationsObservableList);

        stocksLocationComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                populateBloodStockTableView());
    }

    private void populateBloodStockTableView()
    {
        Location selectedLocation = stocksLocationComboBox.getSelectionModel().getSelectedItem();

        List<Donation> donations = donationRepository.getAll().stream()
                .filter(d -> d.getClinic().getLocation().getName().equals(selectedLocation.getName()))
                .collect(Collectors.toList());

        List<Blood> bloodFromDonations = donations.stream()
                .map(Donation::getDonatedBlood)
                .collect(Collectors.toList());

        stocksBloodTypeTableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClass().getSimpleName()));
        stocksBloodGroupTableColumn.setCellValueFactory(data -> data.getValue().bloodGroupProperty());
        stocksExpirationDateTableColumn.setCellValueFactory(data -> data.getValue().quantityProperty().asString());
        stocksQuantityTableColumn.setCellValueFactory(data ->
        {
            return data.getValue().expirationDateProperty();
        });
        stocksLocationTableColumn.setCellValueFactory(data -> {

            List<Donation> donationRelatedToBlood = donations.stream()
                    .filter(d -> d.getDonatedBlood() == data.getValue())
                    .collect(Collectors.toList());

            Clinic clinicRelatedToBlood = donationRelatedToBlood.get(0).getClinic();
            return new SimpleStringProperty(clinicRelatedToBlood.getName() + ", " +
                    clinicRelatedToBlood.getLocation());
        });

        ObservableList<Blood> bloodObservableList = FXCollections.observableList(bloodFromDonations);
        stocksTableView.setItems(bloodObservableList);

    }

    private void initializeBloodContainerJourneyTab()
    {
        // Donations in testing table and related buttons

        populatePendingDonationRequestsTable();

        populateDonationsInTestingTable();

//        journeyBloodInTestingTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
//            if (newSelection != null)
//            {
//                // TODO check if they work as expected
//                switch (newSelection.getBloodContainerJourneyStatus())
//                {
//                    case SAMPLING:
//                        journeySetBloodGroupButton.setDisable(false);
//                        journeyBeginPreparationButton.setDisable(true);
//                        journeyBeginBiologicalQualityControlButton.setDisable(true);
//                        journeyBeginRedistributionButton.setDisable(true);
//                        break;
//                    case PREPARATION:
//                        journeySetBloodGroupButton.setDisable(true);
//                        journeyBeginPreparationButton.setDisable(false);
//                        journeyBeginBiologicalQualityControlButton.setDisable(true);
//                        journeyBeginRedistributionButton.setDisable(true);
//                        break;
//                    case BIOLOGICAL_QUALITY_CONTROL:
//                        journeySetBloodGroupButton.setDisable(true);
//                        journeyBeginPreparationButton.setDisable(true);
//                        journeyBeginBiologicalQualityControlButton.setDisable(false);
//                        journeyBeginRedistributionButton.setDisable(true);
//                        break;
//                    case REDISTRIBUTION:
//                        journeySetBloodGroupButton.setDisable(true);
//                        journeyBeginPreparationButton.setDisable(true);
//                        journeyBeginBiologicalQualityControlButton.setDisable(true);
//                        journeyBeginRedistributionButton.setDisable(false);
//                        break;
//                }
//            }
//        });


        // Pending donations table

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // populate table views

        // DONATION REQUESTS TAB
        initializeDonationRequestsTab();
        // TODO add event listeners when selecting a row (if needed)

        // BLOOD REQUESTS TAB
        initializeBloodRequestsTable();

        // AVAILABLE STOCKS TAB
        initializeAvailableStocksTable();

        // BLOOD CONTAINER JOURNEY TAB
        initializeBloodContainerJourneyTab();


    }
}
