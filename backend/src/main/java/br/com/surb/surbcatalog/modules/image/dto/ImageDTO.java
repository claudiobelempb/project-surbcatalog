package br.com.surb.surbcatalog.modules.image.dto;

import br.com.surb.surbcatalog.modules.image.entities.Image;
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

    public ImageDTO() {
    }

    public ImageDTO(UUID imageId, String name, Long size, byte[] file, ImageExtensionType extension, String tags, Boolean active, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.imageId = imageId;
        this.name = name;
        this.size = size;
        this.file = file;
        this.extension = extension;
        this.tags = tags;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public ImageDTO(Image entity) {
        this.imageId = entity.getImageId();
        this.name = entity.getName();
        this.size = entity.getSize();
        this.file = entity.getFile();
        this.extension = entity.getExtension();
        this.tags = entity.getTags();
        this.active = entity.getActive();
        this.createdAt = entity.getCreatedAt();
        this.updatedAt = entity.getUpdatedAt();
    }

    public UUID getImageId() {
        return imageId;
    }

    public void setImageId(UUID imageId) {
        this.imageId = imageId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public ImageExtensionType getExtension() {
        return extension;
    }

    public void setExtension(ImageExtensionType extension) {
        this.extension = extension;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}
