package org.example.automarket24backend.offer;

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
import org.example.automarket24backend.fuelType.FuelType;
import org.example.automarket24backend.fuelType.FuelTypeRepository;
import org.example.automarket24backend.generation.Generation;
import org.example.automarket24backend.generation.GenerationRepository;
import org.example.automarket24backend.make.Make;
import org.example.automarket24backend.make.MakeRepository;
import org.example.automarket24backend.model.Model;
import org.example.automarket24backend.model.ModelRepository;
import org.example.automarket24backend.transmission.Transmission;
import org.example.automarket24backend.transmission.TransmissionRepository;
import org.example.automarket24backend.user.User;
import org.example.automarket24backend.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private MakeRepository makeRepository;
    private ModelRepository modelRepository;
    private GenerationRepository generationRepository;
    private BodyTypeRepository bodyTypeRepository;
    private TransmissionRepository transmissionRepository;
    private DrivetrainRepository drivetrainRepository;
    private ColorRepository colorRepository;
    private FuelTypeRepository fuelTypeRepository;
    private DamageTypeRepository damageTypeRepository;
    private ConditionRepository conditionRepository;
    private CarRepository carRepository;

    public ResponseEntity<List<Offer>> getOffers() {
        return new ResponseEntity<>(offerRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Offer>> getUserOffers(Integer userId) {
        return new ResponseEntity<>(offerRepository.findAllByUserId(userId), HttpStatus.OK);
    }

    public ResponseEntity<Offer> getOffer(Integer offerId) {
        Offer offer = offerRepository.findById(offerId).orElse(null);
        if (offer == null) {
            return new ResponseEntity<>(new Offer(), HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }

    public ResponseEntity<Offer> saveOffer(OfferDto offerDto) {
        Offer offer = new Offer();
        offer.setDescription(offerDto.description());
        offer.setPrice(offerDto.price());

        User user = userRepository.findUserByEmailContaining(offerDto.email());
        offer.setUser(user);

        Car car = new Car();
        car.setProductionYear(offerDto.car().productionYear());
        car.setMileage(offerDto.car().mileage());
        car.setPower(offerDto.car().power());
        car.setEngineSize(offerDto.car().engineSize());
        car.setSeats(offerDto.car().seats());
        car.setDoors(offerDto.car().doors());

        Make make = makeRepository.findById(offerDto.car().make()).orElse(null);
        car.setMake(make);

        Model model = modelRepository.findById(offerDto.car().model()).orElse(null);
        car.setModel(model);

        Generation generation = generationRepository.findById(offerDto.car().generation()).orElse(null);
        car.setGeneration(generation);

        BodyType bodyType = bodyTypeRepository.findById(offerDto.car().bodyType()).orElse(null);
        car.setBodyType(bodyType);

        Transmission transmission = transmissionRepository.findById(offerDto.car().transmission()).orElse(null);
        car.setTransmission(transmission);

        Drivetrain drivetrain = drivetrainRepository.findById(offerDto.car().drivetrain()).orElse(null);
        car.setDrivetrain(drivetrain);

        Color color = colorRepository.findById(offerDto.car().color()).orElse(null);
        car.setColor(color);

        FuelType fuelType = fuelTypeRepository.findById(offerDto.car().fuelType()).orElse(null);
        car.setFuelType(fuelType);

        DamageType damageType = damageTypeRepository.findById(offerDto.car().damageType()).orElse(null);
        car.setDamageType(damageType);

        Condition condition = conditionRepository.findById(offerDto.car().condition()).orElse(null);
        car.setCondition(condition);

        carRepository.save(car);

        offer.setCar(car);
        Offer saved = offerRepository.save(offer);

        return new ResponseEntity<>(saved, HttpStatus.OK);
    }

    public ResponseEntity<Offer> removeOffer(Integer offerId) {
        Offer offer = offerRepository.findById(offerId).orElse(null);
        if (offer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        offerRepository.deleteById(offerId);

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }
}