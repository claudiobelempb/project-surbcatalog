package br.com.surb.surbcatalog.modules.allocation.resources;

import br.com.surb.surbcatalog.modules.allocation.dto.AllocationUpdateDTO;
import br.com.surb.surbcatalog.modules.allocation.services.AllocationUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/allocations")
public class AllocationUpdateResource {
    private final AllocationUpdateService allocationUpdateService;
    private final Executor executor;

    public AllocationUpdateResource(AllocationUpdateService allocationUpdateService, Executor executor) {
        this.allocationUpdateService = allocationUpdateService;
        this.executor = executor;
    }

    @PutMapping(value = "/{allocationId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID allocationId, @RequestBody AllocationUpdateDTO dto) {
        return CompletableFuture
                .runAsync(() -> allocationUpdateService.execute(allocationId, dto), executor)
                .thenApply((a) -> ResponseEntity.noContent().build());
    }
}
