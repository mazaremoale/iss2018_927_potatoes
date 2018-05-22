package blood_donation.controller.donor;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Donor;
import blood_donation.domain.utils.Clinic;
import blood_donation.domain.utils.Donation;
import blood_donation.domain.utils.DonationRequest;
import blood_donation.repository.Repository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public final class DonorQuestionnaireWindowController implements Initializable
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

    @FXML
    private CheckBox romanianCitizenCheckBox;

    @FXML
    private CheckBox ageCheckBox;

    @FXML
    private CheckBox weightCheckBox;

    @FXML
    private CheckBox pulseCheckBox;

    @FXML
    private CheckBox bloodPressureCheckBox;

    @FXML
    private CheckBox surgeryCheckBox;

    @FXML
    private CheckBox pregnantCheckBox;

    @FXML
    private CheckBox alcoholCheckBox;

    @FXML
    private CheckBox treatmentCheckBox;

    @FXML
    private CheckBox tuberculosisCheckBox;

    @FXML
    private CheckBox poxCheckBox;

    @FXML
    private CheckBox malariaCheckBox;

    @FXML
    private CheckBox epilepsyCheckBox;

    @FXML
    private CheckBox mentalIllnessCheckBox;

    @FXML
    private CheckBox brucellosisCheckBox;

    @FXML
    private CheckBox ulcerCheckBox;

    @FXML
    private CheckBox diabetesCheckBox;

    @FXML
    private CheckBox heartDiseaseCheckBox;

    @FXML
    private CheckBox miopiaCheckBox;

    @FXML
    private CheckBox cancerCheckBox;

    @FXML
    private VBox uncheckedVBox;

    @FXML
    private Set<CheckBox> checkedCheckBoxes = new HashSet<>();

    @FXML
    private Set<CheckBox> uncheckedCheckBoxes = new HashSet<>();

    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DonorQuestionnaireWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DonorQuestionnaireWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DonorQuestionnaireWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Donor getCurrentDonor()
    {
        return currentDonor;
    }

    public DonorQuestionnaireWindowController setCurrentDonor(Donor currentDonor)
    {
        this.currentDonor = currentDonor;
        return this;
    }

    public Repository<Donation> getDonationRepository()
    {
        return donationRepository;
    }

    public DonorQuestionnaireWindowController setDonationRepository(Repository<Donation> donationRepository)
    {
        this.donationRepository = donationRepository;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public DonorQuestionnaireWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    public Repository<Clinic> getClinicRepository()
    {
        return clinicRepository;
    }

    public DonorQuestionnaireWindowController setClinicRepository(Repository<Clinic> clinicRepository)
    {
        this.clinicRepository = clinicRepository;
        return this;
    }

    public Repository<Blood> getBloodRepository()
    {
        return bloodRepository;
    }

    public DonorQuestionnaireWindowController setBloodRepository(Repository<Blood> bloodRepository)
    {
        this.bloodRepository = bloodRepository;
        return this;
    }

    public Repository<BloodGroup> getBloodGroupRepository()
    {
        return bloodGroupRepository;
    }

    public DonorQuestionnaireWindowController setBloodGroupRepository(Repository<BloodGroup> bloodGroupRepository)
    {
        this.bloodGroupRepository = bloodGroupRepository;
        return this;
    }

    @FXML
    void submitData()
    {
        StringBuilder diseases = new StringBuilder();
        for(CheckBox checkBox : uncheckedCheckBoxes)
        {
            if(checkBox.isSelected())
            {
                diseases.append(checkBox.getText()).append(" ");
            }
        }

        if(!diseases.toString().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You cannot donate because you have " + diseases);
            alert.setContentText("Sorry and thank you for your time");

            Optional<ButtonType> result = alert.showAndWait();

            if(result.get() == ButtonType.OK)
            {
                goBack();
                return;
            }
        }

        StringBuilder temporaryConditions = new StringBuilder();
        for(CheckBox checkBox : checkedCheckBoxes)
        {
            if(!checkBox.isSelected())
            {
                temporaryConditions.append(checkBox.getText()).append(" ");
            }
        }

        //TODO set text to red, don't alert

        if(!temporaryConditions.toString().isEmpty())
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("You cannot donate because " + temporaryConditions);
            alert.setContentText("Sorry and thank you for your time");

            Optional<ButtonType> result = alert.showAndWait();

            if(result.get() == ButtonType.OK)
            {
                goBack();
            }
        }
    }

    @FXML
    void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        List<Node> vBoxChildren = uncheckedVBox.getChildren();
        uncheckedCheckBoxes.addAll(vBoxChildren.subList(1, vBoxChildren.size()).stream()
                .map(node -> (CheckBox) node)
                .collect(Collectors.toList()));

        uncheckedCheckBoxes.addAll(Arrays.asList(surgeryCheckBox, pregnantCheckBox, alcoholCheckBox, treatmentCheckBox));
        checkedCheckBoxes.addAll(Arrays.asList(romanianCitizenCheckBox, ageCheckBox, weightCheckBox));
    }
}
