package org.example.automarket24backend.offer;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.car.Car;
import org.example.automarket24backend.car.CarService;
import org.example.automarket24backend.photo.Photo;
import org.example.automarket24backend.photo.PhotoService;
import org.example.automarket24backend.user.User;
import org.example.automarket24backend.user.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class OfferService {

    private OfferRepository offerRepository;
    private UserRepository userRepository;
    private CarService carService;
    private PhotoService photoService;

    public ResponseEntity<List<OfferResponse>> getLatestOffers() {
        List<OfferResponse> offerResponses = offerRepository.findFirst6ByOrderByPostTimeDesc()
                .stream().map(Offer::toOfferResponse).toList();
        return new ResponseEntity<>(offerResponses, HttpStatus.OK);
    }

    public ResponseEntity<List<OfferResponse>> getOffers() {
        List<OfferResponse> offerResponses = offerRepository.findAll().stream().map(Offer::toOfferResponse).toList();
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