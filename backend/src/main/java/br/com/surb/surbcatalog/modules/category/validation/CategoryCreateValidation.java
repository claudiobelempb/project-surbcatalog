package br.com.surb.surbcatalog.modules.category.validation;

import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.category.repositories.CategoryRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidFieldMessage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class CategoryCreateValidation implements ConstraintValidator<CategoryCreateValid, CategoryDTO> {

    private final CategoryRepository categoryRepository;

    public CategoryCreateValidation(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public void initialize(CategoryCreateValid ann) {
    }

    @Override
    public boolean isValid(CategoryDTO dto, ConstraintValidatorContext context) {
        List<AppValidFieldMessage> appValidFieldMessages = new ArrayList<>();

        categoryRepository
                .findByNameAndActive(dto.getName(), true)
                .ifPresent(user -> {
                    if (!Objects.isNull(dto.getName())) {
                        appValidFieldMessages.add(new AppValidFieldMessage("name", AppValidatorConstants.DUPLICATE));
                    }
                });


        for (AppValidFieldMessage e : appValidFieldMessages) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return appValidFieldMessages.isEmpty();
    }

}
