package br.com.surb.surbcatalog.modules.category.dto;

import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.validation.CategoryCreateValid;
import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@CategoryCreateValid
public class CategoryDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4931407971722715507L;

    private UUID categoryId;
    @NotBlank(message = AppValidatorConstants.REQUIRED_FIELD)
    @Size(min = 3, max = 15, message = AppValidatorConstants.BETWEEN_LENGTH)
    private String name;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Boolean active;
    private final Set<ProductDTO> products = new HashSet<>();

    public CategoryDTO(){}

    public CategoryDTO(UUID categoryId, String name, OffsetDateTime createdAt, OffsetDateTime updatedAt, Boolean active) {
        this.categoryId = categoryId;
        this.name = name;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public CategoryDTO(Category entity) {
        categoryId = entity.getCategoryId();
        name = entity.getName();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
        active = entity.getActive();
    }

    public CategoryDTO(Category entity, Set<Product> products) {
        this(entity);
        products.forEach(product -> this.products.add(new ProductDTO(product)));
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

    public Set<ProductDTO> getProducts() {
        return products;
    }

}
