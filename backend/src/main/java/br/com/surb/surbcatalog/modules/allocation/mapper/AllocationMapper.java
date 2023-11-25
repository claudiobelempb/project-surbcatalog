package br.com.surb.surbcatalog.modules.allocation.mapper;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationUpdateDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.user.entities.User;

public abstract class AllocationMapper {

    public static Allocation fromCreateDTOToEntity(AllocationCreateDTO dto, Room room, User user) {
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
                .room(room)
                .user(user)
                .build();
    }

    public static Allocation fromUpdateDTOToEntity(AllocationUpdateDTO dto, Room room, User user) {
        if (dto == null) {
            return null;
        }
        return Allocation.newAllocation()
                .allocationId(dto.getAllocationId())
                .subject(dto.getSubject())
                .startAt(dto.getStartAt())
                .endAt(dto.getEndAt())
                .build();
    }

    public static AllocationDTO fromEntityToDTO(Allocation entity) {
        if (entity == null) {
            return null;
        }

        return new AllocationCreateDTO()
                .allocationId(entity.getAllocationId())
                .subject(entity.getSubject())
                .startAt(entity.getStartAt())
                .endAt(entity.getEndAt())
                .createdAt(entity.getCreatedAt())
                .updatedAt(entity.getUpdatedAt())
                .active(entity.getActive())
                .roomId(entity.getRoom().getRoomId())
                .userId(entity.getUser().getUserId());

    }

}
