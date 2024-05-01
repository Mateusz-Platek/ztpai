package org.example.automarket24backend.photo;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@AllArgsConstructor
public class PhotoService {

    private PhotoRepository photoRepository;

    public void savePhotos(List<MultipartFile> photos) {
        for (MultipartFile photo: photos) {

        }
    }
}
