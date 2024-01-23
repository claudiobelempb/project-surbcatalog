package br.com.surb.surbcatalog.modules.room.mapper;

import br.com.surb.surbcatalog.modules.room.dto.RoomCreateDTO;
import br.com.surb.surbcatalog.modules.room.dto.RoomUpdateDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomUpdateMapper {

    public RoomUpdateMapper() {
    }

    public static Room fromEntiry(RoomUpdateDTO dto) {
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

    public static RoomUpdateDTO fromDTO(Room entity) {
        if (entity == null) {
            return null;
        }
        return new RoomUpdateDTO(
                entity.getRoomId(),
                entity.getName(),
                entity.getSeats(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getActive()
        );
    }

}
