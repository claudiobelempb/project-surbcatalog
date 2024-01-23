package br.com.surb.surbcatalog.modules.product.services;

import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.modules.product.repositories.ProductRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppDataIntegrityViolationException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class ProductDeleteService {
    private final ProductRepository productRepository;

    public ProductDeleteService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void execute(UUID productId) {
        try {
            Objects.requireNonNull(productId);
            productRepository.findByProductIdAndActive(productId, true)
                    .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + productId));
            productRepository.deleteById(productId);
        } catch (DataIntegrityViolationException e) {
            throw new AppDataIntegrityViolationException(AppExceptionConstants.DATA_INTEGRITY_VIOLATION + productId);
        }
    }
}
