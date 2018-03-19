package domain.blood;

import java.time.LocalDate;

public class RedBloodCell extends Blood
{

    public RedBloodCell(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        super(id, type, isPositiveRH, lifeSpan);
    }
}
