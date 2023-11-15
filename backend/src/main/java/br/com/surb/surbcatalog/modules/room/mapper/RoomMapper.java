package br.com.surb.surbcatalog.modules.room.mapper;

import br.com.surb.surbcatalog.modules.room.dto.RoomCreateDTO;
import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.dto.RoomUpdateDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.stereotype.Component;

@Component
public abstract class RoomMapper {
    public static RoomDTO copyEntityToDto(Room room){
        if(room == null){
            return null;
        }
        RoomDTO dto = new RoomDTO();

        dto.setRoomId(room.getRoomId());
        dto.setName(room.getName());
        dto.setSeats(room.getSeats());
        dto.setActive(room.getActive());
        dto.setCreatedAt(room.getCreatedAt());
        dto.setUpdatedAt(room.getUpdatedAt());

        return dto;
    }

    public static RoomCreateDTO copyCreateEntityToDto(Room room){
        if(room == null){
            return null;
        }
        RoomCreateDTO dto = new RoomCreateDTO();

        dto.setRoomId(room.getRoomId());
        dto.setSeats(room.getSeats());
        dto.setActive(room.getActive());
        dto.setCreatedAt(room.getCreatedAt());
        dto.setUpdatedAt(room.getUpdatedAt());

        return dto;
    }

    public static RoomUpdateDTO copyUpdateEntityToDto(Room room){
        if(room == null){
            return null;
        }
        RoomUpdateDTO dto = new RoomUpdateDTO();

        dto.setRoomId(room.getRoomId());
        dto.setName(room.getName());
        dto.setSeats(room.getSeats());
        dto.setActive(room.getActive());
        dto.setCreatedAt(room.getCreatedAt());
        dto.setUpdatedAt(room.getUpdatedAt());

        return dto;
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

    public static Room copyDtoToEntity(RoomDTO roomDTO){
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
