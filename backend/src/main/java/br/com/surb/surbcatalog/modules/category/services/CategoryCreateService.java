package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoryCreateService {
  private final CategoryRepository categoryRepository;

  public CategoryCreateService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  public CategoryDTO execute(CategoryDTO categoryDTO){
    Category entity = new Category();
    entity.setName(categoryDTO.getName());
    entity = categoryRepository.save(entity);
    return new CategoryDTO(entity);
  }
}
