package org.example.automarket24backend;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.bodyType.BodyType;
import org.example.automarket24backend.bodyType.BodyTypeRepository;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.car.CarRepository;
import org.example.automarket24backend.color.Color;
import org.example.automarket24backend.color.ColorRepository;
import org.example.automarket24backend.condition.Condition;
import org.example.automarket24backend.condition.ConditionRepository;
import org.example.automarket24backend.damageType.DamageType;
import org.example.automarket24backend.damageType.DamageTypeRepository;
import org.example.automarket24backend.drivetrain.Drivetrain;
import org.example.automarket24backend.drivetrain.DrivetrainRepository;
import org.example.automarket24backend.feature.Feature;
import org.example.automarket24backend.feature.FeatureRepository;
import org.example.automarket24backend.fuelType.FuelType;
import org.example.automarket24backend.fuelType.FuelTypeRepository;
import org.example.automarket24backend.generation.Generation;
import org.example.automarket24backend.generation.GenerationRepository;
import org.example.automarket24backend.make.Make;
import org.example.automarket24backend.make.MakeRepository;
import org.example.automarket24backend.model.Model;
import org.example.automarket24backend.model.ModelRepository;
import org.example.automarket24backend.offer.Offer;
import org.example.automarket24backend.offer.OfferRepository;
import org.example.automarket24backend.photo.Photo;
import org.example.automarket24backend.photo.PhotoRepository;
import org.example.automarket24backend.statusType.StatusType;
import org.example.automarket24backend.statusType.StatusTypeRepository;
import org.example.automarket24backend.transmission.Transmission;
import org.example.automarket24backend.transmission.TransmissionRepository;
import org.example.automarket24backend.user.User;
import org.example.automarket24backend.user.UserRepository;
import org.example.automarket24backend.userType.UserType;
import org.example.automarket24backend.userType.UserTypeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private ColorRepository colorRepository;
    private BodyTypeRepository bodyTypeRepository;
    private ConditionRepository conditionRepository;
    private DamageTypeRepository damageTypeRepository;
    private DrivetrainRepository drivetrainRepository;
    private FuelTypeRepository fuelTypeRepository;
    private TransmissionRepository transmissionRepository;
    private UserTypeRepository userTypeRepository;
    private StatusTypeRepository statusTypeRepository;
    private UserRepository userRepository;
    private FeatureRepository featureRepository;
    private MakeRepository makeRepository;
    private ModelRepository modelRepository;
    private GenerationRepository generationRepository;
    private CarRepository carRepository;
    private OfferRepository offerRepository;
    private PhotoRepository photoRepository;

    @Override
    public void run(String... args) {

        Color black = new Color();
        black.setName("Black");
        Color white = new Color();
        white.setName("White");
        Color red = new Color();
        red.setName("Red");
        Color green = new Color();
        green.setName("Green");
        Color orange = new Color();
        orange.setName("Orange");
        Color yellow = new Color();
        yellow.setName("Yellow");
        Color gold = new Color();
        gold.setName("Gold");
        Color silver = new Color();
        silver.setName("Silver");
        Color grey = new Color();
        grey.setName("Grey");
        Color beige = new Color();
        beige.setName("Beige");
        Color blue = new Color();
        blue.setName("Blue");
        Color purple = new Color();
        purple.setName("Purple");

        List<Color> colors = List.of(
                black, white, red, green, orange,
                yellow, gold, silver, grey, blue, purple
        );
        colorRepository.saveAll(colors);

        BodyType sedan = new BodyType();
        sedan.setName("Sedan");
        BodyType suv = new BodyType();
        suv.setName("Suv");
        BodyType compact = new BodyType();
        compact.setName("Compact");
        BodyType pickUp = new BodyType();
        pickUp.setName("Pick-up");
        BodyType van = new BodyType();
        van.setName("Van");
        BodyType stationWagon = new BodyType();
        stationWagon.setName("Station wagon");
        BodyType cabriolet = new BodyType();
        cabriolet.setName("Cabriolet");
        BodyType coupe = new BodyType();
        coupe.setName("Coupe");

        List<BodyType> bodyTypes = List.of(
                sedan, suv, compact, pickUp, van,
                stationWagon, cabriolet, coupe
        );
        bodyTypeRepository.saveAll(bodyTypes);

        Condition newCondition = new Condition();
        newCondition.setName("New");
        Condition used = new Condition();
        used.setName("Used");

        List<Condition> conditions = List.of(
                newCondition, used
        );
        conditionRepository.saveAll(conditions);

        DamageType damaged = new DamageType();
        damaged.setName("Damaged");
        DamageType notDamaged = new DamageType();
        notDamaged.setName("Not damaged");

        List<DamageType> damageTypes = List.of(
                damaged, notDamaged
        );

        damageTypeRepository.saveAll(damageTypes);

        Transmission automatic = new Transmission();
        automatic.setName("Automatic");
        Transmission semiAutomatic = new Transmission();
        semiAutomatic.setName("Semi- automatic");
        Transmission manual = new Transmission();
        manual.setName("Manual");

        List<Transmission> transmissions = List.of(
                automatic, semiAutomatic, manual
        );
        transmissionRepository.saveAll(transmissions);

        FuelType petrol = new FuelType();
        petrol.setName("Petrol");
        FuelType diesel = new FuelType();
        diesel.setName("Diesel");
        FuelType lpg = new FuelType();
        lpg.setName("LPG");
        FuelType cng = new FuelType();
        cng.setName("CNG");
        FuelType hybrid = new FuelType();
        hybrid.setName("Hybrid");
        FuelType electric = new FuelType();
        electric.setName("Electric");

        List<FuelType> fuelTypes = List.of(
                petrol, diesel, lpg, cng, hybrid, electric
        );
        fuelTypeRepository.saveAll(fuelTypes);

        Drivetrain fwd = new Drivetrain();
        fwd.setName("FWD");
        Drivetrain rwd = new Drivetrain();
        rwd.setName("RWD");
        Drivetrain awd = new Drivetrain();
        awd.setName("AWD");

        List<Drivetrain> drivetrains = List.of(
                fwd, rwd, awd
        );
        drivetrainRepository.saveAll(drivetrains);

        UserType admin = new UserType();
        admin.setName("Admin");
        UserType privateUser = new UserType();
        privateUser.setName("Private");
        UserType dealer = new UserType();
        dealer.setName("Dealer");

        List<UserType> userTypes = List.of(
                admin, privateUser, dealer
        );
        userTypeRepository.saveAll(userTypes);

        StatusType active = new StatusType();
        active.setName("Active");
        StatusType blocked = new StatusType();
        blocked.setName("Blocked");

        List<StatusType> statusTypes = List.of(
                active, blocked
        );
        statusTypeRepository.saveAll(statusTypes);

        User user1 = new User();
        user1.setEmail("user1@email.com");
        user1.setPassword("password");
        user1.setPhoneNumber("123123123");
        user1.setStatusType(active);
        user1.setUserType(admin);

        User user2 = new User();
        user2.setEmail("user2@email.com");
        user2.setPassword("password");
        user2.setPhoneNumber("111222333");
        user2.setStatusType(active);
        user2.setUserType(privateUser);
        user2.setLocation("Warszawa");

        User user3 = new User();
        user3.setEmail("user3@email.com");
        user3.setPassword("password");
        user3.setPhoneNumber("234234234");
        user3.setStatusType(active);
        user3.setUserType(privateUser);
        user3.setLocation("Kraków");

        User user4 = new User();
        user4.setEmail("user4@email.com");
        user4.setPassword("password");
        user4.setPhoneNumber("231231321");
        user4.setStatusType(active);
        user4.setUserType(privateUser);

        List<User> users = List.of(
                user1, user2, user3, user4
        );
        userRepository.saveAll(users);

        Feature abs = new Feature();
        abs.setName("ABS");
        Feature esp = new Feature();
        esp.setName("ESP");
        Feature frontParkingSensors = new Feature();
        frontParkingSensors.setName("Front parking sensors");
        Feature rearParkingSensors = new Feature();
        rearParkingSensors.setName("Rear parking sensors");
        Feature camera = new Feature();
        camera.setName("Camera");
        Feature camera360 = new Feature();
        camera360.setName("Camera 360");
        Feature radio = new Feature();
        radio.setName("Radio");
        Feature centralLocking = new Feature();
        centralLocking.setName("Central locking");
        Feature androidAuto = new Feature();
        androidAuto.setName("Android Auto");
        Feature appleCarPlay = new Feature();
        appleCarPlay.setName("Apple CarPlay");
        Feature blindSpotAssist = new Feature();
        blindSpotAssist.setName("Blind spot assist");
        Feature automaticAirConditioning = new Feature();
        automaticAirConditioning.setName("Automatic air conditiong");
        Feature manualAirConditioning = new Feature();
        manualAirConditioning.setName("Manual air conditioning");

        List<Feature> features = List.of(
                abs, esp, frontParkingSensors, rearParkingSensors,
                camera, camera360, radio, centralLocking, androidAuto,
                appleCarPlay, blindSpotAssist, automaticAirConditioning,
                manualAirConditioning
        );
        featureRepository.saveAll(features);

        Make alfaRomeo = new Make();
        alfaRomeo.setName("Alfa Romeo");
        Make audi = new Make();
        audi.setName("Audi");
        Make bmw = new Make();
        bmw.setName("BMW");
        Make citroen = new Make();
        citroen.setName("Citroen");
        Make ford = new Make();
        ford.setName("Ford");
        Make honda = new Make();
        honda.setName("Honda");
        Make mercedesBenz = new Make();
        mercedesBenz.setName("Mercedes-Benz");

        List<Make> makes = List.of(
                alfaRomeo, audi, bmw, citroen, ford,
                honda, mercedesBenz
        );
        makeRepository.saveAll(makes);

        Model ar159 = new Model();
        ar159.setMake(alfaRomeo);
        ar159.setName("159");
        Model ar146 = new Model();
        ar146.setMake(alfaRomeo);
        ar146.setName("146");
        Model gulia = new Model();
        gulia.setMake(alfaRomeo);
        gulia.setName("Gulia");
        Model a4 = new Model();
        a4.setMake(audi);
        a4.setName("A4");
        Model a6 = new Model();
        a6.setMake(audi);
        a6.setName("A6");
        Model a8 = new Model();
        a8.setMake(audi);
        a8.setName("A8");
        Model series3 = new Model();
        series3.setMake(bmw);
        series3.setName("3 Series");
        Model series5 = new Model();
        series5.setMake(bmw);
        series5.setName("5 Series");
        Model series7 = new Model();
        series7.setMake(bmw);
        series7.setName("7 Series");
        Model c3 = new Model();
        c3.setMake(citroen);
        c3.setName("C3");
        Model c4 = new Model();
        c4.setMake(citroen);
        c4.setName("C4");
        Model c5 = new Model();
        c5.setMake(citroen);
        c5.setName("C5");
        Model fiesta = new Model();
        fiesta.setMake(ford);
        fiesta.setName("Fiesta");
        Model focus = new Model();
        focus.setMake(ford);
        focus.setName("Focus");
        Model mondeo = new Model();
        mondeo.setMake(ford);
        mondeo.setName("Mondeo");
        Model civic = new Model();
        civic.setMake(honda);
        civic.setName("Civic");
        Model accord = new Model();
        accord.setMake(honda);
        accord.setName("Accord");
        Model crv = new Model();
        crv.setMake(honda);
        crv.setName("CR-V");
        Model cClass = new Model();
        cClass.setMake(mercedesBenz);
        cClass.setName("C-Class");
        Model eClass = new Model();
        eClass.setMake(mercedesBenz);
        eClass.setName("E-Class");
        Model sClass = new Model();
        sClass.setMake(mercedesBenz);
        sClass.setName("S-Class");

        List<Model> models = List.of(
                ar159, ar146, gulia, a4, a6, a8,series3, series5,
                series7, c3, c4, c5, fiesta, focus, mondeo, civic,
                accord, crv, cClass, eClass, sClass
        );
        modelRepository.saveAll(models);

        Generation e46 = new Generation();
        e46.setModel(series3);
        e46.setName("E46");
        Generation e90 = new Generation();
        e90.setModel(series3);
        e90.setName("E90");
        Generation f30 = new Generation();
        f30.setModel(series3);
        f30.setName("F30");
        Generation mk3 = new Generation();
        mk3.setModel(mondeo);
        mk3.setName("Mk3");
        Generation mk4 = new Generation();
        mk4.setModel(mondeo);
        mk4.setName("Mk4");
        Generation mk5 = new Generation();
        mk5.setModel(mondeo);
        mk5.setName("Mk5");
        Generation w203 = new Generation();
        w203.setModel(cClass);
        w203.setName("W203");
        Generation w204 = new Generation();
        w204.setModel(cClass);
        w204.setName("W204");
        Generation w205 = new Generation();
        w205.setModel(cClass);
        w205.setName("W205");

        List<Generation> generations = List.of(
                e46, e90, f30, mk3, mk4, mk5, w203,
                w204, w205
        );
        generationRepository.saveAll(generations);

        Offer offer1 = new Offer();
        offer1.setUser(user2);
        offer1.setPrice(25000);
        offer1.setDescription("Good car.");

        Offer offer2 = new Offer();
        offer2.setUser(user3);
        offer2.setPrice(90000);
        offer2.setDescription("Very good car.");

        List<Offer> offers = List.of(
                offer1, offer2
        );
        offerRepository.saveAll(offers);

        List<Feature> car1Features = List.of(
                abs, esp, rearParkingSensors, radio, automaticAirConditioning
        );
        Car car1 = new Car();
        car1.setBodyType(sedan);
        car1.setColor(black);
        car1.setProductionYear(2008);
        car1.setDoors(4);
        car1.setSeats(5);
        car1.setMileage(250000);
        car1.setEngineSize(3000);
        car1.setPower(250);
        car1.setTransmission(automatic);
        car1.setFuelType(petrol);
        car1.setDrivetrain(rwd);
        car1.setMake(bmw);
        car1.setModel(series3);
        car1.setGeneration(e90);
        car1.setDamageType(notDamaged);
        car1.setCondition(used);
        car1.setFeatures(car1Features);
        car1.setOffer(offer1);
        List<Feature> car2Features = List.of(
                abs, esp, rearParkingSensors, frontParkingSensors, radio, automaticAirConditioning
        );
        Car car2 = new Car();
        car2.setBodyType(sedan);
        car2.setColor(black);
        car2.setProductionYear(2016);
        car2.setDoors(4);
        car2.setSeats(5);
        car2.setMileage(150000);
        car2.setEngineSize(2000);
        car2.setPower(220);
        car2.setTransmission(automatic);
        car2.setFuelType(diesel);
        car2.setDrivetrain(rwd);
        car2.setMake(mercedesBenz);
        car2.setModel(cClass);
        car2.setGeneration(w205);
        car2.setDamageType(notDamaged);
        car2.setCondition(used);
        car2.setFeatures(car2Features);
        car2.setOffer(offer2);

        List<Car> cars = List.of(
                car1, car2
        );
        carRepository.saveAll(cars);

        Photo photo1 = new Photo();
        photo1.setPath("p1");
        photo1.setCar(car1);
        Photo photo2 = new Photo();
        photo2.setPath("p2");
        photo2.setCar(car1);
        Photo photo3 = new Photo();
        photo3.setPath("p3");
        photo3.setCar(car2);
        Photo photo4 = new Photo();
        photo4.setPath("p4");
        photo4.setCar(car2);

        List<Photo> photos = List.of(
                photo1, photo2, photo3, photo4
        );
        photoRepository.saveAll(photos);

        List<Offer> user2Observed = List.of(
                offer2
        );
        user2.setObserved(user2Observed);
        List<Offer> user4Observed = List.of(
                offer1, offer2
        );
        user4.setObserved(user4Observed);

        List<User> userObserved = List.of(
                user2, user4
        );
        userRepository.saveAll(userObserved);
    }
}
