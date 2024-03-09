package br.com.surb.surbcatalog.modules.room.services;

import br.com.surb.surbcatalog.modules.room.dto.RoomCreateDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.room.mapper.RoomCreateMapper;
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
    public RoomCreateDTO execute(RoomCreateDTO dto) {
        roomValidator.validate(dto);
        Room room = RoomCreateMapper.fromEntiry(dto);
        roomRepository.save(room);
        return RoomCreateMapper.fromDTO(room);
    }

}
