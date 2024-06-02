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
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

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
    private PasswordEncoder passwordEncoder;

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

        colorRepository.saveAll(Set.of(
                black, white, red, green, orange, beige,
                yellow, gold, silver, grey, blue, purple
        ));

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

        bodyTypeRepository.saveAll(Set.of(
                sedan, suv, compact, pickUp, van,
                stationWagon, cabriolet, coupe
        ));

        Condition newCondition = new Condition();
        newCondition.setName("New");
        Condition used = new Condition();
        used.setName("Used");

        conditionRepository.saveAll(Set.of(newCondition, used));

        DamageType damaged = new DamageType();
        damaged.setName("Damaged");
        DamageType notDamaged = new DamageType();
        notDamaged.setName("Not damaged");

        damageTypeRepository.saveAll(Set.of(damaged, notDamaged));

        Transmission automatic = new Transmission();
        automatic.setName("Automatic");
        Transmission semiAutomatic = new Transmission();
        semiAutomatic.setName("Semi-automatic");
        Transmission manual = new Transmission();
        manual.setName("Manual");

        transmissionRepository.saveAll(Set.of(automatic, semiAutomatic, manual));

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

        fuelTypeRepository.saveAll(Set.of(petrol, diesel, lpg, cng, hybrid, electric));

        Drivetrain fwd = new Drivetrain();
        fwd.setName("FWD");
        Drivetrain rwd = new Drivetrain();
        rwd.setName("RWD");
        Drivetrain awd = new Drivetrain();
        awd.setName("AWD");

        drivetrainRepository.saveAll(Set.of(fwd, rwd, awd));

        UserType admin = new UserType();
        admin.setName("Admin");
        UserType privateUser = new UserType();
        privateUser.setName("Private");
        UserType dealer = new UserType();
        dealer.setName("Dealer");

        userTypeRepository.saveAll(Set.of(admin, privateUser, dealer));

        StatusType active = new StatusType();
        active.setName("Active");
        StatusType blocked = new StatusType();
        blocked.setName("Blocked");

        statusTypeRepository.saveAll(Set.of(active, blocked));

        User user1 = new User();
        user1.setEmail("user1@email.com");
        user1.setPassword(passwordEncoder.encode("password"));
        user1.setPhoneNumber("123123123");
        user1.setStatusType(active);
        user1.setUserType(admin);
        user1.setLocation("Opole");

        User user2 = new User();
        user2.setEmail("user2@email.com");
        user2.setPassword(passwordEncoder.encode("password"));
        user2.setPhoneNumber("111222333");
        user2.setStatusType(active);
        user2.setUserType(privateUser);
        user2.setLocation("Warszawa");

        User user3 = new User();
        user3.setEmail("user3@email.com");
        user3.setPassword(passwordEncoder.encode("password"));
        user3.setPhoneNumber("234234234");
        user3.setStatusType(active);
        user3.setUserType(privateUser);
        user3.setLocation("Kraków");

        User user4 = new User();
        user4.setEmail("user4@email.com");
        user4.setPassword(passwordEncoder.encode("password"));
        user4.setPhoneNumber("231231321");
        user4.setStatusType(active);
        user4.setUserType(privateUser);
        user4.setLocation("Opole");

        User user5 = new User();
        user5.setEmail("user5@email.com");
        user5.setPassword(passwordEncoder.encode("password"));
        user5.setPhoneNumber("545323121");
        user5.setStatusType(active);
        user5.setUserType(privateUser);
        user5.setLocation("Wrocław");

        userRepository.saveAll(Set.of(user1, user2, user3, user4, user5));

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

        featureRepository.saveAll(Set.of(
                abs, esp, frontParkingSensors, rearParkingSensors,
                camera, camera360, radio, centralLocking, androidAuto,
                appleCarPlay, blindSpotAssist, automaticAirConditioning,
                manualAirConditioning
        ));

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

        makeRepository.saveAll(Set.of(
                alfaRomeo, audi, bmw, citroen, ford,
                honda, mercedesBenz
        ));

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

        modelRepository.saveAll(Set.of(
                ar159, ar146, gulia, a4, a6, a8,series3, series5,
                series7, c3, c4, c5, fiesta, focus, mondeo, civic,
                accord, crv, cClass, eClass, sClass
        ));

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

        generationRepository.saveAll(Set.of(e46, e90, f30, mk3, mk4, mk5, w203, w204, w205));

        Offer offer1 = new Offer();
        offer1.setUser(user2);
        offer1.setPrice(25000);
        offer1.setDescription("Good car.");

        Offer offer2 = new Offer();
        offer2.setUser(user3);
        offer2.setPrice(90000);
        offer2.setDescription("Very good car.");

        Offer offer3 = new Offer();
        offer3.setUser(user5);
        offer3.setPrice(10000);
        offer3.setDescription("Cool and good car.");

        Offer offer4 = new Offer();
        offer4.setUser(user4);
        offer4.setPrice(35000);
        offer4.setDescription("Fast car.");

        Offer offer5 = new Offer();
        offer5.setUser(user1);
        offer5.setPrice(20000);
        offer5.setDescription("Cheap car.");

        Offer offer6 = new Offer();
        offer6.setUser(user4);
        offer6.setPrice(60000);
        offer6.setDescription("Big car.");

        Offer offer7 = new Offer();
        offer7.setUser(user4);
        offer7.setPrice(120000);
        offer7.setDescription("Nice car.");

        Offer offer8 = new Offer();
        offer8.setUser(user4);
        offer8.setPrice(5000);
        offer8.setDescription("Cool car.");

        offerRepository.saveAll(Set.of(offer1, offer2, offer3, offer4, offer5, offer6, offer7, offer8));

        Set<Feature> car1Features = Set.of(
                abs, esp, rearParkingSensors, radio,
                automaticAirConditioning
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
        Set<Feature> car2Features = Set.of(
                abs, esp, rearParkingSensors, frontParkingSensors,
                radio, automaticAirConditioning
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
        Set<Feature> car3Features = Set.of(
                abs, esp, rearParkingSensors,
                radio, automaticAirConditioning
        );
        Car car3 = new Car();
        car3.setBodyType(stationWagon);
        car3.setColor(beige);
        car3.setProductionYear(2013);
        car3.setDoors(4);
        car3.setSeats(5);
        car3.setMileage(180000);
        car3.setEngineSize(2000);
        car3.setPower(200);
        car3.setTransmission(manual);
        car3.setFuelType(petrol);
        car3.setDrivetrain(fwd);
        car3.setMake(ford);
        car3.setModel(mondeo);
        car3.setGeneration(mk4);
        car3.setDamageType(notDamaged);
        car3.setCondition(used);
        car3.setFeatures(car3Features);
        car3.setOffer(offer3);
        Set<Feature> car4Features = Set.of(
                abs, esp, radio, automaticAirConditioning
        );
        Car car4 = new Car();
        car4.setBodyType(compact);
        car4.setColor(green);
        car4.setProductionYear(2008);
        car4.setDoors(5);
        car4.setSeats(5);
        car4.setMileage(250000);
        car4.setEngineSize(1400);
        car4.setPower(120);
        car4.setTransmission(manual);
        car4.setFuelType(lpg);
        car4.setDrivetrain(fwd);
        car4.setMake(ford);
        car4.setModel(focus);
        car4.setGeneration(null);
        car4.setDamageType(notDamaged);
        car4.setCondition(used);
        car4.setFeatures(car4Features);
        car4.setOffer(offer4);
        Set<Feature> car5Features = Set.of(
                abs, esp, rearParkingSensors, frontParkingSensors,
                radio, automaticAirConditioning
        );
        Car car5 = new Car();
        car5.setBodyType(compact);
        car5.setColor(green);
        car5.setProductionYear(2012);
        car5.setDoors(4);
        car5.setSeats(5);
        car5.setMileage(350000);
        car5.setEngineSize(1750);
        car5.setPower(200);
        car5.setTransmission(manual);
        car5.setFuelType(petrol);
        car5.setDrivetrain(fwd);
        car5.setMake(alfaRomeo);
        car5.setModel(ar159);
        car5.setGeneration(null);
        car5.setDamageType(notDamaged);
        car5.setCondition(used);
        car5.setFeatures(car5Features);
        car5.setOffer(offer5);
        Set<Feature> car6Features = Set.of(
                abs, esp, rearParkingSensors, frontParkingSensors,
                radio, automaticAirConditioning
        );
        Car car6 = new Car();
        car6.setBodyType(sedan);
        car6.setColor(green);
        car6.setProductionYear(2016);
        car6.setDoors(4);
        car6.setSeats(5);
        car6.setMileage(10000);
        car6.setEngineSize(3000);
        car6.setPower(250);
        car6.setTransmission(automatic);
        car6.setFuelType(petrol);
        car6.setDrivetrain(rwd);
        car6.setMake(bmw);
        car6.setModel(series3);
        car6.setGeneration(f30);
        car6.setDamageType(notDamaged);
        car6.setCondition(used);
        car6.setFeatures(car6Features);
        car6.setOffer(offer6);
        Set<Feature> car7Features = Set.of(
                abs, esp, rearParkingSensors, radio,
                automaticAirConditioning, appleCarPlay, androidAuto
        );
        Car car7 = new Car();
        car7.setBodyType(suv);
        car7.setColor(green);
        car7.setProductionYear(2018);
        car7.setDoors(5);
        car7.setSeats(5);
        car7.setMileage(10000);
        car7.setEngineSize(2000);
        car7.setPower(150);
        car7.setTransmission(manual);
        car7.setFuelType(diesel);
        car7.setDrivetrain(awd);
        car7.setMake(honda);
        car7.setModel(crv);
        car7.setGeneration(null);
        car7.setDamageType(notDamaged);
        car7.setCondition(used);
        car7.setFeatures(car7Features);
        car7.setOffer(offer7);
        Set<Feature> car8Features = Set.of(
                abs, esp, rearParkingSensors, frontParkingSensors,
                radio, automaticAirConditioning, androidAuto, centralLocking
        );
        Car car8 = new Car();
        car8.setBodyType(sedan);
        car8.setColor(red);
        car8.setProductionYear(2013);
        car8.setDoors(4);
        car8.setSeats(5);
        car8.setMileage(130000);
        car8.setEngineSize(3000);
        car8.setPower(250);
        car8.setTransmission(automatic);
        car8.setFuelType(petrol);
        car8.setDrivetrain(awd);
        car8.setMake(bmw);
        car8.setModel(series3);
        car8.setGeneration(f30);
        car8.setDamageType(notDamaged);
        car8.setCondition(used);
        car8.setFeatures(car8Features);
        car8.setOffer(offer8);

        carRepository.saveAll(Set.of(car1, car2, car3, car4, car5, car6, car7, car8));

        Photo photo1 = new Photo();
        photo1.setPath("1-1-image.webp");
        photo1.setCar(car1);
        Photo photo2 = new Photo();
        photo2.setPath("1-2-image.webp");
        photo2.setCar(car1);
        Photo photo3 = new Photo();
        photo3.setPath("1-3-image.webp");
        photo3.setCar(car1);
        Photo photo4 = new Photo();
        photo4.setPath("2-1-image.webp");
        photo4.setCar(car2);
        Photo photo5 = new Photo();
        photo5.setPath("2-2-image.webp");
        photo5.setCar(car2);
        Photo photo6 = new Photo();
        photo6.setPath("2-3-image.webp");
        photo6.setCar(car2);
        Photo photo7 = new Photo();
        photo7.setPath("3-1-image.webp");
        photo7.setCar(car3);
        Photo photo8 = new Photo();
        photo8.setPath("3-2-image.webp");
        photo8.setCar(car3);
        Photo photo9 = new Photo();
        photo9.setPath("3-3-image.webp");
        photo9.setCar(car3);
        Photo photo10 = new Photo();
        photo10.setPath("4-1-image.webp");
        photo10.setCar(car4);
        Photo photo11 = new Photo();
        photo11.setPath("4-2-image.webp");
        photo11.setCar(car4);
        Photo photo12 = new Photo();
        photo12.setPath("4-3-image.webp");
        photo12.setCar(car4);
        Photo photo13 = new Photo();
        photo13.setPath("5-1-image.webp");
        photo13.setCar(car5);
        Photo photo14 = new Photo();
        photo14.setPath("5-2-image.webp");
        photo14.setCar(car5);
        Photo photo15 = new Photo();
        photo15.setPath("5-3-image.webp");
        photo15.setCar(car5);
        Photo photo16 = new Photo();
        photo16.setPath("6-1-image.webp");
        photo16.setCar(car6);
        Photo photo17 = new Photo();
        photo17.setPath("6-2-image.webp");
        photo17.setCar(car6);
        Photo photo18 = new Photo();
        photo18.setPath("6-3-image.webp");
        photo18.setCar(car6);
        Photo photo19 = new Photo();
        photo19.setPath("7-1-image.webp");
        photo19.setCar(car7);
        Photo photo20 = new Photo();
        photo20.setPath("7-2-image.webp");
        photo20.setCar(car7);
        Photo photo21 = new Photo();
        photo21.setPath("7-3-image.webp");
        photo21.setCar(car7);
        Photo photo22 = new Photo();
        photo22.setPath("8-1-image.webp");
        photo22.setCar(car8);
        Photo photo23 = new Photo();
        photo23.setPath("8-2-image.webp");
        photo23.setCar(car8);
        Photo photo24 = new Photo();
        photo24.setPath("8-3-image.webp");
        photo24.setCar(car8);

        photoRepository.saveAll(Set.of(
                photo1, photo2, photo3, photo4, photo5, photo6,
                photo7, photo8, photo9, photo10, photo11, photo12,
                photo13, photo14, photo15, photo16, photo17,
                photo18, photo19, photo20, photo21, photo22,
                photo23, photo24
        ));

        car1.setPhotos(Set.of(photo1, photo2));
        car2.setPhotos(Set.of(photo3, photo4));

        carRepository.saveAll(Set.of(car1, car2));

        user2.setObservedOffers(Set.of(offer2));
        user3.setObservedOffers(Set.of(offer2, offer4));
        user4.setObservedOffers(Set.of(offer1, offer2));

        userRepository.saveAll(Set.of(user2, user3, user4));
    }
}
