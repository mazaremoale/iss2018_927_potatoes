package blood_donation.domain.blood;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "redBloodCell")
public class RedBloodCell extends Blood
{

    public RedBloodCell(String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(type, isPositiveRH, lifeSpan);
    }

    public RedBloodCell()
    {
    }
}
