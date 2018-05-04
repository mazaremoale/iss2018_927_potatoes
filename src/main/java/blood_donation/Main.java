package blood_donation;

import blood_donation.controller.misc.UserSelectWindowController;
import blood_donation.domain.blood.*;
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

        Repository<Blood> bloodRepository = new Repository<>(Blood.class, session);
        Repository<Plasma> plasmaRepository = new Repository<>(Plasma.class, session);
        Repository<RedBloodCell> redBloodCellRepository = new Repository<>(RedBloodCell.class, session);
        Repository<Platelet> plateletRepository = new Repository<>(Platelet.class, session);
        Repository<Donor> donorRepository = new Repository<>(Donor.class, session);
        Repository<Doctor> doctorRepository = new Repository<>(Doctor.class, session);
        Repository<Patient> patientRepository = new Repository<>(Patient.class, session);
        Repository<Personnel> personnelRepository = new Repository<>(Personnel.class, session);
        Repository<Clinic> clinicRepository = new Repository<>(Clinic.class, session);
        Repository<Donation> donationRepository = new Repository<>(Donation.class, session);
        Repository<DonationRequest> donationRequestRepository = new Repository<>(DonationRequest.class, session);
        Repository<Hospital> hospitalRepository = new Repository<>(Hospital.class, session);
        Repository<Location> locationRepository = new Repository<>(Location.class, session);
        Repository<BloodRequest> requestRepository = new Repository<>(BloodRequest.class, session);
        Repository<BloodGroup> bloodGroupRepository = new Repository<>(BloodGroup.class, session);






        if(locationRepository.getAll().isEmpty()) //lazy, unefficient, works nonetheless.
        {
            locationRepository.add(new Location("Alba Iulia"));
            locationRepository.add(new Location("Arad"));
            locationRepository.add(new Location("Pitesti"));
            locationRepository.add(new Location("Bacau"));
            locationRepository.add(new Location("Oradea"));
            locationRepository.add(new Location("Bistrita"));
            locationRepository.add(new Location("Botosani"));
            locationRepository.add(new Location("Brasov"));
            locationRepository.add(new Location("Braila"));
            locationRepository.add(new Location("Bucuresti"));
            locationRepository.add(new Location("Buzau"));
            locationRepository.add(new Location("Resita"));
            locationRepository.add(new Location("Calarasi"));
            locationRepository.add(new Location("Cluj"));
            locationRepository.add(new Location("Constanta"));
            locationRepository.add(new Location("Covasna"));
            locationRepository.add(new Location("Dambovita"));
            locationRepository.add(new Location("Dolj"));
            locationRepository.add(new Location("Galati"));
            locationRepository.add(new Location("Giurgiu"));
            locationRepository.add(new Location("Gorj"));
            locationRepository.add(new Location("Harghita"));
            locationRepository.add(new Location("Hunedoara"));
            locationRepository.add(new Location("Ialomita"));
            locationRepository.add(new Location("Iasi"));
            locationRepository.add(new Location("Ilfov"));
            locationRepository.add(new Location("Maramures"));
            locationRepository.add(new Location("Mehedinti"));
            locationRepository.add(new Location("Mures"));
            locationRepository.add(new Location("Neamt"));
            locationRepository.add(new Location("Olt"));
            locationRepository.add(new Location("Prahova"));
            locationRepository.add(new Location("Satu Mare"));
            locationRepository.add(new Location("Salaj"));
            locationRepository.add(new Location("Sibiu"));
            locationRepository.add(new Location("Suceava"));
            locationRepository.add(new Location("Teleorman"));
            locationRepository.add(new Location("Timis"));
            locationRepository.add(new Location("Tulcea"));
            locationRepository.add(new Location("Vaslui"));
            locationRepository.add(new Location("Valcea"));
            locationRepository.add(new Location("Vrancea"));

        }


        if(bloodGroupRepository.getAll().isEmpty()) 
            //same as above. also, are these enums clever enough to warrant using them? idk.
        {
            bloodGroupRepository.add(new BloodGroup(BloodTypeLetter.A, BloodTypeRH.POSITIVE));
            bloodGroupRepository.add(new BloodGroup(BloodTypeLetter.A, BloodTypeRH.NEGATIVE));
            bloodGroupRepository.add(new BloodGroup(BloodTypeLetter.B, BloodTypeRH.POSITIVE));
            bloodGroupRepository.add(new BloodGroup(BloodTypeLetter.B, BloodTypeRH.NEGATIVE));
            bloodGroupRepository.add(new BloodGroup(BloodTypeLetter.AB, BloodTypeRH.POSITIVE));
            bloodGroupRepository.add(new BloodGroup(BloodTypeLetter.AB, BloodTypeRH.NEGATIVE));
            bloodGroupRepository.add(new BloodGroup(BloodTypeLetter.O, BloodTypeRH.POSITIVE));
            bloodGroupRepository.add(new BloodGroup(BloodTypeLetter.O, BloodTypeRH.NEGATIVE));
        }






        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/fxml/userSelectWindow.fxml"));

        loader.setController(new UserSelectWindowController()
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

        primaryStage.show();


    }

    public static void main(String[] args)
    {
        launch(args);
    }





}

