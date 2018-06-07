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
    private Repository<Location> locationRepository;
    private Repository<BloodRequest> bloodRequestRepository;

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
    @FXML
    private Button cancelRequestButton;
    @FXML
    private Button backButton;

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

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public PersonnelDonorMedicalDataWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Repository<BloodRequest> getBloodRequestRepository()
    {
        return bloodRequestRepository;
    }

    public PersonnelDonorMedicalDataWindowController setBloodRequestRepository(Repository<BloodRequest> bloodRequestRepository)
    {
        this.bloodRequestRepository = bloodRequestRepository;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    private void goToPersonnelMainWindow() throws IOException
    {
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
                .setBloodGroupRepository(bloodGroupRepository)
                .setLocationRepository(locationRepository)
                .setBloodRequestRepository(bloodRequestRepository)
        );

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Personnel main menu");
    }

    private int computeAge(LocalDate birthDate)
    {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    private LocalDate computeExpirationDate(LocalDate donationDate)
    {
        return donationDate.plusDays(42);  // blood expires after 42 days
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

    private String validateData()
    {
        String errorString = "";
        String diseasesString = "";

        if(citizenComboBox.getSelectionModel().getSelectedItem().equals("No"))
            errorString = errorString.concat("Only Romanian citizens or EU citizens living in Romania can donate.\n");
//        if(Integer.parseInt(ageTextField.getText()) < 18 || Integer.parseInt(ageTextField.getText()) > 60)
//            errorString = errorString.concat("The age must be between 18 and 60.\n");
//        if(Float.parseFloat(weightTextField.getText()) < 50)
//            errorString = errorString.concat("The weight must be at least 50kg.\n");
//        if(Float.parseFloat(pulseTextField.getText()) < 60 || Float.parseFloat(pulseTextField.getText()) > 100)
//            errorString = errorString.concat("The pulse must be between 60 and 100 beats.\n");
//        if(Float.parseFloat(bloodPressureTextField.getText()) < 100 || Float.parseFloat(bloodPressureTextField.getText()) > 180)
//            errorString = errorString.concat("The systolic blood pressure must be between 100 and 180 mmHg.\n");
        if(surgeriesComboBox.getSelectionModel().getSelectedItem().equals("Yes"))
            errorString = errorString.concat("The donor had surgeries less that 6 months before donating.\n");
        if(pregnantComboBox.getSelectionModel().getSelectedItem().equals("Yes"))
            errorString = errorString.concat("The donor is pregnant, post birth or menstruating.\n");
        if(inTreatmentComboBox.getSelectionModel().getSelectedItem().equals("Yes"))
            errorString = errorString.concat("The donor is under treatment.\n");
        if(alcoholConsumtionComboBox.getSelectionModel().getSelectedItem().equals("Yes"))
            errorString = errorString.concat("The donor has consumed alcohol before donating.\n");
        if(fatConsumptionComboBox.getSelectionModel().getSelectedItem().equals("Yes"))
            errorString = errorString.concat("The donor has consumed fat before donating.\n");
        if(smokedComboBox.getSelectionModel().getSelectedItem().equals("Yes"))
            errorString = errorString.concat("The donor has smoked before donating.\n");
        if(wellSleptComboBox.getSelectionModel().getSelectedItem().equals("No"))
            errorString = errorString.concat("The donor hasn't slept well before donating.\n");

        if(hepatitisCheckBox.isSelected())
            diseasesString = diseasesString.concat("Hepatitis\n");
        if(tbCheckBox.isSelected())
            diseasesString = diseasesString.concat("TB\n");
        if(poxCheckBox.isSelected())
            diseasesString = diseasesString.concat("Pox\n");
        if(malariaCheckBox.isSelected())
            diseasesString = diseasesString.concat("Malaria\n");
        if(epilepsyCheckBox.isSelected())
            diseasesString = diseasesString.concat("Epilepsy\n");
        if(mentalIllnessCheckBox.isSelected())
            diseasesString = diseasesString.concat("Mental Illness\n");
        if(brucellosisCheckBox.isSelected())
            diseasesString = diseasesString.concat("Brucellosis\n");
        if(ulcerCheckBox.isSelected())
            diseasesString = diseasesString.concat("Ulcer\n");
        if(diabetesCheckBox.isSelected())
            diseasesString = diseasesString.concat("Diabetes\n");
        if(heartDiseasesCheckBox.isSelected())
            diseasesString = diseasesString.concat("Heart Diseases\n");
        if(skinDeseasesCheckBox.isSelected())
            diseasesString = diseasesString.concat("Skin Diseases\n");
        if(myopiaCheckBox.isSelected())
            diseasesString = diseasesString.concat("Myopia over (-) 6 diopters\n");
        if(cancerCheckBox.isSelected())
            diseasesString = diseasesString.concat("Cancer\n");
        if(hivCheckBox.isSelected())
            diseasesString = diseasesString.concat("HIV\n");

        if(!diseasesString.equals(""))
        {
            errorString = errorString.concat("The donor has the following diseases: \n");
            errorString = errorString.concat(diseasesString);
        }

        return errorString;
    }

    @FXML
    public void saveDonorMedicalData() throws IOException
    {
        if(!isFormCompleted())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("All the fields on the left side are required in order to continue.");
            alert.setContentText("Please fill in all the fields before continuing!");

            Optional<ButtonType> result = alert.showAndWait();
        }
        else if(!areTextBoxesValid())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("All the fields on the left side are required in order to continue.");
            alert.setContentText("Please make sure that the data has the correct format before continuing!");

            Optional<ButtonType> result = alert.showAndWait();
        }
        else if(!validateData().equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cannot send donation request.");
            alert.setContentText("The donor does not meet the requirements! REVIEW or CANCEL the request!\n\nERRORS: \n" + validateData());

            Optional<ButtonType> result = alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirm Sending Donation Request Dialog");
            alert.setHeaderText("");
            alert.setContentText("Are you sure you want to save and send this donation request?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK)
            {
                // user pressed OK button

                // current donation request
                DonationRequest currentDonationRequest = donationAppointment.getDonationRequest();

                // combo boxes
                currentDonationRequest
                        .setHadSurgeryRecently(!surgeriesComboBox.getSelectionModel().getSelectedItem().equals("No"));
                currentDonationRequest
                        .setUnderTreatment(!inTreatmentComboBox.getSelectionModel().getSelectedItem().equals("No"));
                currentDonationRequest
                        .setHasConsumedAlcoholRecently(!alcoholConsumtionComboBox.getSelectionModel().getSelectedItem().equals("No"));
                currentDonationRequest
                        .setHasConsumedFatRecently(!fatConsumptionComboBox.getSelectionModel().getSelectedItem().equals("No"));
                currentDonationRequest
                        .setHasSmokedRecently(!smokedComboBox.getSelectionModel().getSelectedItem().equals("No"));
                currentDonationRequest
                        .setWellSlept(wellSleptComboBox.getSelectionModel().getSelectedItem().equals("Yes"));

                // text fields
                currentDonationRequest.setAge(Integer.parseInt(ageTextField.getText()));
                currentDonationRequest.setWeight(Float.parseFloat(weightTextField.getText()));
                currentDonationRequest.setPulse(Float.parseFloat(pulseTextField.getText()));
                currentDonationRequest.setBloodPressure(Float.parseFloat(bloodPressureTextField.getText()));

                // check boxes
                currentDonationRequest.setHasHepatitis(hepatitisCheckBox.isSelected());
                currentDonationRequest.setHasTB(tbCheckBox.isSelected());
                currentDonationRequest.setHasPox(poxCheckBox.isSelected());
                currentDonationRequest.setHasMalaria(malariaCheckBox.isSelected());
                currentDonationRequest.setHasEpilepsy(epilepsyCheckBox.isSelected());
                currentDonationRequest.setHasOtherNeurologicalDisease(epilepsyCheckBox.isSelected());
                currentDonationRequest.setHasMentalIllness(mentalIllnessCheckBox.isSelected());
                currentDonationRequest.setHasBrucellosis(brucellosisCheckBox.isSelected());
                currentDonationRequest.setHasUlcer(ulcerCheckBox.isSelected());
                currentDonationRequest.setHasDiabetes(diabetesCheckBox.isSelected());
                currentDonationRequest.setHasHeartDisease(heartDiseasesCheckBox.isSelected());
                currentDonationRequest.setHasVitiligo(skinDeseasesCheckBox.isSelected());
                currentDonationRequest.setHasPsoriasis(skinDeseasesCheckBox.isSelected());
                currentDonationRequest.setHasMyopiaOverOrUnder6(myopiaCheckBox.isSelected());
                currentDonationRequest.setHasCancer(cancerCheckBox.isSelected());
                currentDonationRequest.setHasHIV(hivCheckBox.isSelected());

                // text area
                currentDonationRequest.setOtherInformation(otherInformationTextArea.getText());

                // actually update the values in the repo and database
                donationRequestRepository.update(currentDonationRequest);

                // send request to doctor for validation
                currentDonationRequest.setValidatedByPersonnel(true);
                currentDonationRequest.setInTesting(false);
                donationRequestRepository.update(currentDonationRequest);

                // create a donation with the status PENDING
//
//                Donation newDonation = new Donation();
//                Blood donatedBlood = new Blood();
//
////                donatedBlood.setQuantity(0.3);
////                donatedBlood.setBloodGroup(cdr.getDonor().getBloodGroup());  // PROBLEM
//                List<BloodGroup> bloodGroupList = bloodGroupRepository.getAll();
//
//                donatedBlood.setExpirationDate(computeExpirationDate(donationAppointment.getAppointmentDate()));
//
//                newDonation.setDonor(cdr.getDonor());
//                newDonation.setDonationDate(donationAppointment.getAppointmentDate());
//                newDonation.setStatus(Status.PENDING);
////                newDonation.setPatient(cdr.getPatient());
//                newDonation.setDonationRequest(cdr);
//                newDonation.setClinic(donationAppointment.getClinic());
//                newDonation.setBloodContainerJourneyStatus(JourneyStatus.SAMPLING);
//
//                // cancer
//                newDonation.setDonatedBlood(donatedBlood);
//                donatedBlood.setDonation(newDonation);
//
//                // more cancer
//                bloodRepository.add(donatedBlood);
//                donationRepository.add(newDonation);


                // change to Personnel Main Window
                goToPersonnelMainWindow();
            }
        }
    }

    @FXML
    public void cancelRequest() throws IOException
    {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirm Donation Request Cancel Dialog");
        alert.setHeaderText("");
        alert.setContentText("Are you sure you want to cancel this donation request?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK)
        {
            // user pressed OK button

            // current donation request
            DonationRequest cdr = donationAppointment.getDonationRequest();
            cdr.setValidatedByPersonnel(false);
            donationRequestRepository.update(cdr);

//            // create a donation with the status REJECTED
//            Blood donatedBlood = new Blood();
////                donatedBlood.setQuantity(0.3);
//            donatedBlood.setBloodGroup(cdr.getDonor().getBloodGroup());
//            donatedBlood.setExpirationDate(computeExpirationDate(donationAppointment.getAppointmentDate()));
//
//            Donation newDonation = new Donation();
//            newDonation.setDonor(cdr.getDonor());
//            newDonation.setDonationDate(donationAppointment.getAppointmentDate());
//            newDonation.setStatus(Status.REJECTED);
////                newDonation.setPatient(cdr.getPatient());
//            newDonation.setDonationRequest(cdr);
//            newDonation.setClinic(donationAppointment.getClinic());
//            newDonation.setBloodContainerJourneyStatus(JourneyStatus.SAMPLING);
//
//            // cancer
//            newDonation.setDonatedBlood(donatedBlood);
//            donatedBlood.setDonation(newDonation);
//
//            // actually adding the donation in the repository
//            donationRepository.add(newDonation);

            // change to Personnel Main Window
            goToPersonnelMainWindow();
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
