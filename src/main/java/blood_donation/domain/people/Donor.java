package blood_donation.domain.people;

import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.utils.Donation;
import blood_donation.domain.utils.DonationRequest;
import blood_donation.domain.utils.Location;
import blood_donation.repository.Repository;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@DiscriminatorValue("donor")
public class Donor extends Person
{
    private LocalDate birthDate;
    private String idAddress;
    private String idCity;
    private Location idCounty;

    private String residenceAddress;
    private String residenceCity;
    private Location residenceCounty;


    private BloodGroup bloodGroup;

    private List<DonationRequest> donationRequests;



    public Donor()
    {
    }

    public void setBloodGroup(BloodGroup bloodGroup)
    {
        this.bloodGroup = bloodGroup;
    }

    public LocalDate getBirthDate()
    {
        return birthDate;
    }

    public String getIdAddress()
    {
        return idAddress;
    }

    public String getIdCity()
    {
        return idCity;
    }

    @ManyToOne
    @JoinColumn(name = "idCountyID")
    public Location getIdCounty()
    {
        return idCounty;
    }

    public String getResidenceAddress()
    {
        return residenceAddress;
    }

    public String getResidenceCity()
    {
        return residenceCity;
    }

    @ManyToOne
    @JoinColumn(name = "residenceCountyID")
    public Location getResidenceCounty()
    {
        return residenceCounty;
    }

    @ManyToOne
    @JoinColumn(name = "bloodGroupID")
    public BloodGroup getBloodGroup()
    {
        return bloodGroup;
    }

    public void setBirthDate(LocalDate birthDate)
    {
        this.birthDate = birthDate;
    }

    public void setIdAddress(String idAddress)
    {
        this.idAddress = idAddress;
    }

    public void setIdCity(String idCity)
    {
        this.idCity = idCity;
    }

    public void setIdCounty(Location idCounty)
    {
        this.idCounty = idCounty;
    }

    public void setResidenceAddress(String residenceAddress)
    {
        this.residenceAddress = residenceAddress;
    }

    public void setResidenceCity(String residenceCity)
    {
        this.residenceCity = residenceCity;
    }

    public void setResidenceCounty(Location residenceCounty)
    {
        this.residenceCounty = residenceCounty;
    }


    @OneToMany
    public List<DonationRequest> getDonationRequests()
    {
        return donationRequests;
    }

    public void setDonationRequests(List<DonationRequest> donationRequests)
    {
        this.donationRequests = donationRequests;
    }

    @Transient
    public List<Donation> getDonations(Repository<Donation> donationRepository)
    {
        return donationRepository.getAll().stream().filter(donation -> donation.getDonor() == this).collect(Collectors.toList());
    }

    public Donation getLatestDonation(Repository<Donation> donationRepository)
    {
        List<Donation> donations = getDonations(donationRepository);
        if(donations.size() > 1)
            return donations.stream().reduce((first, second) -> second).orElse(null);
        else if(donations.size() == 1)
            return donations.get(0);
        else
            return null;
    }

    @Override
    public String toString()
    {
        return "Donor{" +
                "birthDate=" + birthDate +
                ", idAddress='" + idAddress + '\'' +
                ", idCity='" + idCity + '\'' +
                ", idCounty='" + idCounty + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", residenceCity='" + residenceCity + '\'' +
                ", residenceCounty='" + residenceCounty + '\'' +
                ", bloodGroup=" + bloodGroup;
    }
}