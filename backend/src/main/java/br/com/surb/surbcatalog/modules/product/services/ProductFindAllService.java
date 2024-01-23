package br.com.surb.surbcatalog.modules.product.services;

import br.com.surb.surbcatalog.modules.product.dto.ProductDTO;
import br.com.surb.surbcatalog.modules.product.entities.Product;
import br.com.surb.surbcatalog.modules.product.repositories.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductFindAllService {
    private final ProductRepository productRepository;

    public ProductFindAllService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public Page<ProductDTO> execute(Pageable pageable) {
        Page<Product> entity = productRepository.findAll(pageable);
        return entity.map((product) -> new ProductDTO(product));
    }
}
