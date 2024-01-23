package br.com.surb.surbcatalog.modules.product.services;

import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.modules.product.repositories.ProductRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class ProductDeactiveService {
    private final ProductRepository productRepository;

    public ProductDeactiveService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional
    public void execute(UUID productId) {
        Objects.requireNonNull(productId);
        Product entiry = productRepository.findByProductIdAndActive(productId, true)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + productId));
        entiry.setActive(false);
        productRepository.save(entiry);
    }
}
