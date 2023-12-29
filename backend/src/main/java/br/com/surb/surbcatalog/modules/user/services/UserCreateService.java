package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.dto.UserCreateDTO;
import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.mapper.UserMapper;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@Service
public class UserCreateService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserCreateService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserDTO execute(UserCreateDTO dto) {
//        roomValidator.validate(dto);
        User user = UserMapper.fromEntity(dto);
        userRepository.save(user);
        return userMapper.fromDTO(user);
    }
}
