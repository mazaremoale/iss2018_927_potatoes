package blood_donation.domain.blood;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDate;


@DiscriminatorValue(value = "platelet")

public class Platelet extends Blood
{
    public Platelet(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(id, type, isPositiveRH, lifeSpan);
    }
}
