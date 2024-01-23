package br.com.surb.surbcatalog.modules.user.mapper;

import br.com.surb.surbcatalog.modules.user.dto.UserUpdateDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserUpdateMapper {

    public UserUpdateMapper() {
    }

    public static UserUpdateDTO fromDTO(User entity) {
        if (entity == null) {
            return null;
        }

        return new UserUpdateDTO(entity);

    }

    public static User fromEntity(UserUpdateDTO dto) {
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
