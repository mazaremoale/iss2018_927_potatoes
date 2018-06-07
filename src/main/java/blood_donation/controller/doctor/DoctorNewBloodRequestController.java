package blood_donation.controller.doctor;

import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.blood.BloodTypeLetter;
import blood_donation.domain.blood.BloodTypeRH;
import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Patient;
import blood_donation.domain.utils.BloodRequest;
import blood_donation.domain.utils.Hospital;
import blood_donation.domain.utils.Priority;
import blood_donation.repository.Repository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class DoctorNewBloodRequestController implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Doctor currentDoctor;

    private Repository<Hospital> hospitalRepository;
    private Repository<Patient> patientRepository;
    private Repository<BloodRequest> bloodRequestRepository;
    private Repository<BloodGroup> bloodGroupRepository;

    private ToggleGroup rhRadioButtonGroup;
    private ToggleGroup priorityRadioButtonGroup;

    @FXML
    private ComboBox<BloodTypeLetter> bloodGroupComboBox;

    @FXML
    private ComboBox<Hospital> hospitalComboBox;

    @FXML
    private RadioButton positiveRHRadioButton;

    @FXML
    private RadioButton negativeRHRadioButton;

    @FXML
    private RadioButton lowPriorityRadioButton;

    @FXML
    private RadioButton mediumPriorityRadioButton;

    @FXML
    private RadioButton highPriorityRadioButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextField patientFirstNameTextField;

    @FXML
    private TextField patientLastNameTextField;

    @FXML
    private TextField patientAgeTextField;

    @FXML
    private TextField bloodRequestQuantityTextField;

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DoctorNewBloodRequestController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DoctorNewBloodRequestController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DoctorNewBloodRequestController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Doctor getCurrentDoctor()
    {
        return currentDoctor;
    }

    public DoctorNewBloodRequestController setCurrentDonor(Doctor currentDoctor)
    {
        this.currentDoctor = currentDoctor;
        return this;
    }

    public Repository<Hospital> getHospitalRepository()
    {
        return hospitalRepository;
    }

    public DoctorNewBloodRequestController setHospitalRepository(Repository<Hospital> hospitalRepository)
    {
        this.hospitalRepository = hospitalRepository;
        return this;
    }

    public Repository<Patient> getPatientRepository()
    {
        return patientRepository;
    }

    public DoctorNewBloodRequestController setPatientRepository(Repository<Patient> patientRepository)
    {
        this.patientRepository = patientRepository;
        return this;
    }

    public Repository<BloodRequest> getBloodRequestRepository()
    {
        return bloodRequestRepository;
    }

    public DoctorNewBloodRequestController setBloodRequestRepository(Repository<BloodRequest> bloodRequestRepository)
    {
        this.bloodRequestRepository = bloodRequestRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public DoctorNewBloodRequestController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //fill blood group comboBox
        List<BloodTypeLetter> bloodGroups = Arrays.asList(BloodTypeLetter.values());
        ObservableList<BloodTypeLetter> bloodGroupsObservableList = FXCollections.observableList(bloodGroups);
        bloodGroupComboBox.setItems(bloodGroupsObservableList);
        bloodGroupComboBox.setValue(BloodTypeLetter.A);

        //fill hospitals comboBox
        List<Hospital> hospitals = hospitalRepository.getAll();
        ObservableList<Hospital> hospitalObservableList = FXCollections.observableList(hospitals);
        hospitalComboBox.setItems(hospitalObservableList);
        hospitalComboBox.setValue(currentDoctor.getHospital());

        //useful for selecting only one radioButton at a time
        rhRadioButtonGroup = new ToggleGroup();
        positiveRHRadioButton.setToggleGroup(rhRadioButtonGroup);
        negativeRHRadioButton.setToggleGroup(rhRadioButtonGroup);

        priorityRadioButtonGroup = new ToggleGroup();
        lowPriorityRadioButton.setToggleGroup(priorityRadioButtonGroup);
        mediumPriorityRadioButton.setToggleGroup(priorityRadioButtonGroup);
        highPriorityRadioButton.setToggleGroup(priorityRadioButtonGroup);
    }

    @FXML
    public void submitBloodRequest()
    {
        String patientFirstName = patientFirstNameTextField.getText();
        String patientLastName = patientLastNameTextField.getText();
        String patientAgeString = patientAgeTextField.getText();
        Integer patientAge = null;

        RadioButton selectedRHRadioButton = (RadioButton)rhRadioButtonGroup.getSelectedToggle();
        String selectedRH = selectedRHRadioButton.getText();

        RadioButton selectedPriorityRadioButton = (RadioButton)priorityRadioButtonGroup.getSelectedToggle();
        String selectedPriority = selectedPriorityRadioButton.getText();

        String bloodRequestQuantityString = bloodRequestQuantityTextField.getText();
        Float bloodRequestQuantity;

        if (patientFirstName.equals("") || patientLastName.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Name field can not be empty");
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
        else if (!patientFirstName.matches("[a-zA-Z]+") || !patientLastName.matches("[a-zA-Z]+"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Name must contain only letters");
            alert.setContentText("Please try again");
            alert.showAndWait();

        }
        else if (!patientAgeString.equals("") && !patientAgeString.matches("[0-9]+"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Age must be an integer number");
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
        else if (bloodRequestQuantityString.equals(""))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Quantity field can not be empty");
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
        else if (bloodRequestQuantityString.equals("0"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Quantity can not be 0");
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
        else if (!bloodRequestQuantityString.matches("[0-9]+"))
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Quantity must be an integer number");
            alert.setContentText("Please try again");
            alert.showAndWait();
        }
        else
        {
            if (!patientAgeString.equals(""))
                patientAge = Integer.valueOf(patientAgeString);
            Integer bloodRequestQuantityInteger = Integer.valueOf(bloodRequestQuantityString);
            bloodRequestQuantity = (float) (bloodRequestQuantityInteger / 1000.0);

            Patient patient = new Patient(patientFirstName, patientFirstName, patientAge);
            patient.setDoctor(currentDoctor);
            patientRepository.add(patient);

            BloodTypeLetter bloodTypeLetter = bloodGroupComboBox.getValue();
            BloodTypeRH bloodTypeRH = BloodTypeRH.valueOf(selectedRH.toUpperCase());
            List<BloodGroup> allBloodGroup = bloodGroupRepository.getAll().stream()
                                                .filter(bloodGroup -> bloodGroup.getBloodTypeLetter() == bloodTypeLetter
                                                        && bloodGroup.getBloodTypeRH() == bloodTypeRH)
                                                .collect(Collectors.toList());

            Priority priority = Priority.valueOf(selectedPriority.toUpperCase());

            Hospital hospital = hospitalComboBox.getValue();

            BloodRequest bloodRequest = new BloodRequest(patient, allBloodGroup.get(0), priority, hospital,
                                                        bloodRequestQuantity, currentDoctor);
            bloodRequestRepository.add(bloodRequest);

            patientFirstNameTextField.setText("");
            patientLastNameTextField.setText("");
            patientAgeTextField.setText("");
            bloodGroupComboBox.setValue(BloodTypeLetter.A);
            positiveRHRadioButton.setSelected(true);
            lowPriorityRadioButton.setSelected(true);
            hospitalComboBox.setValue(currentDoctor.getHospital());
            bloodRequestQuantityTextField.setText("");

        }
    }
}
