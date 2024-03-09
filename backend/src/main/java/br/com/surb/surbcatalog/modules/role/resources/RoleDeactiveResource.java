package br.com.surb.surbcatalog.modules.role.resources;

import br.com.surb.surbcatalog.modules.role.services.RoleDeactiveService;
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
public class RoleDeactiveResource {
    private final RoleDeactiveService roleDeactiveService;
    private final Executor executor;

    public RoleDeactiveResource(RoleDeactiveService roleDeactiveService, Executor executor) {
        this.roleDeactiveService = roleDeactiveService;
        this.executor = executor;
    }

    @PatchMapping(value = "/deactivate/{roleId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable String roleId) {
        return CompletableFuture
                .runAsync(() -> roleDeactiveService.execute(roleId), executor)
                .thenApply((result) -> ResponseEntity.noContent().build());
    }
}
