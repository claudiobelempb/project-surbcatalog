package br.com.surb.surbcatalog.modules.category.dto;

import br.com.surb.surbcatalog.modules.category.entities.Category;
import java.io.Serial;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;

public class CategoryDTO implements Serializable {

  @Serial
  private static final long serialVersionUID = -4661532469334771781L;

  private UUID categoryId;
  private String name;
  private Instant createdAt;
  private Instant updatedAt;
  private boolean active;

  public CategoryDTO(){}

  public CategoryDTO(UUID categoryId, String name, Instant createdAt, Instant updatedAt, boolean active) {
    this.categoryId = categoryId;
    this.name = name;
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.active = active;
  }

  public CategoryDTO(Category entity){
    categoryId = entity.getCategoryId();
    name = entity.getName();
    createdAt = entity.getCreatedAt();
    updatedAt = entity.getUpdatedAt();
    active = entity.isActive();
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

  public Instant getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public boolean isActive() {
    return active;
  }

  public void setActive(boolean active) {
    this.active = active;
  }
}
