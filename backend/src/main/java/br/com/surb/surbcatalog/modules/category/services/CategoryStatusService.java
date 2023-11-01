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
public class CategoryStatusService {
  private final CategoryRepository categoryRepository;

  public CategoryStatusService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Transactional
  public void execute(UUID categoryId, CategoryDTO categoryDTO){
    try{
      Category entity = categoryRepository.getReferenceById(categoryId);
      entity.setActive(categoryDTO.isActive());
      categoryRepository.save(entity);
    }catch (EntityNotFoundException e) {
      throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + categoryId);
    }
  }
}
