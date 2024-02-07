package br.com.surb.surbcatalog.modules.user.validator.create;

import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidFieldMessage;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
public class UserCreateValidation implements ConstraintValidator<UserCreateValid, UserCreateDTO> {

    private final UserRepository userRepository;

    public UserCreateValidation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void initialize(UserCreateValid ann) {
    }

    @Override
    public boolean isValid(UserCreateDTO dto, ConstraintValidatorContext context) {
        List<AppValidFieldMessage> appValidFieldMessages = new ArrayList<>();

//        userRepository
//                .findByFirstNameAndActive(dto.getFirstName(), true)
//                .ifPresent(user -> {
//                    if (!Objects.isNull(dto.getFirstName())) {
//                        appValidFieldMessages.add(new AppValidFieldMessage("firstName", dto.getFirstName() + AppValidatorConstants.NAME_EXIST));
//                    }
//                });

        userRepository
                .findByEmailAndActive(dto.getEmail(), true)
                .ifPresent(user -> {
                    if (!Objects.isNull(dto.getEmail())) {
                        appValidFieldMessages.add(new AppValidFieldMessage("email", dto.getEmail() + AppValidatorConstants.REQUIRED_EMAIL_EXIST));
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
