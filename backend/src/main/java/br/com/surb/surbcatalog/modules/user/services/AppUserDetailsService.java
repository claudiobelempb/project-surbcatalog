package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.role.entities.Role;
import br.com.surb.surbcatalog.modules.role.repositories.RoleRepository;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    private static final Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);

    public AppUserDetailsService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailAndActive(username, true).orElseThrow();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

        for (Role roleModel : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(roleModel.getAuthority()));
        }

        if (user == null) {
            logger.error(AppExceptionConstants.USER_NOT_FOUND + username);
            throw new UsernameNotFoundException(AppExceptionConstants.EMAIL_NOT_FOUND + username);
        }

        logger.info(AppExceptionConstants.USER_FOUND + username);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
    }

    public void addRoleToUser(String email, String authority) {
        User userModel = userRepository.findByEmailAndActive(email, true).orElseThrow();
        Role roleModel = roleRepository.findByAuthorityAndActive(authority, true).orElseThrow();

        userModel.getRoles().add(roleModel);
        userRepository.save(userModel);
    }
}
