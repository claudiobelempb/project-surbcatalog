package br.com.surb.surbcatalog.modules.image.entities;

import br.com.surb.surbcatalog.shared.AppEnums.ImageExtensionType;
import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tb_image")
public class Image implements Serializable {

    @Serial
    private static final long serialVersionUID = -640182075399529019L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID imageId;

    @Column
    private String name;

    @Column
    private Long size;

    @Column
    @Enumerated(EnumType.STRING)
    private ImageExtensionType extension;

    @Column
    private String tags;

    @Column
    @Lob
    private byte[] file;

    @Column
    private Boolean active;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private OffsetDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private OffsetDateTime updatedAt;

    @PrePersist
    public void prePersist() {
        if (Objects.isNull(createdAt)) {
            createdAt = AppDateUtils.now();
            updatedAt = createdAt;
        }
        if (Objects.isNull(active)) {
            active = true;
        }
    }

    @PreUpdate
    public void preUpdate() {
        updatedAt = AppDateUtils.now();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        Image image = (Image) object;
        return Objects.equals(imageId, image.imageId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(imageId);
    }
}
