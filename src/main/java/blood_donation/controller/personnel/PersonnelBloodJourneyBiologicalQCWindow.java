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

public class PersonnelBloodJourneyBiologicalQCWindow implements Initializable
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

    @FXML
    private CheckBox immunoHematologyTestsCheckbox;
    @FXML
    private CheckBox hepatitisCheckbox;
    @FXML
    private CheckBox malariaCheckbox;
    @FXML
    private CheckBox hivCheckbox;
    @FXML
    private CheckBox otherDiseasesCheckbox;

    @FXML
    private Button proceedButton;


    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Personnel getCurrentPersonnel()
    {
        return currentPersonnel;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setCurrentPersonnel(Personnel currentPersonnel)
    {
        this.currentPersonnel = currentPersonnel;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Donation getCurrentDonation()
    {
        return currentDonation;
    }

    public PersonnelBloodJourneyBiologicalQCWindow setCurrentDonation(Donation currentDonation)
    {
        this.currentDonation = currentDonation;
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
        );

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Personnel main menu");
    }

    @FXML
    public void proceedToRedistributionStage() throws IOException
    {
        if(immunoHematologyTestsCheckbox.isSelected() && !hepatitisCheckbox.isSelected() && !hivCheckbox.isSelected() &&
                !malariaCheckbox.isSelected() && !otherDiseasesCheckbox.isSelected())
        {
            currentDonation.getDonationRequest().setPassedImmunoHematologyTest(true);
            currentDonation.getDonationRequest().setHasHIV(false);
            currentDonation.getDonationRequest().setHasHepatitis(false);
            currentDonation.getDonationRequest().setHasMalaria(false);

            // proceed to the next stage
            currentDonation.setBloodContainerJourneyStatus(JourneyStatus.REDISTRIBUTION);

            donationRequestRepository.update(currentDonation.getDonationRequest());
            donationRepository.update(currentDonation);
        }
        else
        {
            currentDonation.getDonationRequest().setPassedImmunoHematologyTest(immunoHematologyTestsCheckbox.isSelected());
            currentDonation.getDonationRequest().setHasHIV(hivCheckbox.isSelected());
            currentDonation.getDonationRequest().setHasHepatitis(hepatitisCheckbox.isSelected());
            currentDonation.getDonationRequest().setHasMalaria(malariaCheckbox.isSelected());

            if (otherDiseasesCheckbox.isSelected())
            {
                currentDonation.getDonationRequest().setHasHIV(true);
                currentDonation.getDonationRequest().setHasHepatitis(true);
                currentDonation.getDonationRequest().setHasMalaria(true);
            }

            // discard the donation and notify the donor
            currentDonation.setStatus(Status.REJECTED);

            donationRequestRepository.update(currentDonation.getDonationRequest());
            donationRepository.update(currentDonation);
        }

        // go back to main window
        goToPersonnelMainWindow();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
