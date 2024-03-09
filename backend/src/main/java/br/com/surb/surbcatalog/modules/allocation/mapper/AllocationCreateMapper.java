package br.com.surb.surbcatalog.modules.allocation.mapper;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationUpdateDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.stereotype.Component;

@Component
public class AllocationCreateMapper {

    public AllocationCreateMapper() {
    }

    public static AllocationCreateDTO fromDTO(Allocation allocation) {
        if (allocation == null) {
            return null;
        }

        return new AllocationCreateDTO(
                allocation.getAllocationId(),
                allocation.getSubject(),
                allocation.getStartAt(),
                allocation.getEndAt(),

                allocation.getCreatedAt(),
                allocation.getUpdatedAt(),
                allocation.getActive(),
                allocation.getRoom().getRoomId(),
                allocation.getUser().getUserId()
        );

    }

    public static AllocationCreateDTO fromCreateDTO(Allocation allocation) {
        if (allocation == null) {
            return null;
        }

        return new AllocationCreateDTO(
                allocation.getAllocationId(),
                allocation.getSubject(),
                allocation.getStartAt(),
                allocation.getEndAt(),

                allocation.getCreatedAt(),
                allocation.getUpdatedAt(),
                allocation.getActive(),
                allocation.getRoom().getRoomId(),
                allocation.getUser().getUserId()
        );

    }

    public static AllocationUpdateDTO fromUpdateDTO(Allocation allocation) {
        if (allocation == null) {
            return null;
        }

        return new AllocationUpdateDTO(
                allocation.getAllocationId(),
                allocation.getSubject(),
                allocation.getStartAt(),
                allocation.getEndAt(),

                allocation.getCreatedAt(),
                allocation.getUpdatedAt(),
                allocation.getActive(),
                allocation.getRoom().getRoomId(),
                allocation.getUser().getUserId()
        );

    }

    public static Allocation fromEntity(AllocationCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        return Allocation.builder()
        .allocationId(dto.allocationId())
        .subject(dto.subject())
        .startAt(dto.startAt())
        .endAt(dto.endAt())
        .active(dto.active())
        .createdAt(dto.createdAt())
        .updatedAt(dto.updatedAt()).build();

    }
}