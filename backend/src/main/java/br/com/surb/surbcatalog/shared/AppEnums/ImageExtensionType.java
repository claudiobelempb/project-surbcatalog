package br.com.surb.surbcatalog.shared.AppEnums;

import lombok.Getter;
import org.springframework.http.MediaType;

import java.util.Arrays;
import java.util.stream.Collectors;

@Getter
public enum ImageExtensionType {
    PNG(MediaType.IMAGE_PNG),
    GIF(MediaType.IMAGE_GIF),
    JPEG(MediaType.IMAGE_JPEG);

    private final MediaType mediaType;

    ImageExtensionType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public static ImageExtensionType valueOf(MediaType mediaType) {
        return Arrays.stream(values())
                .filter(ie -> ie.mediaType.equals(mediaType))
                .findFirst()
                .orElse(null);
    }

    public static ImageExtensionType ofName(String name){
        return Arrays.stream(values())
                .filter(ie -> ie.name().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

}
