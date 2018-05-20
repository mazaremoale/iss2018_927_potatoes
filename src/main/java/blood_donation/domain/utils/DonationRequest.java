package blood_donation.domain.utils;

import blood_donation.domain.people.Donor;

import javax.persistence.*;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name = "DonationRequests")
public class DonationRequest
{
    private int id;

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

    private Donor donor;

    public DonationRequest()
    {
    }

    private int randomInt1_100()
    {
        return ThreadLocalRandom.current().nextInt(1, 101);
    }

    public DonationRequest(int age, float pulse, float weight, float bloodPressure, Boolean hasConsumedFatRecently,
                           Boolean hasConsumedAlcoholRecently, Boolean hadSurgeryRecently, Boolean isUnderTreatment,
                           Boolean hasSmokedRecently, Boolean isWellSlept, Boolean hasHIV, Boolean hasHepatitis,
                           Boolean hasTB, Boolean hasPox, Boolean hasMalaria, Boolean hasEpilepsy,
                           Boolean hasOtherNeurologicalDisease, Boolean hasMentalIllness, Boolean hasBrucellosis,
                           Boolean hasUlcer, Boolean hasDiabetes, Boolean hasHeartDisease, Boolean hasPsoriasis,
                           Boolean hasVitiligo, Boolean hasMyopiaOverOrUnder6, Boolean hasCancer)
    {
        this.age = age;
        this.pulse = pulse;
        this.weight = weight;
        this.bloodPressure = bloodPressure;
        this.hasConsumedFatRecently = hasConsumedFatRecently;
        this.hasConsumedAlcoholRecently = hasConsumedAlcoholRecently;
        this.hadSurgeryRecently = hadSurgeryRecently;
        this.isUnderTreatment = isUnderTreatment;
        this.hasSmokedRecently = hasSmokedRecently;
        this.isWellSlept = isWellSlept;
        this.hasHIV = hasHIV;
        this.hasHepatitis = hasHepatitis;
        this.hasTB = hasTB;
        this.hasPox = hasPox;
        this.hasMalaria = hasMalaria;
        this.hasEpilepsy = hasEpilepsy;
        this.hasOtherNeurologicalDisease = hasOtherNeurologicalDisease;
        this.hasMentalIllness = hasMentalIllness;
        this.hasBrucellosis = hasBrucellosis;
        this.hasUlcer = hasUlcer;
        this.hasDiabetes = hasDiabetes;
        this.hasHeartDisease = hasHeartDisease;
        this.hasPsoriasis = hasPsoriasis;
        this.hasVitiligo = hasVitiligo;
        this.hasMyopiaOverOrUnder6 = hasMyopiaOverOrUnder6;
        this.hasCancer = hasCancer;
    }

    public void generateRandoms()
    {
        hasHIV = randomInt1_100() >= 99;
        hasHepatitis = randomInt1_100() >= 99;
        hasTB = randomInt1_100() >= 99;
        hasPox = randomInt1_100() >= 99;
        hasMalaria = randomInt1_100() >= 99;
        hasEpilepsy = randomInt1_100() >= 99;
        hasOtherNeurologicalDisease = randomInt1_100() >= 99;
        hasMentalIllness = randomInt1_100() >= 99;
        hasBrucellosis = randomInt1_100() >= 99;
        hasUlcer = randomInt1_100() >= 99;
        hasDiabetes = randomInt1_100() >= 99;
        hasHeartDisease = randomInt1_100() >= 99;
        hasPsoriasis = randomInt1_100() >= 99;
        hasVitiligo = randomInt1_100() >= 99;
        hasMyopiaOverOrUnder6 = randomInt1_100() >= 99;
        hasCancer = randomInt1_100() >= 99;

    }

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

    @ManyToOne
    @JoinColumn(name = "donorID")
    public Donor getDonor()
    {
        return donor;
    }

    public void setDonor(Donor donor)
    {
        this.donor = donor;
    }
}
