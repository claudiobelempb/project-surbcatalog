package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryFindAllService {
  private final CategoryRepository categoryRepository;

  public CategoryFindAllService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Transactional(readOnly = true)
  public List<CategoryDTO> execute(){
    List<Category> categories = categoryRepository.findAll();
    return categories.stream().map((category) -> new CategoryDTO(category)).collect(Collectors.toList());
    /*List<CategoryDTO> categoryDTOS = new ArrayList<>();
    for(Category category : categories){
      categoryDTOS.add(new CategoryDTO(category));
    }
    return categoryDTOS;*/

  }
}
