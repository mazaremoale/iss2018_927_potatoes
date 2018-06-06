package blood_donation.domain.utils;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "DonationAppointments")
public class DonationAppointment
{
    private LocalDate appointmentDate;
    private Integer appointmentTime;
    private Clinic clinic;
    private DonationRequest donationRequest;

    @FXML
    private IntegerProperty id = new SimpleIntegerProperty();

    @FXML
    private StringProperty appointmentDateProperty = new SimpleStringProperty();

    @FXML
    private StringProperty appointmentTimeProperty = new SimpleStringProperty();

    @FXML
    private StringProperty clinicProperty = new SimpleStringProperty();

    public DonationAppointment()
    {

    }

    public DonationAppointment(LocalDate appointmentDate, Integer appointmentTime, Clinic clinic)
    {
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.clinic = clinic;

        appointmentDateProperty.setValue(appointmentDate.toString());
        appointmentTimeProperty.setValue(appointmentTime.toString());
        clinicProperty.setValue(clinic.toString());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId()
    {
        return id.get();
    }

    public LocalDate getAppointmentDate()
    {
        return appointmentDate;
    }

    public Integer getAppointmentTime()
    {
        return appointmentTime;
    }

    public void setId(int id)
    {
        this.id.set(id);
    }

    public void setAppointmentDate(LocalDate appointmentDate)
    {
        this.appointmentDate = appointmentDate;
        if(appointmentDate != null)
            this.appointmentDateProperty.setValue(appointmentDate.toString());
    }

    public void setAppointmentTime(Integer appointmentTime)
    {
        this.appointmentTime = appointmentTime;
        if(appointmentTime != null)
            this.appointmentTimeProperty.setValue(appointmentTime.toString());
    }

    @OneToOne
    @JoinColumn(unique = true)
    public DonationRequest getDonationRequest()
    {
        return donationRequest;
    }

    @ManyToOne
    @JoinColumn(name = "clinicID")
    public Clinic getClinic()
    {
        return clinic;
    }

    public void setClinic(Clinic clinic)
    {
        this.clinic = clinic;
        if(clinic != null)
            this.clinicProperty.setValue(clinic.toString());
    }

    public void setDonationRequest(DonationRequest donationRequest)
    {
        this.donationRequest = donationRequest;
    }

    public StringProperty appointmentDateProperty()
    {
        return appointmentDateProperty;
    }

    public StringProperty appointmentTimeProperty()
    {
        return appointmentTimeProperty;
    }

    public StringProperty clinicProperty()
    {
        return clinicProperty;
    }

    @Override
    public String toString()
    {
        //ignore
        return String.valueOf(id.get());
    }
}
