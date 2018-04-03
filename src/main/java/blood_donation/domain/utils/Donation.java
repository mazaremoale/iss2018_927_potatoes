package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.people.Donor;
import blood_donation.domain.people.Patient;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

//@Entity
//@Table(name = "Donations")
public class Donation
{
    private int id;
    private Donor donor;
    private List<Blood> bloodList;
    private LocalDate donationDate;
    private String status;
    private Patient patient;

    public Donation(Donor donor, List<Blood> bloodList, String status, Patient patient)
    {
        this.donor = donor;
        this.bloodList = bloodList;
        this.donationDate = LocalDate.now();
        this.status = status;
        this.patient = patient;
    }

    public Donor getDonor()
    {
        return donor;
    }

    public List<Blood> getBloodList()
    {
        return bloodList;
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
