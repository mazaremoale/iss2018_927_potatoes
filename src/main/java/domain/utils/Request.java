package domain.utils;

import domain.blood.Blood;

import java.util.List;

public class Request
{
    private List<Blood> requestedItems;
    private String firstName;
    private String lastName;
    private String status;


    public Request(String firstName, String lastName)
    {

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void process()
    {

    }
}
