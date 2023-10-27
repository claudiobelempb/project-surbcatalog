package br.com.surb.surbcatalog.modules.category.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "tb_category")
public class Category implements Serializable {

  private static final long serialVersionUID = 5188743431161409951L;

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID categoryId;
  private String name;

  public Category() {
  }

  public Category(UUID categoryId, String name) {
    this.categoryId = categoryId;
    this.name = name;
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
