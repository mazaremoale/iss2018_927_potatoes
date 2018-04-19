package blood_donation.controller.misc;

import blood_donation.controller.admin.AdminOperationSelectionWindowController;
import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.Plasma;
import blood_donation.domain.blood.Platelet;
import blood_donation.domain.blood.RedBloodCell;
import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import blood_donation.domain.people.Personnel;
import blood_donation.domain.utils.*;
import blood_donation.repository.Repository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public final class LoginWindowController implements Initializable
{
    private String adminUsername = "root";
    private String adminPassword = "cartofi3";

    private Stage primaryStage;
    private Session session;
    private String userType;
    private Scene previousScene;

    private Repository<Blood> bloodRepository;
    private Repository<Plasma> plasmaRepository;
    private Repository<RedBloodCell> redBloodCellRepository;
    private Repository<Platelet> plateletRepository;
    private Repository<Donor> donorRepository;
    private Repository<Doctor> doctorRepository;
    private Repository<Patient> patientRepository;
    private Repository<Personnel> personnelRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Donation> donationRepository;
    private Repository<DonationRequest> donationRequestRepository;
    private Repository<Hospital> hospitalRepository;
    private Repository<Location> locationRepository;
    private Repository<BloodRequest> requestRepository;


    @FXML
    private TextField usernameTextField;

    @FXML
    private TextField passwordField;

    public LoginWindowController()
    {

    }

    public LoginWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public LoginWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public LoginWindowController setPlasmaRepository(Repository<Plasma> plasmaRepository)
    {
        this.plasmaRepository = plasmaRepository;
        return this;
    }

    public LoginWindowController setRedBloodCellRepository(Repository<RedBloodCell> redBloodCellRepository)
    {
        this.redBloodCellRepository = redBloodCellRepository;
        return this;
    }

    public LoginWindowController setPlateletRepository(Repository<Platelet> plateletRepository)
    {
        this.plateletRepository = plateletRepository;
        return this;
    }

    public LoginWindowController setDonorRepository(Repository<Donor> donorRepository)
    {
        this.donorRepository = donorRepository;
        return this;
    }

    public LoginWindowController setDoctorRepository(Repository<Doctor> doctorRepository)
    {
        this.doctorRepository = doctorRepository;
        return this;
    }

    public LoginWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public LoginWindowController setPersonnelRepository(Repository<Personnel> personnelRepository)
    {
        this.personnelRepository = personnelRepository;
        return this;
    }

    public LoginWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public LoginWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public LoginWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public LoginWindowController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    public LoginWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public LoginWindowController setRequestRepository(Repository<BloodRequest> requestRepository)
    {
        this.requestRepository = requestRepository;
        return this;
    }

    public LoginWindowController setUsernameTextField(TextField usernameTextField)
    {
        this.usernameTextField = usernameTextField;
        return this;
    }

    public LoginWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public LoginWindowController setUserType(String userType)
    {
        this.userType = userType;
        return this;
    }

    public LoginWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    LoginWindowController(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }


    public void login() throws IOException
    {

        switch (userType)
        {
            case "admin":
            {
                loginAdmin();
                break;
            }
            case "doctor":
            {
                loginDoctor();
                break;
            }
            case "donor":
            {
                loginDonor();
                break;
            }
            default:
                System.out.println("Bad type");
                break;


        }

    }

    private void loginDonor()
    {
    }

    private void loginDoctor()
    {
    }

    private void loginAdmin() throws IOException
    {
        if (usernameTextField.getText().equals(adminUsername) &&
                passwordField.getText().equals(adminPassword))
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/adminOperationSelectionWindow.fxml"));

            loader.setController(new AdminOperationSelectionWindowController()
                    .setPrimaryStage(primaryStage)
                    .setSession(session)
                    .setDoctorRepository(doctorRepository)
                    .setPersonnelRepository(personnelRepository)
                    .setClinicRepository(clinicRepository)
                    .setHospitalRepository(hospitalRepository));

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Admin");
        }
        else
            throw new IOException("Invalid password");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
