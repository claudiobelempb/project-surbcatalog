package br.com.surb.surbcatalog.modules.room.validator;

import br.com.surb.surbcatalog.modules.room.dto.RoomCreateDTO;
import br.com.surb.surbcatalog.modules.room.dto.RoomUpdateDTO;
import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppUtils.AppValidatorUtils;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class RoomValidator {

    private final RoomRepository roomRepository;

    public RoomValidator(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void validate(RoomCreateDTO roomDTO){
        AppValidationErrors appValidateErrors = new AppValidationErrors();
        if(
            validateName(roomDTO.name(), appValidateErrors) &&
            validateSeats(roomDTO.seats(), appValidateErrors)
        ){
            validateNameDuplicate(null, roomDTO.name(), appValidateErrors);
        }

        AppValidatorUtils.throwOnError(appValidateErrors);
    }

    public void validate(UUID roomId, RoomUpdateDTO dto){
        AppValidationErrors appValidateErrors = new AppValidationErrors();
        if(
            AppValidatorUtils.validateRequiredValid(roomId, "name", appValidateErrors) &&
            validateName(dto.name(), appValidateErrors) &&
            validateSeats(dto.seats(), appValidateErrors)
        ){
            validateNameDuplicate(roomId, dto.name(), appValidateErrors);
        }

        AppValidatorUtils.throwOnError(appValidateErrors);
    }

    private static boolean validateName(String name, AppValidationErrors appValidateErrors) {
        return (
            AppValidatorUtils.validateRequiredValid(name, "name", appValidateErrors) &&
            AppValidatorUtils.validateMaxLengthValid(name, "name", 20, appValidateErrors) &&
            AppValidatorUtils.validateMinLengthValid(name, "name", 5, appValidateErrors)
        );
    }

    private static boolean validateSeats(Integer value, AppValidationErrors appValidateErrors) {
        return (
            AppValidatorUtils.validateRequiredValid(value, "seats", appValidateErrors) &&
            AppValidatorUtils.validateMaxValueValid(value, "seats", 20, appValidateErrors) &&
            AppValidatorUtils.validateMinValueValid(value, "seats", 1, appValidateErrors)
        );
    }

    private void validateNameDuplicate(UUID roomIdToExclude, String name, AppValidationErrors appValidationErrors){
        roomRepository
                .findByNameAndActive(name, true)
                .ifPresent(room -> {
                    if(!Objects.isNull(roomIdToExclude) && !Objects.equals(room.getRoomId(), roomIdToExclude)) {
                        appValidationErrors.addErrors("name", AppValidatorConstants.REQUIRED_EXIST);
                    }
                });
    }
}
