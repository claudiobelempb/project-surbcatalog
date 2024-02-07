package br.com.surb.surbcatalog.modules.user.validator.update;

import br.com.surb.surbcatalog.modules.user.dto.UserUpdateDTO;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidFieldMessage;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;

import java.util.*;

@Component
public class UserUpdateValidation implements ConstraintValidator<UserUpdateValid, UserUpdateDTO> {

    private final UserRepository userRepository;
    private final HttpServletRequest request;

    public UserUpdateValidation(UserRepository userRepository, HttpServletRequest request) {
        this.userRepository = userRepository;
        this.request = request;
    }

    @Override
    public void initialize(UserUpdateValid ann) {
    }

    @Override
    public boolean isValid(UserUpdateDTO dto, ConstraintValidatorContext context) {
        List<AppValidFieldMessage> appValidFieldMessages = new ArrayList<>();
        var uriVas = (Map<String, String>) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        UUID userId = UUID.fromString(uriVas.get("userId"));

        userRepository
                .findByEmailAndActive(dto.getEmail(), true)
                .ifPresent(user -> {
                    if (!Objects.isNull(dto.getEmail()) && !userId.equals(user.getUserId())) {
                        appValidFieldMessages.add(new AppValidFieldMessage("email", AppValidatorConstants.REQUIRED_EMAIL_EXIST));
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
