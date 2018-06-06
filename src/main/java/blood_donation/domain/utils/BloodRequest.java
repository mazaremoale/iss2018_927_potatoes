package blood_donation.domain.utils;

import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.BloodGroup;
import blood_donation.domain.people.Doctor;
import blood_donation.domain.people.Patient;

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
    private Float quantity;
    private Priority priority = Priority.LOW;
    private Hospital hospital;
    private Status status = Status.PENDING;
    private Doctor doctor;
    private List<Blood> givenBlood = new ArrayList<>();

    public BloodRequest(Patient patient, BloodGroup bloodGroup, Priority priority, Hospital hospital,
                        Float quantity, Doctor doctor)
    {
        this.patient = patient;
        this.bloodGroup = bloodGroup;
        this.priority = priority;
        this.hospital = hospital;
        this.quantity = quantity;
        this.doctor = doctor;
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

    public void setStatus(Status status)
    {
        this.status = status;
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

    public Float getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Float quantity)
    {
        this.quantity = quantity;
    }

    @Enumerated(EnumType.STRING)
    public Priority getPriority()
    {
        return priority;
    }

    public void setPriority(Priority priority)
    {
        this.priority = priority;
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
