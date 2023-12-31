package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
import br.com.surb.surbcatalog.modules.allocation.validator.AllocationValidator;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static br.com.surb.surbcatalog.modules.allocation.mapper.AllocationMapper.createAllocationDTOToEntity;
import static br.com.surb.surbcatalog.modules.allocation.mapper.AllocationMapper.entityToAllocationCreateDTO;

@Service
public class AllocationCreateService {
    private final AllocationRepository allocationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final AllocationValidator allocationCreateValidator;
    private final AllocationNotificationService allocationNotificationService;

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
        this.allocationNotificationService = allocationNotificationService;
    }

    @Transactional
    public AllocationDTO execute(AllocationCreateDTO dto) {
        Room room = roomRepository
                .findById(dto.getRoomId())
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + "RoomId " + dto.getRoomId()));
        User user = userRepository
                .findById(dto.getUserId().getUserId())
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + "UserId " + dto.getUserId()));

        allocationCreateValidator.validate(dto);
        Allocation entity = createAllocationDTOToEntity(dto);
        System.out.println("Entity: " + entity);
        allocationRepository.save(entity);
//        allocationNotificationService.notifyAllocationCreate(entity);
        return entityToAllocationCreateDTO(entity, room.getRoomId(), user);
    }
}
