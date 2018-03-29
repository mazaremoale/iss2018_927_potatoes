package blood_donation.domain.utils;

import blood_donation.domain.people.Patient;

public class Request
{
    private int id;
    private Patient patient;
    private String status = "waiting";

    public Request(Patient patient)
    {
        this.patient = patient;
    }

    public void process()
    {

    }
}
