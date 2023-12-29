package br.com.surb.surbcatalog.modules.room.mapper;

import br.com.surb.surbcatalog.modules.room.dto.RoomCreateDTO;
import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.stereotype.Component;

@Component
public abstract class RoomMapper {
    public static Room fromCreateDTOToEntity(RoomCreateDTO dto) {
        if (dto == null) {
            return null;
        }
        return Room.newBuilder()
                .roomId(dto.getRoomId())
                .name(dto.getName())
                .seats(dto.getSeats())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .active(dto.getActive())
                .build();
    }

    public static RoomDTO fromEntityToDTO(Room entity) {
        if (entity == null) {
            return null;
        }
        return RoomCreateDTO.newBuilderDTO()
                .roomId(entity.getRoomId())
                .name(entity.getName())
                .seats(entity.getSeats())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .active(entity.getActive())
                .build();
    }

}
