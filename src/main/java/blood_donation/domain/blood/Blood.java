package blood_donation.domain.blood;

import blood_donation.domain.utils.BloodRequest;
import blood_donation.domain.utils.Donation;
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
    private IntegerProperty quantity = new SimpleIntegerProperty();
    private BloodGroup bloodGroup;
    private LocalDate lifeSpan;
    private BloodRequest bloodRequest;
    private Donation donation;


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

    public int quantityProperty()
    {
        return quantity.get();
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

    @ManyToOne
    @JoinColumn(name = "bloodRequestID")
    public BloodRequest getBloodRequest()
    {
        return bloodRequest;
    }

    public void setBloodRequest(BloodRequest bloodRequest)
    {
        this.bloodRequest = bloodRequest;
    }

    public void setDonation(Donation donation)
    {
        this.donation = donation;
    }

    @OneToOne(mappedBy = "donatedBlood")
    public Donation getDonation()
    {
        return donation;
    }

    @Override
    public String toString()
    {
        return "x" + quantity.get() + " units of " + bloodGroup;

    }
}
