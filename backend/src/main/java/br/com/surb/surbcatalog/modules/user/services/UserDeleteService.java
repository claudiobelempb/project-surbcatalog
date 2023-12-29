package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppDataIntegrityViolationException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserDeleteService {
    private final UserRepository userRepository;

    public UserDeleteService(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    public void execute(UUID userId) {
        try {
            userRepository.deleteById(userId);
        } catch (EmptyResultDataAccessException e) {
            throw new AppEntityNotFoundException("Id not found " + userId);
        } catch (DataIntegrityViolationException e) {
            throw new AppDataIntegrityViolationException("Integrity violation");
        }
    }
}
