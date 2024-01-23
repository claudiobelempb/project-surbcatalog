package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.mapper.UserCreateMapper;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCreateService {

    private final UserRepository userRepository;

    public UserCreateService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserCreateDTO execute(UserCreateDTO dto) {
//        roomValidator.validate(dto);
        User user = UserCreateMapper.fromEntity(dto);
        userRepository.save(user);
        return UserCreateMapper.fromDTO(user);
    }
}
