package blood_donation.domain.blood;

import javafx.beans.property.IntegerProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "plasma")
public class Plasma extends Blood
{

    public Plasma(IntegerProperty quantity, BloodGroup bloodGroup, LocalDate lifeSpan)
    {
        super(quantity, bloodGroup, lifeSpan);
    }

    public Plasma()
    {

    }

}
