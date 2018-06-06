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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
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

    @FXML
    void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    void goNext()
    {

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
        int dayIndex = dayComboBox.getItems().indexOf(currentDonor.getBirthDate().getDayOfMonth());
        System.out.println(dayIndex);
        System.out.println(currentDonor.getBirthDate().getDayOfMonth());


        yearComboBox.getSelectionModel().select(yearIndex);
        monthComboBox.getSelectionModel().select(currentDonor.getBirthDate().getMonthValue() - 1);
        dayComboBox.getSelectionModel().select(dayIndex);


        idAddressTextField.setText(currentDonor.getIdAddress());
        idCountyComboBox.getSelectionModel();

        if(currentDonor.getResidenceCounty() != null)
        {

        }

    }
}
