package blood_donation.domain.people;

import blood_donation.domain.blood.Blood;

import java.util.List;

public class Patient extends Person
{

    private List<Blood> requiredBlood;
    private List<String> antiBodies;

}
