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

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsPojection> result = userRepository.seachUserAndRolesByEmailAndActive(username, true);
        for (UserDetailsPojection userDetailsPojection : result) {
//            System.out.println("User Id => " + userDetailsPojection.getUserId());
            logger.info("User Id => " + userDetailsPojection.getUserId());
            logger.info("Email => " + userDetailsPojection.getUsername());
            logger.info("Authority => " + userDetailsPojection.getAuthority());
            logger.info("First Name => " + userDetailsPojection.getFirstName());
            logger.info("Password => " + userDetailsPojection.getPassword());
            logger.info("Role Id => " + userDetailsPojection.getRoleId());
        }

        if (result.isEmpty()) {
            logger.error(AppExceptionConstants.USER_NOT_FOUND + username);
            throw new UsernameNotFoundException(AppExceptionConstants.EMAIL_NOT_FOUND + username);
        }

        User entity = new User();
        entity.setUserId(result.get(0).getUserId());
        entity.setFirstName(result.get(0).getFirstName());
        entity.setEmail(result.get(0).getUsername());
        entity.setPassword(result.get(0).getPassword());

        for (UserDetailsPojection projection : result) {
            entity.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return entity;
    }
}
