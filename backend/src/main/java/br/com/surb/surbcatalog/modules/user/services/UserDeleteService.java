package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppDataIntegrityViolationException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.UUID;

@Service
public class UserDeleteService {
    private final UserRepository userRepository;

    public UserDeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void execute(UUID userId) {
        try {
            Objects.requireNonNull(userId);
            userRepository.findByUserIdAndActive(userId, true)
                    .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + userId));
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND + userId);
        } catch (DataIntegrityViolationException e) {
            throw new AppDataIntegrityViolationException(AppExceptionConstants.DATA_INTEGRITY_VIOLATION);
        }
    }
}
