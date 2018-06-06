package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Patient;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "BloodRequests")
public class BloodRequest
{
    private int id;
    private Patient patient;
    private BloodGroup bloodGroup;
    private Priority priority = Priority.LOW;
    private Hospital hospital;
    private Status status = Status.PENDING;
    private Doctor doctor;
    private List<Blood> givenBlood = new ArrayList<>();

    @FXML
    private FloatProperty quantity = new SimpleFloatProperty();

    @FXML
    private StringProperty priorityProperty = new SimpleStringProperty();

    @FXML
    private StringProperty hospitalProperty = new SimpleStringProperty();

    @FXML
    private StringProperty statusProperty = new SimpleStringProperty();


    public BloodRequest(Patient patient, BloodGroup bloodGroup, Priority priority, Hospital hospital,
                        Float quantity, Doctor doctor)
    {
        this.patient = patient;
        this.bloodGroup = bloodGroup;
        this.priority = priority;
        this.hospital = hospital;
        this.doctor = doctor;

        this.quantity.set(quantity);
        this.priorityProperty.set(priority.toString());
        this.hospitalProperty.set(hospital.toString());
        this.statusProperty.set(status.toString());
    }

    public BloodRequest()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "patientID")
    public Patient getPatient()
    {
        return patient;
    }

    public void setPatient(Patient patient)
    {
        this.patient = patient;
    }

    @Enumerated(EnumType.STRING)
    public Status getStatus()
    {
        return status;
    }

    public StringProperty statusProperty()
    {
        return statusProperty;
    }

    public void setStatus(Status status)
    {
        this.status = status;
        this.statusProperty.set(status.toString());
    }

    @OneToMany(mappedBy = "bloodRequest")
    public List<Blood> getGivenBlood()
    {
        return givenBlood;
    }

    public void setGivenBlood(List<Blood> givenBlood)
    {
        this.givenBlood = givenBlood;
    }

    @ManyToOne
    @JoinColumn(name = "bloodGroupID")
    public BloodGroup getBloodGroup() { return bloodGroup; }

    public void setBloodGroup(BloodGroup bloodGroup) { this.bloodGroup = bloodGroup; }

    public float getQuantity()
    {
        return quantity.get();
    }

    public FloatProperty quantityProperty()
    {
        return quantity;
    }

    public void setQuantity(float quantity)
    {
        this.quantity.setValue(quantity);
    }

    @Enumerated(EnumType.STRING)
    public Priority getPriority()
    {
        return priority;
    }

    public StringProperty priorityProperty()
    {
        return this.priorityProperty;
    }

    public void setPriority(Priority priority)
    {
        this.priority = priority;
        this.priorityProperty.set(priority.toString());
    }

    @ManyToOne
    @JoinColumn(name = "hospitalID")
    public Hospital getHospital()
    {
        return hospital;
    }

    public void setHospital(Hospital hospital)
    {
        this.hospital = hospital;
        this.hospitalProperty.set(hospital.toString());
    }

    public StringProperty hospitalProperty()
    {
        return hospitalProperty;
    }

    @ManyToOne
    @JoinColumn(name = "doctorID")
    public Doctor getDoctor()
    {
        return doctor;
    }

    public void setDoctor(Doctor doctor)
    {
        this.doctor = doctor;
    }

    public void process()
    {

    }
}
