package blood_donation.domain.people;

import blood_donation.domain.utils.Hospital;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue(value="doctor")
public class Doctor extends Person
{
    private Hospital hospital;
    private final StringProperty hospitalProperty = new SimpleStringProperty("hospital");

    public Doctor(String firstName, String lastName, String username, String password, Hospital hospital)
    {
        super(firstName, lastName, username, password);
        this.hospital = hospital;
        this.hospitalProperty.set(hospital.toString());
    }

    public Doctor(Hospital hospital)
    {
        this.hospital = hospital;
    }

    public Doctor()
    {
    }

    @ManyToOne
    @JoinColumn(name = "hospitalID")
    public Hospital getHospital()
    {
        return hospital;
    }

    public void setHospital(Hospital hospital)
    {
        this.hospital = hospital;
        //these stupid guards are hibernate's fault. (or @Andrei's)
        if(hospital != null)
            hospitalProperty.set(hospital.toString());
    }

    public StringProperty hospitalProperty()
    {
        return hospitalProperty;
    }


    @Override
    public String toString()
    {
        return "Dr." + super.toString();
    }
}