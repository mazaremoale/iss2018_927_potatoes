package blood_donation.domain.blood;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDate;

@DiscriminatorValue(value = "plasma")
public class Plasma extends Blood
{
    public Plasma(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(id, type, isPositiveRH, lifeSpan);
    }
}
