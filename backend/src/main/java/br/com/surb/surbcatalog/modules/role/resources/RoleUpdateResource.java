package br.com.surb.surbcatalog.modules.role.resources;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.services.RoleUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/roles")
public class RoleUpdateResource {
    private final RoleUpdateService roleUpdateService;
    private final Executor executor;

    public RoleUpdateResource(RoleUpdateService roleUpdateService, Executor executor) {
        this.roleUpdateService = roleUpdateService;
        this.executor = executor;
    }

    @PutMapping(value = "/{roleId}")
    public CompletableFuture<ResponseEntity<RoleDTO>> handle(@PathVariable UUID roleId, @RequestBody RoleDTO dto) {
        return supplyAsync(() -> roleUpdateService.execute(roleId, dto), executor).thenApply((role) -> ResponseEntity.ok().body(role));
//        return CompletableFuture
//                .runAsync(() -> roleUpdateService.execute(roleId, dto), executor)
//                .thenApply((a) -> ResponseEntity.noContent().build());
    }
}
