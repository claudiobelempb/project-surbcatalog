package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserFindByIdService {
    private final UserRepository userRepository;

    public UserFindByIdService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public UserDTO execute(String userId) {
        Objects.requireNonNull(userId);
        User entity = userRepository.findByUserIdAndActive(userId, true)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + userId));
        return new UserDTO(entity);
    }

}
