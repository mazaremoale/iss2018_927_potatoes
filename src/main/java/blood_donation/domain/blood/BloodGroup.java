package blood_donation.domain.blood;

import javax.persistence.*;

@Entity
@Table(name = "BloodGroups")
public class BloodGroup
{

    private int id;
    private BloodTypeLetter bloodTypeLetter;
    private Boolean isPositiveRH;



    public BloodGroup(BloodTypeLetter bloodTypeLetter, Boolean isPositiveRH)
    {
        this.bloodTypeLetter = bloodTypeLetter;
        this.isPositiveRH = isPositiveRH;
    }

    public BloodGroup()
    {
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

    @Enumerated(EnumType.STRING)
    public BloodTypeLetter getBloodTypeLetter()
    {
        return bloodTypeLetter;
    }

    public void setBloodTypeLetter(BloodTypeLetter bloodTypeLetter)
    {
        this.bloodTypeLetter = bloodTypeLetter;
    }

    public Boolean isPositiveRH()
    {
        return isPositiveRH;
    }

    public void setPositiveRH(Boolean positiveRH)
    {
        isPositiveRH = positiveRH;
    }

    @Override
    public String toString()
    {
        return bloodTypeLetter.toString() + isPositiveRH;
    }
}
