package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "Donations")
public class Donation
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "donorID")
    private Donor donor;


    //private List<Blood> bloodList;

    @Column(name = "donationDate")
    private LocalDate donationDate;

    @Column(name = "status")
    private String status;

    @ManyToOne
    @JoinColumn(name = "patientID")
    private Patient patient;

    public Donation(Donor donor, List<Blood> bloodList, String status, Patient patient)
    {
        this.donor = donor;
        //this.bloodList = bloodList;
        this.donationDate = LocalDate.now();
        this.status = status;
        this.patient = patient;
    }

    public Donation()
    {
    }

    public Donor getDonor()
    {
        return donor;
    }

    public List<Blood> getBloodList()
    {
        return null;//bloodList;
    }

    public LocalDate getDonationDate()
    {
        return donationDate;
    }

    public String getStatus()
    {
        return status;
    }

    public Patient getPatient()
    {
        return patient;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }
}
