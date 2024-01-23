package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.allocation.mapper.AllocationCreateMapper;
import br.com.surb.surbcatalog.modules.allocation.mapper.AllocationMapper;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
import br.com.surb.surbcatalog.modules.allocation.validator.AllocationValidator;
import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AllocationCreateService {
    private final AllocationRepository allocationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final AllocationValidator allocationCreateValidator;
//    private final AllocationNotificationService allocationNotificationService;

    public AllocationCreateService(
            AllocationRepository allocationRepository,
            RoomRepository roomRepository,
            UserRepository userRepository,
            AllocationValidator allocationCreateValidator,
            AllocationNotificationService allocationNotificationService) {
        this.allocationRepository = allocationRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
        this.allocationCreateValidator = allocationCreateValidator;
//        this.allocationNotificationService = allocationNotificationService;
    }

    @Transactional
    public AllocationCreateDTO execute(AllocationCreateDTO dto) {
        roomRepository
                .findById(dto.allocationId())
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + "RoomId " + dto.roomId()));
        userRepository
                .findById(dto.allocationId())
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + "UserId " + dto.userId()));

        allocationCreateValidator.validate(dto);
        Allocation entity = Allocation.newBuilder().allocationId(dto.allocationId()).build();
        allocationRepository.save(entity);
        //allocationNotificationService.notifyAllocationCreate(entity);
        return AllocationCreateMapper.fromDTO(entity);
    }
}
