package br.com.surb.surbcatalog.modules.allocation.services;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.allocation.mapper.AllocationMapper;
import br.com.surb.surbcatalog.modules.allocation.repositories.AllocationRepository;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

@Service
public class AllocationCreateService {
    private final AllocationRepository allocationRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    public AllocationCreateService(AllocationRepository allocationRepository, RoomRepository roomRepository, UserRepository userRepository) {
        this.allocationRepository = allocationRepository;
        this.roomRepository = roomRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public AllocationCreateDTO execute(AllocationCreateDTO dto){
        Room room = roomRepository
                .findById(dto.getRoomId())
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + dto.getRoomId()));
        User user = userRepository
                .findById(dto.getUserId())
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + dto.getUserId()));
        Allocation entity = AllocationMapper.copyEntity(dto, room, user);
        System.out.println(entity);

        allocationRepository.save(entity);
        return AllocationMapper.copyCreateDTO(entity);
    }
}
