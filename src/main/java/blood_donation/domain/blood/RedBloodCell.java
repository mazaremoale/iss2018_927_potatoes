package blood_donation.domain.blood;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDate;

@DiscriminatorValue(value = "redbloodcell")

public class RedBloodCell extends Blood
{

    public RedBloodCell(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(id, type, isPositiveRH, lifeSpan);
    }
}
