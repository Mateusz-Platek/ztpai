package org.example.automarket24backend.offer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/offer/{offerId}")
    public ResponseEntity<Offer> getOffer(@PathVariable Integer offerId) {
        return offerService.getOffer(offerId);
    }

    @PostMapping
    public ResponseEntity<Offer> saveOffer(@RequestBody OfferDto offerDto) {
        return offerService.saveOffer(offerDto);
    }

    @DeleteMapping("/{offerId}")
    public ResponseEntity<Offer> removeOffer(@PathVariable Integer offerId) {
        return offerService.removeOffer(offerId);
    }
}
