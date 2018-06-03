package blood_donation.controller.donor;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import blood_donation.domain.utils.*;
import blood_donation.repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.hibernate.Session;

import java.net.URL;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class DonorDonationScheduleWindowController implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Donor currentDonor;
    private Repository<Donation> donationRepository;
    private Repository<DonationRequest> donationRequestRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Blood> bloodRepository;
    private Repository<BloodGroup> bloodGroupRepository;
    private Repository<Distance> distanceRepository;
    private Repository<Patient> patientRepository;

    @FXML
    private Scene donorMainScene;

    @FXML
    private Label dateLabel;

    @FXML
    private DatePicker donationDatePicker;

    @FXML
    private ComboBox<Clinic> clinicComboBox;

    @FXML
    private ComboBox<Integer> timeComboBox;

    @FXML
    private CheckBox targettedDonationCheckBox;

    @FXML
    private Label whoLabel;

    @FXML
    private ComboBox<Patient> patientComboBox;

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DonorDonationScheduleWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DonorDonationScheduleWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DonorDonationScheduleWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Donor getCurrentDonor()
    {
        return currentDonor;
    }

    public DonorDonationScheduleWindowController setCurrentDonor(Donor currentDonor)
    {
        this.currentDonor = currentDonor;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public DonorDonationScheduleWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public DonorDonationScheduleWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public DonorDonationScheduleWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public DonorDonationScheduleWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public DonorDonationScheduleWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public DonorDonationScheduleWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Scene getDonorMainScene()
    {
        return donorMainScene;
    }

    public DonorDonationScheduleWindowController setDonorMainScene(Scene donorMainScene)
    {
        this.donorMainScene = donorMainScene;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public DonorDonationScheduleWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    @FXML
    private void initializeDatePickerFormat()
    {
        donationDatePicker.setConverter(new StringConverter<LocalDate>()
        {
            String pattern = "dd-MM-yyyy";
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date)
            {
                if (date != null)
                {
                    return dateFormatter.format(date);
                }
                else
                {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string)
            {
                if (string != null && !string.isEmpty())
                {
                    return LocalDate.parse(string, dateFormatter);
                }
                else
                {
                    return null;
                }
            }
        });
    }

    @FXML
    private void initializeDateRestrictions(Donation lastDonation)
    {
        donationDatePicker.setDayCellFactory(picker -> new DateCell()
        {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);

                LocalDate nextPossibleDonationDate;
                LocalDate rightNow = LocalDate.now();

                if(lastDonation != null)
                {
                    LocalDate lastDonationDate = lastDonation.getDonationDate();
                    if(rightNow.compareTo(lastDonationDate.plusWeeks(2)) > 0)
                    {
                        nextPossibleDonationDate = rightNow;
                    }
                    else
                    {
                        nextPossibleDonationDate = lastDonationDate.plusWeeks(2);
                    }
                }
                else
                {
                    nextPossibleDonationDate = rightNow;
                }

                setDisable(empty ||
                        date.compareTo(nextPossibleDonationDate) < 0 ||
                        date.getDayOfWeek() == DayOfWeek.SUNDAY ||
                        date.getDayOfWeek() == DayOfWeek.SATURDAY);
            }
        });
    }

    @FXML
    private void initializeClinics()
    {
        List<Clinic> clinics = clinicRepository.getAll();

        List<Integer> distances = new ArrayList<>();

        Location currentLocation = currentDonor.getResidenceCounty();

        List<Location> locationsList = distanceRepository.getAll().stream()
                .filter(distance -> distance.getLocation1() == currentLocation)
                .sorted(Comparator.comparing(Distance::getDistance))
                .map(Distance::getLocation2)
                .collect(Collectors.toList());

        for(Location loc : locationsList)
        {
            for(Clinic clinic : clinics)
                if(clinic.getLocation() == loc)
                {
                    clinicComboBox.getItems().add(clinic);
                }
        }
    }

    @FXML
    private void initializeTimes()
    {
        ObservableList<Integer> observableTimes = FXCollections.observableArrayList();
        for(int i=8; i<= 16; i++)
            observableTimes.add(i);

        timeComboBox.setItems(observableTimes);
    }

    @FXML
    private void initializeTargettedDonation()
    {
        whoLabel.setVisible(false);
        patientComboBox.setVisible(false);

        patientComboBox.setItems(FXCollections.observableArrayList(patientRepository.getAll()));

        targettedDonationCheckBox.selectedProperty().addListener((observable, oldValue, newValue) ->
        {
            whoLabel.setVisible(newValue);
            patientComboBox.setVisible(newValue);
        });
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    public void submitAppointment()
    {
        Optional<ButtonType> result;

        if(donationDatePicker.getValue() != null &&
                !clinicComboBox.getSelectionModel().isEmpty() &&
                !timeComboBox.getSelectionModel().isEmpty())
        {

            if(!targettedDonationCheckBox.isSelected() || !patientComboBox.getSelectionModel().isEmpty())
            {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation");
                alert.setHeaderText("You are about to book an appointment on " +
                        donationDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) +
                        " at " + timeComboBox.getSelectionModel().getSelectedItem() + " o'clock" +
                        " at " + clinicComboBox.getSelectionModel().getSelectedItem());
                alert.setContentText("Are you sure about this?");

                result = alert.showAndWait();

                if (result.get() == ButtonType.OK)
                {
                    Alert successAlert = new Alert(Alert.AlertType.INFORMATION);
                    successAlert.setTitle("Success");
                    successAlert.setHeaderText("Appointment scheduled");
                    successAlert.setContentText("Press OK to continue");
                    successAlert.showAndWait();

                    primaryStage.setScene(donorMainScene);
                }
            }
            else if(targettedDonationCheckBox.isSelected())
            {
                Alert badTargettedDonationInputAlert = new Alert(Alert.AlertType.ERROR);
                badTargettedDonationInputAlert.setTitle("Error");
                badTargettedDonationInputAlert.setHeaderText("In order to continue with donating to someone in particular, select the name of the patient");
                badTargettedDonationInputAlert.setContentText("Please try again");

                badTargettedDonationInputAlert.showAndWait();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("In order to continue, all fields must be filled");
            alert.setContentText("Please fill in all the fields and try again");

            alert.showAndWait();
        }
    }



    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        Donation lastDonation = currentDonor.getLatestDonation(donationRepository);
        initializeDatePickerFormat();
        initializeDateRestrictions(lastDonation);
        initializeClinics();
        initializeTimes();
        initializeTargettedDonation();

    }

}
