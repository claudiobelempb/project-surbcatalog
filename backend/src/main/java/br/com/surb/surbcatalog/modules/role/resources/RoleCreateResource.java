package br.com.surb.surbcatalog.modules.role.resources;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.services.RoleCreateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import static java.util.concurrent.CompletableFuture.supplyAsync;

@RestController
@RequestMapping(value = "/roles")
public class RoleCreateResource {

    private final RoleCreateService roleCreateService;
    private final Executor executor;

    public RoleCreateResource(RoleCreateService roleCreateService, Executor executor) {
        this.roleCreateService = roleCreateService;
        this.executor = executor;
    }

    @PostMapping
    public CompletableFuture<ResponseEntity<RoleDTO>>  handle(@RequestBody RoleDTO dto){
        RoleDTO  obj  = roleCreateService.execute(dto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{roleId}").buildAndExpand(dto.getRoleId()).toUri();
        return supplyAsync(() -> obj, executor).thenApply((__) -> ResponseEntity.created(uri).body(obj));
    }
}
