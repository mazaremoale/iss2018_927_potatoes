package domain.blood;

import domain.blood.Blood;

import javax.persistence.DiscriminatorValue;
import java.time.LocalDate;


@DiscriminatorValue(value = "thrombocyte")

public class Thrombocyte extends Blood
{
    public Thrombocyte(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(id, type, isPositiveRH, lifeSpan);
    }
}
