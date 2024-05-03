package org.example.automarket24backend.photo;

import lombok.AllArgsConstructor;
import org.example.automarket24backend.car.Car;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@AllArgsConstructor
public class PhotoService {

    private PhotoRepository photoRepository;

    public void savePhotos(List<MultipartFile> photos, Integer offerId, Car car) {
        int imageId = 1;
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

            photoRepository.save(newPhoto);

            imageId++;
        }
    }
}
