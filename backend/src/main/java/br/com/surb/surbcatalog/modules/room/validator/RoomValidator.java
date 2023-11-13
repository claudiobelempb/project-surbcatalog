package br.com.surb.surbcatalog.modules.room.validator;

import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppInvalidRequestException;
import br.com.surb.surbcatalog.shared.AppUtils.AppValidatorUtils;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidError;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationError;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import org.springframework.boot.context.properties.bind.validation.ValidationErrors;
import org.springframework.stereotype.Component;

@Component
public class RoomValidator {

    private final RoomRepository roomRepository;

    public RoomValidator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void validate(RoomDTO roomDTO){
        AppValidationErrors appValidateErrors = new AppValidationErrors();

        validateName(roomDTO.getName(), appValidateErrors);
        validateSeats(roomDTO.getSeats(), appValidateErrors);
        validateNameDuplicate(roomDTO.getName(), appValidateErrors);

        AppValidatorUtils.throwOnError(appValidateErrors);
    }

    private static void validateName(String name, AppValidationErrors appValidateErrors) {
        AppValidatorUtils.validateRequiredValid(name, "name", appValidateErrors);
        AppValidatorUtils.validateMaxLengthValid(name, "name", 20, appValidateErrors);
        AppValidatorUtils.validateMinLengthValid(name, "name", 5, appValidateErrors);
    }

    private static void validateSeats(Integer value, AppValidationErrors appValidateErrors) {
        AppValidatorUtils.validateRequiredValid(value, "seats", appValidateErrors);
        AppValidatorUtils.validateMaxValueValid(value, "seats", 20, appValidateErrors);
        AppValidatorUtils.validateMinValueValid(value, "seats", 1, appValidateErrors);
    }

    private void validateNameDuplicate(String name, AppValidationErrors appValidationErrors){
        roomRepository
                .findByNameAndActive(name, true)
                .ifPresent(__ -> appValidationErrors.addErrors("name", AppValidatorConstants.REQUIRED_NAME_EXIST));
    }
}
