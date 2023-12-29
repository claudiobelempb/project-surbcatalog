package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.mapper.CategoryMapper;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryFindAllService {
  private final CategoryRepository categoryRepository;

  public CategoryFindAllService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Transactional(readOnly = true)
  public Page<CategoryDTO> execute(Pageable pageable) {
    Page<Category> categories = categoryRepository.findAll(pageable);
    return categories.map((category) -> CategoryMapper.fromDTO(category));
  }
}
