package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class CategoryFindByService {

  private final CategoryRepository categoryRepository;

  public CategoryFindByService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Transactional(readOnly = true)
  public CategoryDTO execute(UUID categoryId){
    Optional<Category> obj = categoryRepository.findById(categoryId);
    Category entity = obj.orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + categoryId));
    return new CategoryDTO(entity);
  }
}
