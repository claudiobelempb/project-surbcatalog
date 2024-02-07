package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.dto.UserUpdateDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserUpdateService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserUpdateService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Transactional
    public UserDTO execute(UUID userId, UserUpdateDTO dto) {
        try {
            Objects.requireNonNull(userId);
            User entiry = userRepository
                    .findByUserIdAndActive(userId, true)
                    .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + userId));
            copyDtoToEntity(dto, entiry);
            userRepository.save(entiry);
            return new UserDTO(entiry);
        } catch (EntityNotFoundException e) {
            throw new AppEntityNotFoundException("Id not found" + userId);
        }
    }

    private void copyDtoToEntity(UserUpdateDTO dto, User entity) {

        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setEmail(dto.getEmail());

        entity.getRoles().clear();
        for (RoleDTO roleDTO : dto.getRoles()) {
            Role role = roleRepository.getReferenceById(roleDTO.getRoleId());
            entity.getRoles().add(role);
        }
    }

}
