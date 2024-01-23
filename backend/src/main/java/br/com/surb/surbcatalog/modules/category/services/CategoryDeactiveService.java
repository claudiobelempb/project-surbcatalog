package br.com.surb.surbcatalog.modules.category.services;

import br.com.surb.surbcatalog.modules.category.entities.Category;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class CategoryDeactiveService {
    private final CategoryRepository categoryRepository;

    public CategoryDeactiveService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Transactional
    public void execute(UUID categoryId){
        Objects.requireNonNull(categoryId);
        Category entiry = categoryRepository.findByCategoryIdAndActive(categoryId, true)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + categoryId));
        entiry.setActive(false);
        categoryRepository.save(entiry);
    }

}
