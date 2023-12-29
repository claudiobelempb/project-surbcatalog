package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryCreateDTO;
import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.mapper.CategoryMapper;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryCreateService {
    private final CategoryRepository categoryRepository;

    public CategoryCreateService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public CategoryCreateDTO execute(CategoryCreateDTO dto) {
        Category category = CategoryMapper.fromCreateEntity(dto);
        categoryRepository.save(category);
        return CategoryMapper.fromCreateDTO(category);
    }
}
