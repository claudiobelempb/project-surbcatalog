package br.com.surb.surbcatalog.shared.AppUtils;

import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsResource.AppFieldMessage;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppInvalidRequestException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppMethodArgumentNotValidException;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidErrors;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidFieldMessage;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import io.micrometer.common.util.StringUtils;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;
import java.util.Objects;

public final class AppValidatorUtils {
    private AppValidatorUtils() {
    }

    public static void throwOnError(AppValidErrors appValidErrors) {
        if (appValidErrors.hasErrors()) {
            throw new AppMethodArgumentNotValidException(appValidErrors);
        }
    }

    public static boolean validMinLength(String fieldName, Integer minLength, AppValidErrors appValidErrors) {
        if (!StringUtils.isBlank(fieldName) && fieldName.trim().length() < minLength) {
            appValidErrors.addErrors(fieldName, AppValidatorConstants.MIN_LENGTH + minLength + " caracteres");
            return false;
        }
        return true;
    }

    public static boolean validMaxLength(String fieldName, Integer maxLength, List<AppFieldMessage> appFieldMessages) {
        if (!StringUtils.isBlank(fieldName) && fieldName.trim().length() > maxLength) {
            appFieldMessages.add(new AppFieldMessage(fieldName, AppValidatorConstants.MIN_LENGTH + maxLength + " caracteres"));
            return false;
        }
        return true;
    }

    public static boolean validateRequired(String fieldName, AppValidErrors appValidErrors) {
        if (StringUtils.isBlank(fieldName)) {
            appValidErrors.addErrors(fieldName, fieldName + AppValidatorConstants.REQUIRED_FIELD);
            return false;
        }
        return true;
    }

    public static boolean validateRequired(Object field, String fieldName, AppValidationErrors appValidateErrors) {
        if (Objects.isNull(field)) {
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.REQUIRED_FIELD);
            return false;
        }
        return true;
    }


    public static boolean validateMaxLength(String field, String fieldName, int maxLength, AppValidationErrors appValidateErrors) {
        if (!StringUtils.isBlank(field) && fieldName.trim().length() > maxLength) {
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.MAX_LENGTH + maxLength + " caracteres");
            return false;
        }
        return true;
    }

    public static boolean validateMinLength(String field, String fieldName, int minLength, AppValidationErrors appValidateErrors) {
        if (!StringUtils.isBlank(field) && fieldName.trim().length() < minLength) {
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.MIN_LENGTH + minLength + " caracteres");
            return false;
        }
        return true;
    }


    public static boolean validateMaxLengthValid(String field, String fieldName, int maxLength, AppValidationErrors appValidateErrors) {
        if (!StringUtils.isBlank(field) && field.trim().length() > maxLength) {
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.MAX_LENGTH + maxLength + " caracteres");
            return false;
        }
        return true;
    }

    public static boolean validateMinLengthValid(String field, String fieldName, int minLength, AppValidationErrors appValidateErrors) {
        if (!StringUtils.isBlank(field) && field.trim().length() < minLength) {
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.MAX_LENGTH + minLength + " caracteres");
            return false;
        }
        return true;
    }

    public static boolean validateMaxValueValid(Integer field, String fieldName, Integer maxValue, AppValidationErrors appValidateErrors) {
        if (!Objects.isNull(field) && field > maxValue) {
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.MAX_VALUE);
            return false;
        }
        return true;
    }

    public static boolean validateMinValueValid(Integer field, String fieldName, int minValue, AppValidationErrors appValidateErrors) {
        if (!Objects.isNull(field) && field < minValue) {
            appValidateErrors.addErrors(fieldName, AppValidatorConstants.MIN_VALUE);
            return false;
        }
        return true;
    }
}
