package blood_donation.domain.blood;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.*;


@Entity
@Table(name = "Blood")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="blood")
public class Blood
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "bloodType")
    private String bloodType;

    @Column(name = "isPositiveRH")
    private Boolean isPositiveRH;

    @Column(name = "lifeSpan")
    private LocalDate lifeSpan;


    public Blood(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        this.id = id;
        this.bloodType = type;
        this.isPositiveRH = isPositiveRH;
        this.lifeSpan = lifeSpan;
    }

    public Blood()
    {
    }

    public String getType()
    {
        return bloodType;
    }

    public void setType(String type)
    {
        this.bloodType = type;
    }

    public Boolean getPositiveRH()
    {
        return isPositiveRH;
    }

    public void setPositiveRH(Boolean positiveRH)
    {
        isPositiveRH = positiveRH;
    }

    public LocalDate getLifeSpan()
    {
        return lifeSpan;
    }

    public void setLifeSpan(LocalDate lifeSpan)
    {
        this.lifeSpan = lifeSpan;
    }

    public Blood split()
    {
        return this;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString()
    {
        return "Blood{" +
                "id=" + id +
                ", type='" + bloodType + '\'' +
                ", isPositiveRH=" + isPositiveRH +
                ", lifeSpan=" + lifeSpan +
                '}';
    }
}
