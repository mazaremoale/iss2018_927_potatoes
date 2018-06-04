package blood_donation.domain.people;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "Persons")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue(value="person")
public abstract class Person implements Serializable
{
    private IntegerProperty id = new SimpleIntegerProperty();
    private SimpleStringProperty firstName = new SimpleStringProperty();
    private SimpleStringProperty lastName = new SimpleStringProperty();
    private SimpleStringProperty username = new SimpleStringProperty();
    private SimpleStringProperty password = new SimpleStringProperty();

    Person(String firstName, String lastName, String username, String password) {
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public Person()
    {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id.get();
    }

    public String getFirstName()
    {
        return firstName.get();
    }

    public String getLastName()
    {
        return lastName.get();
    }

    public String getUsername()
    {
        return username.get();
    }

    public String getPassword()
    {
        return password.get();
    }

    public StringProperty fullNameProperty()
    {
        String fullname = this.firstName.get() + " " + this.lastName.get();
        return new SimpleStringProperty(fullname);
    }

    public void setId(int id)
    {
        this.id.set(id);
    }

    public void setFirstName(String firstName)
    {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName)
    {
        this.lastName.set(lastName);
    }

    public void setUsername(String username)
    {
        this.username.set(username);
    }

    public void setPassword(String password)
    {
        this.password.set(password);
    }

    @Override
    public String toString()
    {
        return lastName.get() + " " + firstName.get();
    }
}