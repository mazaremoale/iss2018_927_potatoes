package blood_donation.controller.personnel;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Donor;
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
import java.util.*;
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
    private Repository<BloodRequest> bloodRequestRepository;
    private Repository<Donor> donorRepository;

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
    private TableView<BloodRequest> bloodRequestsTableView;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsDoctorNameTableColumn;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsPatientNameTableColumn;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsBloodGroupTableColumn;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsQuantityTableColumn;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsPriorityTableColumn;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsHospitalTableColumn;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsStatusTableColumn;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsRequestDateTableColumn;
    @FXML
    private TableColumn<BloodRequest, String> bloodRequestsDonatedBloodTableColumn;
    @FXML
    private Label noAvailableBloodLabel;
    @FXML
    private Label availableBloodLabel;
    @FXML
    private ComboBox<Blood> availableBloodComboBox;
    @FXML
    private Button sendBloodButton;
    @FXML
    private Button notifyClinicsButton;
    @FXML
    private Button notifyDonorsButton;

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

    public Repository<BloodRequest> getBloodRequestRepository()
    {
        return bloodRequestRepository;
    }

    public PersonnelMainWindowController setBloodRequestRepository(Repository<BloodRequest> bloodRequestRepository)
    {
        this.bloodRequestRepository = bloodRequestRepository;
        return this;
    }

    public Repository<Donor> getDonorRepository()
    {
        return donorRepository;
    }

    public PersonnelMainWindowController setDonorRepository(Repository<Donor> donorRepository)
    {
        this.donorRepository = donorRepository;
        return this;
    }

    // ################################################################################################################

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    public void refresh()
    {
        populateDonationAppointmentTable();
        populateBloodRequestsTable();

        populateBloodStockTableView();
        populateApprovedDonationRequestsTable();
        populateDonationsInTestingTable();
    }

    private LocalDate computeExpirationDate(LocalDate donationDate)
    {
        return donationDate.plusDays(42);  // blood expires after 42 days
    }

// ################################################################################################################



// #######################################################
// TAB 1 --- Donation Requests and Appointments
// #######################################################

    private void initializeDonationRequestsTab()
    {
        // DONATION REQUESTS TAB

        // populate donation requests table
        // a personnel can only see the requests made at their clinic
        donationRequestDonorFirstNameTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDonationRequest().getDonor().getFirstName()));
        donationRequestDonorLastNameTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDonationRequest().getDonor().getLastName()));
        donationRequestAppointmentDateTableColumn.setCellValueFactory(data ->
                data.getValue().appointmentDateProperty());
        donationRequestAppointmentHourTableColumn.setCellValueFactory(data ->
                data.getValue().appointmentTimeProperty());

        populateDonationAppointmentTable();
    }

    private void populateDonationAppointmentTable()
    {
        List<DonationAppointment> thisPersonnelDonationAppointments =
                donationAppointmentRepository.getAll()
                        .stream()
                        .filter(donationAppointment -> donationAppointment.getClinic() == currentPersonnel.getClinic())
                        .filter(donationAppointment -> donationAppointment.getDonationRequest().getValidatedByPersonnel() == null)
                        .collect(Collectors.toList());

        ObservableList<DonationAppointment> thisPersonnelDonationAppointmentsObservableList =
                FXCollections.observableArrayList(thisPersonnelDonationAppointments);

        donationRequestsTableView.setItems(thisPersonnelDonationAppointmentsObservableList);
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
                    .setBloodRequestRepository(bloodRequestRepository)
                    .setDonorRepository(donorRepository)
            );

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Personnel main menu");
        }
    }

