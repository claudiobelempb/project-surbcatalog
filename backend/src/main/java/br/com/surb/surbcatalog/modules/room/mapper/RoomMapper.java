package br.com.surb.surbcatalog.modules.room.mapper;

import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.stereotype.Component;

@Component
public abstract class RoomMapper {
    public static RoomDTO copyEntityToDto(Room room){
        if(room == null){
            return null;
        }
        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setRoomId(room.getRoomId());
        roomDTO.setName(room.getName());
        roomDTO.setSeats(room.getSeats());
        roomDTO.setActive(room.getActive());
        roomDTO.setCreatedAt(room.getCreatedAt());
        roomDTO.setUpdatedAt(room.getUpdatedAt());

        return roomDTO;
    }

    public static Room copyCreateEntityToDto(RoomDTO roomDTO){
        if(roomDTO == null){
            return null;
        }
        return Room.newRoomBuilder()
            .roomId(roomDTO.getRoomId())
            .name(roomDTO.getName())
            .seats(roomDTO.getSeats())
            .active(roomDTO.getActive())
            .createdAt(roomDTO.getCreatedAt())
            .updatedAt(roomDTO.getUpdatedAt())
            .build();
    }

}
