package blood_donation.controller.personnel;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Patient;
import blood_donation.domain.people.Personnel;
import blood_donation.domain.utils.*;
import blood_donation.repository.Repository;
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
import java.util.Optional;
import java.util.ResourceBundle;

public class PersonnelDonorMedicalDataWindowController implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Personnel currentPersonnel;
    private DonationAppointment donationAppointment;

    private Repository<Donation> donationRepository;
    private Repository<DonationRequest> donationRequestRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Blood> bloodRepository;
    private Repository<BloodGroup> bloodGroupRepository;
    private Repository<Distance> distanceRepository;
    private Repository<Patient> patientRepository;
    private Repository<DonationAppointment> donationAppointmentRepository;

    @FXML
    private TextField ageTextField;
    @FXML
    private TextField weightTextField;
    @FXML
    private TextField pulseTextField;
    @FXML
    private TextField bloodPressureTextField;

    @FXML
    private ComboBox<String> citizenComboBox;
    @FXML
    private ComboBox<String> surgeriesComboBox;
    @FXML
    private ComboBox<String> pregnantComboBox;
    @FXML
    private ComboBox<String> inTreatmentComboBox;
    @FXML
    private ComboBox<String> alcoholConsumtionComboBox;
    @FXML
    private ComboBox<String> fatConsumptionComboBox;
    @FXML
    private ComboBox<String> smokedComboBox;
    @FXML
    private ComboBox<String> wellSleptComboBox;

    @FXML
    private CheckBox hepatitisCheckBox;
    @FXML
    private CheckBox tbCheckBox;
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
    private CheckBox heartDiseasesCheckBox;
    @FXML
    private CheckBox skinDeseasesCheckBox;
    @FXML
    private CheckBox myopiaCheckBox;
    @FXML
    private CheckBox cancerCheckBox;
    @FXML
    private CheckBox hivCheckBox;

    @FXML
    private TextArea otherInformationTextArea;

    @FXML
    private Button saveDonorMedicalDataButton;

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public PersonnelDonorMedicalDataWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public PersonnelDonorMedicalDataWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public PersonnelDonorMedicalDataWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Personnel getCurrentPersonnel()
    {
        return currentPersonnel;
    }

    public PersonnelDonorMedicalDataWindowController setCurrentPersonnel(Personnel currentPersonnel)
    {
        this.currentPersonnel = currentPersonnel;
        return this;
    }

    public DonationAppointment getDonationAppointment()
    {
        return donationAppointment;
    }

    public PersonnelDonorMedicalDataWindowController setDonationAppointment(DonationAppointment donationAppointment)
    {
        this.donationAppointment = donationAppointment;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public PersonnelDonorMedicalDataWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public PersonnelDonorMedicalDataWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public PersonnelDonorMedicalDataWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public PersonnelDonorMedicalDataWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public PersonnelDonorMedicalDataWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public PersonnelDonorMedicalDataWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public PersonnelDonorMedicalDataWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public PersonnelDonorMedicalDataWindowController setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
        return this;
    }

    private int computeAge(LocalDate birthDate)
    {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    private Boolean isFormCompleted()
    {
        // check combo boxes and text fields
        return !citizenComboBox.getSelectionModel().isEmpty() &&
                !surgeriesComboBox.getSelectionModel().isEmpty() &&
                !pregnantComboBox.getSelectionModel().isEmpty() &&
                !inTreatmentComboBox.getSelectionModel().isEmpty() &&
                !alcoholConsumtionComboBox.getSelectionModel().isEmpty() &&
                !fatConsumptionComboBox.getSelectionModel().isEmpty() &&
                !smokedComboBox.getSelectionModel().isEmpty() &&
                !wellSleptComboBox.getSelectionModel().isEmpty() &&
                !ageTextField.getText().isEmpty() &&
                !weightTextField.getText().isEmpty() &&
                !pulseTextField.getText().isEmpty() &&
                !bloodPressureTextField.getText().isEmpty();
    }

    private Boolean areTextBoxesValid()
    {
        try
        {
            Integer.parseInt(ageTextField.getText());
            Float.parseFloat(weightTextField.getText());
            Float.parseFloat(pulseTextField.getText());
            Float.parseFloat(bloodPressureTextField.getText());

            return true;
        }
        catch(NumberFormatException er)
        {
            return false;
        }
    }

    @FXML
    public void saveDonorMedicalData() throws IOException
    {
        if(isFormCompleted() && areTextBoxesValid())
        {
            // current donation request
            DonationRequest cdr = donationAppointment.getDonationRequest();

            // combo boxes
            cdr.setHadSurgeryRecently(!surgeriesComboBox.getSelectionModel().getSelectedItem().equals("No"));
            cdr.setUnderTreatment(!inTreatmentComboBox.getSelectionModel().getSelectedItem().equals("No"));
            cdr.setHasConsumedAlcoholRecently(!alcoholConsumtionComboBox.getSelectionModel().getSelectedItem().equals("No"));
            cdr.setHasConsumedFatRecently(!fatConsumptionComboBox.getSelectionModel().getSelectedItem().equals("No"));
            cdr.setHasSmokedRecently(!smokedComboBox.getSelectionModel().getSelectedItem().equals("No"));
            cdr.setWellSlept(wellSleptComboBox.getSelectionModel().getSelectedItem().equals("Yes"));

            // text fields
            cdr.setAge(Integer.parseInt(ageTextField.getText()));
            cdr.setWeight(Float.parseFloat(weightTextField.getText()));
            cdr.setPulse(Float.parseFloat(pulseTextField.getText()));
            cdr.setBloodPressure(Float.parseFloat(bloodPressureTextField.getText()));

            // check boxes
            cdr.setHasHepatitis(hepatitisCheckBox.isSelected());
            cdr.setHasTB(tbCheckBox.isSelected());
            cdr.setHasPox(poxCheckBox.isSelected());
            cdr.setHasMalaria(malariaCheckBox.isSelected());
            cdr.setHasEpilepsy(epilepsyCheckBox.isSelected());
            cdr.setHasOtherNeurologicalDisease(epilepsyCheckBox.isSelected());
            cdr.setHasMentalIllness(mentalIllnessCheckBox.isSelected());
            cdr.setHasBrucellosis(brucellosisCheckBox.isSelected());
            cdr.setHasUlcer(ulcerCheckBox.isSelected());
            cdr.setHasDiabetes(diabetesCheckBox.isSelected());
            cdr.setHasHeartDisease(heartDiseasesCheckBox.isSelected());
            cdr.setHasVitiligo(skinDeseasesCheckBox.isSelected());
            cdr.setHasPsoriasis(skinDeseasesCheckBox.isSelected());
            cdr.setHasMyopiaOverOrUnder6(myopiaCheckBox.isSelected());
            cdr.setHasCancer(cancerCheckBox.isSelected());
            cdr.setHasHIV(hivCheckBox.isSelected());

            // text area
            cdr.setOtherInformation(otherInformationTextArea.getText());

            // actually update the values in the repo and database
            donationRequestRepository.update(cdr);

            // change to Personnel Main Window
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/personnel/personnelMainWindow.fxml"));


            loader.setController(new PersonnelMainWindowController()
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
            );

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Personnel main menu");

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("All the fields on the left side are required in order to continue");
            alert.setContentText("Please fill in all the fields and make sure that the data has the correct format before continuing");

            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        citizenComboBox.getItems().addAll("Yes", "No");
        surgeriesComboBox.getItems().addAll("Yes", "No");
        pregnantComboBox.getItems().addAll("Yes", "No");
        inTreatmentComboBox.getItems().addAll("Yes", "No");
        alcoholConsumtionComboBox.getItems().addAll("Yes", "No");
        fatConsumptionComboBox.getItems().addAll("Yes", "No");
        smokedComboBox.getItems().addAll("Yes", "No");
        wellSleptComboBox.getItems().addAll("Yes", "No");

        // initialize form fields with information filled in by the donor in the request
        DonationRequest currentDonationRequest = donationAppointment.getDonationRequest();

        ageTextField.setText(String.valueOf(computeAge(currentDonationRequest.getDonor().getBirthDate())));

        citizenComboBox.setValue("Yes");
        surgeriesComboBox.setValue("No");
        pregnantComboBox.setValue("No");
        inTreatmentComboBox.setValue("No");
        alcoholConsumtionComboBox.setValue("No");
        fatConsumptionComboBox.setValue("No");

    }
}
