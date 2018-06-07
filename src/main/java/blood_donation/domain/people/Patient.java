package blood_donation.domain.people;


import javax.persistence.*;


@Entity
@DiscriminatorValue("patient")
public class Patient extends Person
{
    private Doctor doctor;
    private Integer age;

    public Patient(String firstName, String lastName,Integer age)
    {
        setFirstName(firstName);
        setLastName(lastName);
        setAge(age);

        this.age = age;
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

    public Integer getAge()
    {
        return age;
    }

    public void setAge(Integer age)
    {
        this.age = age;
    }

    @Override
    public String toString()
    {
        return "Patient " + getFirstName() + " " + getLastName();
    }

    //private List<Blood> requiredBlood;
    //private List<String> antibodies;
}
