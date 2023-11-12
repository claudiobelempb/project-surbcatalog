package br.com.surb.surbcatalog.modules.room.services;

import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.room.mapper.RoomMapper;
import br.com.surb.surbcatalog.modules.room.repositories.RoomRepository;
import br.com.surb.surbcatalog.modules.room.validator.RoomValidator;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class RoomCreateService {
    private final RoomRepository roomRepository;
    private final RoomValidator roomValidator;

    public RoomCreateService(RoomRepository roomRepository, RoomValidator roomValidator) {
        this.roomRepository = roomRepository;
        this.roomValidator = roomValidator;
    }

    @Transactional
    public RoomDTO execute(RoomDTO roomDTO){
        roomValidator.validate(roomDTO);
        Room room = RoomMapper.copyCreateEntityToDto(roomDTO);
        roomRepository.save(room);
        return RoomMapper.copyEntityToDto(room);
    }
}
