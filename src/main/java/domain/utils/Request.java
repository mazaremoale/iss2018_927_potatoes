package domain.utils;

import domain.blood.Blood;
import domain.people.Patient;

import java.util.List;

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
