package blood_donation.domain.blood;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.*;


@Entity
@Table(name = "Bloods")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="blood")
public class Blood
{
    private IntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty bloodType;
    private SimpleBooleanProperty isPositiveRH;
    private LocalDate lifeSpan;


    public Blood(String bloodType, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        this.bloodType = new SimpleStringProperty(bloodType);
        this.isPositiveRH = new SimpleBooleanProperty(isPositiveRH);
        this.lifeSpan = lifeSpan;
    }

    public Blood()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id.get();
    }

    public String getBloodType()
    {
        return bloodType.get();
    }

    public Boolean getIsPositiveRH()
    {
        return isPositiveRH.get();
    }

    public LocalDate getLifeSpan()
    {
        return lifeSpan;
    }

    public void setId(int id)
    {
        this.id.set(id);
    }

    public void setBloodType(String bloodType)
    {
        this.bloodType.set(bloodType);
    }

    public void setIsPositiveRH(Boolean isPositiveRH)
    {
        this.isPositiveRH.set(isPositiveRH);
    }

    public void setLifeSpan(LocalDate lifeSpan)
    {
        this.lifeSpan = lifeSpan;
    }

    @Override
    public String toString()
    {
        return this.getClass().getSimpleName() +
                "{id=" + id +
                ", type='" + bloodType + '\'' +
                ", isPositiveRH=" + isPositiveRH +
                ", lifeSpan=" + lifeSpan +
                '}';
    }
}
