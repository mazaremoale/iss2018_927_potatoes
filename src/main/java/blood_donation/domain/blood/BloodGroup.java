package blood_donation.domain.blood;

import javax.persistence.*;

@Entity
@Table(name = "BloodGroups")
public class BloodGroup
{
    private int id;
    private BloodTypeLetter bloodTypeLetter;
    private BloodTypeRH bloodTypeRH;

    public BloodGroup(BloodTypeLetter bloodTypeLetter, BloodTypeRH bloodTypeRH)
    {
        this.bloodTypeLetter = bloodTypeLetter;
        this.bloodTypeRH = bloodTypeRH;
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

    @Enumerated(EnumType.STRING)
    public BloodTypeRH getBloodTypeRH()
    {
        return bloodTypeRH;
    }

    public void setBloodTypeRH(BloodTypeRH bloodTypeRH)
    {
        this.bloodTypeRH = bloodTypeRH;
    }

    public boolean canBeDonatedTo(BloodGroup receivingBloodGroup)
    {
        if (bloodTypeLetter == BloodTypeLetter.O)
        {
            if (bloodTypeRH == BloodTypeRH.NEGATIVE)
                return true;
            if (receivingBloodGroup.bloodTypeRH == BloodTypeRH.POSITIVE)
                return true;
        }

        if (bloodTypeLetter == BloodTypeLetter.A)
        {
            if (receivingBloodGroup.bloodTypeLetter == BloodTypeLetter.A ||
                    receivingBloodGroup.bloodTypeLetter == BloodTypeLetter.AB)
            {
                if (bloodTypeRH == BloodTypeRH.NEGATIVE)
                    return true;
                if (receivingBloodGroup.bloodTypeRH == BloodTypeRH.POSITIVE)
                    return true;
            }
        }

        if (bloodTypeLetter == BloodTypeLetter.B)
        {
            if (receivingBloodGroup.bloodTypeLetter == BloodTypeLetter.B ||
                    receivingBloodGroup.bloodTypeLetter == BloodTypeLetter.AB)
            {
                if (bloodTypeRH == BloodTypeRH.NEGATIVE)
                    return true;
                if (receivingBloodGroup.bloodTypeRH == BloodTypeRH.POSITIVE)
                    return true;
            }
        }

        if (bloodTypeLetter == BloodTypeLetter.AB)
        {
            if (receivingBloodGroup.bloodTypeLetter == BloodTypeLetter.AB)
            {
                if (bloodTypeRH == BloodTypeRH.NEGATIVE)
                    return true;
                if (receivingBloodGroup.bloodTypeRH == BloodTypeRH.POSITIVE)
                    return true;
            }
        }

        return false;
    }

    @Override
    public String toString()
    {
        return bloodTypeLetter.toString() + (bloodTypeRH.equals(BloodTypeRH.POSITIVE) ? "+" : "-");
    }
}
