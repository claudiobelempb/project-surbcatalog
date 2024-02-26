package br.com.surb.surbcatalog.shared.AppEnums;

import org.springframework.http.MediaType;

import java.util.Arrays;

public enum ImageExtensionType {
    PNG(MediaType.IMAGE_PNG),
    GIF(MediaType.IMAGE_GIF),
    JPEG(MediaType.IMAGE_JPEG);

    private MediaType mediaType;

    ImageExtensionType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public static ImageExtensionType valueOf(MediaType mediaType) {
        return Arrays.stream(values()).filter(ie -> ie.mediaType.equals(mediaType)).findFirst().orElse(null);
    }
}
