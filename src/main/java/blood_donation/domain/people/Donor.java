package blood_donation.domain.people;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.util.*;

/**
 * 
 */
@Entity
@DiscriminatorValue("donor")
public class Donor extends Person {

    /**
     * Default constructor
     */
    public Donor() {
    }


    @Column(name= "birthDate")
    private Date birthDate;

    @Column(name = "idAddress")
    private String idAddress;

    @Column(name = "idCity")
    private String idCity;

    @Column(name = "idCounty")
    private String idCounty;

    private String residenceAddress;

    private String residenceCity;

    private String residenceCounty;

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