package br.com.surb.surbcatalog.modules.product.services;

import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.modules.product.repositories.ProductRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class ProductFindByIdService {
    private final ProductRepository productRepository;

    public ProductFindByIdService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public ProductDTO execute(UUID productId) {
        Objects.requireNonNull(productId);
        Product entity = productRepository.findByProductIdAndActive(productId, true)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + productId));
        return new ProductDTO(entity, entity.getCategories());
    }
}
