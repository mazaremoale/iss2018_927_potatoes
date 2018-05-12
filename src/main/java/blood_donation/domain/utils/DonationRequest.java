package blood_donation.domain.utils;

import javax.persistence.*;

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
}
