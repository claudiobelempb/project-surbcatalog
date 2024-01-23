package br.com.surb.surbcatalog.modules.role.resources;

import br.com.surb.surbcatalog.modules.role.services.RoleDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/roles")
public class RoleDeleteResource {

    private final RoleDeleteService roleDeleteService;
    private final Executor executor;

    public RoleDeleteResource(RoleDeleteService roleDeleteService, Executor executor) {
        this.roleDeleteService = roleDeleteService;
        this.executor = executor;
    }

    @DeleteMapping(value = "/{roleId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID roleId ) {
        return CompletableFuture
                .runAsync(() -> roleDeleteService.execute(roleId), executor)
                .thenApply((__) -> ResponseEntity.noContent().build());
    }
}
