package domain.people;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * 
 */
@Entity
@DiscriminatorValue("personnel")
public class Personnel extends Person {

    /**
     * Default constructor
     */
    public Personnel() {
    }

    //private List donorList;

}