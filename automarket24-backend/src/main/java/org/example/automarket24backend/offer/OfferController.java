package org.example.automarket24backend.offer;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/offers")
@AllArgsConstructor
public class OfferController {

    private OfferService offerService;

    @GetMapping
    public ResponseEntity<List<Offer>> getOffers() {
        return offerService.getOffers();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Offer>> getUserOffers(@PathVariable Integer userId) {
        return offerService.getUserOffers(userId);
    }

    @GetMapping("/{offerId}")
    public ResponseEntity<Offer> getOffer(@PathVariable Integer offerId) {
        return offerService.getOffer(offerId);
    }

    @PostMapping
    public ResponseEntity<Offer> saveOffer(@RequestPart List<MultipartFile> images, @RequestPart OfferDto offerDto) {
        return offerService.saveOffer(images, offerDto);
    }

    @DeleteMapping("/{offerId}")
    public ResponseEntity<Offer> removeOffer(@PathVariable Integer offerId) {
        return offerService.removeOffer(offerId);
    }
}
