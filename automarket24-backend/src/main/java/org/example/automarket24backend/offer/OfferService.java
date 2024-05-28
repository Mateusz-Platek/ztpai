package org.example.automarket24backend.offer;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.bodyType.BodyType;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.car.CarService;
import org.example.automarket24backend.color.Color;
import org.example.automarket24backend.condition.Condition;
import org.example.automarket24backend.damageType.DamageType;
import org.example.automarket24backend.drivetrain.Drivetrain;
import org.example.automarket24backend.fuelType.FuelType;
import org.example.automarket24backend.generation.Generation;
import org.example.automarket24backend.make.Make;
import org.example.automarket24backend.model.Model;
import org.example.automarket24backend.photo.Photo;
import org.example.automarket24backend.photo.PhotoService;
import org.example.automarket24backend.transmission.Transmission;
import org.example.automarket24backend.user.User;
import org.example.automarket24backend.user.UserRepository;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private CarService carService;
    private PhotoService photoService;

    public ResponseEntity<List<SimpleOfferResponse>> getLatestOffers() {
        List<SimpleOfferResponse> offerResponses = offerRepository.findFirst6ByOrderByPostTimeDesc()
                .stream().map(Offer::toSimpleOfferResponse).toList();
        return new ResponseEntity<>(offerResponses, HttpStatus.OK);
    }

    public ResponseEntity<List<OfferResponse>> getOffers(Map<String, String> params) {
        Offer offer = new Offer();
        offer.setPostTime(null);
        Car car = new Car();
        offer.setCar(car);
        User user = new User();
        offer.setUser(user);

        if (params.containsKey("make")) {
            Make make = new Make();
            make.setId(Integer.valueOf(params.get("make")));
            car.setMake(make);
        }

        if (params.containsKey("model")) {
            Model model = new Model();
            model.setId(Integer.valueOf(params.get("model")));
            car.setModel(model);
        }

        if (params.containsKey("generation")) {
            Generation generation = new Generation();
            generation.setId(Integer.valueOf(params.get("generation")));
            car.setGeneration(generation);
        }

        if (params.containsKey("bodyType")) {
            BodyType bodyType = new BodyType();
            bodyType.setId(Integer.valueOf(params.get("bodyType")));
            car.setBodyType(bodyType);
        }

        if (params.containsKey("color")) {
            Color color = new Color();
            color.setId(Integer.valueOf(params.get("color")));
            car.setColor(color);
        }

        if (params.containsKey("drivetrain")) {
            Drivetrain drivetrain = new Drivetrain();
            drivetrain.setId(Integer.valueOf(params.get("drivetrain")));
            car.setDrivetrain(drivetrain);
        }

        if (params.containsKey("damageType")) {
            DamageType damageType = new DamageType();
            damageType.setId(Integer.valueOf(params.get("damageType")));
            car.setDamageType(damageType);
        }

        if (params.containsKey("transmission")) {
            Transmission transmission = new Transmission();
            transmission.setId(Integer.valueOf(params.get("transmission")));
            car.setTransmission(transmission);
        }

        if (params.containsKey("fuelType")) {
            FuelType fuelType = new FuelType();
            fuelType.setId(Integer.valueOf(params.get("fuelType")));
            car.setFuelType(fuelType);
        }

        if (params.containsKey("condition")) {
            Condition condition = new Condition();
            condition.setId(Integer.valueOf(params.get("condition")));
            car.setCondition(condition);
        }

        if (params.containsKey("location")) {
            user.setLocation(params.get("location"));
        }

        List<OfferResponse> offerResponses = offerRepository.findAll(Example.of(offer)).stream().filter(ofr -> {
            if (params.containsKey("priceFrom")) {
                return ofr.getPrice() >= Integer.parseInt(params.get("priceFrom"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("priceTo")) {
                return ofr.getPrice() <= Integer.parseInt(params.get("priceTo"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("engineSizeFrom")) {
                return ofr.getCar().getEngineSize() >= Integer.parseInt(params.get("engineSizeFrom"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("engineSizeTo")) {
                return ofr.getCar().getEngineSize() <= Integer.parseInt(params.get("engineSizeTo"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("powerFrom")) {
                return ofr.getCar().getPower() >= Integer.parseInt(params.get("powerFrom"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("powerTo")) {
                return ofr.getCar().getPower() <= Integer.parseInt(params.get("powerTo"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("mileageFrom")) {
                return ofr.getCar().getMileage() >= Integer.parseInt(params.get("mileageFrom"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("mileageTo")) {
                return ofr.getCar().getMileage() <= Integer.parseInt(params.get("mileageTo"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("productionYearFrom")) {
                return ofr.getCar().getProductionYear() >= Integer.parseInt(params.get("productionYearFrom"));
            }
            return true;
        }).filter(ofr -> {
            if (params.containsKey("productionYearTo")) {
                return ofr.getCar().getProductionYear() <= Integer.parseInt(params.get("productionYearTo"));
            }
            return true;
        }).map(Offer::toOfferResponse).toList();
        return new ResponseEntity<>(offerResponses, HttpStatus.OK);
    }

    public ResponseEntity<List<OfferResponse>> getUserOffers(Integer userId) {
        List<OfferResponse> offerResponses = offerRepository.findAllByUserId(userId).stream().map(Offer::toOfferResponse).toList();
        return new ResponseEntity<>(offerResponses, HttpStatus.OK);
    }

    public ResponseEntity<OfferResponse> getOffer(Integer offerId) {
        Offer offer = offerRepository.findById(offerId).orElse(null);
        if (offer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(offer.toOfferResponse(), HttpStatus.OK);
    }

    public ResponseEntity<OfferResponse> saveOffer(List<MultipartFile> images, OfferDto offerDto) {
        Offer offer = new Offer();
        offer.setDescription(offerDto.description());
        offer.setPrice(offerDto.price());

        User user = userRepository.findById(offerDto.userId()).orElse(null);
        offer.setUser(user);

        Offer savedOffer = offerRepository.save(offer);

        Car savedCar = carService.saveCar(offerDto.car(), savedOffer);

        Set<Photo> photos = photoService.savePhotos(images, savedOffer.getId(), savedCar);
        savedCar.setPhotos(photos);

        savedOffer.setCar(savedCar);
        offerRepository.save(savedOffer);

        return new ResponseEntity<>(savedOffer.toOfferResponse(), HttpStatus.OK);
    }

    public ResponseEntity<OfferResponse> removeOffer(Integer offerId) {
        Offer offer = offerRepository.findById(offerId).orElse(null);
        if (offer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        offerRepository.deleteById(offer.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}