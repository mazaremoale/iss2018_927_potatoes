package blood_donation.controller.misc;

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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class UserSelectController implements Initializable
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


    private Stage primaryStage;
    private Session session;

    public UserSelectController()
    {

    }


    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public UserSelectController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<Plasma> getPlasmaRepository()
    {
        return plasmaRepository;
    }

    public UserSelectController setPlasmaRepository(Repository<Plasma> plasmaRepository)
    {
        this.plasmaRepository = plasmaRepository;
        return this;
    }

    public Repository<RedBloodCell> getRedBloodCellRepository()
    {
        return redBloodCellRepository;
    }

    public UserSelectController setRedBloodCellRepository(Repository<RedBloodCell> redBloodCellRepository)
    {
        this.redBloodCellRepository = redBloodCellRepository;
        return this;
    }

    public Repository<Platelet> getPlateletRepository()
    {
        return plateletRepository;
    }

    public UserSelectController setPlateletRepository(Repository<Platelet> plateletRepository)
    {
        this.plateletRepository = plateletRepository;
        return this;
    }

    public Repository<Donor> getDonorRepository()
    {
        return donorRepository;
    }

    public UserSelectController setDonorRepository(Repository<Donor> donorRepository)
    {
        this.donorRepository = donorRepository;
        return this;
    }

    public Repository<Doctor> getDoctorRepository()
    {
        return doctorRepository;
    }

    public UserSelectController setDoctorRepository(Repository<Doctor> doctorRepository)
    {
        this.doctorRepository = doctorRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public UserSelectController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<Personnel> getPersonnelRepository()
    {
        return personnelRepository;
    }

    public UserSelectController setPersonnelRepository(Repository<Personnel> personnelRepository)
    {
        this.personnelRepository = personnelRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public UserSelectController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public UserSelectController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public UserSelectController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Hospital> getHospitalRepository()
    {
        return hospitalRepository;
    }

    public UserSelectController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public UserSelectController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Repository<BloodRequest> getRequestRepository()
    {
        return requestRepository;
    }

    public UserSelectController setRequestRepository(Repository<BloodRequest> requestRepository)
    {
        this.requestRepository = requestRepository;
        return this;
    }

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public UserSelectController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public UserSelectController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public void exit()
    {
        System.out.println(bloodRepository);
        System.exit(0);
    }

    public void openAdminLogin() throws Exception
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/loginWindow.fxml"));
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
                .setRequestRepository(requestRepository));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Login");
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
