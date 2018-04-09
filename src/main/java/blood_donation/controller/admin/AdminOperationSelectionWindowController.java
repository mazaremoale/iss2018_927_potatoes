package blood_donation.controller.admin;

import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Personnel;
import blood_donation.domain.utils.Clinic;
import blood_donation.domain.utils.Hospital;
import blood_donation.repository.Repository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminOperationSelectionWindowController implements Initializable
{
    private Session session;

    private Stage primaryStage;

    private Repository<Hospital> hospitalRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Doctor> doctorRepository;
    private Repository<Personnel> personnelRepository;

    @FXML
    private Button doctorButton;

    @FXML
    private Button donorButton;

    @FXML
    private Button personnelButton;



    public AdminOperationSelectionWindowController()
    {

    }

    public AdminOperationSelectionWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public AdminOperationSelectionWindowController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    public AdminOperationSelectionWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public AdminOperationSelectionWindowController setDoctorRepository(Repository<Doctor> doctorRepository)
    {
        this.doctorRepository = doctorRepository;
        return this;
    }

    public AdminOperationSelectionWindowController setPersonnelRepository(Repository<Personnel> personnelRepository)
    {
        this.personnelRepository = personnelRepository;
        return this;
    }

    public AdminOperationSelectionWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }


    @FXML
    public void doctorButtonOnClick()
    {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {


    }
}
