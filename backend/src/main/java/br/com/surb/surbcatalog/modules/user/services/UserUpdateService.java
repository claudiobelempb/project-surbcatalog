package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.mapper.UserMapper;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class UserUpdateService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserUpdateService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserDTO execute(UUID userId, UserCreateDTO dto) {
        try {
            User user = userRepository.getReferenceById(userId);
            UserMapper.fromEntity(dto);
            user = userRepository.save(user);
            return UserMapper.fromDTO(user);
        } catch (EntityNotFoundException e) {
            throw new AppEntityNotFoundException("Id not found" + userId);
        }
    }

}
