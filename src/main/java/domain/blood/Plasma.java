package domain.blood;

import java.time.LocalDate;

public class Plasma extends Blood
{
    public Plasma(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(id, type, isPositiveRH, lifeSpan);
    }
}
