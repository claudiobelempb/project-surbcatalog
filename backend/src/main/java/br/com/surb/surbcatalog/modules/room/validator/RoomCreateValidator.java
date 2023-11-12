package br.com.surb.surbcatalog.modules.room.validator;

import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource.AppFieldMessage;
import br.com.surb.surbcatalog.shared.AppUtils.AppValidatorUtils;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.ArrayList;
import java.util.List;

public class RoomCreateValidator implements ConstraintValidator<RoomCreateValid, RoomDTO> {

    @Override
    public void initialize(RoomCreateValid ann) {
    }

    @Override
    public boolean isValid(RoomDTO roomDTO, ConstraintValidatorContext context) {

        List<AppFieldMessage> appFieldMessages = new ArrayList<>();

        /*if(roomDTO.getName() != null){
            appFieldMessages.add(new AppFieldMessage( "name", AppValidatorConstants.REQUIRED_EMAIL_EXIST));
        }*/

        //Room
        /*if(StringUtils.isBlank(roomDTO.getName())){
            appFieldMessages.add(new AppFieldMessage("name", AppValidatorConstants.REQUIRED_FIELD));
        }*/
        AppValidatorUtils.validateRequired(roomDTO.getName(), "name", appFieldMessages);
        AppValidatorUtils.validateMaxLength(roomDTO.getName(), "name", 20, appFieldMessages);
        AppValidatorUtils.validateMinLength(roomDTO.getName(), "name", 5, appFieldMessages);

        //Room Seats
        AppValidatorUtils.validateRequired(String.valueOf(roomDTO.getSeats()), "seats", appFieldMessages);
        //AppValidatorUtils.validateMaxValue(roomDTO.getSeats(), 20, appFieldMessages);
        //AppValidatorUtils.validateMinValue(roomDTO.getSeats(), 5, appFieldMessages);

        for (AppFieldMessage e : appFieldMessages) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
                    .addConstraintViolation();
        }
        return appFieldMessages.isEmpty();
    }
}
