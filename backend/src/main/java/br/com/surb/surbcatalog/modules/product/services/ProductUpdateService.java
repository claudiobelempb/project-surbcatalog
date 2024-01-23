package br.com.surb.surbcatalog.modules.product.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.modules.product.repositories.ProductRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class ProductUpdateService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductUpdateService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public ProductDTO execute(UUID productId, ProductDTO dto) {
        try {
            Objects.requireNonNull(productId);
            Product entity = productRepository
                    .findByProductIdAndActive(productId, true)
                    .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + productId));
            copyDtoToEntity(dto, entity);
            productRepository.save(entity);
            return new ProductDTO(entity);
        } catch (EntityNotFoundException e) {
            throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + productId);
        }
    }

    private void copyDtoToEntity(ProductDTO dto, Product entity) {

        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setDiscount(dto.getDiscount());
        entity.setMinStock(dto.getMinStock());
        entity.setMaxStock(dto.getMaxStock());
        entity.setImgUri(dto.getImgUri());

        entity.getCategories().clear();

        for(CategoryDTO cateDto: dto.getCategories()){
            Category category = categoryRepository.getReferenceById(cateDto.getCategoryId());
            entity.getCategories().add(category);
        }
    }
}
