package br.com.surb.surbcatalog.modules.user.mapper;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserCreateMapper {

    public UserCreateMapper() {
    }

    public static UserCreateDTO fromDTO(User entity) {
        if (entity == null) {
            return null;
        }

        return new UserCreateDTO(entity);

    }

    public static User fromEntity(UserCreateDTO dto) {
        if (dto == null) {
            return null;
        }

        User.Builder entity = User.newBuilder();

        entity.userId(dto.getUserId());
        entity.firstName(dto.getFirstName());
        entity.lastName(dto.getLastName());
        entity.email(dto.getEmail());
        entity.password(dto.getPassword());
        entity.active(dto.getActive());
        entity.createdAt(dto.getCreatedAt());
        entity.updatedAt(dto.getUpdatedAt());

        return entity.build();
    }


}
