package blood_donation.controller.admin;

import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Personnel;
import blood_donation.domain.utils.Clinic;
import blood_donation.domain.utils.Hospital;
import blood_donation.domain.utils.Location;
import blood_donation.repository.Repository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public final class AdminOperationSelectionWindowController implements Initializable
{
    private Session session;

    private Stage primaryStage;
    private Scene previousScene;

    private Repository<Hospital> hospitalRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Doctor> doctorRepository;
    private Repository<Personnel> personnelRepository;
    private Repository<Location> locationRepository;


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

    public AdminOperationSelectionWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
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

    public AdminOperationSelectionWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    public void chooseHospital()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/admin/adminHospitalWindow.fxml"));

            loader.setController(new AdminHospitalWindowController()
                    .setPrimaryStage(primaryStage)
                    .setPreviousScene(primaryStage.getScene())
                    .setSession(session)
                    .setHospitalRepository(hospitalRepository)
                    .setLocationRepository(locationRepository));

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Hospital management");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void chooseDoctor()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/admin/adminDoctorWindow.fxml"));

            loader.setController(new AdminDoctorWindowController()
                    .setPrimaryStage(primaryStage)
                    .setSession(session)
                    .setDoctorRepository(doctorRepository)
                    .setHospitalRepository(hospitalRepository)
                    .setPreviousScene(primaryStage.getScene()));

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Doctor management");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void choosePersonnel()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/admin/adminPersonnelWindow.fxml"));

            loader.setController(new AdminPersonnelWindowController()
                    .setPrimaryStage(primaryStage)
                    .setSession(session)
                    .setPersonnelRepository(personnelRepository)
                    .setClinicRepository(clinicRepository)
                    .setPreviousScene(primaryStage.getScene()));

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Personnel management");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    @FXML
    public void chooseClinic()
    {
        try
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/admin/adminClinicWindow.fxml"));

            loader.setController(new AdminClinicWindowController()
                    .setPrimaryStage(primaryStage)
                    .setPreviousScene(primaryStage.getScene())
                    .setSession(session)
                    .setClinicRepository(clinicRepository)
                    .setLocationRepository(locationRepository));

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Clinic management");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {


    }
}
