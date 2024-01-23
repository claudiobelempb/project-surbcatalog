package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.dto.UserUpdateDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.mapper.UserUpdateMapper;
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

    public UserUpdateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserUpdateDTO execute(UUID userId, UserUpdateDTO dto) {
        try {
            Objects.requireNonNull(userId);
            User user = userRepository
                    .findByUserIdAndActive(userId, true)
                    .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + userId));
            user = userRepository.save(user);
            return UserUpdateMapper.fromDTO(user);
        } catch (EntityNotFoundException e) {
            throw new AppEntityNotFoundException("Id not found" + userId);
        }
    }

}
