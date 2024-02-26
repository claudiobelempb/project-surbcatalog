package br.com.surb.surbcatalog.modules.user.resources;

import br.com.surb.surbcatalog.modules.user.dto.UserDTO;
import br.com.surb.surbcatalog.modules.user.services.UserFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/users")
public class UserFindAllResource {
    private final UserFindAllService userFindAllService;
    private final Executor executor;

    public UserFindAllResource(UserFindAllService userFindAllService, Executor executor) {
        this.userFindAllService = userFindAllService;
        this.executor = executor;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    public CompletableFuture<ResponseEntity<Page<UserDTO>>> handle(
            Pageable pageable
    ) {
        return CompletableFuture.supplyAsync(() -> userFindAllService.execute(pageable), executor)
                .thenApply((category) -> ResponseEntity.ok().body(category));
    }
}
