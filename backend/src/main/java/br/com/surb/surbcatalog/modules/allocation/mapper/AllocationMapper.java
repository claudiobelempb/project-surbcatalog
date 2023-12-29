package br.com.surb.surbcatalog.modules.allocation.mapper;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationCreateDTO;
import br.com.surb.surbcatalog.modules.allocation.dto.AllocationDTO;
import br.com.surb.surbcatalog.modules.allocation.entities.Allocation;
import br.com.surb.surbcatalog.modules.category.dto.CategoryDTO;
import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.room.dto.RoomDTO;
import br.com.surb.surbcatalog.modules.room.entities.Room;
import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class AllocationMapper {

    public AllocationMapper() {
    }

    public static AllocationDTO fromDTO(Allocation allocation) {
        if (allocation == null) {
            return null;
        }

        AllocationCreateDTO.Builder dto = AllocationCreateDTO.newBuilderDTO();

        dto.roomId(allocation.getAllocationId());
        dto.subject(allocation.getSubject());
        dto.startAt(allocation.getStartAt());
        dto.endAt(allocation.getEndAt());
        dto.active(allocation.getActive());
        dto.createdAt(allocation.getCreatedAt());
        dto.updatedAt(allocation.getUpdatedAt());
        dto.roomId(allocation.getRoom().getRoomId());
        dto.userId(allocation.getUser().getUserId());

        return dto.build();
    }

    public static Allocation fromEntity(AllocationDTO allocationDTO, UUID roomId, UUID userId) {
        if (allocationDTO == null) {
            return null;
        }

        Allocation.Builder entity = Allocation.newBuilder();

        entity.allocationId(allocationDTO.getAllocationId());
        entity.subject(allocationDTO.getSubject());
        entity.startAt(allocationDTO.getStartAt());
        entity.endAt(allocationDTO.getEndAt());
        entity.active(allocationDTO.getActive());
        entity.createdAt(allocationDTO.getCreatedAt());
        entity.updatedAt(allocationDTO.getUpdatedAt());
        entity.room(Room.newBuilder().roomId(roomId).build());
        entity.user(User.newBuilder().userId(userId).build());

        return entity.build();
    }
}