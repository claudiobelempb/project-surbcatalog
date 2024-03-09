package br.com.surb.surbcatalog.modules.user.resources;

import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.entities.User;
import br.com.surb.surbcatalog.modules.user.services.UserAuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;


@RestController
@RequestMapping(value = "/users")
public class UserAuthResource {
    private final UserAuthService userAuthService;
    private final Executor executor;

    public UserAuthResource(UserAuthService userAuthService, Executor executor) {
        this.userAuthService = userAuthService;
        this.executor = executor;
    }

    @GetMapping(value = "/profile")
//    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    public CompletableFuture<ResponseEntity<UserDTO>> handle() {
        User entity = userAuthService.execute();
//        return supplyAsync(() -> user, executor).thenApply((__) -> ResponseEntity.ok().body(user));
        return supplyAsync(() -> new UserDTO(entity), executor).thenApply((user) -> ResponseEntity.ok().body(user));
    }
}
