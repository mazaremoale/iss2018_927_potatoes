package blood_donation.domain.blood;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

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
    private IntegerProperty quantity;
    private BloodGroup bloodGroup;
    private LocalDate lifeSpan;

    public Blood(IntegerProperty quantity, BloodGroup bloodGroup, LocalDate lifeSpan)
    {
        this.quantity = quantity;
        this.bloodGroup = bloodGroup;
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



    public LocalDate getLifeSpan()
    {
        if(lifeSpan != null)
            return lifeSpan;
        return null;
    }

    public void setId(int id)
    {
        this.id.set(id);
    }


    public void setLifeSpan(LocalDate lifeSpan)
    {
        if(this.lifeSpan != null)
            this.lifeSpan = lifeSpan;
    }

    public int getQuantity()
    {
        return quantity.get();
    }

    public IntegerProperty quantityProperty()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity.set(quantity);
    }

    @ManyToOne
    @JoinColumn(name = "bloodGroupID")
    public BloodGroup getBloodGroup()
    {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup)
    {
        this.bloodGroup = bloodGroup;
    }

    @Override
    public String toString()
    {
        return "Blood{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", bloodGroup=" + bloodGroup +
                ", lifeSpan=" + lifeSpan +
                '}';
    }
}
