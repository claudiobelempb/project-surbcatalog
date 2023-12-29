package br.com.surb.surbcatalog.modules.category.entities;

import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import jakarta.persistence.*;
import org.springframework.data.annotation.LastModifiedDate;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 5188743431161409951L;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID categoryId;
    private String name;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private OffsetDateTime createdAt;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private OffsetDateTime updatedAt;
    private Boolean active;

    public Category() {
    }

    private Category(Builder builder) {
        categoryId = builder.categoryId;
        name = builder.name;
        createdAt = builder.createdAt;
        updatedAt = builder.updatedAt;
        active = builder.active;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public String getName() {
        return name;
    }

    public OffsetDateTime getCreatedAt() {
        return createdAt;
    }

    public OffsetDateTime getUpdatedAt() {
        return updatedAt;
    }

    public Boolean getActive() {
        return active;
    }

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

    @LastModifiedDate
    public void preUpdate() {
        System.out.println("preUpdate");
        updatedAt = AppDateUtils.now();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        return categoryId.equals(category.categoryId);
    }

    @Override
    public int hashCode() {
        return categoryId.hashCode();
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private UUID categoryId;
        private String name;
        private OffsetDateTime createdAt;
        private OffsetDateTime updatedAt;
        private Boolean active;

        public Builder() {
        }

        public Builder categoryId(UUID categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder createdAt(OffsetDateTime createdAt) {
            this.createdAt = createdAt;
            return this;
        }

        public Builder updatedAt(OffsetDateTime updatedAt) {
            this.updatedAt = updatedAt;
            return this;
        }

        public Builder active(Boolean active) {
            this.active = active;
            return this;
        }

        public Category build() {
            return new Category(this);
        }
    }
}
