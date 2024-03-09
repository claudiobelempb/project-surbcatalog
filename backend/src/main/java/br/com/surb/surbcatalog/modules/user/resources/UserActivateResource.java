package br.com.surb.surbcatalog.modules.user.resources;

import br.com.surb.surbcatalog.modules.user.services.UserActivateService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/users")
public class UserActivateResource {
    private final UserActivateService userActivateService;
    private final Executor executor;

    public UserActivateResource(UserActivateService userActivateService, Executor executor) {
        this.userActivateService = userActivateService;
        this.executor = executor;
    }

    @PatchMapping(value = "/activate/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable String userId) {
        return CompletableFuture
                .runAsync(() -> userActivateService.execute(userId), executor)
                .thenApply((r) -> ResponseEntity.noContent().build());
    }
}