// ################################################################################################################





    // #######################################################
    // TAB 2 --- Blood Requests
    // #######################################################

    private void initializeBloodRequestsTable()
    {
        availableBloodLabel.setVisible(false);
        availableBloodComboBox.setVisible(false);
        sendBloodButton.setVisible(false);
        notifyClinicsButton.setVisible(false);
        notifyDonorsButton.setVisible(false);

        populateBloodRequestsTable();

        bloodRequestsTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                {
                    showSendBloodControls();
                });
    }

    private void showSendBloodControls()
    {
        if (!bloodRequestsTableView.getSelectionModel().isEmpty())
        {
            BloodRequest selectedBloodRequest = bloodRequestsTableView.getSelectionModel().getSelectedItem();
            BloodGroup bloodGroupFromBloodRequest = selectedBloodRequest.getBloodGroup();

            List<Donation> donations = donationRepository.getAll().stream()
                    .filter(d -> d.getClinic() == currentPersonnel.getClinic())
                    .collect(Collectors.toList());

            List<Blood> bloodFromDonations = donations.stream()
                    .map(Donation::getDonatedBlood)
                    .filter(blood -> blood.getQuantity() != 0)
                    .filter(blood -> blood.getBloodGroup().canBeDonatedTo(bloodGroupFromBloodRequest))
                    .collect(Collectors.toList());

            if (!bloodFromDonations.isEmpty())
            {
                availableBloodLabel.setVisible(true);
                availableBloodComboBox.setVisible(true);
                sendBloodButton.setVisible(true);
                noAvailableBloodLabel.setText("");

                availableBloodComboBox.setItems(FXCollections.observableList(bloodFromDonations));

                sendBloodToBloodRequest();
            }
            else
            {
                noAvailableBloodLabel.setText("No available blood found.");
                availableBloodLabel.setVisible(false);
                availableBloodComboBox.setVisible(false);
                sendBloodButton.setVisible(false);

                notifyDonorsButton.setVisible(true);
                notifyClinicsButton.setVisible(true);
            }
        }
    }

    private Boolean isDonor(Patient patient)
    {
        for(Donor donor : donorRepository.getAll())
        {
            if(donor.getFirstName().equals(patient.getFirstName()) && donor.getLastName().equals(patient.getLastName()))
            {
//                System.out.println("--->>>" + donor.getFirstName() + donor.getLastName());
                return true;
            }
        }
        return false;
    }

    private void populateBloodRequestsTable() //please accept me
    {
        List<BloodRequest> bloodRequests = bloodRequestRepository.getAll().stream()
                .filter(bloodRequest -> bloodRequest.getQuantity() > bloodRequest.getGivenBlood())
                .filter(bloodRequest -> bloodRequest.getHospital().getLocation() == currentPersonnel.getClinic().getLocation()
                                                || (bloodRequest.isRequireBloodClinics()
                                                    && distanceBetweenBloodRequestAndClinic(bloodRequest, currentPersonnel.getClinic()) < 500 ) )//some random number
                .collect(Collectors.toList());

        // --------------- SORTING -------------------
        System.out.println(bloodRequests);
        bloodRequests.sort((bloodRequest1, bloodRequest2) ->
        {
            if (bloodRequest1.getPriority() == bloodRequest2.getPriority())
            {
                if (isDonor(bloodRequest1.getPatient()) == isDonor(bloodRequest2.getPatient()))
                {
                    if (bloodRequest1.getRequestDate().isBefore(bloodRequest2.getRequestDate()))
                        return -1;
                    if (bloodRequest1.getRequestDate().isEqual(bloodRequest2.getRequestDate()))
                        return 0;
                    return 1;
                } else
                {
                    if (isDonor(bloodRequest1.getPatient()))
                        return -1;
                    return 1;
                }
            } else
            {
                if(bloodRequest1.getPriority().compareTo(bloodRequest2.getPriority()) < 0)
                {
                    return 1;
                }
                return -1;
            }
        });


        ObservableList<BloodRequest> allBloodRequestsObservableList = FXCollections.observableList(bloodRequests);

        bloodRequestsDoctorNameTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getDoctor().toString()));
        bloodRequestsPatientNameTableColumn.setCellValueFactory(data -> data.getValue().getPatient().fullNameProperty());
        bloodRequestsBloodGroupTableColumn.setCellValueFactory(data -> data.getValue().bloodGroupProperty());
        bloodRequestsQuantityTableColumn.setCellValueFactory(data -> data.getValue().quantityProperty().asString());
        bloodRequestsPriorityTableColumn.setCellValueFactory(data -> data.getValue().priorityProperty());
        bloodRequestsHospitalTableColumn.setCellValueFactory(data -> data.getValue().hospitalProperty());
        bloodRequestsStatusTableColumn.setCellValueFactory(data -> data.getValue().statusProperty());
        bloodRequestsRequestDateTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getRequestDate().toString()));
        bloodRequestsRequestDateTableColumn.setCellValueFactory(data -> data.getValue().requestDateProperty());
        bloodRequestsDonatedBloodTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(String.valueOf(data.getValue().getGivenBlood())));

        bloodRequestsTableView.setItems(allBloodRequestsObservableList);

        // sorting -------------
        bloodRequestsPriorityTableColumn.setSortable(false);
        bloodRequestsDoctorNameTableColumn.setSortable(false);
        bloodRequestsPatientNameTableColumn.setSortable(false);
        bloodRequestsBloodGroupTableColumn.setSortable(false);
        bloodRequestsQuantityTableColumn.setSortable(false);
        bloodRequestsHospitalTableColumn.setSortable(false);
        bloodRequestsStatusTableColumn.setSortable(false);
        bloodRequestsRequestDateTableColumn.setSortable(false);
        bloodRequestsDonatedBloodTableColumn.setSortable(false);
        // ---------------------
    }

    private int distanceBetweenBloodRequestAndClinic(BloodRequest bloodRequest, Clinic clinic)
    {
        Location location1 = bloodRequest.getHospital().getLocation();
        Location location2 = clinic.getLocation();
        int distanceBetweenLocations = 0;

        for (Distance distance : distanceRepository.getAll())
        {
            if (distance.getLocation1() == location1 && distance.getLocation2() == location2)
                distanceBetweenLocations = distance.getDistance();
        }

        return distanceBetweenLocations;
    }

    @FXML
    private void sendBloodToBloodRequest()
    {
        if (!bloodRequestsTableView.getSelectionModel().isEmpty())
        {
            BloodRequest selectedBloodRequest = bloodRequestsTableView.getSelectionModel().getSelectedItem();
            if (!availableBloodComboBox.getSelectionModel().isEmpty())
            {
                noAvailableBloodLabel.setText("");

                Blood selectedBlood = availableBloodComboBox.getValue();

                float neededBlood = selectedBloodRequest.getQuantity() - selectedBloodRequest.getGivenBlood();
                if (neededBlood >= selectedBlood.getQuantity())
                {
                    selectedBloodRequest.setGivenBlood(selectedBloodRequest.getGivenBlood() + selectedBlood.getQuantity());
                    selectedBlood.setQuantity(0f);
                }
                else
                {
                    selectedBloodRequest.setGivenBlood(selectedBloodRequest.getGivenBlood() + neededBlood);
                    selectedBlood.setQuantity(selectedBlood.getQuantity() - neededBlood);
                }

                bloodRequestRepository.update(selectedBloodRequest);
                bloodRepository.update(selectedBlood);

            }
        }
    }

    @FXML
    private void notifyCloseClinics()
    {
        if (!bloodRequestsTableView.getSelectionModel().isEmpty())
        {
            BloodRequest selectedBloodRequest = bloodRequestsTableView.getSelectionModel().getSelectedItem();
            selectedBloodRequest.setRequireBloodClinics(true);
            bloodRequestRepository.update(selectedBloodRequest);
        }
    }

    @FXML
    private void notifyCloseDonors()
    {
        if (!bloodRequestsTableView.getSelectionModel().isEmpty())
        {
            BloodRequest selectedBloodRequest = bloodRequestsTableView.getSelectionModel().getSelectedItem();
            selectedBloodRequest.setRequireBloodDonors(true);
            bloodRequestRepository.update(selectedBloodRequest);
        }
    }


