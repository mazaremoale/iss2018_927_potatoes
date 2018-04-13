package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Donations")
public class Donation
{
    private IntegerProperty id = new SimpleIntegerProperty();
    private Donor donor;
    private LocalDate donationDate;
    private SimpleStringProperty status;
    private Patient patient;
    //private List<Blood> bloodList

    public Donation(Donor donor, List<Blood> bloodList, String status, Patient patient)
    {
        this.donor = donor;
        //this.bloodList = bloodList;
        this.donationDate = LocalDate.now();
        this.status = new SimpleStringProperty(status);
        this.patient = patient;
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

    public String getStatus()
    {
        return status.get();
    }

    @ManyToOne
    @JoinColumn(name = "patientID")
    public Patient getPatient()
    {
        return patient;
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
    }

    public void setStatus(String status)
    {
        this.status.set(status);
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }
}
