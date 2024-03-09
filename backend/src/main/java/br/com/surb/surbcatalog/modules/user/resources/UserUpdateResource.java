package br.com.surb.surbcatalog.modules.user.resources;

import br.com.surb.surbcatalog.modules.user.dto.UserUpdateDTO;
import br.com.surb.surbcatalog.modules.user.services.UserUpdateService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "users")
public class UserUpdateResource {
    private final UserUpdateService userUpdateService;
    private final Executor executor;

    public UserUpdateResource(UserUpdateService userUpdateService, Executor executor) {
        this.userUpdateService = userUpdateService;
        this.executor = executor;
    }

    @PutMapping(value = "/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable String userId, @Valid @RequestBody UserUpdateDTO dto) {
        return CompletableFuture
                .runAsync(() -> userUpdateService.execute(userId, dto), executor)
                .thenApply((__) -> ResponseEntity.noContent().build());
    }
}
