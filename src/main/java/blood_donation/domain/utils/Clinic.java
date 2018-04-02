package blood_donation.domain.utils;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Clinics")
public class Clinic
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    //private Location location;
    //private List<Personnel> personnelList;


    public Clinic()
    {
    }
}
