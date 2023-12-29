package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.dto.CategoryUpdateDTO;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class CategoryUpdateService {
    private final CategoryRepository categoryRepository;

    public CategoryUpdateService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void execute(UUID categoryId, CategoryUpdateDTO dto) {
        try {
            Objects.requireNonNull(categoryId);
            categoryRepository
                    .findByCategoryIdAndActive(categoryId, true)
                    .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + categoryId));
            categoryRepository.update(categoryId, dto.name());
        } catch (EntityNotFoundException e) {
            throw new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + categoryId);
        }
    }
}
