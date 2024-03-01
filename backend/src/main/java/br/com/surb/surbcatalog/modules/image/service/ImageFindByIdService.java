package br.com.surb.surbcatalog.modules.image.service;

import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.modules.image.repository.ImageRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageFindByIdService {
    private final ImageRepository imageRepository;

    public ImageFindByIdService(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }


    @Transactional(readOnly = true)
    public Optional<Image> execute(UUID imageId) {
        Objects.requireNonNull(imageId);

       return Optional.ofNullable(imageRepository.findByImageIdAndActive(imageId, true)
               .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + imageId)));

    }
}
