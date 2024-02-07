package br.com.surb.surbcatalog.modules.category.entities;

import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
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

    @ManyToMany(mappedBy = "categories")
    private final Set<Product> products = new HashSet<>();

    public Category() {
    }

    public Category(UUID categoryId, String name, OffsetDateTime createdAt, OffsetDateTime updatedAt, Boolean active) {
        this.categoryId = categoryId;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public UUID getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(UUID categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Set<Product> getProducts() {
        return products;
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

    @PreUpdate
    public void preUpdate() {
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

}
