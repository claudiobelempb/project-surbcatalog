package br.com.surb.surbcatalog.modules.image.mapper;

import br.com.surb.surbcatalog.modules.image.dto.ImageUploadDTO;
import br.com.surb.surbcatalog.modules.image.entities.Image;
import br.com.surb.surbcatalog.shared.AppEnums.ImageExtensionType;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Component
public class ImageMapper {

    public static Image mapperToImage(MultipartFile file, String name, List<String> tags) throws IOException {
        Image image = new Image();
        image.setName(name);
        image.setTags(String.join(",", tags));
        image.setSize(file.getSize());
        image.setExtension(ImageExtensionType.valueOf(MediaType.valueOf(Objects.requireNonNull(file.getContentType()))));
        image.setFile(file.getBytes());

        return image;
    }

    public static ImageUploadDTO entityToDTO(Image image, String url){
        return ImageUploadDTO.builder()
                .name(image.getName())
                .url(url)
                .extension(image.getExtension().name())
                .size(image.getSize())
                .createdAt(image.getCreatedAt())
                .build();
    }
}
