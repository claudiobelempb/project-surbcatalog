package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFindAllService {
    private final UserRepository userRepository;

    public UserFindAllService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> execute(Pageable pageable) {
        Page<User> entity = userRepository.findAll(pageable);
        return entity.map(user -> new UserDTO(user));
    }
}
