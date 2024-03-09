package br.com.surb.surbcatalog.modules.role.resources;

import br.com.surb.surbcatalog.modules.role.services.RoleActiveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/roles")
public class RoleActiveResource {
    private final RoleActiveService roleActiveService;
    private final Executor executor;

    public RoleActiveResource(RoleActiveService roleActiveService, Executor executor) {
        this.roleActiveService = roleActiveService;
        this.executor = executor;
    }

    @PatchMapping(value = "/activate/{roleId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable String roleId) {
        return CompletableFuture
                .runAsync(() -> roleActiveService.execute(roleId), executor)
                .thenApply((__) -> ResponseEntity.noContent().build());
    }
}
