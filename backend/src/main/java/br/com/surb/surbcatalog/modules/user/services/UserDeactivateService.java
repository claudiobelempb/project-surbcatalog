package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserDeactivateService {
    private final UserRepository userRepository;

    public UserDeactivateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void execute(String userId) {
        Objects.requireNonNull(userId);
        userRepository.findByUserIdAndActive(userId, true)
                .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.ENTITY_NOT_FOUND + userId));
        userRepository.deactivate(userId);
    }
}