// #######################################################
// TAB 3 --- Available Blood Stocks
// #######################################################

    private void initializeAvailableStocksTable()
    {
        List<Location> locations = locationRepository.getAll();
        ObservableList<Location> locationsObservableList = FXCollections.observableArrayList(locations);
        stocksLocationComboBox.setItems(locationsObservableList);

        stocksLocationComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
                populateBloodStockTableView());
    }

    private void populateBloodStockTableView()
    {
        if(!stocksLocationComboBox.getSelectionModel().isEmpty())
        {
            Location selectedLocation = stocksLocationComboBox.getSelectionModel().getSelectedItem();

            List<Donation> donations = donationRepository.getAll().stream()
                    .filter(d -> d.getClinic().getLocation().getName().equals(selectedLocation.getName()))
                    .collect(Collectors.toList());

            List<Blood> bloodFromDonations = donations.stream()
                    .map(Donation::getDonatedBlood)
                    .filter(blood -> blood.getReadyForUse() != null)
                    .filter(Blood::getReadyForUse)
                    .filter(blood -> blood.getQuantity() != 0)
                    .collect(Collectors.toList());

            stocksBloodTypeTableColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getClass().getSimpleName()));
            stocksBloodGroupTableColumn.setCellValueFactory(data -> data.getValue().bloodGroupProperty());
            stocksExpirationDateTableColumn.setCellValueFactory(data -> data.getValue().expirationDateProperty());
            stocksQuantityTableColumn.setCellValueFactory(data -> data.getValue().quantityProperty().asString());
            stocksLocationTableColumn.setCellValueFactory(data ->
            {

                List<Donation> donationRelatedToBlood = donations.stream()
                        .filter(d -> d.getDonatedBlood() == data.getValue())
                        .collect(Collectors.toList());

                Clinic clinicRelatedToBlood = donationRelatedToBlood.get(0).getClinic();
                return new SimpleStringProperty(clinicRelatedToBlood.getName() + ", " +
                        clinicRelatedToBlood.getLocation());
            });

            ObservableList<Blood> bloodObservableList = FXCollections.observableArrayList(bloodFromDonations);
            stocksTableView.setItems(bloodObservableList);
        }
    }

    // ################################################################################################################





