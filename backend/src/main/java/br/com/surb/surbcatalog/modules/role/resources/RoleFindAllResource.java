package br.com.surb.surbcatalog.modules.role.resources;

import br.com.surb.surbcatalog.modules.role.dto.RoleDTO;
import br.com.surb.surbcatalog.modules.role.services.RoleFindAllService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "roles")
public class RoleFindAllResource {
    private final RoleFindAllService roleFindAllService;
    private final Executor executor;

    public RoleFindAllResource(RoleFindAllService roleFindAllService, Executor executor) {
        this.roleFindAllService = roleFindAllService;
        this.executor = executor;
    }

    @GetMapping
    public CompletableFuture<ResponseEntity<Page<RoleDTO>>> handle(
            @RequestParam(value = "page", defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage", defaultValue = "12") Integer linesPerPage,
            @RequestParam(value = "direction", defaultValue = "ASC") String diregtion,
            @RequestParam(value = "orderBy", defaultValue = "authority") String orderBy,
            @RequestParam(value = "authority", defaultValue = "authority") String authority
    ){
        Pageable pageable = PageRequest.of(page, linesPerPage, Sort.Direction.valueOf(diregtion), orderBy);
        return CompletableFuture.supplyAsync(() -> roleFindAllService.execute(pageable), executor)
                .thenApply((entity) -> ResponseEntity.ok().body(entity));
    }
}
