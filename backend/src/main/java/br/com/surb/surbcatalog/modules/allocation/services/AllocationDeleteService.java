package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppConstants.AppValidatorConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppInvalidRequestException;
import br.com.surb.surbcatalog.shared.AppUtils.AppDateUtils;
import br.com.surb.surbcatalog.shared.AppValidator.AppValidationErrors;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AllocationDeleteService {
    private final AllocationRepository allocationRepository;

    public AllocationDeleteService(AllocationRepository allocationRepository) {
        this.allocationRepository = allocationRepository;
    }

    public void execute(UUID allocationId){
        AppValidationErrors appValidateErrors = new AppValidationErrors();
        Allocation entity = allocationRepository
                .findById(allocationId)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + allocationId));
        if(entity.getEndAt().isBefore(AppDateUtils.now())){
            throw new AppInvalidRequestException(AppValidatorConstants.IN_THE_PAST + allocationId, appValidateErrors);
        }
        allocationRepository.delete(entity);
    }
}
