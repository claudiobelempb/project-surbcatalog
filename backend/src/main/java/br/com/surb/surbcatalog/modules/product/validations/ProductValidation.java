package br.com.surb.surbcatalog.modules.product.validations;

import br.com.surb.surbcatalog.modules.product.repositories.ProductRepository;
import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.validator.create.UserCreateValid;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidFieldMessage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class ProductValidation implements ConstraintValidator<UserCreateValid, UserCreateDTO> {

    private final ProductRepository productRepository;

    public ProductValidation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void initialize(UserCreateValid ann) {
    }

    @Override
    public boolean isValid(UserCreateDTO dto, ConstraintValidatorContext context) {
        List<AppValidFieldMessage> appValidFieldMessages = new ArrayList<>();

//        userRepository
//                .findByEmailAndActive(dto.getEmail(), true)
//                .ifPresent(user -> {
//                    if (!Objects.isNull(dto.getEmail())) {
//                        appValidFieldMessages.add(new AppValidFieldMessage("email", AppValidatorConstants.REQUIRED_EMAIL_EXIST));
//                    }
//                });


        for (AppValidFieldMessage e : appValidFieldMessages) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return appValidFieldMessages.isEmpty();
    }

}

