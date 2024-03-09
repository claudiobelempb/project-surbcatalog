package br.com.surb.surbcatalog.modules.user.services;

import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.repositories.UserRepository;
import br.com.surb.surbcatalog.shared.AppConstants.AppExceptionConstants;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppEntityNotFoundException;
import br.com.surb.surbcatalog.shared.AppExeptions.AppExeptionsService.AppForbiddenException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserAuthService {
    private final UserRepository userRepository;

    public UserAuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute() {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            Jwt jwtPrincipal = (Jwt) authentication.getPrincipal();
            String username = jwtPrincipal.getClaim("username");
            return userRepository.findByEmailAndActive(username, true)
                    .orElseThrow(() -> new AppEntityNotFoundException(AppExceptionConstants.NOT_FOUND));
        } catch (Exception e) {
            throw new UsernameNotFoundException("Ivalid user");
        }
    }

    public void validateSelfOrAdmin(String userId){
        User user = execute();
        if(!user.getUserId().equals(userId) && !user.hasRole("ROLE_ADMIN")){
            throw new AppForbiddenException(AppExceptionConstants.ACCESS_DENIED);
        }
    }

}
