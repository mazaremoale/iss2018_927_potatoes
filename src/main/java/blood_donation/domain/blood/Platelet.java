package blood_donation.domain.blood;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "platelet")
public class Platelet extends Blood
{
    public Platelet(String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(type, isPositiveRH, lifeSpan);
    }

    public Platelet()
    {
    }
}
