package br.com.surb.surbcatalog.modules.allocation.mapper;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.user.entities.User;

import java.util.UUID;

public abstract class AllocationMapper {

    public static Allocation createAllocationDTOToEntity(AllocationCreateDTO dto) {
        if (dto == null) {
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
                .room(Room.newRoomBuilder().roomId(dto.getRoomId()).build())
                .user(User.newUserBuilder().build())
                .build();
    }

    public static AllocationDTO entityToAllocationCreateDTO(Allocation entity, UUID roomId, User userId) {
        if (entity == null) {
            return null;
        }

        return AllocationCreateDTO.newAllocationDTO()
                .allocationId(entity.getAllocationId())
                .subject(entity.getSubject())
                .startAt(entity.getStartAt())
                .endAt(entity.getEndAt())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .active(entity.getActive())
                .roomId(roomId)
                .userId(userId)
                .build();
    }

    public static AllocationDTO entityToAllocationDTO(Allocation entity) {
        if (entity == null) {
            return null;
        }

        return AllocationCreateDTO.newAllocationDTO()
                .allocationId(entity.getAllocationId())
                .subject(entity.getSubject())
                .startAt(entity.getStartAt())
                .endAt(entity.getEndAt())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .active(entity.getActive())
                .roomId(entity.getRoom().getRoomId())
                .userId(entity.getUser())
                .build();
    }

}