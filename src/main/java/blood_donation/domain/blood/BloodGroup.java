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
}
