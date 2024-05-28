package org.example.automarket24backend.offer;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/offers")
@AllArgsConstructor
public class OfferController {

    private OfferService offerService;

    @GetMapping("/latest")
    public ResponseEntity<List<SimpleOfferResponse>> getLatestOffers() {
        return offerService.getLatestOffers();
    }

    @GetMapping
    public ResponseEntity<List<OfferResponse>> getOffers(@RequestParam Map<String, String> params) {
        return offerService.getOffers(params);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<OfferResponse>> getUserOffers(@PathVariable Integer userId) {
        return offerService.getUserOffers(userId);
    }

    @GetMapping("/{offerId}")
    public ResponseEntity<OfferResponse> getOffer(@PathVariable Integer offerId) {
        return offerService.getOffer(offerId);
    }

    @PostMapping
    public ResponseEntity<OfferResponse> saveOffer(@RequestPart List<MultipartFile> images, @RequestPart OfferDto offerDto) {
        return offerService.saveOffer(images, offerDto);
    }

    @DeleteMapping("/{offerId}")
    public ResponseEntity<OfferResponse> removeOffer(@PathVariable Integer offerId) {
        return offerService.removeOffer(offerId);
    }
}
