package blood_donation.controller.misc;

import blood_donation.controller.donor.DonorRegistrationWindowController;
import blood_donation.domain.blood.*;
import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import blood_donation.domain.people.Personnel;
import blood_donation.domain.utils.*;
import blood_donation.repository.Repository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public final class UserSelectWindowController implements Initializable
{
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
    private Repository<BloodGroup> bloodGroupRepository;
    private Repository<Distance> distanceRepository;
    private Repository<DonationAppointment> donationAppointmentRepository;


    private Stage primaryStage;
    private Session session;

    @FXML
    private Button donorLoginButton;

    @FXML
    private Button donorRegisterButton;

    public UserSelectWindowController()
    {

    }


    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public UserSelectWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<Plasma> getPlasmaRepository()
    {
        return plasmaRepository;
    }

    public UserSelectWindowController setPlasmaRepository(Repository<Plasma> plasmaRepository)
    {
        this.plasmaRepository = plasmaRepository;
        return this;
    }

    public Repository<RedBloodCell> getRedBloodCellRepository()
    {
        return redBloodCellRepository;
    }

    public UserSelectWindowController setRedBloodCellRepository(Repository<RedBloodCell> redBloodCellRepository)
    {
        this.redBloodCellRepository = redBloodCellRepository;
        return this;
    }

    public Repository<Platelet> getPlateletRepository()
    {
        return plateletRepository;
    }

    public UserSelectWindowController setPlateletRepository(Repository<Platelet> plateletRepository)
    {
        this.plateletRepository = plateletRepository;
        return this;
    }

    public Repository<Donor> getDonorRepository()
    {
        return donorRepository;
    }

    public UserSelectWindowController setDonorRepository(Repository<Donor> donorRepository)
    {
        this.donorRepository = donorRepository;
        return this;
    }

    public Repository<Doctor> getDoctorRepository()
    {
        return doctorRepository;
    }

    public UserSelectWindowController setDoctorRepository(Repository<Doctor> doctorRepository)
    {
        this.doctorRepository = doctorRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public UserSelectWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<Personnel> getPersonnelRepository()
    {
        return personnelRepository;
    }

    public UserSelectWindowController setPersonnelRepository(Repository<Personnel> personnelRepository)
    {
        this.personnelRepository = personnelRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public UserSelectWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public UserSelectWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public UserSelectWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Hospital> getHospitalRepository()
    {
        return hospitalRepository;
    }

    public UserSelectWindowController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public UserSelectWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Repository<BloodRequest> getRequestRepository()
    {
        return requestRepository;
    }

    public UserSelectWindowController setRequestRepository(Repository<BloodRequest> requestRepository)
    {
        this.requestRepository = requestRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public UserSelectWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public UserSelectWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public UserSelectWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public UserSelectWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public UserSelectWindowController setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
        return this;
    }

    @FXML
    public void exit()
    {
        System.exit(0);
    }

    @FXML
    public void showDonorOptions()
    {
        donorLoginButton.setVisible(true);
        donorRegisterButton.setVisible(true);
    }

    @FXML
    public void openDonorRegistration() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/donor/donorRegistrationWindow.fxml"));
        loader.setController(new DonorRegistrationWindowController()
                .setPreviousScene(primaryStage.getScene())
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setLocationRepository(locationRepository)
                .setDonorRepository(donorRepository)
                .setDonationRepository(donationRepository)
                .setClinicRepository(clinicRepository)
                .setDistanceRepository(distanceRepository)
                .setPatientRepository(patientRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setDonationAppointmentRepository(donationAppointmentRepository));


        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Donor registration");
    }

    @FXML
    public void openDonorLogin() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/misc/loginWindow.fxml"));
        loader.setController(new LoginWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setUserType("donor")
                .setBloodRepository(bloodRepository)
                .setPlasmaRepository(plasmaRepository)
                .setRedBloodCellRepository(redBloodCellRepository)
                .setPlateletRepository(plateletRepository)
                .setDonorRepository(donorRepository)
                .setDoctorRepository(doctorRepository)
                .setPatientRepository(patientRepository)
                .setPersonnelRepository(personnelRepository)
                .setClinicRepository(clinicRepository)
                .setDonationRepository(donationRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setHospitalRepository(hospitalRepository)
                .setLocationRepository(locationRepository)
                .setRequestRepository(requestRepository)
                .setBloodGroupRepository(bloodGroupRepository)
                .setPreviousScene(primaryStage.getScene())
                .setDistanceRepository(distanceRepository)
                .setDonationAppointmentRepository(donationAppointmentRepository));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Login");
    }

    public void openDoctorLogin() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/misc/loginWindow.fxml"));
        loader.setController(new LoginWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setUserType("doctor")
                .setBloodRepository(bloodRepository)
                .setPlasmaRepository(plasmaRepository)
                .setRedBloodCellRepository(redBloodCellRepository)
                .setPlateletRepository(plateletRepository)
                .setDonorRepository(donorRepository)
                .setDoctorRepository(doctorRepository)
                .setPatientRepository(patientRepository)
                .setPersonnelRepository(personnelRepository)
                .setClinicRepository(clinicRepository)
                .setDonationRepository(donationRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setHospitalRepository(hospitalRepository)
                .setLocationRepository(locationRepository)
                .setRequestRepository(requestRepository)
                .setDistanceRepository(distanceRepository)
                .setBloodGroupRepository(bloodGroupRepository)
                .setPreviousScene(primaryStage.getScene()));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Login");

    }

    @FXML
    public void openPersonnelLogin() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/misc/loginWindow.fxml"));
        loader.setController(new LoginWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setUserType("personnel")
                .setBloodRepository(bloodRepository)
                .setPlasmaRepository(plasmaRepository)
                .setRedBloodCellRepository(redBloodCellRepository)
                .setPlateletRepository(plateletRepository)
                .setDonorRepository(donorRepository)
                .setDoctorRepository(doctorRepository)
                .setPatientRepository(patientRepository)
                .setPersonnelRepository(personnelRepository)
                .setClinicRepository(clinicRepository)
                .setDonationRepository(donationRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setHospitalRepository(hospitalRepository)
                .setLocationRepository(locationRepository)
                .setRequestRepository(requestRepository)
                .setDistanceRepository(distanceRepository)
                .setPreviousScene(primaryStage.getScene())
                .setDonationAppointmentRepository(donationAppointmentRepository));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Login");

    }

    public void openAdminLogin() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/misc/loginWindow.fxml"));
        loader.setController(new LoginWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setUserType("admin")
                .setBloodRepository(bloodRepository)
                .setPlasmaRepository(plasmaRepository)
                .setRedBloodCellRepository(redBloodCellRepository)
                .setPlateletRepository(plateletRepository)
                .setDonorRepository(donorRepository)
                .setDoctorRepository(doctorRepository)
                .setPatientRepository(patientRepository)
                .setPersonnelRepository(personnelRepository)
                .setClinicRepository(clinicRepository)
                .setDonationRepository(donationRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setHospitalRepository(hospitalRepository)
                .setLocationRepository(locationRepository)
                .setRequestRepository(requestRepository)
                .setDistanceRepository(distanceRepository)
                .setPreviousScene(primaryStage.getScene()));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Login");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        donorLoginButton.setVisible(false);
        donorRegisterButton.setVisible(false);

        primaryStage.setOnCloseRequest(p->
        {
            Platform.exit();
            System.exit(0);
        });
    }
}
