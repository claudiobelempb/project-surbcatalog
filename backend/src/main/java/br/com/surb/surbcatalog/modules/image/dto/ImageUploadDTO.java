package br.com.surb.surbcatalog.modules.image.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@Builder
public class ImageUploadDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8424180623735353514L;

    private String url;
    private String name;
    private String extension;
    private Long size;
    private OffsetDateTime createdAt;

}
