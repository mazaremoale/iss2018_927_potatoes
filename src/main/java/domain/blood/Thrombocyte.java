package domain.blood;

import domain.blood.Blood;

import java.time.LocalDate;

public class Thrombocyte extends Blood
{
    public Thrombocyte(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(id, type, isPositiveRH, lifeSpan);
    }
}
