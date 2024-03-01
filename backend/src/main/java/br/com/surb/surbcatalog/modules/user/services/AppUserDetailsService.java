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
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<UserDetailsPojection> user = userRepository.seachUserAndRolesByEmail(username, true);
//        System.out.println("USER =>" + user);

        if (user.isEmpty()) {
            logger.error(AppExceptionConstants.USER_NOT_FOUND + username);
            throw new UsernameNotFoundException(AppExceptionConstants.EMAIL_NOT_FOUND + username);
        }

        User entity = new User();
        entity.setEmail(user.get(0).getUsername());
        entity.setPassword(user.get(0).getPassword());

        for (UserDetailsPojection projection : user) {
            entity.addRole(new Role(projection.getRoleId(), projection.getAuthority()));
        }

        return entity;
    }
}
