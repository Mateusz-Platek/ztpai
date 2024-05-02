package org.example.automarket24backend.offer;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.bodyType.BodyType;
import org.example.automarket24backend.bodyType.BodyTypeRepository;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.car.CarRepository;
import org.example.automarket24backend.car.CarService;
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
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private CarService carService;

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

    public ResponseEntity<Offer> saveOffer(List<MultipartFile> images, OfferDto offerDto) {
        Offer offer = new Offer();
        offer.setDescription(offerDto.description());
        offer.setPrice(offerDto.price());

        User user = userRepository.findById(offerDto.userId()).orElse(null);
        offer.setUser(user);

        Car savedCar = carService.saveCar(offerDto.car());
        offer.setCar(savedCar);

        Offer savedOffer = offerRepository.save(offer);

        return new ResponseEntity<>(savedOffer, HttpStatus.OK);
    }

    public ResponseEntity<Offer> removeOffer(Integer offerId) {
        Offer offer = offerRepository.findById(offerId).orElse(null);
        if (offer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        offerRepository.deleteById(offer.getId());

        return new ResponseEntity<>(offer, HttpStatus.OK);
    }
}