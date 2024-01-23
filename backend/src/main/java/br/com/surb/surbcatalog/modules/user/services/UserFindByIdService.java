package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.mapper.UserCreateMapper;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserFindByIdService {
    private final UserRepository userRepository;

    public UserFindByIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public UserCreateDTO execute(UUID userId) {
        Objects.requireNonNull(userId);
        Optional<User> obj = userRepository.findById(userId);
        User user = obj.orElseThrow(() -> new AppEntityNotFoundException("Entity not found" + userId));
        return UserCreateMapper.fromDTO(user);
    }

}
