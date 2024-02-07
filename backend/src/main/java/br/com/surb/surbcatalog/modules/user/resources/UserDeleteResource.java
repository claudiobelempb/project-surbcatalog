package br.com.surb.surbcatalog.modules.user.resources;

import br.com.surb.surbcatalog.modules.user.services.UserDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/users")
public class UserDeleteResource {
    private final UserDeleteService userDeleteService;
    private final Executor executor;

    public UserDeleteResource(UserDeleteService userDeleteService, Executor executor) {
        this.userDeleteService = userDeleteService;
        this.executor = executor;
    }

    @DeleteMapping(value = "/{userId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID userId ) {
        return CompletableFuture
                .runAsync(() -> userDeleteService.execute(userId), executor)
                .thenApply((__) -> ResponseEntity.noContent().build());
    }

}
