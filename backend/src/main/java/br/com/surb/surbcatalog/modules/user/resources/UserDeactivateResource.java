package br.com.surb.surbcatalog.modules.user.resources;

import br.com.surb.surbcatalog.modules.user.services.UserDeactivateService;
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
public class UserDeactivateResource {
    private final UserDeactivateService userDeactivateService;
    private final Executor executor;

    public UserDeactivateResource(UserDeactivateService userDeactivateService, Executor executor) {
        this.userDeactivateService = userDeactivateService;
        this.executor = executor;
    }

    @PatchMapping(value = "/deactivate/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable String userId) {
        return CompletableFuture
                .runAsync(() -> userDeactivateService.execute(userId), executor)
                .thenApply((result) -> ResponseEntity.noContent().build());
    }
}
