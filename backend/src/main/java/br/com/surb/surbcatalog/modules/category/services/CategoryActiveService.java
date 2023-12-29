package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class CategoryActiveService {
    private final CategoryRepository categoryRepository;

    public CategoryActiveService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void execute(UUID categoryId) {
        Objects.requireNonNull(categoryId);
        categoryRepository
                .findByCategoryIdAndActive(categoryId, false)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + categoryId));
        categoryRepository.activate(categoryId);
    }
}
