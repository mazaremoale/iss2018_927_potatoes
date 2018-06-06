package blood_donation.domain.blood;

import javafx.beans.property.FloatProperty;
import javafx.beans.property.IntegerProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "platelet")
public class Platelet extends Blood
{
    public Platelet(FloatProperty quantity, BloodGroup bloodGroup, LocalDate lifeSpan)
    {
        super(quantity, bloodGroup, lifeSpan);
    }

    public Platelet()
    {
    }
}
