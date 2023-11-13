package br.com.surb.surbcatalog.modules.room.validator;

import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppInvalidRequestException;
import br.com.surb.surbcatalog.shared.AppUtils.AppValidatorUtils;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidError;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationError;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import org.springframework.stereotype.Component;

@Component
public class RoomValidator {

    private final RoomRepository roomRepository;

    public RoomValidator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

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

        validateNameDuplicate(roomDTO.getName());
    }

    private void validateNameDuplicate(String name){
        roomRepository.findByNameAndActive(name, true).ifPresent(__ -> {
            throw new AppInvalidRequestException(new AppValidError("name", AppValidatorConstants.REQUIRED_NAME_EXIST));
        });
    }
}
