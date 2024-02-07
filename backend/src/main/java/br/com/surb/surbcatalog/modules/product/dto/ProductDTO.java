package br.com.surb.surbcatalog.modules.product.dto;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class ProductDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 396999032983672409L;

    private UUID productId;
    @Size(min = 5, max = 60, message = AppValidatorConstants.MIN_MAX)
    @NotBlank(message = AppValidatorConstants.REQUIRED_FIELD)
    private String name;
    @NotBlank(message = AppValidatorConstants.REQUIRED_FIELD)
    private String description;
    @Positive(message = AppValidatorConstants.REQUIRED_PRICE_POSITIVO)
    private Double price;
    private Double discount;
    private Integer minStock;
    private Integer maxStock;
    private String imgUri;
    @PastOrPresent(message = AppValidatorConstants.REQUIRED_DATA_PRESENT)
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;
    private Boolean active;
    private final List<CategoryDTO> categories = new ArrayList<>();

    public ProductDTO() {
    }

    public ProductDTO(UUID productId, String name, String description, Double price, Double discount, Integer minStock, Integer maxStock, String imgUri, OffsetDateTime createdAt, OffsetDateTime updatedAt, Boolean active) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.discount = discount;
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.imgUri = imgUri;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.active = active;
    }

    public ProductDTO(Product entity) {
        productId = entity.getProductId();
        name = entity.getName();
        description = entity.getDescription();
        price = entity.getPrice();
        discount = entity.getDiscount();
        minStock = entity.getMinStock();
        maxStock = entity.getMaxStock();
        imgUri = entity.getImgUri();
        createdAt = entity.getCreatedAt();
        updatedAt = entity.getUpdatedAt();
        active = entity.getActive();
    }

    public ProductDTO(Product entity, Set<Category> categories) {
        this(entity);
        categories.forEach(category -> this.categories.add(new CategoryDTO(category)));
    }

    public UUID getProductId() {
        return productId;
    }

    public void setProductId(UUID productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Integer getMinStock() {
        return minStock;
    }

    public void setMinStock(Integer minStock) {
        this.minStock = minStock;
    }

    public Integer getMaxStock() {
        return maxStock;
    }

    public void setMaxStock(Integer maxStock) {
        this.maxStock = maxStock;
    }

    public String getImgUri() {
        return imgUri;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
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

    public List<CategoryDTO> getCategories() {
        return categories;
    }
}
