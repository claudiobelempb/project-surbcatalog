package br.com.surb.surbcatalog.modules.product.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.modules.product.repositories.ProductRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductCreateService {
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductCreateService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public ProductDTO execute(ProductDTO dto) {
        Product entity = new Product();
        copyDtoToEntity(dto, entity);
        productRepository.save(entity);
        return new ProductDTO(entity);
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
