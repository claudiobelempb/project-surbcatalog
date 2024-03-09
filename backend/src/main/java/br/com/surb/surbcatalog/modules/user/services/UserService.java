package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.projections.UserDetailsPojection;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsPojection> result = userRepository.searchUserAndRolesByEmailAndActive(username, true);
        if (result.isEmpty()) {
            logger.error(AppExceptionConstants.USER_NOT_FOUND + username);
            throw new UsernameNotFoundException(AppExceptionConstants.EMAIL_NOT_FOUND + username);
        }

        User entity = new User();
        entity.setUserId(result.get(0).getUserId());
        entity.setFirstName(result.get(0).getFirstName());
        entity.setLastName(result.get(0).getLastName());
        entity.setEmail(result.get(0).getUsername());
        entity.setPassword(result.get(0).getPassword());

        for (UserDetailsPojection projection : result) {
            entity.addRole(Role.builder().roleId(projection.getRoleId()).authority(projection.getAuthority()).build());
        }

        return entity;
    }
}
