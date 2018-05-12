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

import java.util.concurrent.ThreadLocalRandom;

public class Main extends Application
{

    public static Session session;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();

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
        Repository<Distance> distanceRepository = new Repository<>(Distance.class, session);





        Location location1 = new Location("Alba Iulia");
        Location location2 = new Location("Arad");
        Location location3 = new Location("Pitesti");
        Location location4 = new Location("Bacau");
        Location location5 = new Location("Oradea");
        Location location6 = new Location("Bistrita");
        Location location7 = new Location("Botosani");
        Location location8 = new Location("Brasov");
        Location location9 = new Location("Braila");
        Location location10 = new Location("Bucuresti");
        Location location11 = new Location("Buzau");
        Location location12 = new Location("Resita");
        Location location13 = new Location("Calarasi");
        Location location14 = new Location("Cluj");
        Location location15 = new Location("Constanta");
        Location location16 = new Location("Covasna");
        Location location17 = new Location("Dambovita");
        Location location18 = new Location("Dolj");
        Location location19 = new Location("Galati");
        Location location20 = new Location("Giurgiu");
        Location location21 = new Location("Gorj");
        Location location22 = new Location("Harghita");
        Location location23 = new Location("Hunedoara");
        Location location24 = new Location("Ialomita");
        Location location25 = new Location("Iasi");
        Location location26 = new Location("Ilfov");
        Location location27 = new Location("Maramures");
        Location location28 = new Location("Mehedinti");
        Location location29 = new Location("Mures");
        Location location30 = new Location("Neamt");
        Location location31 = new Location("Olt");
        Location location32 = new Location("Prahova");
        Location location33 = new Location("Satu Mare");
        Location location34 = new Location("Salaj");
        Location location35 = new Location("Sibiu");
        Location location36 = new Location("Suceava");
        Location location37 = new Location("Teleorman");
        Location location38 = new Location("Timis");
        Location location39 = new Location("Tulcea");
        Location location40 = new Location("Vaslui");
        Location location41 = new Location("Valcea");
        Location location42 = new Location("Vrancea");

        if(locationRepository.getAll().size() != 42 &&
                distanceRepository.getAll().size() != 1722) //lazy, unefficient, works fine.
        {
            locationRepository.add(location1);
            locationRepository.add(location2);
            locationRepository.add(location3);
            locationRepository.add(location4);
            locationRepository.add(location5);
            locationRepository.add(location6);
            locationRepository.add(location7);
            locationRepository.add(location8);
            locationRepository.add(location9);
            locationRepository.add(location10);
            locationRepository.add(location11);
            locationRepository.add(location12);
            locationRepository.add(location13);
            locationRepository.add(location14);
            locationRepository.add(location15);
            locationRepository.add(location16);
            locationRepository.add(location17);
            locationRepository.add(location18);
            locationRepository.add(location19);
            locationRepository.add(location20);
            locationRepository.add(location21);
            locationRepository.add(location22);
            locationRepository.add(location23);
            locationRepository.add(location24);
            locationRepository.add(location25);
            locationRepository.add(location26);
            locationRepository.add(location27);
            locationRepository.add(location28);
            locationRepository.add(location29);
            locationRepository.add(location30);
            locationRepository.add(location31);
            locationRepository.add(location32);
            locationRepository.add(location33);
            locationRepository.add(location34);
            locationRepository.add(location35);
            locationRepository.add(location36);
            locationRepository.add(location37);
            locationRepository.add(location38);
            locationRepository.add(location39);
            locationRepository.add(location40);
            locationRepository.add(location41);
            locationRepository.add(location42);

            distanceRepository.add(new Distance(location1,location2,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location3,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location4,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location5,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location6,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location7,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location8,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location9,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location10,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location11,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location12,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location13,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location14,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location15,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location16,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location17,ThreadLocalRandom.current().nextInt(50,800)));
            distanceRepository.add(new Distance(location1,location18,ThreadLocalRandom.current().nextInt(50,800)));


        }






        if(bloodGroupRepository.getAll().size() != 8)
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

