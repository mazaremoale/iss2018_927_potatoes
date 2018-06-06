package blood_donation.controller.donor;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import blood_donation.domain.utils.*;
import blood_donation.repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public class DonorMainWindowController implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Donor currentDonor;
    private Repository<Donation> donationRepository;
    private Repository<DonationRequest> donationRequestRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Blood> bloodRepository;
    private Repository<BloodGroup> bloodGroupRepository;
    private Repository<Distance> distanceRepository;
    private Repository<Patient> patientRepository;
    private Repository<DonationAppointment> donationAppointmentRepository;
    private Repository<Location> locationRepository;
    private Repository<Hospital> hospitalRepository;

    @FXML
    private Label appointmentLabel;

    @FXML
    private TableView<Donation> donationTableView;

    @FXML
    private TableColumn<Donation, String> dateTableColumn;

    @FXML
    private TableColumn<Donation, String> statusTableColumn;

    @FXML
    private TableColumn<Donation, String> donatedBloodTableColumn;

    @FXML
    private TableColumn<Donation, String> patientTableColumn;

    @FXML
    private TableColumn<Donation, String> clinicTableColumn;

    @FXML
    private Label ageLabel;

    @FXML
    private Label pulseLabel;

    @FXML
    private Label weightLabel;

    @FXML
    private Label bloodPressureLabel;

    @FXML
    private CheckBox hivCheckBox;

    @FXML
    private CheckBox hepatitisCheckBox;

    @FXML
    private CheckBox tuberculosisCheckBox;

    @FXML
    private CheckBox poxCheckBox;

    @FXML
    private CheckBox malariaCheckBox;

    @FXML
    private CheckBox epilepsyCheckBox;

    @FXML
    private CheckBox neurologicalCheckBox;

    @FXML
    private CheckBox mentalCheckBox;

    @FXML
    private CheckBox brucellosisCheckBox;

    @FXML
    private CheckBox ulcerCheckBox;

    @FXML
    private CheckBox diabetesCheckBox;

    @FXML
    private CheckBox heartDiseaseCheckBox;

    @FXML
    private CheckBox psioriasisCheckBox;

    @FXML
    private CheckBox vitiligoCheckBox;

    @FXML
    private CheckBox myopiaCheckBox;

    @FXML
    private CheckBox cancerCheckBox;

    @FXML
    private List<CheckBox> bloodAnalysisCheckBoxes;

    @FXML
    private List<Label> diagnosticsLabels;

    @FXML
    private Label lastNameLabel;

    @FXML
    private Label firstNameLabel;

    @FXML
    private Label birthDateLabel;

    @FXML
    private Label idAddressLabel;

    @FXML
    private Label idCityLabel;

    @FXML
    private Label idCountyLabel;

    @FXML
    private Label residenceAddressLabel;

    @FXML
    private Label residenceCityLabel;

    @FXML
    private Label residenceCountyLabel;


    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DonorMainWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DonorMainWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DonorMainWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Donor getCurrentDonor()
    {
        return currentDonor;
    }

    public DonorMainWindowController setCurrentDonor(Donor currentDonor)
    {
        this.currentDonor = currentDonor;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public DonorMainWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public DonorMainWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public DonorMainWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public DonorMainWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public DonorMainWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }


    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public DonorMainWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public DonorMainWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public DonorMainWindowController setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public DonorMainWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Repository<Hospital> getHospitalRepository()
    {
        return hospitalRepository;
    }

    public DonorMainWindowController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    //TODO edit profile with the already existing Window, with a different controller
    //TODO modify donating to a certain patient

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    public void donateBlood() throws IOException
    {
        Donation latestDonation = currentDonor.getLatestDonation(donationRepository);

        Period timePeriod = Period.between(currentDonor.getBirthDate(), LocalDate.now());
        if (timePeriod.getYears() < 18)
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You must be at least 18 to donate.");
            alert.setContentText("Sorry for the inconvenience.");

            alert.showAndWait();

            return;
        }

        if(latestDonation != null)
        {
            if (latestDonation.getDonationDate().plusWeeks(2).compareTo(LocalDate.now()) > 0)
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Warning");
                alert.setHeaderText("You cannot donate again until " + latestDonation.getDonationDate().plusWeeks(2) + " or at a later date");
                alert.setContentText("Would you like to schedule your donation anyway?");

                Optional<ButtonType> result = alert.showAndWait();

                if (result.get() == ButtonType.OK)
                {
                    openDonorQuestionnaireWindow();
                }
            }
            else
            {
                openDonorQuestionnaireWindow();
            }
        }
        else
        {
            openDonorQuestionnaireWindow();
        }
    }

    private void openDonorQuestionnaireWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/donor/donorQuestionnaireWindow.fxml"));

        loader.setController(new DonorQuestionnaireWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setPreviousScene(primaryStage.getScene())
                .setCurrentDonor(currentDonor)
                .setDonationRepository(donationRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setClinicRepository(clinicRepository)
                .setBloodRepository(bloodRepository)
                .setBloodGroupRepository(bloodGroupRepository)
                .setDistanceRepository(distanceRepository)
                .setPatientRepository(patientRepository)
                .setDonationAppointmentRepository(donationAppointmentRepository)
                .setLocationRepository(locationRepository)
                .setHospitalRepository(hospitalRepository));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Donor main menu");
    }

    @FXML
    private void initializeLabels(DonationRequest currentDonationRequest)
    {
        ageLabel.setText(String.valueOf(currentDonationRequest.getAge()));
        pulseLabel.setText(String.valueOf(currentDonationRequest.getPulse()));
        weightLabel.setText(String.valueOf(currentDonationRequest.getWeight()));
        bloodPressureLabel.setText(String.valueOf(currentDonationRequest.getBloodPressure()));


        if (currentDonationRequest.getHasHIV())
        {
            hivCheckBox.setIndeterminate(false);
            hivCheckBox.setSelected(true);
        }
        else
            hivCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasHepatitis())
        {
            hepatitisCheckBox.setIndeterminate(false);
            hepatitisCheckBox.setSelected(true);
        }
        else
            hepatitisCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasTB())
        {
            tuberculosisCheckBox.setIndeterminate(false);
            tuberculosisCheckBox.setSelected(true);
        }
        else
            tuberculosisCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasPox())
        {
            poxCheckBox.setIndeterminate(false);
            poxCheckBox.setSelected(true);
        }
        else
            poxCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasMalaria())
        {
            malariaCheckBox.setIndeterminate(false);
            malariaCheckBox.setSelected(true);
        }
        else
            malariaCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasEpilepsy())
        {
            epilepsyCheckBox.setIndeterminate(false);
            epilepsyCheckBox.setSelected(true);
        }
        else
            epilepsyCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasOtherNeurologicalDisease())
        {
            neurologicalCheckBox.setIndeterminate(false);
            neurologicalCheckBox.setSelected(true);
        }
        else
            neurologicalCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasMentalIllness())
        {
            mentalCheckBox.setIndeterminate(false);
            mentalCheckBox.setSelected(true);
        }
        else
            mentalCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasBrucellosis())
        {
            brucellosisCheckBox.setIndeterminate(false);
            brucellosisCheckBox.setSelected(true);
        }
        else
            brucellosisCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasUlcer())
        {
            ulcerCheckBox.setIndeterminate(false);
            ulcerCheckBox.setSelected(true);
        }
        else
            ulcerCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasDiabetes())
        {
            diabetesCheckBox.setIndeterminate(false);
            diabetesCheckBox.setSelected(true);
        }
        else
            diabetesCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasHeartDisease())
        {
            heartDiseaseCheckBox.setIndeterminate(false);
            heartDiseaseCheckBox.setSelected(true);
        }
        else
            diabetesCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasPsoriasis())
        {
            psioriasisCheckBox.setIndeterminate(false);
            psioriasisCheckBox.setSelected(true);
        }
        else
            psioriasisCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasVitiligo())
        {
            vitiligoCheckBox.setIndeterminate(false);
            vitiligoCheckBox.setSelected(true);
        }
        else
            vitiligoCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasMyopiaOverOrUnder6())
        {
            myopiaCheckBox.setIndeterminate(false);
            myopiaCheckBox.setSelected(true);
        }
        else
            myopiaCheckBox.setIndeterminate(true);

        if(currentDonationRequest.getHasCancer())
        {
            cancerCheckBox.setIndeterminate(false);
            cancerCheckBox.setSelected(true);
        }
        else
            cancerCheckBox.setIndeterminate(true);


        if(!ageLabel.isVisible())
        {
            diagnosticsLabels.forEach(label -> label.setVisible(true));
            bloodAnalysisCheckBoxes.forEach(checkBox -> checkBox.setVisible(true));
        }
    }

    private void initializeAppointmentLabel()
    {
        List<DonationRequest> thisDonorDonationRequests = currentDonor.getDonationRequests(donationRequestRepository);
        List<DonationAppointment> thisDonorAppointments = donationAppointmentRepository.getAll().stream()
                .filter(appointment -> thisDonorDonationRequests.contains(appointment.getDonationRequest()))
                .collect(Collectors.toList());
        if (thisDonorAppointments.size() == 0)
            appointmentLabel.setVisible(false);
        else
        {
            appointmentLabel.setVisible(true);
            DonationAppointment appointment;

            if (thisDonorAppointments.size() == 1)
                appointment = thisDonorAppointments.get(0);
            else
                appointment = thisDonorAppointments.stream().reduce((first, second) -> second).get();

            appointmentLabel.setText("You have an appointment on " + appointment.getAppointmentDate() +
                        " at " + appointment.getAppointmentTime() + " at the " + appointment.getClinic() + " clinic");

        }

    }

    public void openDonorProfileEdit() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/donor/donorRegistrationWindow.fxml"));

        loader.setController(new DonorEditProfileWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setPreviousScene(primaryStage.getScene())
                .setCurrentDonor(currentDonor)
                .setDonationRepository(donationRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setClinicRepository(clinicRepository)
                .setBloodRepository(bloodRepository)
                .setBloodGroupRepository(bloodGroupRepository)
                .setDistanceRepository(distanceRepository)
                .setPatientRepository(patientRepository)
                .setDonationAppointmentRepository(donationAppointmentRepository)
                .setLocationRepository(locationRepository));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Donor main menu");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

        bloodAnalysisCheckBoxes = new ArrayList<>(Arrays.asList(brucellosisCheckBox, cancerCheckBox, diabetesCheckBox, epilepsyCheckBox, heartDiseaseCheckBox,
                hepatitisCheckBox, hivCheckBox, malariaCheckBox, mentalCheckBox, myopiaCheckBox, neurologicalCheckBox, poxCheckBox,
                psioriasisCheckBox, tuberculosisCheckBox, ulcerCheckBox, vitiligoCheckBox));

        diagnosticsLabels = new ArrayList<>(Arrays.asList(ageLabel, pulseLabel, weightLabel, bloodPressureLabel));


        bloodAnalysisCheckBoxes.forEach(checkBox -> checkBox.setVisible(false));
        diagnosticsLabels.forEach(label -> label.setVisible(false));


        dateTableColumn.setCellValueFactory(data -> data.getValue().donationDateProperty());
        statusTableColumn.setCellValueFactory(data -> data.getValue().statusProperty());
        donatedBloodTableColumn.setCellValueFactory(data -> data.getValue().donatedBloodProperty());
        patientTableColumn.setCellValueFactory(data -> data.getValue().patientProperty());
        clinicTableColumn.setCellValueFactory(data -> data.getValue().clinicProperty());


        List<Donation> thisDonorDonations = currentDonor.getDonations(donationRepository);


        //create donation, persist it, show all but last -- would work if donation wouldn't be bound by blood, drequest and whatnot
        ObservableList<Donation> thisDonorDonationsObservableList = FXCollections.observableArrayList(thisDonorDonations
                .stream().filter(donation -> donation.getDonor() != null).collect(Collectors.toList()));

        donationTableView.setItems(thisDonorDonationsObservableList);

        donationTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            DonationRequest currentDonationRequest = newValue.getDonationRequest();

            initializeLabels(currentDonationRequest);
        });

        initializeAppointmentLabel();

        //my Profile tab initialization
        lastNameLabel.setText(currentDonor.getLastName());
        firstNameLabel.setText(currentDonor.getFirstName());
        birthDateLabel.setText(currentDonor.getBirthDate().toString());
        idAddressLabel.setText(currentDonor.getIdAddress());
        idCityLabel.setText(currentDonor.getIdCity());
        idCountyLabel.setText(currentDonor.getIdCounty().toString());
        if(currentDonor.getResidenceAddress() != null)
        {
            residenceAddressLabel.setText(currentDonor.getResidenceAddress());
            residenceCityLabel.setText(currentDonor.getResidenceCity());
            residenceCountyLabel.setText(currentDonor.getResidenceCounty().toString());
        }
        else
        {
            residenceAddressLabel.setText(currentDonor.getIdAddress());
            residenceCityLabel.setText(currentDonor.getIdCity());
            residenceCountyLabel.setText(currentDonor.getIdCounty().toString());
        }

    }
}
