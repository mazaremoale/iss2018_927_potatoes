package domain.blood;

import java.time.*;

public class Blood
{
    private int id;
    private String type;
    private Boolean isPositiveRH;
    private LocalDate lifeSpan;


    public Blood(int id, String type, Boolean isPositiveRH, LocalDate lifeSpan)
    {
        this.id = id;
        this.type = type;
        this.isPositiveRH = isPositiveRH;
        this.lifeSpan = lifeSpan;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public Boolean getPositiveRH()
    {
        return isPositiveRH;
    }

    public void setPositiveRH(Boolean positiveRH)
    {
        isPositiveRH = positiveRH;
    }

    public LocalDate getLifeSpan()
    {
        return lifeSpan;
    }

    public void setLifeSpan(LocalDate lifeSpan)
    {
        this.lifeSpan = lifeSpan;
    }
}
