package br.com.surb.surbcatalog.modules.room.services;

import br.com.surb.surbcatalog.modules.room.dto.RoomUpdateDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.modules.room.validator.RoomValidator;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class RoomUpdateService {
    private final RoomRepository roomRepository;
    private final RoomValidator roomValidator;

    public RoomUpdateService(RoomRepository roomRepository, RoomValidator roomValidator) {
        this.roomRepository = roomRepository;
        this.roomValidator = roomValidator;
    }

    @Transactional
    public void execute(UUID roomId, RoomUpdateDTO dto){
        getActiveOrThrow(roomId);
        roomValidator.validate(roomId, dto);
        roomRepository.update(roomId, dto.getName(), dto.getSeats());
    }

    private Room getActiveOrThrow(UUID roomId) {
        Objects.requireNonNull(roomId);
        return roomRepository
            .findByRoomIdAndActive(roomId, true)
            .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + roomId));
    }
}
