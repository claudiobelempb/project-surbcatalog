package br.com.surb.surbcatalog.modules.allocation.mapper;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationUpdateDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import org.springframework.stereotype.Component;

@Component
public class AllocationMapper {

    public AllocationMapper() {
    }

    public static AllocationDTO fromDTO(Allocation allocation) {
        if (allocation == null) {
            return null;
        }

        return new AllocationDTO(
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


}