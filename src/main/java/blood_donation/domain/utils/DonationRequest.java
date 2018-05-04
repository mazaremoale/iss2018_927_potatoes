package blood_donation.domain.utils;

import javax.persistence.*;

@Entity
@Table(name = "DonationRequests")
public class DonationRequest
{
    private int id;

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


    private int age;
    private float pulse;
    private float weight;
    private float bloodPressure;
    private Boolean hasConsumedFatRecently;
    private Boolean hasConsumedAlcoholRecently;
    private Boolean hadSurgeryRecently;
    private Boolean isUnderTreatment;
    private Boolean hasSmokedRecently;
    private Boolean isWellSlept;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
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

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public float getPulse()
    {
        return pulse;
    }

    public void setPulse(float pulse)
    {
        this.pulse = pulse;
    }

    public float getWeight()
    {
        return weight;
    }

    public void setWeight(float weight)
    {
        this.weight = weight;
    }

    public float getBloodPressure()
    {
        return bloodPressure;
    }

    public void setBloodPressure(float bloodPressure)
    {
        this.bloodPressure = bloodPressure;
    }

    public Boolean getHasConsumedFatRecently()
    {
        return hasConsumedFatRecently;
    }

    public void setHasConsumedFatRecently(Boolean hasConsumedFatRecently)
    {
        this.hasConsumedFatRecently = hasConsumedFatRecently;
    }

    public Boolean getHasConsumedAlcoholRecently()
    {
        return hasConsumedAlcoholRecently;
    }

    public void setHasConsumedAlcoholRecently(Boolean hasConsumedAlcoholRecently)
    {
        this.hasConsumedAlcoholRecently = hasConsumedAlcoholRecently;
    }

    public Boolean getHadSurgeryRecently()
    {
        return hadSurgeryRecently;
    }

    public void setHadSurgeryRecently(Boolean hasHadSurgeryRecently)
    {
        this.hadSurgeryRecently = hasHadSurgeryRecently;
    }

    public Boolean getUnderTreatment()
    {
        return isUnderTreatment;
    }

    public void setUnderTreatment(Boolean underTreatment)
    {
        isUnderTreatment = underTreatment;
    }

    public Boolean getHasSmokedRecently()
    {
        return hasSmokedRecently;
    }

    public void setHasSmokedRecently(Boolean hasSmokedRecently)
    {
        this.hasSmokedRecently = hasSmokedRecently;
    }

    public Boolean getWellSlept()
    {
        return isWellSlept;
    }

    public void setWellSlept(Boolean wellSlept)
    {
        isWellSlept = wellSlept;
    }
}
