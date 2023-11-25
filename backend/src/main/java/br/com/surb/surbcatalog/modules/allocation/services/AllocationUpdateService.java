package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationUpdateDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
import br.com.surb.surbcatalog.modules.allocation.validator.AllocationValidator;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppInvalidRequestException;
import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class AllocationUpdateService {
    private final AllocationRepository allocationRepository;
    private final AllocationValidator allocationValidator;

    public AllocationUpdateService(AllocationRepository allocationRepository, AllocationValidator allocationValidator) {
        this.allocationRepository = allocationRepository;
        this.allocationValidator = allocationValidator;
    }

    @Transactional
    public void execute(UUID allocationId, AllocationUpdateDTO dto) {
        AppValidationErrors appValidateErrors = new AppValidationErrors();

        Objects.requireNonNull(allocationId);
        allocationValidator.validate(allocationId, dto);
        Allocation entity = allocationRepository
                .findById(allocationId)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + allocationId));
        if (entity.getEndAt().isBefore(AppDateUtils.now())) {
            throw new AppInvalidRequestException(AppValidatorConstants.IN_THE_PAST + allocationId, appValidateErrors);
        }
        allocationRepository.update(allocationId, dto.getSubject(), dto.getStartAt(), dto.getEndAt());
    }
}
