package br.com.surb.surbcatalog.modules.category.repositories;

import br.com.surb.surbcatalog.modules.category.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
  boolean existsById(UUID categoryId);
}
