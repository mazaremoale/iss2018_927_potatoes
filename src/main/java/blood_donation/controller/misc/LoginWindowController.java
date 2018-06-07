package blood_donation.controller.misc;

import blood_donation.controller.admin.AdminOperationSelectionWindowController;
import blood_donation.controller.doctor.DoctorMainWindowController;
import blood_donation.controller.donor.DonorMainWindowController;
import blood_donation.controller.personnel.PersonnelMainWindowController;
import blood_donation.domain.blood.*;
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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


public final class LoginWindowController implements Initializable
{
    private final String adminUsername = "root";
    private final String adminPassword = "cartofi3";

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
    private Repository<BloodRequest> bloodRequestRepository;
    private Repository<BloodGroup> bloodGroupRepository;
    private Repository<Distance> distanceRepository;
    private Repository<DonationAppointment> donationAppointmentRepository;

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
        this.bloodRequestRepository = requestRepository;
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

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public LoginWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public LoginWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public LoginWindowController setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
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
        primaryStage.setTitle("User selection");
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
            case "personnel":
            {
                loginPersonnel();
                break;
            }
            default:
                System.out.println("Bad type, m8");
                break;


        }

    }

    private void loginDonor() throws IOException
    {
        Map<String,String> donorCredentials;
        donorCredentials = donorRepository.getAll().stream().collect(Collectors.toMap(Donor::getUsername, Donor::getPassword));

        if(usernameTextField.getText().length() > 0 && passwordField.getText().length() > 0)
        {
            if (donorCredentials.containsKey(usernameTextField.getText()))
            {
                if (donorCredentials.get(usernameTextField.getText()).equals(passwordField.getText()))
                {
                    Donor currentDonor = null;
                    for(Donor donor : donorRepository.getAll())
                    {
                        if(donor.getUsername().equals(usernameTextField.getText()))
                        {
                            currentDonor = donor;
                            break;
                        }

                    }
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/donor/donorMainWindow.fxml"));


                    loader.setController(new DonorMainWindowController()
                            .setPrimaryStage(primaryStage)
                            .setSession(session)
                            .setPreviousScene(primaryStage.getScene())
                            .setCurrentDonor(currentDonor)
                            .setDonationRepository(donationRepository)
                            .setDonationRequestRepository(donationRequestRepository)
                            .setClinicRepository(clinicRepository)
                            .setBloodRepository(bloodRepository)
                            .setBloodGroupRepository(bloodGroupRepository)
                            .setDistanceRepository(distanceRepository)
                            .setPatientRepository(patientRepository)
                            .setDonationAppointmentRepository(donationAppointmentRepository)
                            .setLocationRepository(locationRepository)
                            .setHospitalRepository(hospitalRepository));

                    Parent content = loader.load();

                    Scene selectScene = new Scene(content);
                    primaryStage.setScene(selectScene);
                    primaryStage.setTitle("Donor main menu");
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid password");
                    alert.setContentText("Please try again");

                    Optional<ButtonType> result = alert.showAndWait();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username");
                alert.setContentText("Please try again");

                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("All the fields must be filled");
            alert.setContentText("Please fill in all the fields");

            Optional<ButtonType> result = alert.showAndWait();
        }

    }

    private void loginDoctor() throws IOException
    {
        Map<String,String> doctorCredentials;
        doctorCredentials = doctorRepository.getAll().stream().collect(Collectors.toMap(Doctor::getUsername, Doctor::getPassword));

        if(usernameTextField.getText().length() > 0 && passwordField.getText().length() > 0)
        {
            if (doctorCredentials.containsKey(usernameTextField.getText()))
            {
                if (doctorCredentials.get(usernameTextField.getText()).equals(passwordField.getText()))
                {
                    Doctor currentDoctor = null;
                    for(Doctor doctor : doctorRepository.getAll())
                    {
                        if(doctor.getUsername().equals(usernameTextField.getText()))
                        {
                            currentDoctor = doctor;
                            break;
                        }

                    }
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("/fxml/doctor/doctorMainWindow.fxml"));


                    loader.setController(new DoctorMainWindowController()
                            .setPrimaryStage(primaryStage)
                            .setSession(session)
                            .setPreviousScene(primaryStage.getScene())
                            .setCurrentDonor(currentDoctor)
                            .setDonationRequestRepository(donationRequestRepository)
                            .setLocationRepository(locationRepository)
                            .setDonationRepository(donationRepository)
                            .setBloodRepository(bloodRepository)
                            .setHospitalRepository(hospitalRepository)
                            .setPatientRepository(patientRepository)
                            .setBloodRequestRepository(bloodRequestRepository)
                            .setBloodGroupRepository(bloodGroupRepository));

                    Parent content = loader.load();

                    Scene selectScene = new Scene(content);
                    primaryStage.setScene(selectScene);
                    primaryStage.setTitle("Doctor main menu");
                }
                else
                {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error");
                    alert.setHeaderText("Invalid password");
                    alert.setContentText("Please try again");

                    Optional<ButtonType> result = alert.showAndWait();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username");
                alert.setContentText("Please try again");

                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("All the fields must be filled");
            alert.setContentText("Please fill in all the fields");

            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    private void loginPersonnel() throws IOException
    {
        Map<String,String> personnelCredentials;
        personnelCredentials = personnelRepository.getAll().stream().collect(Collectors.toMap(Personnel::getUsername, Personnel::getPassword));

        if(usernameTextField.getText().length() > 0 && passwordField.getText().length() > 0)
        {
            if (personnelCredentials.containsKey(usernameTextField.getText()))
            {
                if (personnelCredentials.get(usernameTextField.getText()).equals(passwordField.getText()))
                {
                    Personnel currentPersonnel = null;
                    for(Personnel personnel : personnelRepository.getAll())
                    {
                        if(personnel.getUsername().equals(usernameTextField.getText()))
                        {
                            currentPersonnel = personnel;
                            break;
                        }

                    }
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
                            .setLocationRepository(locationRepository)
//                            .setPlasmaRepository(plasmaRepository)
//                            .setRedBloodCellRepository(redBloodCellRepository)
//                            .setPlateletRepository(plateletRepository)
//                            .setDonorRepository(donorRepository)
//                            .setDoctorRepository(doctorRepository)
//                            .setPersonnelRepository(personnelRepository)
//                            .setHospitalRepository(hospitalRepository)
//                            .setLocationRepository(locationRepository)
//                            .setRequestRepository(bloodRequestRepository)
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
                    alert.setHeaderText("Invalid password");
                    alert.setContentText("Please try again");

                    Optional<ButtonType> result = alert.showAndWait();
                }
            }
            else
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("Invalid username");
                alert.setContentText("Please try again");

                Optional<ButtonType> result = alert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("All the fields must be filled");
            alert.setContentText("Please fill in all the fields");

            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    private void loginAdmin() throws IOException
    {
        if (usernameTextField.getText().equals(adminUsername) &&
                passwordField.getText().equals(adminPassword))
        {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/fxml/admin/adminOperationSelectionWindow.fxml"));

            loader.setController(new AdminOperationSelectionWindowController()
                    .setPrimaryStage(primaryStage)
                    .setSession(session)
                    .setDoctorRepository(doctorRepository)
                    .setPersonnelRepository(personnelRepository)
                    .setClinicRepository(clinicRepository)
                    .setHospitalRepository(hospitalRepository)
                    .setLocationRepository(locationRepository)
                    .setPreviousScene(primaryStage.getScene()));

            Parent content = loader.load();

            Scene selectScene = new Scene(content);
            primaryStage.setScene(selectScene);
            primaryStage.setTitle("Admin management panel");
        }
        else if(!usernameTextField.getText().equals(adminUsername))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid admin username");
            alert.setContentText("Please try again");

            Optional<ButtonType> result = alert.showAndWait();
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Invalid admin password");
            alert.setContentText("Please try again");

            Optional<ButtonType> result = alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {

    }
}
