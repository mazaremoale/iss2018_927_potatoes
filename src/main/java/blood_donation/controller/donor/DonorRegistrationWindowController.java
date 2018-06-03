package blood_donation.controller.donor;

import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import blood_donation.domain.utils.Clinic;
import blood_donation.domain.utils.Distance;
import blood_donation.domain.utils.Donation;
import blood_donation.domain.utils.Location;
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

public final class DonorRegistrationWindowController implements Initializable
{

    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Repository<Location> locationRepository;
    private Repository<Donor> donorRepository;
    private Repository<Donation> donationRepository;
    private Repository<Clinic> clinicRepository;
    private Repository<Distance> distanceRepository;
    private Repository<Patient> patientRepository;


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

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    private void loadLoginCredentialsWindow(Donor donor) throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/donor/donorLoginCredentialsWindow.fxml"));
        loader.setController(new DonorLoginCredentialsWindowController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setPreviousScene(primaryStage.getScene())
                .setCurrentDonor(donor)
                .setDonorRepository(donorRepository)
                .setDonationRepository(donationRepository)
                .setClinicRepository(clinicRepository)
                .setDistanceRepository(distanceRepository)
                .setPatientRepository(patientRepository));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Choose a username and password");
    }

    @FXML
    void goNext() throws IOException
    {
        Donor donor = new Donor();

        if(firstNameTextField.getText().length() > 0 &&
                lastNameTextField.getText().length() > 0 &&
                !yearComboBox.getSelectionModel().isEmpty() &&
                !monthComboBox.getSelectionModel().isEmpty() &&
                idAddressTextField.getText().length() > 0 &&
                idCityTextField.getText().length() > 0 &&
                !idCountyComboBox.getSelectionModel().isEmpty())
        {
            donor.setFirstName(firstNameTextField.getText());
            donor.setLastName(lastNameTextField.getText());

            int year = yearComboBox.getSelectionModel().getSelectedItem();
            Month month = Month.valueOf(monthComboBox.getSelectionModel().getSelectedItem().toUpperCase());
            int day = dayComboBox.getSelectionModel().getSelectedItem();
            LocalDate localDate = LocalDate.of(year, month, day);

            donor.setBirthDate(localDate);
            donor.setIdAddress(idAddressTextField.getText());
            donor.setIdCity(idCityTextField.getText());
            donor.setIdCounty(idCountyComboBox.getSelectionModel().getSelectedItem());

            if(residenceAddressTextField.getText().length() > 0 &&
                    !residenceCountyComboBox.getSelectionModel().isEmpty() &&
                    residenceCityTextField.getText().length() > 0)
            {
                donor.setResidenceAddress(residenceAddressTextField.getText());
                donor.setResidenceCity(residenceCityTextField.getText());
                donor.setResidenceCounty(residenceCountyComboBox.getSelectionModel().getSelectedItem());

                loadLoginCredentialsWindow(donor);
            }

            else if(residenceAddressTextField.getText().length() > 0 ||
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
                donor.setResidenceCity(idCityTextField.getText());
                donor.setResidenceAddress(idAddressTextField.getText());
                donor.setResidenceCounty(idCountyComboBox.getSelectionModel().getSelectedItem());


                loadLoginCredentialsWindow(donor);
            }
        }
        else
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("In order to continue, all required fields should be filled");
            alert.setContentText("Please fill in all the required fields");

            Optional<ButtonType> result = alert.showAndWait();
        }


    }


    public DonorRegistrationWindowController()
    {

    }

    public DonorRegistrationWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public DonorRegistrationWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public DonorRegistrationWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Repository<Location> getLocationRepository()
    {
        return locationRepository;
    }

    public DonorRegistrationWindowController setLocationRepository(Repository<Location> locationRepository)
    {
        this.locationRepository = locationRepository;
        return this;
    }

    public Repository<Donor> getDonorRepository()
    {
        return donorRepository;
    }

    public DonorRegistrationWindowController setDonorRepository(Repository<Donor> donorRepository)
    {
        this.donorRepository = donorRepository;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public DonorRegistrationWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public DonorRegistrationWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Distance> getDistanceRepository()
    {
        return distanceRepository;
    }

    public DonorRegistrationWindowController setDistanceRepository(Repository<Distance> distanceRepository)
    {
        this.distanceRepository = distanceRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public DonorRegistrationWindowController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
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


    }
}
