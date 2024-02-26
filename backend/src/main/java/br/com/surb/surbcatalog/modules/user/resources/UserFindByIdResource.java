package br.com.surb.surbcatalog.modules.user.resources;

import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.services.UserFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/users")
public class UserFindByIdResource {
    private final UserFindByIdService userFindByIdService;
    private final Executor executor;

    public UserFindByIdResource(UserFindByIdService userFindByIdService, Executor executor) {
        this.userFindByIdService = userFindByIdService;
        this.executor = executor;
    }

    @GetMapping(value = "/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_OPERATOR')")
    public CompletableFuture<ResponseEntity<UserDTO>> handle(@PathVariable UUID userId) {
        return supplyAsync(() -> userFindByIdService.execute(userId), executor).thenApply((user) -> ResponseEntity.ok().body(user));
    }
}
