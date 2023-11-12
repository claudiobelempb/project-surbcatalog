package br.com.surb.surbcatalog.shared.AppUtils;

import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource.AppFieldMessage;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppInvalidRequestException;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import io.micrometer.common.util.StringUtils;

import java.util.List;
import java.util.Objects;

public final class AppValidatorUtils {
    private AppValidatorUtils(){}

    public static void throwOnError(AppValidationErrors appValidateErrors){
        if(appValidateErrors.hasErrors()){
            throw new AppInvalidRequestException(appValidateErrors);
        }
    }

    public static void validateRequired(String field, String fildName, List<AppFieldMessage> appFieldMessages){
        if(StringUtils.isBlank(field)){
           appFieldMessages.add(new AppFieldMessage( field, fildName,  AppValidatorConstants.REQUIRED_FIELD));
        }
    }

    public static void validateRequired(Object field, String fieldName, List<AppFieldMessage> appFieldMessages){
        if(Objects.isNull(field)){
            appFieldMessages.add(new AppFieldMessage(fieldName, fieldName,  AppValidatorConstants.REQUIRED_FIELD));
        }
    }

    public static void validateMaxLength(String field, String fieldName,  int maxLength, List<AppFieldMessage> appFieldMessages){
        if(!StringUtils.isBlank(field) && field.trim().length() > maxLength){
            appFieldMessages.add(new AppFieldMessage( field, fieldName, AppValidatorConstants.MAX + maxLength + " caracteres"));
        }
    }

    public static void validateMinLength(String field, String fieldName, int minLength, List<AppFieldMessage> appFieldMessages){
        if(!StringUtils.isBlank(field) && field.trim().length() < minLength){
            appFieldMessages.add(new AppFieldMessage( field, fieldName, AppValidatorConstants.MIN + minLength + " caracteres"));
        }
    }

    public static void validateMaxValue(Integer value, Integer maxValue, List<AppFieldMessage> appFieldMessages){
        if(!Objects.isNull(value) && value > maxValue){
            appFieldMessages.add(new AppFieldMessage(AppValidatorConstants.MAX + maxValue + " valor"));
        }
    }

    public static void validateMinValue(Integer value, int minValue, List<AppFieldMessage> appFieldMessages){
        if(!Objects.isNull(value) && value < minValue){
            appFieldMessages.add(new AppFieldMessage(AppValidatorConstants.MAX + minValue + " valor"));
        }
    }

    /*Valid*/
    public static void validateRequiredValid(String field, String fieldName, AppValidationErrors validationErrors){
        if(StringUtils.isBlank(field)){
            validationErrors.addErrors(field, fieldName + AppValidatorConstants.REQUIRED_FIELD);
        }
    }

    public static void validateRequiredValid(Object field, String fieldName, AppValidationErrors appValidateErrors){
        if(Objects.isNull(field)){
            appValidateErrors.addErrors(fieldName, fieldName +   AppValidatorConstants.REQUIRED_FIELD);
        }
    }

    public static void validateMaxLengthValid(String field, String fieldName,  int maxLength, AppValidationErrors appValidateErrors){
        if(!StringUtils.isBlank(field) && field.trim().length() > maxLength){
            appValidateErrors.addErrors(field, fieldName +  AppValidatorConstants.MAX + maxLength + " caracteres");
        }
    }

    public static void validateMinLengthValid(String field, String fieldName, int minLength, AppValidationErrors appValidateErrors){
        if(!StringUtils.isBlank(field) && field.trim().length() < minLength){
            appValidateErrors.addErrors(field, fieldName + AppValidatorConstants.MIN + minLength + " caracteres");
        }
    }

    public static void validateMaxValueValid(Integer field, String fieldName, Integer maxValue, AppValidationErrors appValidateErrors){
        if(!Objects.isNull(field) && field > maxValue){
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.MAX + maxValue);
        }
    }

    public static void validateMinValueValid(Integer field, String fieldName, int minValue, AppValidationErrors appValidateErrors){
        if(!Objects.isNull(field) && field < minValue){
            appValidateErrors.addErrors(fieldName,AppValidatorConstants.MIN + minValue);
        }
    }
}
