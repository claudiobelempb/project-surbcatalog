package br.com.surb.surbcatalog.modules.image.dto;

import br.com.surb.surbcatalog.shared.AppEnums.ImageExtensionType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ImageDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -8398827106393125429L;

    private UUID imageId;
    private String name;
    private Long size;
    private byte[] file;
    private ImageExtensionType extension;
    private String tags;
    private Boolean active;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private OffsetDateTime createdAt;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private OffsetDateTime updatedAt;

}
