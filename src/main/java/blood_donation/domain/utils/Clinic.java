package blood_donation.domain.utils;

import blood_donation.domain.people.Personnel;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Clinics")
public class Clinic
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;


    @ManyToOne
    @JoinColumn(name = "locationID")
    private Location location;

    @OneToMany
    @JoinColumn(name = "clinicID")
    private List<Personnel> personnelList;


    public Clinic()
    {
    }


}
