package br.com.surb.surbcatalog.modules.allocation.validator;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationUpdateDTO;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import br.com.surb.surbcatalog.shared.AppUtils.AppValidatorUtils;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.OffsetDateTime;
import java.util.UUID;

@Component
public class AllocationValidator {
    private final AllocationRepository allocationRepository;

    public AllocationValidator(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    public void validate(AllocationCreateDTO dto) {
        AppValidationErrors appValidateErrors = new AppValidationErrors();
        validateSubject(dto.getSubject(), appValidateErrors);
        validateDates(dto.getStartAt(), dto.getEndAt(), appValidateErrors);

        AppValidatorUtils.throwOnError(appValidateErrors);
    }

    public void validate(UUID allocationId, AllocationUpdateDTO dto) {
        AppValidationErrors appValidateErrors = new AppValidationErrors();
        AppValidatorUtils.validateRequiredValid(allocationId, "allocationId", appValidateErrors);
        validateSubject(dto.getSubject(), appValidateErrors);
        validateDates(dto.getStartAt(), dto.getEndAt(), appValidateErrors);

        AppValidatorUtils.throwOnError(appValidateErrors);
    }

    private static void validateSubject(String subject, AppValidationErrors appValidateErrors) {

        AppValidatorUtils.validateRequiredValid(subject, "subject", appValidateErrors);
        AppValidatorUtils.validateMaxLengthValid(subject, "subject", 60, appValidateErrors);
        AppValidatorUtils.validateMinLengthValid(subject, "subject", 5, appValidateErrors);

    }

    private static void validateDates(OffsetDateTime startAt, OffsetDateTime endAt, AppValidationErrors appValidationErrors) {
        if (validateDatesPresent(startAt, endAt, appValidationErrors)) {
            validateDateOrdering(startAt, endAt, appValidationErrors);
            validateDateInTheFuture(startAt, appValidationErrors);
            validateDuration(startAt, endAt, appValidationErrors);
            validateIfTimeAvailable(startAt, endAt, appValidationErrors);
        }
    }

    private static boolean validateDatesPresent(OffsetDateTime startAt, OffsetDateTime endAt, AppValidationErrors appValidationErrors) {
        return (
                AppValidatorUtils.validateRequiredValid(startAt, "startAt", appValidationErrors) &&
                        AppValidatorUtils.validateRequiredValid(endAt, "endAt", appValidationErrors)
        );
    }

    private static boolean validateDateOrdering(OffsetDateTime startAt, OffsetDateTime endAt, AppValidationErrors appValidationErrors) {
        if (startAt.isEqual(endAt) || startAt.isAfter(endAt)) {
            appValidationErrors.addErrors("startAt", AppValidatorConstants.INVALID_ORDER_DATE);
            return false;
        }
        return true;
    }

    private static void validateDateInTheFuture(OffsetDateTime date, AppValidationErrors appValidationErrors) {
        if (date.isBefore(AppDateUtils.now())) {
            appValidationErrors.addErrors("startAt", AppValidatorConstants.IN_THE_PAST);
        }
    }

    private static void validateDuration(OffsetDateTime startAt, OffsetDateTime endAt, AppValidationErrors appValidationErrors) {
        if (Duration.between(startAt, endAt).getSeconds() > 4 * 60 * 60) {
            appValidationErrors.addErrors("endAt", AppValidatorConstants.EXCEEDS_DURATION);
        }
    }

    private static void validateIfTimeAvailable(OffsetDateTime startAt, OffsetDateTime endAt, AppValidationErrors appValidationErrors) {
        //TODO
    }

}
