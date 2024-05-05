package org.example.automarket24backend.photo;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.car.Car;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PhotoService {

    private PhotoRepository photoRepository;

    public Set<Photo> savePhotos(List<MultipartFile> photos, Integer offerId, Car car) {
        int imageId = 1;
        Set<Photo> photosToSave = new HashSet<>();

        for (MultipartFile photo: photos) {
            String photoName = offerId + "-" + imageId + "-" + photo.getOriginalFilename();

            try {
                File file = new File("../uploads/" + photoName);
                photo.transferTo(file.getAbsoluteFile());
            } catch (IOException exception) {
                System.out.println(exception.getMessage());
            }

            Photo newPhoto = new Photo();
            newPhoto.setPath(photoName);
            newPhoto.setCar(car);

            photosToSave.add(newPhoto);

            imageId++;
        }

        return new HashSet<>(photoRepository.saveAll(photosToSave));
    }
}
