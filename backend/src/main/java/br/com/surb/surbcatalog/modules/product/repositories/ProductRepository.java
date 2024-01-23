package br.com.surb.surbcatalog.modules.product.repositories;

import br.com.surb.surbcatalog.modules.product.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    boolean existsById(UUID productId);

    Optional<Product> findByProductIdAndActive(UUID productId, Boolean active);

    Optional<Product> findByNameAndActive(String name, Boolean active);
}
