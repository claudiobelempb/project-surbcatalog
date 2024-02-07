package br.com.surb.surbcatalog.modules.role.resources;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.services.RoleFindByIdService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/roles")
public class RoleFindByIdResource {
    private final RoleFindByIdService roleFindByIdService;
    private final Executor executor;

    public RoleFindByIdResource(RoleFindByIdService roleFindByIdService, Executor executor) {
        this.roleFindByIdService = roleFindByIdService;
        this.executor = executor;
    }

    @GetMapping(value = "/{roleId}")
    public CompletableFuture<ResponseEntity<RoleDTO>> handle(@PathVariable UUID roleId) {
        Objects.isNull(roleId);
        return supplyAsync(() -> roleFindByIdService.execute(roleId), executor).thenApply((role) -> ResponseEntity.ok().body(role));
    }
}
