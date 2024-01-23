package br.com.surb.surbcatalog.modules.category.repositories;

import br.com.surb.surbcatalog.modules.category.entities.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    boolean existsById(UUID categoryId);

    Optional<Category> findByCategoryIdAndActive(UUID categoryId, Boolean active);

    Optional<Category> findByNameAndActive(String name, Boolean active);

}
