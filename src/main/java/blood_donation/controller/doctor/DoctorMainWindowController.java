package blood_donation.controller.doctor;

import blood_donation.domain.people.Doctor;
import blood_donation.domain.utils.DonationRequest;
import blood_donation.repository.Repository;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.hibernate.Session;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

public class DoctorMainWindowController implements Initializable
{
    private Stage primaryStage;
    private Session session;
    private Scene previousScene;

    private Doctor currentDoctor;

    private Repository<DonationRequest> donationRequestRepository;


    @FXML
    private TableView<DonationRequest> donationRequestTableView;

    @FXML
    private TableColumn<DonationRequest, String> drNameColumn;

    @FXML
    private TableColumn<DonationRequest, String> drAgeColumn;

    @FXML
    private TableColumn<DonationRequest, String> drBloodPressureColumn;

    @FXML
    private TableColumn<DonationRequest, String> drPulseColumn;

    @FXML
    private TableColumn<DonationRequest, String> drWeightColumn;

    @FXML
    private Button approveButton;

    @FXML
    private Button notApproveButton;



    public Stage getPrimaryStage()
    {
        return primaryStage;
    }

    public DoctorMainWindowController setPrimaryStage(Stage primaryStage)
    {
        this.primaryStage = primaryStage;
        return this;
    }

    public Session getSession()
    {
        return session;
    }

    public DoctorMainWindowController setSession(Session session)
    {
        this.session = session;
        return this;
    }

    public Scene getPreviousScene()
    {
        return previousScene;
    }

    public DoctorMainWindowController setPreviousScene(Scene previousScene)
    {
        this.previousScene = previousScene;
        return this;
    }

    public Doctor getCurrentDoctor()
    {
        return currentDoctor;
    }

    public DoctorMainWindowController setCurrentDonor(Doctor currentDoctor)
    {
        this.currentDoctor = currentDoctor;
        return this;
    }

    public Repository<DonationRequest> getDonationRequestRepository()
    {
        return donationRequestRepository;
    }

    public DoctorMainWindowController setDonationRequestRepository(Repository<DonationRequest> donationRequestRepository)
    {
        this.donationRequestRepository = donationRequestRepository;
        return this;
    }

    @FXML
    public void goBack()
    {
        primaryStage.setScene(previousScene);
    }

    @FXML
    public void openMakeNewRequestForm() throws IOException
    {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/doctor/doctorNewBloodRequestWindow.fxml"));

        loader.setController(new DoctorNewBloodRequestController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setPreviousScene(primaryStage.getScene()));

        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("Doctor management panel");
    }

    @FXML
    public void approveDonor()
    {
        DonationRequest currentDonationRequest = donationRequestTableView.getSelectionModel().getSelectedItem();

        currentDonationRequest.setValidatedByDoctor(true);
        donationRequestRepository.update(currentDonationRequest);

        donationRequestTableView.getItems().remove(donationRequestTableView.getSelectionModel().getSelectedItem());
    }

    @FXML
    public void notApproveDonor()
    {
        DonationRequest currentDonationRequest = donationRequestTableView.getSelectionModel().getSelectedItem();

        currentDonationRequest.setValidatedByDoctor(false);
        donationRequestRepository.update(currentDonationRequest);

        donationRequestTableView.getItems().remove(donationRequestTableView.getSelectionModel().getSelectedItem());

    }

    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        System.out.println(donationRequestRepository);
        List<DonationRequest> donationRequests = donationRequestRepository.getAll().stream()
                                                .filter(DonationRequest::getValidatedByPersonnel)
                                                .filter(dr -> dr.getValidatedByDoctor() == null)
                                                .collect(Collectors.toList());

        ObservableList<DonationRequest> donationRequestsObservableList
                = FXCollections.observableList(donationRequests);

        drNameColumn.setCellValueFactory(data -> data.getValue().getDonor().fullNameProperty());
        drAgeColumn.setCellValueFactory(new PropertyValueFactory<>("age"));
        drPulseColumn.setCellValueFactory(new PropertyValueFactory<>("pulse"));
        drWeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        drBloodPressureColumn.setCellValueFactory(new PropertyValueFactory<>("bloodPressure"));

        donationRequestTableView.setItems(donationRequestsObservableList);

        approveButton.setDisable(true);
        notApproveButton.setDisable(true);

        donationRequestTableView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) ->
        {
            approveButton.setDisable(false);
            notApproveButton.setDisable(false);
        });
    }
}
