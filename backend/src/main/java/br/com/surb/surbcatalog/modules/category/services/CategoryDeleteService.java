package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppDataIntegrityViolationException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import java.util.UUID;

@Service
public class CategoryDeleteService {
  private final CategoryRepository categoryRepository;

  public CategoryDeleteService(CategoryRepository categoryRepository) {
    this.categoryRepository = categoryRepository;
  }

  @Transactional(propagation = Propagation.SUPPORTS)
  public void execute(UUID categoryId){
    if (!categoryRepository.existsById(categoryId)) {
      throw new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + categoryId);
    }
    try {
      categoryRepository.deleteById(categoryId);
    }
    catch (DataIntegrityViolationException e) {
      throw new AppDataIntegrityViolationException(AppExceptionConstants.DATA_INTEGRITY_VIOLATION + categoryId);
    }
  }
}
