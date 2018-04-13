package blood_donation;

import blood_donation.controller.misc.UserSelectController;
import blood_donation.domain.blood.Blood;
import blood_donation.domain.blood.Plasma;
import blood_donation.domain.blood.Platelet;
import blood_donation.domain.blood.RedBloodCell;
import blood_donation.domain.people.*;
import blood_donation.domain.utils.*;
import blood_donation.repository.Repository;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Repository<Blood> bloodRepository = new Repository<>(Blood.class,session);
        Repository<Plasma> plasmaRepository = new Repository<>(Plasma.class,session);
        Repository<RedBloodCell> redBloodCellRepository = new Repository<>(RedBloodCell.class,session);
        Repository<Platelet> plateletRepository = new Repository<>(Platelet.class,session);
        Repository<Donor> donorRepository = new Repository<>(Donor.class,session);
        Repository<Doctor> doctorRepository = new Repository<>(Doctor.class,session);
        Repository<Patient> patientRepository = new Repository<>(Patient.class,session);
        Repository<Personnel> personnelRepository = new Repository<>(Personnel.class,session);
        Repository<Clinic> clinicRepository = new Repository<>(Clinic.class,session);
        Repository<Donation> donationRepository = new Repository<>(Donation.class,session);
        Repository<DonationRequest> donationRequestRepository = new Repository<>(DonationRequest.class,session);
        Repository<Hospital> hospitalRepository = new Repository<>(Hospital.class,session);
        Repository<Location> locationRepository = new Repository<>(Location.class,session);
        Repository<BloodRequest> requestRepository = new Repository<>(BloodRequest.class,session);





        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/userSelectWindow.fxml"));

        loader.setController(new UserSelectController()
                .setPrimaryStage(primaryStage)
                .setSession(session)
                .setBloodRepository(bloodRepository)
                .setPlasmaRepository(plasmaRepository)
                .setRedBloodCellRepository(redBloodCellRepository)
                .setPlateletRepository(plateletRepository)
                .setDonorRepository(donorRepository)
                .setDoctorRepository(doctorRepository)
                .setPatientRepository(patientRepository)
                .setPersonnelRepository(personnelRepository)
                .setClinicRepository(clinicRepository)
                .setDonationRepository(donationRepository)
                .setDonationRequestRepository(donationRequestRepository)
                .setHospitalRepository(hospitalRepository)
                .setLocationRepository(locationRepository)
                .setRequestRepository(requestRepository));



        Parent content = loader.load();

        Scene selectScene = new Scene(content);
        primaryStage.setScene(selectScene);
        primaryStage.setTitle("User selection");

        primaryStage.setMaximized(true);
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }





}

