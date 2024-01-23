package br.com.surb.surbcatalog.modules.room.mapper;

import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.stereotype.Component;

@Component
public class RoomMapper {

    public RoomMapper() {
    }

    public static Room fromEntity(RoomDTO dto) {
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

    public static RoomDTO fromDTO(Room entity) {
        if (entity == null) {
            return null;
        }
        return new RoomDTO(
                entity.getRoomId(),
                entity.getName(),
                entity.getSeats(),
                entity.getCreatedAt(),
                entity.getUpdatedAt(),
                entity.getActive()
        );
    }

}
