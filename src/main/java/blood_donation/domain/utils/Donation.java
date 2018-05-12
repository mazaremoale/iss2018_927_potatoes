package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "Donations")
public class Donation
{
    private IntegerProperty id = new SimpleIntegerProperty();
    private Donor donor;
    private LocalDate donationDate = LocalDate.now();
    private Status status = Status.PENDING;
    private Patient patient;
    private Set<Blood> donatedBlood;

    public Donation(Donor donor, Patient patient, Set<Blood> donatedBlood)
    {
        this.donor = donor;
        this.patient = patient;
        this.donatedBlood = donatedBlood;
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

    public void setStatus(Status status)
    {
        this.status = status;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    @OneToMany(mappedBy = "donation")
    public Set<Blood> getDonatedBlood()
    {
        return donatedBlood;
    }

    public void setDonatedBlood(Set<Blood> donatedBlood)
    {
        this.donatedBlood = donatedBlood;
    }
}
