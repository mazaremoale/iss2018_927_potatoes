package blood_donation.domain.utils;

import blood_donation.domain.people.Personnel;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Persons")
public class Clinic
{
    private int id;
    private Location location;
    private List<Personnel> personnelList;


}
