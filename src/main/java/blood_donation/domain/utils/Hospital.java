package blood_donation.domain.utils;

import blood_donation.domain.people.Doctor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Hospitals")
public class Hospital
{
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="Location_ID")
    private Location location;

    public Hospital()
    {
    }
    //private List<Doctor> doctorList;
}
