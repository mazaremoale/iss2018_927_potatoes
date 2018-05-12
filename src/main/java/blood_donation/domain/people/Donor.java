package blood_donation.domain.people;

import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.utils.Location;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

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


    private Boolean hasHIV;
    private Boolean hasHepatitis;
    private Boolean hasTB;
    private Boolean hasPox;
    private Boolean hasMalaria;
    private Boolean hasEpilepsy;
    private Boolean hasOtherNeurologicalDisease;
    private Boolean hasMentalIllness;
    private Boolean hasBrucellosis;
    private Boolean hasUlcer;
    private Boolean hasDiabetes;
    private Boolean hasHeartDisease;
    private Boolean hasPsoriasis;
    private Boolean hasVitiligo;
    private Boolean hasMyopiaOverOrUnder6;
    private Boolean hasCancer;

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

    public Boolean getHasHIV()
    {
        return hasHIV;
    }

    public void setHasHIV(Boolean hasHIV)
    {
        this.hasHIV = hasHIV;
    }

    public Boolean getHasHepatitis()
    {
        return hasHepatitis;
    }

    public void setHasHepatitis(Boolean hasHepatitis)
    {
        this.hasHepatitis = hasHepatitis;
    }

    public Boolean getHasTB()
    {
        return hasTB;
    }

    public void setHasTB(Boolean hasTB)
    {
        this.hasTB = hasTB;
    }

    public Boolean getHasPox()
    {
        return hasPox;
    }

    public void setHasPox(Boolean hasPox)
    {
        this.hasPox = hasPox;
    }

    public Boolean getHasMalaria()
    {
        return hasMalaria;
    }

    public void setHasMalaria(Boolean hasMalaria)
    {
        this.hasMalaria = hasMalaria;
    }

    public Boolean getHasEpilepsy()
    {
        return hasEpilepsy;
    }

    public void setHasEpilepsy(Boolean hasEpilepsy)
    {
        this.hasEpilepsy = hasEpilepsy;
    }

    public Boolean getHasOtherNeurologicalDisease()
    {
        return hasOtherNeurologicalDisease;
    }

    public void setHasOtherNeurologicalDisease(Boolean hasOtherNeurologicalDisease)
    {
        this.hasOtherNeurologicalDisease = hasOtherNeurologicalDisease;
    }

    public Boolean getHasMentalIllness()
    {
        return hasMentalIllness;
    }

    public void setHasMentalIllness(Boolean hasMentalIllness)
    {
        this.hasMentalIllness = hasMentalIllness;
    }

    public Boolean getHasBrucellosis()
    {
        return hasBrucellosis;
    }

    public void setHasBrucellosis(Boolean hasBrucellosis)
    {
        this.hasBrucellosis = hasBrucellosis;
    }

    public Boolean getHasUlcer()
    {
        return hasUlcer;
    }

    public void setHasUlcer(Boolean hasUlcer)
    {
        this.hasUlcer = hasUlcer;
    }

    public Boolean getHasDiabetes()
    {
        return hasDiabetes;
    }

    public void setHasDiabetes(Boolean hasDiabetes)
    {
        this.hasDiabetes = hasDiabetes;
    }

    public Boolean getHasHeartDisease()
    {
        return hasHeartDisease;
    }

    public void setHasHeartDisease(Boolean hasHeartDisease)
    {
        this.hasHeartDisease = hasHeartDisease;
    }

    public Boolean getHasPsoriasis()
    {
        return hasPsoriasis;
    }

    public void setHasPsoriasis(Boolean hasPsoriasis)
    {
        this.hasPsoriasis = hasPsoriasis;
    }

    public Boolean getHasVitiligo()
    {
        return hasVitiligo;
    }

    public void setHasVitiligo(Boolean hasVitiligo)
    {
        this.hasVitiligo = hasVitiligo;
    }

    public Boolean getHasMyopiaOverOrUnder6()
    {
        return hasMyopiaOverOrUnder6;
    }

    public void setHasMyopiaOverOrUnder6(Boolean hasMyopiaOverOrUnder6)
    {
        this.hasMyopiaOverOrUnder6 = hasMyopiaOverOrUnder6;
    }

    public Boolean getHasCancer()
    {
        return hasCancer;
    }

    public void setHasCancer(Boolean hasCancer)
    {
        this.hasCancer = hasCancer;
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
                ", bloodGroup=" + bloodGroup +
                ", hasHIV=" + hasHIV +
                ", hasHepatitis=" + hasHepatitis +
                ", hasTB=" + hasTB +
                ", hasPox=" + hasPox +
                ", hasMalaria=" + hasMalaria +
                ", hasEpilepsy=" + hasEpilepsy +
                ", hasOtherNeurologicalDisease=" + hasOtherNeurologicalDisease +
                ", hasMentalIllness=" + hasMentalIllness +
                ", hasBrucellosis=" + hasBrucellosis +
                ", hasUlcer=" + hasUlcer +
                ", hasDiabetes=" + hasDiabetes +
                ", hasHeartDisease=" + hasHeartDisease +
                ", hasPsoriasis=" + hasPsoriasis +
                ", hasVitiligo=" + hasVitiligo +
                ", hasMyopiaOverOrUnder6=" + hasMyopiaOverOrUnder6 +
                ", hasCancer=" + hasCancer +
                '}';
    }
}