// #######################################################
// TAB 4 --- Blood Container Journey
// #######################################################

    private void initializeBloodContainerJourneyTab()
    {
        approvedDonationRequestsDonorNameTableColumn.setCellValueFactory(data ->
                data.getValue().getDonor().fullNameProperty());
        approvedDonationRequestsAprovedByDoctorTableColumn.setCellValueFactory(data ->
                new SimpleStringProperty(data.getValue().getValidatedByDoctor().toString()));
        populateApprovedDonationRequestsTable();

        journeyTestingDonationDateTableColumn.setCellValueFactory(data ->
                data.getValue().donationDateProperty());
        journeyTestingBloodGroupTableColumn.setCellValueFactory(data ->
                data.getValue().donatedBloodProperty());
        journeyTestingStatusTableColumn.setCellValueFactory(data ->
                data.getValue().bloodContainerStatusProperty());
        populateDonationsInTestingTable();
    }

    private void populateApprovedDonationRequestsTable()
    {
        List<DonationRequest> pendingDonationRequests = donationRequestRepository.getAll()
                .stream()
                //.peek(System.out::println)
                .filter(donationRequest -> donationRequest.getValidatedByDoctor() != null)
                .filter(donationRequest -> donationRequest.getValidatedByPersonnel() && donationRequest.getValidatedByDoctor())
                .filter(donationRequest -> donationRequest.getInTesting() != null)
                .filter(donationRequest -> !donationRequest.getInTesting())
                .collect(Collectors.toList());

        //pendingDonationRequests.forEach(System.out::println);

        ObservableList<DonationRequest> pendingDonationRequestsObservableList = FXCollections.observableArrayList(pendingDonationRequests);

        approvedDonationRequestsTableView.setItems(pendingDonationRequestsObservableList);
    }

    private void populateDonationsInTestingTable()
    {
        List<Donation> donationsInTesting = donationRepository.getAll()
                .stream()
                .filter(donation -> donation.getDonationRequest().getValidatedByPersonnel() && donation.getDonationRequest().getValidatedByDoctor())
                .filter(donation -> donation.getStatus() == Status.TESTING || donation.getStatus() == Status.PENDING)
                .filter(donation -> donation.getDonatedBlood().getQuantity() > 0f)
                .filter(donation -> !donation.getDonatedBlood().getReadyForUse())
                .collect(Collectors.toList());

        ObservableList<Donation> donationObservableList = FXCollections.observableArrayList(donationsInTesting);



        journeyBloodInTestingTableView.setItems(donationObservableList);
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
            blood.setQuantity(0.35f);  // a person can donate max 350ml of blood at a time
            blood.setReadyForUse(false);

            bloodRepository.add(blood);

            selectedDonationRequest.setInTesting(true);
            donationRequestRepository.update(selectedDonationRequest);

            donation.setDonationRequest(selectedDonationRequest);
            donation.setDonatedBlood(blood);
            donation.setDonor(selectedDonationRequest.getDonor());
            donation.setDonationDate(LocalDate.now());
            donation.setStatus(Status.PENDING);
            donation.setPatient(selectedDonationRequest.getPatient());
            donation.setClinic(currentPersonnel.getClinic());
            donation.setQuantity(0.35f);
            donation.setBloodContainerJourneyStatus(JourneyStatus.SAMPLING);

//            blood.setDonation(donation);  // DO I HAVE TO DO THIS TOO????

            donationRepository.add(donation);

            // repopulate the table views
            refresh();
        }
    }

    @FXML
    private void journeyBeginPreparation() throws IOException
    {
        if(!journeyBloodInTestingTableView.getSelectionModel().isEmpty())
        {
            Donation selectedDonation = journeyBloodInTestingTableView.getSelectionModel().getSelectedItem();
            selectedDonation.setStatus(Status.TESTING);
            donationRepository.update(selectedDonation);

            if(selectedDonation.getBloodContainerJourneyStatus() == JourneyStatus.SAMPLING ||
                    selectedDonation.getBloodContainerJourneyStatus() == JourneyStatus.PREPARATION)
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/personnel/personnelBloodJourneyPreparation.fxml"));


                loader.setController(new PersonnelBloodJourneyPreparationWindow()
                        .setPrimaryStage(primaryStage)
                        .setSession(session)
                        .setPreviousScene(primaryStage.getScene())
                        .setCurrentPersonnel(currentPersonnel)
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
                        .setCurrentDonation(selectedDonation)
                        .setBloodRequestRepository(bloodRequestRepository)
                        .setDonorRepository(donorRepository)
                );

                Parent content = loader.load();

                Scene selectScene = new Scene(content);
                primaryStage.setScene(selectScene);
                primaryStage.setTitle("Preparation Stage");
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Cannot proceed to this stage.");
                alert.setContentText("The selected donation does not meet the required Status to proceed to this stage.");

                Optional<ButtonType> result = alert.showAndWait();
            }
        }
    }

    @FXML
    private void journeyBeginBiologicalQualityControl() throws IOException
    {
        if (!journeyBloodInTestingTableView.getSelectionModel().isEmpty())
        {
            Donation selectedDonation = journeyBloodInTestingTableView.getSelectionModel().getSelectedItem();

            if (selectedDonation.getBloodContainerJourneyStatus() == JourneyStatus.BIOLOGICAL_QUALITY_CONTROL)
            {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/fxml/personnel/personnelBloodJourneyQualityControl.fxml"));


                loader.setController(new PersonnelBloodJourneyBiologicalQCWindow()
                        .setPrimaryStage(primaryStage)
                        .setSession(session)
                        .setPreviousScene(primaryStage.getScene())
                        .setCurrentPersonnel(currentPersonnel)
                        .setDonationRepository(donationRepository)
                        .setDonationRequestRepository(donationRequestRepository)
                        .setClinicRepository(clinicRepository)
                        .setBloodRepository(bloodRepository)
                        .setBloodGroupRepository(bloodGroupRepository)
                        .setDistanceRepository(distanceRepository)
                        .setPatientRepository(patientRepository)
                        .setDonationAppointmentRepository(donationAppointmentRepository)
                        .setLocationRepository(locationRepository)
                        .setCurrentDonation(selectedDonation)
                        .setBloodRequestRepository(bloodRequestRepository)
                        .setDonorRepository(donorRepository)
                );

                Parent content = loader.load();

                Scene selectScene = new Scene(content);
                primaryStage.setScene(selectScene);
                primaryStage.setTitle("Biological Quality Control Stage");
            } else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Cannot proceed to this stage.");
                alert.setContentText("The selected donation does not meet the required Status to proceed to this stage.");

                Optional<ButtonType> result = alert.showAndWait();
            }

        }
    }

    @FXML
    private void journeyBeginRedistribution()
    {
        if(!journeyBloodInTestingTableView.getSelectionModel().isEmpty())
        {
            Donation selectedDonation = journeyBloodInTestingTableView.getSelectionModel().getSelectedItem();

            if(selectedDonation.getBloodContainerJourneyStatus() == JourneyStatus.REDISTRIBUTION)
            {
                // should do some fancy validation for the case when split flag is true

                if(selectedDonation.getPatient() != null) // if the donation is for a specific patient
                {
                    // check if a blood request exists for that patient

                    BloodRequest currentBloodRequest = null;

                    for(BloodRequest bloodRequest: bloodRequestRepository.getAll())
                    {
                        if(bloodRequest.getPatient() == selectedDonation.getPatient())
                        {
                            currentBloodRequest = bloodRequest;
                            break;
                        }
                    }

                    if(currentBloodRequest != null && currentBloodRequest.getStatus() == Status.PENDING)  // if an actual blood request was created before or still exists
                    {
                        if(selectedDonation.getDonatedBlood().getBloodGroup().canBeDonatedTo(currentBloodRequest.getBloodGroup()))
                        {
                            float remainingBlood = currentBloodRequest.getQuantity() - currentBloodRequest.getGivenBlood();

                            if (remainingBlood >= selectedDonation.getDonatedBlood().getQuantity())
                            {
                                currentBloodRequest.setGivenBlood(currentBloodRequest.getGivenBlood() + selectedDonation.getDonatedBlood().getQuantity());
                                selectedDonation.getDonatedBlood().setQuantity(0f);
                            } else
                            {
                                currentBloodRequest.setGivenBlood(currentBloodRequest.getGivenBlood() + remainingBlood);
                                selectedDonation.getDonatedBlood().setQuantity(selectedDonation.getDonatedBlood().getQuantity() - remainingBlood);
                            }

                            // check if the blood request is fulfilled
                            if(currentBloodRequest.getQuantity() >= currentBloodRequest.getGivenBlood())
                            {
                                currentBloodRequest.setStatus(Status.DONE);
                            }

                            bloodRequestRepository.update(currentBloodRequest);
                            bloodRepository.update(selectedDonation.getDonatedBlood());
                            donationRepository.update(selectedDonation);
                        }
                    }
                    else
                    {
                        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                        alert.setTitle("Confirm Blood Redistribution Dialog");
                        alert.setHeaderText("There is no pending blood request associated with the patient.");
                        alert.setContentText("The blood will be added to the stocks. Press OK to continue.");

                        Optional<ButtonType> result = alert.showAndWait();
                    }

                }

                // set the readyToUse flag to true
                selectedDonation.getDonatedBlood().setReadyForUse(true);

                // set the status for the donation
                selectedDonation.setStatus(Status.DONE);

                // update the DB
                bloodRepository.update(selectedDonation.getDonatedBlood());
                donationRepository.update(selectedDonation);

            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Cannot proceed to this stage.");
                alert.setContentText("The selected donation does not meet the required Status to proceed to this stage.");

                Optional<ButtonType> result = alert.showAndWait();
            }

            // repopulate the table views
            refresh();
        }
    }





// ################################################################################################################

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        // populate table views

        // DONATION REQUESTS TAB
        initializeDonationRequestsTab();

        // BLOOD REQUESTS TAB
        initializeBloodRequestsTable();

        // AVAILABLE STOCKS TAB
        initializeAvailableStocksTable();

        // BLOOD CONTAINER JOURNEY TAB
        initializeBloodContainerJourneyTab();
    }
}
