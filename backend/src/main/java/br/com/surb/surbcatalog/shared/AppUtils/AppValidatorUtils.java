package br.com.surb.surbcatalog.shared.AppUtils;

import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppInvalidRequestException;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import io.micrometer.common.util.StringUtils;

import java.util.Objects;

public final class AppValidatorUtils {
    private AppValidatorUtils(){}

    public static void throwOnError(AppValidationErrors appValidateErrors){
        if(appValidateErrors.hasErrors()){
            throw new AppInvalidRequestException(appValidateErrors);
        }
    }

    public static boolean validateRequiredValid(String field, String fieldName, AppValidationErrors validationErrors){
        if(StringUtils.isBlank(field)){
            validationErrors.addErrors(fieldName, AppValidatorConstants.REQUIRED_FIELD);
            return false;
        }
        return true;
    }

    public static boolean validateRequiredValid(Object field, String fieldName, AppValidationErrors appValidateErrors){
        if(Objects.isNull(field)){
            appValidateErrors.addErrors(fieldName,  AppValidatorConstants.REQUIRED_FIELD);
            return false;
        }
        return true;
    }

    public static boolean validateMaxLengthValid(String field, String fieldName,  int maxLength, AppValidationErrors appValidateErrors){
        if(!StringUtils.isBlank(field) && field.trim().length() > maxLength){
            appValidateErrors.addErrors(fieldName,   AppValidatorConstants.MAX + maxLength + " caracteres");
            return false;
        }
        return true;
    }

    public static boolean validateMinLengthValid(String field, String fieldName, int minLength, AppValidationErrors appValidateErrors){
        if(!StringUtils.isBlank(field) && field.trim().length() < minLength){
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.MIN + minLength + " caracteres");
            return false;
        }
        return true;
    }

    public static boolean validateMaxValueValid(Integer field, String fieldName, Integer maxValue, AppValidationErrors appValidateErrors){
        if(!Objects.isNull(field) && field > maxValue){
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.REQUIRED_NUMBER);
            return false;
        }
        return true;
    }

    public static boolean validateMinValueValid(Integer field, String fieldName, int minValue, AppValidationErrors appValidateErrors){
        if(!Objects.isNull(field) && field < minValue){
            appValidateErrors.addErrors(fieldName,AppValidatorConstants.REQUIRED_NUMBER);
            return false;
        }
        return true;
    }
}
