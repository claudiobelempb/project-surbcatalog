package br.com.surb.surbcatalog.modules.room.mapper;

import br.com.surb.surbcatalog.modules.room.dto.RoomCreateDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomCreateMapper {

    public RoomCreateMapper() {
    }

    public static Room fromEntiry(RoomCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        return Room.newBuilder()
                .roomId(dto.roomId())
                .name(dto.name())
                .seats(dto.seats())
                .createdAt(dto.createdAt())
                .updatedAt(dto.updatedAt())
                .active(dto.active())
                .build();
    }

    public static RoomCreateDTO fromDTO(Room entity) {
        if (entity == null) {
            return null;
        }
        return new RoomCreateDTO(
                entity.getRoomId(),
                entity.getName(),
                entity.getSeats(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getActive()
        );
    }

}
