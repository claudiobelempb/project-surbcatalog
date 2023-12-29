package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.mapper.UserMapper;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserFindAllService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserFindAllService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Transactional(readOnly = true)
    public Page<UserDTO> execute(PageRequest pageRequest){
        Page<User> users = userRepository.findAll(pageRequest);
        return users.map(user -> UserMapper.fromDTO(user));
    }
}
