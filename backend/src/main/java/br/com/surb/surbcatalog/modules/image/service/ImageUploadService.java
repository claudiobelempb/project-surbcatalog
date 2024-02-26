package br.com.surb.surbcatalog.modules.image.service;

import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.modules.image.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ImageUploadService {

    private final ImageRepository imageRepository;

    public ImageUploadService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional
    public Image execute(Image entity) {
        return imageRepository.save(entity);
    }
}
