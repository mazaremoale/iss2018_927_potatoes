package blood_donation.domain.blood;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import javax.persistence.*;

@Entity
@Table(name = "BloodGroups")
public class BloodGroup
{
    private int id;
    private BloodTypeLetter bloodTypeLetter;
    private BloodTypeRH bloodTypeRH;

    @FXML
    private StringProperty bloodTypeLetterProperty = new SimpleStringProperty();

    @FXML
    private StringProperty bloodTypeRHProperty = new SimpleStringProperty();

    public BloodGroup(BloodTypeLetter bloodTypeLetter, BloodTypeRH bloodTypeRH)
    {
        this.bloodTypeLetter = bloodTypeLetter;
        this.bloodTypeRH = bloodTypeRH;

        bloodTypeLetterProperty.setValue(bloodTypeLetter.toString());
        bloodTypeRHProperty.setValue(bloodTypeRH.toString());
    }

    public BloodGroup()
    {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Enumerated(EnumType.STRING)
    public BloodTypeLetter getBloodTypeLetter()
    {
        return bloodTypeLetter;
    }

    public void setBloodTypeLetter(BloodTypeLetter bloodTypeLetter)
    {
        this.bloodTypeLetter = bloodTypeLetter;
        this.bloodTypeLetterProperty.set(bloodTypeLetter.toString());
    }

    @Enumerated(EnumType.STRING)
    public BloodTypeRH getBloodTypeRH()
    {
        return bloodTypeRH;
    }

    public void setBloodTypeRH(BloodTypeRH bloodTypeRH)
    {
        this.bloodTypeRH = bloodTypeRH;
        this.bloodTypeRHProperty.set(bloodTypeRH.toString());
    }

    public StringProperty bloodTypeLetterProperty()
    {
        return bloodTypeLetterProperty;
    }

    public StringProperty bloodTypeRHProperty()
    {
        return bloodTypeRHProperty;
    }

    @Override
    public String toString()
    {
        return bloodTypeLetter.toString() + (bloodTypeRH.equals(BloodTypeRH.POSITIVE) ? "+" : "-");
    }
}
