package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Donations")
public class Donation
{

    private Donor donor;
    private LocalDate donationDate;
    private Status status = Status.PENDING;
    private Patient patient;
    private Blood donatedBlood;
    private DonationRequest donationRequest;
    private Clinic clinic;
    private JourneyStatus bloodContainerJourneyStatus = JourneyStatus.SAMPLING;


    @FXML
    private IntegerProperty id = new SimpleIntegerProperty();

    @FXML
    private StringProperty donationDateProperty = new SimpleStringProperty();

    @FXML
    private StringProperty statusProperty = new SimpleStringProperty();

    @FXML
    private StringProperty patientProperty = new SimpleStringProperty();

    @FXML
    private StringProperty donatedBloodProperty = new SimpleStringProperty();

    @FXML
    private StringProperty clinicProperty = new SimpleStringProperty();

    @FXML
    private StringProperty bloodContainerStatusProperty = new SimpleStringProperty();

    public Donation(Donor donor, Blood donatedBlood)
    {
        this.donor = donor;
        this.donatedBlood = donatedBlood;

        donationDateProperty.setValue(donationDate.toString());
        statusProperty.setValue(status.toString());
        donatedBloodProperty.setValue(donatedBlood.toString());
    }

    public Donation()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id.get();
    }

    @ManyToOne
    @JoinColumn(name = "donorID")
    public Donor getDonor()
    {
        return donor;
    }

    public LocalDate getDonationDate()
    {
        return donationDate;
    }

    public Status getStatus()
    {
        return status;
    }

    @ManyToOne
    @JoinColumn(name = "patientID")
    public Patient getPatient()
    {
        return patient;
    }

    @OneToOne
    @JoinColumn(unique = true)
    public Blood getDonatedBlood()
    {
        return donatedBlood;
    }

    public JourneyStatus getBloodContainerJourneyStatus()
    {
        return bloodContainerJourneyStatus;
    }



    public void setId(int id)
    {
        this.id.set(id);
    }

    public void setDonor(Donor donor)
    {
        this.donor = donor;
    }

    public void setDonationDate(LocalDate donationDate)
    {
        this.donationDate = donationDate;
        if(donationDate != null)
            this.donationDateProperty.setValue(donationDate.toString());
    }

    public void setStatus(Status status)
    {
        this.status = status;
        if(status != null)
            this.statusProperty.setValue(status.toString());
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
        if(patient != null)
            this.patientProperty.setValue(patient.toString());
    }

    public void setDonatedBlood(Blood donatedBlood)
    {
        this.donatedBlood = donatedBlood;
        if(donatedBlood != null)
            this.donatedBloodProperty.setValue(donatedBlood.toString());
    }

    @OneToOne
    @JoinColumn(unique = true)
    public DonationRequest getDonationRequest()
    {
        return donationRequest;
    }

    @ManyToOne
    @JoinColumn(name = "clinicID")
    public Clinic getClinic()
    {
        return clinic;
    }

    public void setClinic(Clinic clinic)
    {
        this.clinic = clinic;
        if(clinic != null)
            this.clinicProperty.setValue(clinic.toString());
    }

    public void setDonationRequest(DonationRequest donationRequest)
    {
        this.donationRequest = donationRequest;
    }

    public void setBloodContainerJourneyStatus(JourneyStatus status)
    {
        this.bloodContainerJourneyStatus = status;
        if(status != null)
            this.bloodContainerStatusProperty.setValue(status.toString());
    }

    public StringProperty donationDateProperty()
    {
        return donationDateProperty;
    }

    public StringProperty statusProperty()
    {
        return statusProperty;
    }

    public StringProperty patientProperty()
    {
        return patientProperty;
    }

    public StringProperty donatedBloodProperty()
    {
        return donatedBloodProperty;
    }

    public StringProperty clinicProperty(){return clinicProperty;}

    public StringProperty bloodContainerStatusProperty()
    {
        return bloodContainerStatusProperty;
    }

    @Override
    public String toString()
    {
        //ignore
        return String.valueOf(id.get());
    }
}
