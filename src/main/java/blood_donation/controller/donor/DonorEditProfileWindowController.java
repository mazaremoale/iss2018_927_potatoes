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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.Optional;
import java.util.ResourceBundle;

public class DonorEditProfileWindowController implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Repository<Donation> donationRepository;
    private Repository<DonationRequest> donationRequestRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Blood> bloodRepository;
    private Repository<BloodGroup> bloodGroupRepository;
    private Repository<Distance> distanceRepository;
    private Repository<Patient> patientRepository;
    private Repository<DonationAppointment> donationAppointmentRepository;
    private Repository<Location> locationRepository;
    private Repository<Donor> donorRepository;
    private Repository<BloodRequest> bloodRequestRepository;


    private Donor currentDonor;


    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private ComboBox<Integer> yearComboBox;

    @FXML
    private ComboBox<String> monthComboBox;

    @FXML
    private ComboBox<Integer> dayComboBox;

    @FXML
    private TextField idAddressTextField;

    @FXML
    private TextField idCityTextField;

    @FXML
    private ComboBox<Location> idCountyComboBox;

    @FXML
    private TextField residenceAddressTextField;

    @FXML
    private TextField residenceCityTextField;

    @FXML
    private ComboBox<Location> residenceCountyComboBox;


    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DonorEditProfileWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DonorEditProfileWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DonorEditProfileWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public DonorEditProfileWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Repository<Donor> getDonorRepository()
    {
        return donorRepository;
    }

    public DonorEditProfileWindowController setDonorRepository(Repository<Donor> donorRepository)
    {
        this.donorRepository = donorRepository;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public DonorEditProfileWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public DonorEditProfileWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public DonorEditProfileWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public DonorEditProfileWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public DonorEditProfileWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<DonationAppointment> getDonationAppointmentRepository()
    {
        return donationAppointmentRepository;
    }

    public DonorEditProfileWindowController setDonationAppointmentRepository(Repository<DonationAppointment> donationAppointmentRepository)
    {
        this.donationAppointmentRepository = donationAppointmentRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public DonorEditProfileWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public DonorEditProfileWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    public Donor getCurrentDonor()
    {
        return currentDonor;
    }

    public DonorEditProfileWindowController setCurrentDonor(Donor currentDonor)
    {
        this.currentDonor = currentDonor;
        return this;
    }

    public Repository<BloodRequest> getBloodRequestRepository()
    {
        return bloodRequestRepository;
    }

    public DonorEditProfileWindowController setBloodRequestRepository(Repository<BloodRequest> bloodRequestRepository)
    {
        this.bloodRequestRepository = bloodRequestRepository;
        return this;
    }

    @FXML
    void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    private void openDonorMainWindow() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/donor/donorMainWindow.fxml"));
        loader.setController(new DonorMainWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setPreviousScene(primaryStage.getScene())
                .setCurrentDonor(currentDonor)
                .setDonationRepository(donationRepository)
                .setClinicRepository(clinicRepository)
                .setDistanceRepository(distanceRepository)
                .setPatientRepository(patientRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setDonationAppointmentRepository(donationAppointmentRepository)
                .setLocationRepository(locationRepository)
                .setBloodRequestRepository(bloodRequestRepository));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Choose a username and password");
    }


    @FXML
    void goNext() throws IOException
    {
        if (firstNameTextField.getText().length() > 0 &&
                lastNameTextField.getText().length() > 0 &&
                !yearComboBox.getSelectionModel().isEmpty() &&
                !monthComboBox.getSelectionModel().isEmpty() &&
                idAddressTextField.getText().length() > 0 &&
                idCityTextField.getText().length() > 0 &&
                !idCountyComboBox.getSelectionModel().isEmpty())
        {
            currentDonor.setFirstName(firstNameTextField.getText());
            currentDonor.setLastName(lastNameTextField.getText());

            int year = yearComboBox.getSelectionModel().getSelectedItem();
            Month month = Month.valueOf(monthComboBox.getSelectionModel().getSelectedItem().toUpperCase());
            int day = dayComboBox.getSelectionModel().getSelectedItem();
            LocalDate localDate = LocalDate.of(year, month, day);

            currentDonor.setBirthDate(localDate);
            currentDonor.setIdAddress(idAddressTextField.getText());
            currentDonor.setIdCity(idCityTextField.getText());
            currentDonor.setIdCounty(idCountyComboBox.getSelectionModel().getSelectedItem());

            if (residenceAddressTextField.getText().length() > 0 &&
                    !residenceCountyComboBox.getSelectionModel().isEmpty() &&
                    residenceCityTextField.getText().length() > 0)
            {
                currentDonor.setResidenceAddress(residenceAddressTextField.getText());
                currentDonor.setResidenceCity(residenceCityTextField.getText());
                currentDonor.setResidenceCounty(residenceCountyComboBox.getSelectionModel().getSelectedItem());

                openDonorMainWindow();
            }

            else if (residenceAddressTextField.getText().length() > 0 ||
                    !residenceCountyComboBox.getSelectionModel().isEmpty() ||
                    residenceCityTextField.getText().length() > 0)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText("If you fill in one of the optional fields, you should fill all of them!");
                alert.setContentText("Please fill in all the 3 optional fields");

                Optional<ButtonType> result = alert.showAndWait();
            }
            else
            {
                currentDonor.setResidenceCity(idCityTextField.getText());
                currentDonor.setResidenceAddress(idAddressTextField.getText());
                currentDonor.setResidenceCounty(idCountyComboBox.getSelectionModel().getSelectedItem());
                openDonorMainWindow();
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("In order to continue, all required fields should be filled");
            alert.setContentText("Please fill in all the required fields");

            alert.showAndWait();
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        dayComboBox.setDisable(true);
        monthComboBox.setDisable(true);

        ObservableList<Integer> years = FXCollections.observableArrayList();
        for(int i = 2018; i >= 1900; i--)
            years.add(i);

        ObservableList<String> months = FXCollections.observableArrayList();
        months.addAll("January", "February", "March", "April", "May", "June",
                "July", "August", "September", "October", "November", "December");

        ObservableList<Integer> days28 = FXCollections.observableArrayList();
        for(int i=1; i<=28; i++)
            days28.add(i);

        ObservableList<Integer> days29 = FXCollections.observableArrayList(days28);
        days29.add(29);

        ObservableList<Integer> days30 = FXCollections.observableArrayList(days29);
        days30.add(30);

        ObservableList<Integer> days31 = FXCollections.observableArrayList(days30);
        days31.add(31);

        idCountyComboBox.setItems(FXCollections.observableArrayList(locationRepository.getAll()));
        residenceCountyComboBox.setItems(FXCollections.observableArrayList(locationRepository.getAll()));

        yearComboBox.setItems(years);
        monthComboBox.setItems(months);

        yearComboBox.getSelectionModel()
                .selectedItemProperty()
                .addListener(((observable, oldValue, newValue) ->
                {
                    monthComboBox.setDisable(false);
                    if(!monthComboBox.getSelectionModel().isEmpty())
                        if(monthComboBox.getSelectionModel().getSelectedItem().equals("February"))
                        {
                            if (yearComboBox.getSelectionModel().getSelectedItem() % 4 == 0)
                                dayComboBox.setItems(days29);
                            else
                                dayComboBox.setItems(days28);
                        }
                }
                ));

        monthComboBox.getSelectionModel()
                .selectedIndexProperty()
                .addListener(((observable, oldValue, newValue) ->
                {
                    dayComboBox.setDisable(false);

                    String s = monthComboBox.getSelectionModel().getSelectedItem();

                    if ("January".equals(s) || "March".equals(s) || "May".equals(s) ||
                            "July".equals(s) || "August".equals(s) || "October".equals(s) ||
                            "December".equals(s))
                    {
                        dayComboBox.setItems(days31);
                    }

                    else if ("April".equals(s) || "June".equals(s) || "September".equals(s) ||
                            "November".equals(s))
                    {
                        dayComboBox.setItems(days30);
                    }

                    else if ("February".equals(s))
                    {
                        if (yearComboBox.getSelectionModel().getSelectedItem() % 4 == 0)
                        {
                            dayComboBox.setItems(days29);
                        }

                        else
                            dayComboBox.setItems(days28);

                    }
                }));


        firstNameTextField.setText(currentDonor.getFirstName());
        lastNameTextField.setText(currentDonor.getLastName());



        int yearIndex = yearComboBox.getItems().indexOf(currentDonor.getBirthDate().getYear());
        int countyIndex = idCountyComboBox.getItems().indexOf(currentDonor.getIdCounty());


        yearComboBox.getSelectionModel().select(yearIndex);
        monthComboBox.getSelectionModel().select(currentDonor.getBirthDate().getMonthValue() - 1);
        dayComboBox.getSelectionModel().select(currentDonor.getBirthDate().getDayOfMonth() - 1);


        idAddressTextField.setText(currentDonor.getIdAddress());
        idCityTextField.setText(currentDonor.getIdCity());
        idCountyComboBox.getSelectionModel().select(countyIndex);

        if(currentDonor.getResidenceCounty() != null)
        {
            residenceAddressTextField.setText(currentDonor.getResidenceAddress());
            residenceCityTextField.setText(currentDonor.getResidenceCity());
            residenceCountyComboBox.getSelectionModel().select(countyIndex);
        }

    }
}
