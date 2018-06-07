package blood_donation.domain.blood;

import javafx.beans.property.FloatProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "redBloodCell")
public class RedBloodCell extends Blood
{

    public RedBloodCell(FloatProperty quantity, BloodGroup bloodGroup, LocalDate lifeSpan)
    {
        super(quantity, bloodGroup, lifeSpan);
    }

    public RedBloodCell()
    {
    }
}
