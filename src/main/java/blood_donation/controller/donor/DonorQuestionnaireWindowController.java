package blood_donation.controller.donor;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import blood_donation.domain.utils.*;
import blood_donation.repository.Repository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

public final class DonorQuestionnaireWindowController implements Initializable
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
    private CheckBox romanianCitizenCheckBox;

    @FXML
    private CheckBox ageCheckBox;

    @FXML
    private CheckBox weightCheckBox;

    @FXML
    private CheckBox pulseCheckBox;

    @FXML
    private CheckBox bloodPressureCheckBox;

    @FXML
    private CheckBox surgeryCheckBox;

    @FXML
    private CheckBox pregnantCheckBox;

    @FXML
    private CheckBox alcoholCheckBox;

    @FXML
    private CheckBox treatmentCheckBox;

    @FXML
    private CheckBox tuberculosisCheckBox;

    @FXML
    private CheckBox poxCheckBox;

    @FXML
    private CheckBox malariaCheckBox;

    @FXML
    private CheckBox epilepsyCheckBox;

    @FXML
    private CheckBox mentalIllnessCheckBox;

    @FXML
    private CheckBox brucellosisCheckBox;

    @FXML
    private CheckBox ulcerCheckBox;

    @FXML
    private CheckBox diabetesCheckBox;

    @FXML
    private CheckBox heartDiseaseCheckBox;

    @FXML
    private CheckBox miopiaCheckBox;

    @FXML
    private CheckBox cancerCheckBox;

    @FXML
    private VBox uncheckedVBox;

    @FXML
    private Set<CheckBox> checkedCheckBoxes = new HashSet<>();

    @FXML
    private Set<CheckBox> uncheckedCheckBoxes = new HashSet<>();

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DonorQuestionnaireWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DonorQuestionnaireWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DonorQuestionnaireWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Donor getCurrentDonor()
    {
        return currentDonor;
    }

    public DonorQuestionnaireWindowController setCurrentDonor(Donor currentDonor)
    {
        this.currentDonor = currentDonor;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public DonorQuestionnaireWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public DonorQuestionnaireWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public DonorQuestionnaireWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public DonorQuestionnaireWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public DonorQuestionnaireWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public DonorQuestionnaireWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }


    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public DonorQuestionnaireWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public DonorQuestionnaireWindowController setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
        return this;
    }


    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public DonorQuestionnaireWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Repository<Hospital> getHospitalRepository()
    {
        return hospitalRepository;
    }

    public DonorQuestionnaireWindowController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    @FXML
    void submitData() throws IOException
    {
        boolean showAlert = false;

        for(CheckBox checkBox : checkedCheckBoxes)
        {
            if(!checkBox.isSelected())
            {
                checkBox.setTextFill(Color.web("#ff0000"));
                showAlert = true;
            }
        }

        for(CheckBox checkBox : uncheckedCheckBoxes)
        {
            if(checkBox.isSelected())
            {
                checkBox.setTextFill(Color.web("#ff0000"));
                showAlert = true;
            }
        }

        if(showAlert)
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Warning");
            alert.setHeaderText("Sorry, you don't meet the conditions to be a donor. They are highlighted in red");
            alert.setContentText("Would you like to go back to your profile?");

            Optional<ButtonType> result = alert.showAndWait();

            if(result.get() == ButtonType.OK)
                goBack();
            return;
        }

        DonationRequest donationRequest = new DonationRequest();
        donationRequest.setAge(Period.between(currentDonor.getBirthDate(), LocalDate.now()).getYears());
        donationRequest.setHasConsumedFatRecently(alcoholCheckBox.isSelected());
        donationRequest.setHasConsumedAlcoholRecently(alcoholCheckBox.isSelected());
        donationRequest.setHadSurgeryRecently(surgeryCheckBox.isSelected());
        donationRequest.setUnderTreatment(treatmentCheckBox.isSelected());
        donationRequest.setHasTB(tuberculosisCheckBox.isSelected());
        donationRequest.setHasPox(poxCheckBox.isSelected());
        donationRequest.setHasMalaria(malariaCheckBox.isSelected());
        donationRequest.setHasEpilepsy(epilepsyCheckBox.isSelected());
        donationRequest.setHasOtherNeurologicalDisease(epilepsyCheckBox.isSelected());
        donationRequest.setHasMentalIllness(mentalIllnessCheckBox.isSelected());
        donationRequest.setHasBrucellosis(brucellosisCheckBox.isSelected());
        donationRequest.setHasUlcer(ulcerCheckBox.isSelected());
        donationRequest.setHasDiabetes(diabetesCheckBox.isSelected());
        donationRequest.setHasHeartDisease(heartDiseaseCheckBox.isSelected());
        donationRequest.setHasMyopiaOverOrUnder6(miopiaCheckBox.isSelected());
        donationRequest.setHasCancer(cancerCheckBox.isSelected());

        donationRequest.setDonor(currentDonor);

        donationRequestRepository.add(donationRequest);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/donor/donorDonationScheduleWindow.fxml"));
        loader.setController(new DonorDonationScheduleWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setPreviousScene(primaryStage.getScene())
                .setCurrentDonor(currentDonor)
                .setCurrentDonationRequest(donationRequest)
                .setDonationRepository(donationRepository)
                .setDistanceRepository(distanceRepository)
                .setClinicRepository(clinicRepository)
                .setPatientRepository(patientRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setDonationAppointmentRepository(donationAppointmentRepository)
                .setLocationRepository(locationRepository)
                .setHospitalRepository(hospitalRepository));


        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);

        //TODO implement the transition to next scene
    }

    @FXML
    private void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        List<Node> vBoxChildren = uncheckedVBox.getChildren();
        uncheckedCheckBoxes.addAll(vBoxChildren.subList(1, vBoxChildren.size()).stream()
                .map(node -> (CheckBox) node)
                .collect(Collectors.toList()));

        uncheckedCheckBoxes.addAll(Arrays.asList(surgeryCheckBox, pregnantCheckBox, alcoholCheckBox, treatmentCheckBox));
        checkedCheckBoxes.addAll(Arrays.asList(romanianCitizenCheckBox, ageCheckBox, weightCheckBox));
    }
}
