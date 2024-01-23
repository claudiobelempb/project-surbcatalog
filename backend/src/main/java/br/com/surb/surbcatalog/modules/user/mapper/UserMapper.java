package br.com.surb.surbcatalog.modules.user.mapper;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapper {

    public UserMapper() {
    }

    public static UserDTO fromDTO(User entity) {
        if (entity == null) {
            return null;
        }

        return new UserDTO(entity);

    }

    public static UserCreateDTO fromCreateDTO(User entity) {
        if (entity == null) {
            return null;
        }

        return new UserCreateDTO(entity);

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
        return entity.build();
    }


}
