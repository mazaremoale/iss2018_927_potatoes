package blood_donation.domain.people;


import javax.persistence.*;


@Entity
@DiscriminatorValue("patient")
public class Patient extends Person
{
    private Doctor doctor;

    public Patient(String firstName, String lastName, String username, String password)
    {
        super(firstName, lastName, username, password);
    }

    public Patient()
    {
    }

    @ManyToOne
    @JoinColumn(name = "doctorID")
    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    //private List<Blood> requiredBlood;
    //private List<String> antibodies;
}
