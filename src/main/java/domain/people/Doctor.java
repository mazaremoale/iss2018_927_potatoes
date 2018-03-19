package domain.people;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@DiscriminatorValue(value="doctor")
public class Doctor extends Person {

    /**
     * Default constructor
     */
    public Doctor() {
    }


    /**
     * 
     */
    public void request() {
        // TODO implement here
    }

    @Column(name = "score")
    private int score;


    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }

    @Override
    public String toString()
    {
        return "Doctor{" +
                "id=" + super.getId() +
                ", firstName='" + super.getFirstName() + '\'' +
                ", lastName='" + super.getLastName() + '\'' +
                '}';
    }
}