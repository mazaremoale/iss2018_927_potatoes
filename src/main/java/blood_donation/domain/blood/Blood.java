package blood_donation.domain.blood;

import blood_donation.domain.utils.BloodRequest;
import blood_donation.domain.utils.Donation;
import javafx.beans.property.*;
import javafx.fxml.FXML;

import javax.persistence.*;
import java.time.*;

@Entity
@Table(name = "Bloods")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="blood")
public class Blood
{
    private final IntegerProperty id = new SimpleIntegerProperty();
    private FloatProperty quantity = new SimpleFloatProperty();
    private BloodGroup bloodGroup;
    private LocalDate expirationDate;
    private BloodRequest bloodRequest;
    private Donation donation;

    private Boolean isReadyForUse;

    @FXML
    private final StringProperty bloodGroupProperty = new SimpleStringProperty();

    @FXML
    private final StringProperty expirationDateProperty = new SimpleStringProperty();


    public Blood(FloatProperty quantity, BloodGroup bloodGroup, LocalDate expirationDate)
    {
        this.quantity = quantity;
        this.bloodGroup = bloodGroup;
        this.expirationDate = expirationDate;

        bloodGroupProperty.setValue(bloodGroup.toString());
        expirationDateProperty.setValue(expirationDate.toString());
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



    public LocalDate getExpirationDate()
    {
        if(expirationDate != null)
            return expirationDate;
        return null;
    }

    public void setId(int id)
    {
        this.id.set(id);
    }


    public void setExpirationDate(LocalDate expirationDate)
    {
        if(this.expirationDate != null)
            this.expirationDate = expirationDate;
        if(expirationDate != null)
            this.expirationDateProperty.setValue(expirationDate.toString());
    }

    public StringProperty expirationDateProperty()
    {
        return expirationDateProperty;
    }

    public float getQuantity()
    {
        return quantity.get();
    }

    public FloatProperty quantityProperty()
    {
        return quantity;
    }

    public void setQuantity(float quantity)
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
        if(bloodGroup != null)
            this.bloodGroupProperty.setValue(bloodGroup.toString());
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

    public StringProperty bloodGroupProperty()
    {
        return bloodGroupProperty;
    }

    public Boolean getReadyForUse()
    {
        return isReadyForUse;
    }

    public void setReadyForUse(Boolean readyForUse)
    {
        isReadyForUse = readyForUse;
    }

    @Override
    public String toString()
    {
        return "x" + quantity.get() + " units of " + bloodGroup;

    }
}
