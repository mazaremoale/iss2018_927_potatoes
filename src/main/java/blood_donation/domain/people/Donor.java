package blood_donation.domain.people;

import blood_donation.domain.blood.BloodGroup;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.*;

@Entity
@DiscriminatorValue("donor")
public class Donor extends Person
{
    private Date birthDate;
    private String idAddress;
    private String idCity;
    private String idCounty;
    private String residenceAddress;
    private String residenceCity;
    private String residenceCounty;
    private BloodGroup bloodGroup;

    public Donor()
    {
    }

    public Donor(String firstName, String lastName, String username, String password, Date birthDate, String idAddress, String idCity, String idCounty, String residenceAddress, String residenceCity, String residenceCounty, BloodGroup bloodGroup)
    {
        super(firstName, lastName, username, password);
        this.birthDate = birthDate;
        this.idAddress = idAddress;
        this.idCity = idCity;
        this.idCounty = idCounty;
        this.residenceAddress = residenceAddress;
        this.residenceCity = residenceCity;
        this.residenceCounty = residenceCounty;
        this.bloodGroup = bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup)
    {
        this.bloodGroup = bloodGroup;
    }

    public Date getBirthDate()
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

    public String getIdCounty()
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

    public String getResidenceCounty()
    {
        return residenceCounty;
    }

    @ManyToOne
    public BloodGroup getBloodGroup()
    {
        return bloodGroup;
    }

    public void setBirthDate(Date birthDate)
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

    public void setIdCounty(String idCounty)
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

    public void setResidenceCounty(String residenceCounty)
    {
        this.residenceCounty = residenceCounty;
    }

    @Override
    public String toString()
    {
        return super.toString()+ "-Donor{" +
                "birthDate=" + birthDate +
                ", idAddress='" + idAddress + '\'' +
                ", idCity='" + idCity + '\'' +
                ", idCounty='" + idCounty + '\'' +
                ", residenceAddress='" + residenceAddress + '\'' +
                ", residenceCity='" + residenceCity + '\'' +
                ", residenceCounty='" + residenceCounty + '\'' +
                '}';
    }
}