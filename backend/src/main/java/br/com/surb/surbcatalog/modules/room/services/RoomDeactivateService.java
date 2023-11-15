package br.com.surb.surbcatalog.modules.room.services;

import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class RoomDeactivateService {
    private final RoomRepository roomRepository;

    public RoomDeactivateService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Transactional
    public void execute(UUID roomId){
        Objects.requireNonNull(roomId);
        roomRepository
                .findByRoomIdAndActive(roomId, true)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + roomId));
        roomRepository.deactivate(roomId);
    }
}
