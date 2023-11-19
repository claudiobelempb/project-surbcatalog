package br.com.surb.surbcatalog.modules.allocation.mapper;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.user.entities.User;

public abstract class AllocationMapper {

    public static Allocation copyEntity(AllocationCreateDTO dto, Room room, User user){
        if(dto == null){
            return null;
        }
        return Allocation.newAllocation()
                .allocationId(dto.getAllocationId())
                .subject(dto.getSubject())
                .startAt(dto.getStartAt())
                .endAt(dto.getEndAt())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .active(dto.getActive())
                .room(room)
                .user(user)
                .build();
    }

    public static Allocation copyCreateEntity(AllocationCreateDTO dto, Room room, User user){
        if(dto == null){
            return null;
        }
        return Allocation.newAllocation()
                .allocationId(dto.getAllocationId())
                .subject(dto.getSubject())
                .startAt(dto.getStartAt())
                .endAt(dto.getEndAt())
                .createdAt(dto.getCreatedAt())
                .updatedAt(dto.getUpdatedAt())
                .active(dto.getActive())
                .room(room)
                .user(user)
                .build();
    }

    public static AllocationCreateDTO copyCreateDTO(Allocation entity){
        if(entity == null){
            return null;
        }
        AllocationCreateDTO dto = new AllocationCreateDTO();
            dto.setAllocationId(entity.getAllocationId());
            dto.setSubject(entity.getSubject());
            dto.setStartAt(entity.getStartAt());
            dto.setEndAt(entity.getEndAt());
            dto.setCreatedAt(entity.getCreatedAt());
            dto.setUpdatedAt(entity.getUpdatedAt());
            dto.setActive(entity.getActive());
            dto.setRoomId(entity.getRoom().getRoomId());
            dto.setUserId(entity.getUser().getUserId());
        return dto;
    }
}
