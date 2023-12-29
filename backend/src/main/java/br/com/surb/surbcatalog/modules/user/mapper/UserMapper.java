package br.com.surb.surbcatalog.modules.user.mapper;

import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserMapper() {
    }

    public static UserDTO fromDTO(User entity) {
        if (entity == null) {
            return null;
        }

        UserCreateDTO.Builder dto = UserCreateDTO.newBuilderDTO();

        dto.userId(entity.getUserId());
        dto.firstName(entity.getFirstName());
        dto.lastName(entity.getLastName());
        dto.email(entity.getEmail());
        dto.active(entity.getActive());
        dto.createdAt(entity.getCreatedAt());
        dto.updatedAt(entity.getUpdatedAt());
        entity.getRoles().clear();
        entity.getRoles().stream().map((role) -> entity.getRoles().add(role));

        return dto.build();
    }

    public static User fromEntity(UserDTO dto) {
        if (dto == null) {
            return null;
        }

        User.Builder entity = User.newBuilder();

        entity.userId(dto.getUserId());
        entity.firstName(dto.getFirstName());
        entity.lastName(dto.getLastName());
        entity.email(dto.getEmail());
        entity.active(dto.getActive());
        entity.createdAt(dto.getCreatedAt());
        entity.updatedAt(dto.getUpdatedAt());
        dto.getRoles().clear();
        dto.getRoles().stream().map((role) -> dto.getRoles().add(role));

        return entity.build();
    }
}
