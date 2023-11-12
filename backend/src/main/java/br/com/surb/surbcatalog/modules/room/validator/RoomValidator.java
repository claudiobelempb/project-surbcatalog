package br.com.surb.surbcatalog.modules.room.validator;

import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.shared.AppUtils.AppValidatorUtils;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import org.springframework.stereotype.Component;

@Component
public class RoomValidator {
    public void validate(RoomDTO roomDTO){
        AppValidationErrors appValidateErrors = new AppValidationErrors();

        //Room name
        AppValidatorUtils.validateRequiredValid(roomDTO.getName(), "name", appValidateErrors);
        AppValidatorUtils.validateMaxLengthValid(roomDTO.getName(), "name", 20, appValidateErrors);
        AppValidatorUtils.validateMinLengthValid(roomDTO.getName(), "name", 5, appValidateErrors);

        //Room seats
        AppValidatorUtils.validateRequiredValid(roomDTO.getSeats(), "seats", appValidateErrors);
        AppValidatorUtils.validateMaxValueValid(roomDTO.getSeats(), "seats", 20, appValidateErrors);
        AppValidatorUtils.validateMinValueValid(roomDTO.getSeats(), "seats", 1, appValidateErrors);

        AppValidatorUtils.throwOnError(appValidateErrors);
    }
}
