package br.com.surb.surbcatalog.modules.allocation.resources;

import br.com.surb.surbcatalog.modules.allocation.services.AllocationDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@RestController
@RequestMapping(value = "/allocations")
public class AllocationDeleteResource {
    private final AllocationDeleteService allocationDeleteService;
    private final Executor executor;

    public AllocationDeleteResource(AllocationDeleteService allocationDeleteService, Executor executor) {
        this.allocationDeleteService = allocationDeleteService;
        this.executor = executor;
    }

    @DeleteMapping(value = "/{allocationId}")
    public CompletableFuture<ResponseEntity<Void>> handle(@PathVariable UUID allocationId) {
        return CompletableFuture.runAsync(() -> allocationDeleteService.execute(allocationId), executor)
                .thenApply((r) -> ResponseEntity.noContent().build());
    }
}
