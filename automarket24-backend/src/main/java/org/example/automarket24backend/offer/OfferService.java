package org.example.automarket24backend.offer;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.car.CarService;
import org.example.automarket24backend.photo.PhotoService;
import org.example.automarket24backend.user.User;
import org.example.automarket24backend.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private CarService carService;
    private PhotoService photoService;

    public ResponseEntity<List<Offer>> getOffers() {
        return new ResponseEntity<>(offerRepository.findAll(), HttpStatus.OK);
    }

    public ResponseEntity<List<Offer>> getUserOffers(Integer userId) {
        return new ResponseEntity<>(/*offerRepository.findAllByUserId(userId),*/ HttpStatus.OK);
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
//        offer.setUser(user);

        Offer savedOffer = offerRepository.save(offer);

        Car savedCar = carService.saveCar(offerDto.car(), savedOffer);
        savedOffer.setCar(savedCar);
        offerRepository.save(savedOffer);

        photoService.savePhotos(images, savedOffer.getId(), savedCar);

        return new ResponseEntity<>(savedOffer, HttpStatus.OK);
    }

    public ResponseEntity<Offer> removeOffer(Integer offerId) {
        Offer offer = offerRepository.findById(offerId).orElse(null);
        if (offer == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        offerRepository.deleteById(offer.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }
}