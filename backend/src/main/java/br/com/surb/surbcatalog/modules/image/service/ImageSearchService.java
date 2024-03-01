package br.com.surb.surbcatalog.modules.image.service;

import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.modules.image.repository.ImageRepository;
import br.com.surb.surbcatalog.shared.AppEnums.ImageExtensionType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ImageSearchService {
    private final ImageRepository imageRepository;

    public ImageSearchService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Transactional(readOnly = true)
    public List<Image> execute(ImageExtensionType extension, String query){
        return imageRepository.findByExtensionAndNameOrTagsLike(extension, query);
    }
}
