package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class CategoryUpdateService {
  private final CategoryRepository categoryRepository;

  public CategoryUpdateService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Transactional
  public CategoryDTO execute(UUID categoryId, CategoryDTO categoryDTO){
    try{
      Category entity = categoryRepository.getReferenceById(categoryId);
      entity.setName(categoryDTO.getName());
      entity = categoryRepository.save(entity);
      return new CategoryDTO(entity);
    }catch (EntityNotFoundException e) {
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + categoryId);
    }
  }
}
