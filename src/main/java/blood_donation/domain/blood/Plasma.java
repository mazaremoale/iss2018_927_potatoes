package blood_donation.domain.blood;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "plasma")
public class Plasma extends Blood
{
    public Plasma(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(id, type, isPositiveRH, lifeSpan);
    }

    public Plasma()
    {

    }
}
