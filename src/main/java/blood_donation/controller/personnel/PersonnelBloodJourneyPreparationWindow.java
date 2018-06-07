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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class PersonnelBloodJourneyPreparationWindow implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Personnel currentPersonnel;
    private Donation currentDonation;

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
    private CheckBox filtrationCheckbox;
    @FXML
    private CheckBox centrifugeCheckbox;
    @FXML
    private CheckBox separateCheckbox;

    @FXML
    private Button proceedButton;


    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public PersonnelBloodJourneyPreparationWindow setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public PersonnelBloodJourneyPreparationWindow setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public PersonnelBloodJourneyPreparationWindow setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Personnel getCurrentPersonnel()
    {
        return currentPersonnel;
    }

    public PersonnelBloodJourneyPreparationWindow setCurrentPersonnel(Personnel currentPersonnel)
    {
        this.currentPersonnel = currentPersonnel;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Donation getCurrentDonation()
    {
        return currentDonation;
    }

    public PersonnelBloodJourneyPreparationWindow setCurrentDonation(Donation currentDonation)
    {
        this.currentDonation = currentDonation;
        return this;
    }

    public Repository<BloodRequest> getBloodRequestRepository()
    {
        return bloodRequestRepository;
    }

    public PersonnelBloodJourneyPreparationWindow setBloodRequestRepository(Repository<BloodRequest> bloodRequestRepository)
    {
        this.bloodRequestRepository = bloodRequestRepository;
        return this;
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

    @FXML
    public void proceedToBiologicalQualityControl() throws IOException
    {
        if(filtrationCheckbox.isSelected() && centrifugeCheckbox.isSelected())
        {
            if(separateCheckbox.isSelected())
            {
                currentDonation.setSplitBlood(true);
                donationRepository.update(currentDonation);
            }

            currentDonation.setBloodContainerJourneyStatus(JourneyStatus.BIOLOGICAL_QUALITY_CONTROL);
            donationRepository.update(currentDonation);

            goToPersonnelMainWindow();

        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Cannot proceed to next stage.");
            alert.setContentText("All required steps need to be completed in order to continue!");

            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
